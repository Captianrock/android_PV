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

import com.androidpv.java.gui.PVGUI;
import org.eclipse.jdt.core.dom.*;

public class Parser {

    //use ASTParse to parse string
    public static void parse(String str, String outputFile) {
        ASTParser parser = ASTParser.newParser(AST.JLS3);
        parser.setSource(str.toCharArray());
        parser.setKind(ASTParser.K_COMPILATION_UNIT);
        final CompilationUnit cu = (CompilationUnit) parser.createAST(null);
        cu.accept(new ASTVisitor() {
            Set names = new HashSet();

            public boolean visit(MethodDeclaration node) {
                SimpleName name = node.getName();
                List classes = cu.types();
                TypeDeclaration typeDec = (TypeDeclaration) classes.get(0);
                //System.out.println((cu.getPackage() != null ? cu.getPackage().getName().toString() : "Null")
                //+ "," + typeDec.getName().toString() +  "," + name.toString());

                printtoFile(outputFile, (cu.getPackage() != null ? cu.getPackage().getName().toString() : "Null") +
                        "," + typeDec.getName().toString() + "," + name.toString() + "," + node.parameters() );
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
//            System.out.println(f);
            filePath = f.getAbsolutePath();
            if (f.isFile()) {
//                System.out.println("FILE BEING PARSED" + f);
                try {
                    parse(readFileToString(filePath), outputFile);
                } catch (IOException e) {
                    System.err.println("Error parse(readFileToString) in ParseFilesInDir: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        }
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

        PVGUI gui = new PVGUI();
        dataBaseListener db = new dataBaseListener();
        gui.createGUI();


        while (!gui.returnButtonPressed()) {
            try {
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        String inputPathString = gui.getInputPath().trim();
        String outputPathString = gui.getOutputPath().trim();

        List<File> fileL = getFiles(inputPathString);
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
    }
}