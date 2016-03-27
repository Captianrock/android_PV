package com.androidpv.java;

/**
 * Created by bradley on 2/12/2016.
 */

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import com.androidpv.java.apkParser.APKParser;
import com.androidpv.java.gui.PVGUI;
import com.androidpv.java.xposed.MBConstants;
import com.androidpv.java.xposed.ModuleBuilder;
import jadx.core.utils.exceptions.JadxException;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.dom.*;

public class Parser {

    //use ASTParse to parse string
    public static void parse(String str, String outputFile, File sourceFile) {
        ASTParser parser = ASTParser.newParser(AST.JLS8);

        File currentDirectory = new File(new File(".").getAbsolutePath());
        File jarFolder = null;
        try {
            jarFolder = new File(currentDirectory.getCanonicalPath() + MBConstants.JAR_FILES);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String sourcePath = getSourcePath(sourceFile);

        File[] jarFiles = jarFolder.listFiles();

        String[] classpath = new String[jarFiles.length];

        for (int jarIter = 0; jarIter < jarFiles.length; jarIter++) {
            classpath[jarIter] = jarFiles[jarIter].getPath();
        }

        Map options = JavaCore.getOptions();
        JavaCore.setComplianceOptions(JavaCore.VERSION_1_7, options);
        parser.setCompilerOptions(options);

        parser.setUnitName(sourceFile.getName());
        parser.setEnvironment(classpath, new String[] {sourcePath}, new String[] {"UTF-8"}, true);
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
                TypeDeclaration typeDec = (TypeDeclaration) classes.get(0);

                try {
                    isInterface = ((TypeDeclaration) node.getParent()).isInterface();
                }
                catch(Throwable throwable) {

                }

                List<List<String>> parentsAnonClassList = getParents(node);
                List<String> parentList = parentsAnonClassList.get(0);
                List<String> anonClassList = parentsAnonClassList.get(1);

                int paramLength = node.resolveBinding().getParameterTypes().length;
                String[] parameters = new String[paramLength];
                for (int paramIndex = 0; paramIndex < paramLength; paramIndex++) {
                    if (MBConstants.PRIMITIVES_LIST.contains(
                            node.resolveBinding().getParameterTypes()[paramIndex].getName())) {
                        parameters[paramIndex] = node.resolveBinding().getParameterTypes()[paramIndex].getName();
                    }
                    else {
                        parameters[paramIndex] = node.resolveBinding().getParameterTypes()[paramIndex].getBinaryName();
                    }
                }

                printtoFile(outputFile, (cu.getPackage() != null ? cu.getPackage().getName().toString() : "Null") +
                        ";" + typeDec.getName().toString() + ";" + parentList + ";" + anonClassList + ";" +
                        name.toString() + ";" + Arrays.toString(parameters) + ";" +
                        node.modifiers() + ";" + node.isConstructor() + ";" + isInterface);

                this.names.add(name.getIdentifier());
                return false; // do not continue
            }
        });
    }

    /**
     * This method returns the chain of parents as a list.
     *
     * @param node
     * @return
     */
    private static List<List<String>> getParents(MethodDeclaration node) {

        List<String> parentsList = new ArrayList<>();
        List<String> anonClassList = new ArrayList<>();

        TypeDeclaration parentTypeDec = null;
        ClassInstanceCreation parentClassInstanceDec = null;
        EnumDeclaration parentEnumDec = null;

        boolean lastParentFound = false;
        String parentString;

        // first run through is with node
        boolean parentSet = false;
        try {
            parentTypeDec = (TypeDeclaration) node.getParent();
            parentString = parentTypeDec.getName().toString();
            parentsList.add(parentString);
            parentSet = true;
        } catch (Throwable throwable) {

        }
        if (!parentSet) {
            try {
                parentClassInstanceDec = ((ClassInstanceCreation) node.getParent().getParent());
                parentString = parentClassInstanceDec.getType().toString();
                parentsList.add(parentString);
                anonClassList.add(parentString);
                parentSet = true;
            } catch (Throwable throwable) {

            }
        }
        if (!parentSet) {
            try {
                parentEnumDec = (EnumDeclaration) node.getParent();
                parentString = parentEnumDec.getName().toString();
                parentsList.add(parentString);
            } catch (Throwable throwable) {

            }
        }

        while (!lastParentFound) {

            parentSet = false;

            if (parentTypeDec != null) {
                try {
                    parentTypeDec = (TypeDeclaration) parentTypeDec.getParent();
                    parentString = parentTypeDec.getName().toString();
                    parentsList.add(parentString);
                    parentSet = true;

                    parentClassInstanceDec = null;
                    parentEnumDec = null;

                } catch (Throwable throwable) {

                }
                if (!parentSet) {
                    try {
                        parentClassInstanceDec = (ClassInstanceCreation) parentTypeDec.getParent().getParent();
                        parentString = parentClassInstanceDec.getType().toString();
                        parentsList.add(parentString);
                        parentSet = true;

                        parentTypeDec = null;
                        parentEnumDec = null;
                    } catch (Throwable throwable) {

                    }
                }
                if (!parentSet) {
                    try {
                        parentEnumDec = (EnumDeclaration) parentTypeDec.getParent();
                        parentString = parentEnumDec.getName().toString();
                        parentsList.add(parentString);
                        parentSet = true;

                        parentTypeDec = null;
                        parentClassInstanceDec = null;
                    } catch (Throwable throwable) {

                    }
                }
            }
            else if (parentClassInstanceDec != null) {
                try {
                    parentTypeDec = (TypeDeclaration) parentClassInstanceDec.getParent().getParent().getParent();
                    parentString = parentTypeDec.getName().toString();
                    parentsList.add(parentString);
                    parentSet = true;

                    parentClassInstanceDec = null;
                    parentEnumDec = null;

                } catch (Throwable throwable) {

                }
                if (!parentSet) {
                    try {
                        parentClassInstanceDec = (ClassInstanceCreation) parentClassInstanceDec.getParent().getParent().getParent();
                        parentString = parentClassInstanceDec.getType().toString();
                        parentsList.add(parentString);
                        parentSet = true;

                        anonClassList.add(parentString);
                        parentTypeDec = null;
                        parentEnumDec = null;
                    } catch (Throwable throwable) {

                    }
                }
                if (!parentSet) {
                    try {
                        parentEnumDec = (EnumDeclaration) parentClassInstanceDec.getParent().getParent().getParent();
                        parentString = parentEnumDec.getName().toString();
                        parentsList.add(parentString);
                        parentSet = true;

                        parentTypeDec = null;
                        parentClassInstanceDec = null;
                    } catch (Throwable throwable) {

                    }
                }
            }
            else if (parentEnumDec != null) {
                try {
                    parentTypeDec = (TypeDeclaration) parentEnumDec.getParent();
                    parentString = parentTypeDec.getName().toString();
                    parentsList.add(parentString);
                    parentSet = true;

                    parentClassInstanceDec = null;
                    parentEnumDec = null;

                } catch (Throwable throwable) {

                }
                if (!parentSet) {
                    try {
                        parentClassInstanceDec = (ClassInstanceCreation) parentEnumDec.getParent().getParent();
                        parentString = parentClassInstanceDec.getType().toString();
                        parentsList.add(parentString);
                        parentSet = true;

                        anonClassList.add(parentString);
                        parentTypeDec = null;
                        parentEnumDec = null;
                    } catch (Throwable throwable) {

                    }
                }
                if (!parentSet) {
                    try {
                        parentEnumDec = (EnumDeclaration) parentEnumDec.getParent();
                        parentString = parentEnumDec.getName().toString();
                        parentsList.add(parentString);
                        parentSet = true;

                        parentTypeDec = null;
                        parentClassInstanceDec = null;
                    } catch (Throwable throwable) {

                    }
                }
            }
            if (!parentSet) {
                // we've hit the end of the parent chain
                lastParentFound = true;
            }
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
    public static void ParseFilesInDir(List<File> files, String outputFile) {
        String filePath;
        for (File f : files) {
            filePath = f.getAbsolutePath();
            if (f.isFile()) {
   //             System.out.println("FILE BEING PARSED" + f);
                try {
//                    parse(f, outputFile, inputFile);

                    parse(readFileToString(filePath), outputFile, f);
                } catch (Exception e) {
                    System.err.println("Error parse(readFileToString) in ParseFilesInDir: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Done Parsing Files!");
    }

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

        int srcIndex = fullPath.indexOf("src");
        if (srcIndex == -1) {
            return "";
        }
        String path = fullPath.substring(0, srcIndex + "src".length());

        return path;
    }


    public static void main(String[] args) {
        APKParser apkParser = new APKParser();
        PVGUI gui = new PVGUI();
   //     dataBaseListener db = new dataBaseListener();
        gui.createGUI();
        List<File> fileL;
        while (!gui.returnButtonPressed()) {
            try {
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        String inputPathString = gui.getInputPath().trim();
        String outputPathString = gui.getOutputPath().trim();

        //Checks if the path is an apk file and automatically parsing for methods!
        Path inputPath = Paths.get(inputPathString);
        if (APKParser.isAPK(inputPath)) try {
            System.out.println("Parsing APK NOW");
            apkParser.parse(inputPath.toFile());
            //C:\Users\bradley\IdeaProjects\android_PV\Code\Java\Software Performance\src\BBCNews.apk

            fileL = getFiles(new File("").getAbsoluteFile().toString() + "/decompiledSource");
            ParseFilesInDir(fileL, outputPathString);

        } catch (JadxException e) {
            System.err.println("Error JadxException in main: " + e.getMessage());
            e.printStackTrace();
        }


        //
        fileL = getFiles(inputPathString);
        while (fileL == null) { // bad input
            gui.resetGUI();
            while (!gui.returnButtonPressed()) {
                try {
                    Thread.currentThread().sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // reset strings and check if directory is valid
            inputPathString = gui.getInputPath().trim();
            outputPathString = gui.getOutputPath().trim();

            fileL = getFiles(inputPathString);
        }

        try {
            ParseFilesInDir(fileL, outputPathString);
        } catch (Exception e) {
            System.err.println("Error parseFilesInDir in main: " + e.getMessage());
            e.printStackTrace();
        }
        System.out.println("Done parsing");
        gui.closeGUI();
        ModuleBuilder moduleBuilder = new ModuleBuilder(outputPathString);
    }
}