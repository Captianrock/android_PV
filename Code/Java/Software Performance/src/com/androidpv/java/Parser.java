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
                System.out.println((cu.getPackage() != null ? cu.getPackage().getName().toString() : "Null")
                        + "," + typeDec.getName().toString() +  "," + name.toString());

                printtoFile((cu.getPackage() != null ? cu.getPackage().getName().toString() : "Null") +
                        "," + typeDec.getName().toString() +  "," + name.toString());
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
        int numRead = 0;
        while ((numRead = reader.read(buf)) != -1) {
            String readData = String.valueOf(buf, 0, numRead);
            fileData.append(readData);
            buf = new char[1024];
        }
        reader.close();

        return  fileData.toString();
    }

    //loop directory to get file list
    public static void ParseFilesInDir(List<File> files) throws IOException{
        String filePath = null;
        int n=0;
        for (File f : files ) {
            //System.out.println(f);
            filePath = f.getAbsolutePath();
            if(f.isFile()){
                //System.out.println("FILE BEING PARSED" + f);
                parse(readFileToString(filePath));
            }
        }
    }
    public static List getFiles() {
        Path fp = Paths.get("C:/Users/bradley/IdeaProjects");
        PrintFiles pf = new PrintFiles();
        try {
            Files.walkFileTree(fp, pf);
            //System.out.println("This is your fileList: " + pf.getFileL());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pf.getFileL();
    }

    public static void printtoFile(String s){
        try {
            File file = new File("./sourceMethods.txt");

            // if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(s);
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        List<File> fileL = getFiles();
        ParseFilesInDir(fileL);
    }
}