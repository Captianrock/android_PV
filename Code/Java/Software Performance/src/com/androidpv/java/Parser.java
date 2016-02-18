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
    public static void parse(String str) {
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

                printtoFile((cu.getPackage() != null ? cu.getPackage().getName().toString() : "Null") +
                        "," + typeDec.getName().toString() + "," + name.toString());
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
    public static void ParseFilesInDir(List<File> files) throws IOException {
        String filePath;
        int n = 0;
        for (File f : files) {
            //System.out.println(f);
            filePath = f.getAbsolutePath();
            if (f.isFile()) {
                //System.out.println("FILE BEING PARSED" + f);
                parse(readFileToString(filePath));
            }
        }
    }

    public static List getFiles(String input) {
        Path fp = Paths.get(input);
        PrintFiles pf = new PrintFiles();
        try {
            Files.walkFileTree(fp, pf);
            //System.out.println("This is your fileList: " + pf.getFileL());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pf.getFileL();
    }

    public static void printtoFile(String s) {
        // Creates a file called "sourceMethods.txt" in the src directory
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sourceMethods.txt", true)))) {
            out.print("");
            out.println(s);
        } catch (IOException e) {
            //exception handling left as an exercise for the reader
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {

        PVGUI gui = new PVGUI();
        Thread thread = new Thread(new Runnable(){

            @Override
            public void run() {
                gui.createGUI();
            }
        });
        thread.start();

        while (!gui.returnButtonPressed()) {
            try {
                Thread.currentThread().sleep(1000);
                System.out.println("sleeping!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            thread.join();
            System.out.println("Exited Thread");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String inputPathString = gui.getInputPath();
        System.out.println("checking input string: " + inputPathString);
        String outputPathString = gui.getOutputPath();

        List<File> fileL = getFiles(inputPathString);
        ParseFilesInDir(fileL);
        System.out.println("Done");
    }
}