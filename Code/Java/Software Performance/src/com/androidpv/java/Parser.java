package com.androidpv.java;

/**
 * Created by bradley on 2/12/2016.
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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
                String pack;
                if (cu.getPackage() == null){
                    pack = "Null";
                }
                else{
                    pack =  cu.getPackage().getName().toString();
                }
                System.out.println("Package: " + pack + " Class: " + typeDec.getName()  +  " & Method: " + name);
                this.names.add(name.getIdentifier());
                return false; // do not continue
            }

            public boolean visit(SimpleName node) {
                if (this.names.contains(node.getIdentifier())) {
                    System.out.println("Usage of '" + node + "' at line "
                            + cu.getLineNumber(node.getStartPosition()));
                }
                return true;
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
            //System.out.println(numRead);
            String readData = String.valueOf(buf, 0, numRead);
            fileData.append(readData);
            buf = new char[1024];
        }

        reader.close();

        return  fileData.toString();
    }

    //loop directory to get file list
    public static void ParseFilesInDir(List<File> files) throws IOException{
//        File dirs = new File(".");
//        String dirPath = dirs.getCanonicalPath() + File.separator+"src"+File.separator;
//
//        File root = new File(dirPath);
//        //System.out.println(rootDir.listFiles());
//        File[] files = root.listFiles ( );
        String filePath = null;
        int n=0;
        for (File f : files ) {
            //System.out.println(f);
            filePath = f.getAbsolutePath();
            if(f.isFile()){
                System.out.println("FILE BEING PARSED" + f);
                parse(readFileToString(filePath));
            }
        }
    }
    public static List printFiles() {
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

    public static void main(String[] args) throws IOException {
        List<File> fileL = printFiles();
        ParseFilesInDir(fileL);


    }
}