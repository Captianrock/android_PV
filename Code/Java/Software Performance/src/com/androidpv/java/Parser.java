package com.androidpv.java;

/**
 * Created by bradley on 2/12/2016.
 */

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.androidpv.java.apkParser.APKParser;
import com.androidpv.java.gui.PVGUI;
import com.androidpv.java.xposed.ModuleBuilder;
import jadx.core.utils.exceptions.JadxException;
import org.eclipse.jdt.core.dom.*;

public class Parser {

    //use ASTParse to parse string
    public static void parse(String str, String outputFile) {
//    public static void parse(File file, String outputFile, String inputString) {

        ASTParser parser = ASTParser.newParser(AST.JLS3);

        parser.setSource(str.toCharArray());
     //   parser.setSource(JavaCore.createCompilationUnitFrom((IFile) file));
        parser.setKind(ASTParser.K_COMPILATION_UNIT);

        parser.setResolveBindings(true);
        parser.setBindingsRecovery(true);

        final CompilationUnit cu = (CompilationUnit) parser.createAST(null);

        cu.accept(new ASTVisitor() {
            Set names = new HashSet();

            public boolean visit(MethodDeclaration node) {
//            public boolean visit(MethodDeclaration node) {
                SimpleName name = node.getName();
                List classes = cu.types();
                TypeDeclaration typeDec = (TypeDeclaration) classes.get(0);
                //System.out.println((cu.getPackage() != null ? cu.getPackage().getName().toString() : "Null")
                //+ "," + typeDec.getName().toString() +  "," + name.toString());

//                for (Object parameter : node.parameters()) {
//                    VariableDeclaration variableDeclaration = (VariableDeclaration) parameter;
//
//                    String type = variableDeclaration.getStructuralProperty(SingleVariableDeclaration.TYPE_PROPERTY)
//                            .toString();
//                    System.out.println(type);
//                    for (int i = 0; i < variableDeclaration.getExtraDimensions(); i++) {
//                        type += "[]";
//                    }
//                }


                printtoFile(outputFile, (cu.getPackage() != null ? cu.getPackage().getName().toString() : "Null") +
                        ";" + typeDec.getName().toString() + ";" + name.toString() + ";" + node.parameters() + ";"
                        + node.modifiers());
//                + ","
//                        + (!node.parameters().isEmpty() ? node.parameters().get(0).getClass() : "Null"));
           //     System.out.println(node.typeParameters());


                this.names.add(name.getIdentifier());
                return false; // do not continue
            }
        });
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
//                System.out.println("FILE BEING PARSED" + f);
                try {
                    parse(readFileToString(filePath), outputFile);
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

    public static void main(String[] args) {
        APKParser apkParser = new APKParser();
        PVGUI gui = new PVGUI();
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

        System.out.println("Done");
        gui.closeGUI();
        ModuleBuilder moduleBuilder = new ModuleBuilder(outputPathString);
    }
}