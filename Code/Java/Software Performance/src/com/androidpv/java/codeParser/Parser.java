package com.androidpv.java.codeParser;

/**
 * Created by bradley on 2/12/2016.
 */

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import com.androidpv.java.gui.PVView;
import com.androidpv.java.xposed.APKBuilder;
import com.androidpv.java.xposed.MBConstants;
import com.androidpv.java.xposed.ModuleBuilder;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.dom.*;

import javax.swing.*;

public class Parser {

    //use ASTParse to parse string
    public static void parse(String str, String outputFile, File sourceFile, String jarFilesLoc, String adbLoc, String sdkLoc) {

        ASTParser parser = ASTParser.newParser(AST.JLS8);
        String sourcePath = getSourcePath(sourceFile);

        if (sourcePath.equals("")) {
            return;
        }

        String[] classpath;

        if (jarFilesLoc != null) {

            File jarFolder = new File(jarFilesLoc);


            File[] jarFiles = jarFolder.listFiles();

            classpath = new String[jarFiles.length];

            for (int jarIter = 0; jarIter < jarFiles.length; jarIter++) {
                classpath[jarIter] = jarFiles[jarIter].getPath();
            }
        } else {
            classpath = new String[]{""};
        }

        Map options = JavaCore.getOptions();
        JavaCore.setComplianceOptions(JavaCore.VERSION_1_7, options);
        parser.setCompilerOptions(options);

        parser.setUnitName(sourceFile.getName());
        parser.setEnvironment(classpath, new String[]{sourcePath}, new String[]{"UTF-8"}, true);
        parser.setSource(str.toCharArray());

        parser.setResolveBindings(true);
        parser.setBindingsRecovery(true);
        parser.setStatementsRecovery(true);

        parser.setKind(ASTParser.K_COMPILATION_UNIT);

        final CompilationUnit cu = (CompilationUnit) parser.createAST(null);

        cu.accept(new ASTVisitor() {
            Set names = new HashSet();

            public boolean visit(MethodDeclaration node) {

                boolean isInterface = false;

                SimpleName name = node.getName();
                List classes = cu.types();
                TypeDeclaration typeDec;
                try {
                    typeDec = (TypeDeclaration) classes.get(0);
                } catch (Exception e) {
                    System.err.println("Node: " + node.getName());
                    System.err.println(e.getMessage());
                    return false;
                }
                String mainClassName = typeDec.getName().toString();

                try {
                    isInterface = ((TypeDeclaration) node.getParent()).isInterface();
                } catch (Throwable throwable) {

                }

                List<List<String>> parentsAnonClassList = getParents(node, mainClassName);
                List<String> parentList = parentsAnonClassList.get(0);
                List<String> anonClassList = parentsAnonClassList.get(1);

                int paramLength = node.resolveBinding().getParameterTypes().length;
                String[] parameters = new String[paramLength];
                for (int paramIndex = 0; paramIndex < paramLength; paramIndex++) {
                    if (MBConstants.PRIMITIVES_LIST.contains(
                            node.resolveBinding().getParameterTypes()[paramIndex].getName())) {
                        parameters[paramIndex] = node.resolveBinding().getParameterTypes()[paramIndex].getName();
                    } else {
                        if (!node.resolveBinding().getParameterTypes()[paramIndex].getBinaryName().equals(
                                node.resolveBinding().getParameterTypes()[paramIndex].getName())) {
                            parameters[paramIndex] = node.resolveBinding().getParameterTypes()[paramIndex].getBinaryName();
                        } else {
                            System.err.println("Missing jar - unable to resolve parameter type bindings for parameter " +
                                    node.resolveBinding().getParameterTypes()[paramIndex].getBinaryName() +
                                    " in method " + name.toString() + "() in class " + mainClassName + ".\n\tMethod " +
                                    name.toString() + "() will not be analyzed by module.");
//                            PVView.updateOutputArea("Missing jar for parameter " +
//                                    node.resolveBinding().getParameterTypes()[paramIndex].getBinaryName() +
//                                    " in method " + name.toString() + " in class " + mainClassName + ".\n\tMethod " +
//                                    name.toString() + " will not be analyzed by module.");
                            return false;
                        }
                    }
                }
                List<String> parentModifiers = new ArrayList<String>();
                try {
                    parentModifiers = ((TypeDeclaration) node.getParent()).modifiers();
                } catch (Exception e) {

                }

                printtoFile(outputFile, (cu.getPackage() != null ? cu.getPackage().getName().toString() : "Null") +
                        ";" + mainClassName + ";" + parentList + ";" + anonClassList + ";" +
                        name.toString() + ";" + Arrays.toString(parameters) + ";" + node.modifiers() + ";" +
                        parentModifiers + ";" + node.isConstructor() + ";" + isInterface);

                this.names.add(name.getIdentifier());
//                return true;
                return false; // do not continue
            }
        });

    }

    /**
     * This method returns the chain of parents as a list.
     *
     * @param originalNode
     * @return
     */
    private static List<List<String>> getParents(MethodDeclaration originalNode, String mainClassName) {

        ASTNode astNode = originalNode;

        List<String> parentsList = new ArrayList<>();
        List<String> anonClassList = new ArrayList<>();

        boolean lastParentFound = false;

        while (!lastParentFound) {
            ASTNode node = astNode.getParent();
            Class parentClass = node.getClass();

            if (parentClass.getName().equals("org.eclipse.jdt.core.dom.TypeDeclaration")) {
                parentsList.add(((TypeDeclaration) node).getName().toString());
                if (((TypeDeclaration) node).getName().toString().equals(mainClassName)) {
                    lastParentFound = true;
                }
            }
            else if (parentClass.getName().equals("org.eclipse.jdt.core.dom.ClassInstanceCreation")) {
                parentsList.add(((ClassInstanceCreation) node).getType().toString());
                anonClassList.add(((ClassInstanceCreation) node).getType().toString());
            }
            else if (parentClass.getName().equals("org.eclipse.jdt.core.dom.EnumDeclaration")) {
                parentsList.add(((EnumDeclaration) node).getName().toString());
            }
            astNode = node;
        }

        List<List<String>> parentsAnonClassList = new ArrayList<>();
        parentsAnonClassList.add(parentsList);
        parentsAnonClassList.add(anonClassList);

        return parentsAnonClassList;
    }

    //read file content into a string
    public static String readFileToString(String filePath) throws IOException {
        StringBuilder fileData = new StringBuilder(1000);
        BufferedReader reader = new BufferedReader(new FileReader(filePath));

        char[] buf = new char[10];
        int numRead;
        while ((numRead = reader.read(buf)) != -1) {
            String readData = String.valueOf(buf, 0, numRead);
            fileData.append(readData);
            buf = new char[1024];
        }
        reader.close();
        return fileData.toString();
    }

    //loop directory to get file list
    public static void parseFilesInDir(List<File> files, String outputFile, String jarFilesLoc, String adbLoc, String sdkLoc) {
        SwingWorker worker = new SwingWorker() {
            @Override
            protected Object doInBackground() throws Exception {

                String filePath;
                for (File f : files) {
                    filePath = f.getAbsolutePath();
                    if (f.isFile()) {
           //             System.out.println("FILE BEING PARSED" + f);
                        try {
        //                    parse(f, outputFile, inputFile);

                            parse(readFileToString(filePath), outputFile, f, jarFilesLoc, adbLoc, sdkLoc);
                        } catch (Exception e) {
                            System.err.println("Error parse(readFileToString) in ParseFilesInDir: " + e.getMessage());
                            e.printStackTrace();
                        }
                    }
                }
                System.out.println("Done Parsing Files!");
                PVView.getInstance().updateOutLog("Done Parsing Files!"); //Let's see if it Breaks
                return null;
            }

            @Override
            protected void done(){
                String outputPathString = new File("").getAbsoluteFile().toString() + "/parseData.txt";
                PVView.getInstance().updateOutLog("Building module...");
                new ModuleBuilder(outputPathString);
                PVView.getInstance().updateOutLog("Building APK...");
                new APKBuilder(adbLoc, sdkLoc);
            }
        };
        worker.execute();
    }

    //Gets files in a given directory
    public static List getFiles(String input) {
        Path fp = Paths.get(input);
        PrintFiles pf = new PrintFiles();
        try {
            Files.walkFileTree(fp, pf);
        } catch (Exception e) {
            System.err.println("Error walkFileTree in getFiles: " + e.getMessage());
            e.printStackTrace();
        }
        if (pf.getFileL().size() == 0) {  // either empty directory or directory doesn't exist
            return null;
        }
        else {
            return pf.getFileL();
        }
    }

    public static void printtoFile(String outputFile, String s) {
        // Creates output file in the src directory
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(outputFile, true)))) {
            out.print("");
            out.println(s);
        } catch (IOException e) {
            //exception handling left as an exercise for the reader
            e.printStackTrace();
        }
    }

    private static String getSourcePath(File file) {
        String fullPath = file.getPath();

        int srcIndex = fullPath.indexOf("src/main/java");
        if (srcIndex == -1) {
            // RETURN TO GUI AND ASK FOR SOURCE PATH

            // for now, just get src
//            srcIndex = fullPath.indexOf("src");
//            String path = fullPath.substring(0, srcIndex + "src".length());
//            return path;
            return "";
        }
        String path = fullPath.substring(0, srcIndex + "src".length());

        return path;
    }


    public static void main(String[] args) {
        PVView view = new PVView();

    }

}