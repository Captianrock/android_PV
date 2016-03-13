package com.androidpv.java;

/**
 * Created by bradley on 2/12/2016.
 */

import java.io.*;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import com.androidpv.java.gui.PVGUI;
import com.androidpv.java.xposed.MBConstants;
import com.androidpv.java.xposed.ModuleBuilder;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.dom.*;

public class Parser {

    //use ASTParse to parse string
    public static void parse(String str, String outputFile, List<String> classpathList, File file) {
        ASTParser parser = ASTParser.newParser(AST.JLS8);
      //  String[] sourcePaths = {inputString};

        File currentDirectory = new File(new File(".").getAbsolutePath());
        try {
            System.out.println(currentDirectory.getCanonicalPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        File jarFolder = null;
        try {
            jarFolder = new File(currentDirectory.getCanonicalPath() + MBConstants.JAR_FILES);
        } catch (IOException e) {
            e.printStackTrace();
        }

        File[] jarFiles = jarFolder.listFiles();

        String[] classpath = new String[jarFiles.length + 1];

        for (int jarIter = 0; jarIter < jarFiles.length; jarIter++) {
            classpath[jarIter] = jarFiles[jarIter].getPath();
        }
        classpath[jarFiles.length] = "/Users/eobie3/android-sdks/platforms/android-19/android.jar";

        Map options = JavaCore.getOptions();
        JavaCore.setComplianceOptions(JavaCore.VERSION_1_7, options);
        parser.setCompilerOptions(options);

   //     String[] classpath = classpathList.toArray(new String[classpathList.size()]);
    //    String[] sources = new String[] {"/Users/eobie3/android_PV/Code/Java/Software Performance/src"};
//        parser.setEnvironment(new String[] {"/Users/eobie3/android_PV/Code/Java/Software Performance/src/com/androidpv/java/PrintFiles", "/Users/eobie3/android_PV/Code/Java/Software Performance/src/com/androidpv/java/Parser", "/Users/eobie3/android_PV/Code/Java/Software Performance/src/com/androidpv/java/GetFileExtension", "/Users/eobie3/android_PV/Code/Java/Software Performance/src/com/androidpv/java/dataBaseListener", "/Users/eobie3/android_PV/Code/Java/Software Performance/src/com/androidpv/java/xposed/ModuleBuilder", "/Users/eobie3/android_PV/Code/Java/Software Performance/src/com/androidpv/java/gui/PVGUI", "/Users/eobie3/android_PV/Code/Java/Software Performance/libs/commons-collections-3.2.1.jar", "/Users/eobie3/android_PV/Code/Java/Software Performance/libs/commons-configuration-1.6.jar", "/Users/eobie3/android_PV/Code/Java/Software Performance/libs/commons-lang-2.5.jar", "/Users/eobie3/android_PV/Code/Java/Software Performance/libs/commons-logging-1.1.1.jar","/Users/eobie3/android_PV/Code/Java/Software Performance/libs/mysql-connector-java-5.1.38-bin.jar", "/Users/eobie3/android_PV/Code/Java/Software Performance/libs/org.eclipse.core.contenttype_3.4.1.R35x_v20090826-0451.jar", "/Users/eobie3/android_PV/Code/Java/Software Performance/libs/org.eclipse.core.jobs_3.4.100.v20090429-1800.jar", "/Users/eobie3/android_PV/Code/Java/Software Performance/libs/org.eclipse.core.resources_3.5.2.R35x_v20091203-1235.jar", "/Users/eobie3/android_PV/Code/Java/Software Performance/libs/org.eclipse.core.runtime_3.5.0.v20090525.jar", "/Users/eobie3/android_PV/Code/Java/Software Performance/libs/org.eclipse.equinox.common_3.5.1.R35x_v20090807-1100.jar", "/Users/eobie3/android_PV/Code/Java/Software Performance/libs/org.eclipse.equinox.preferences_3.2.301.R35x_v20091117.jar", "/Users/eobie3/android_PV/Code/Java/Software Performance/libs/org.eclipse.jdt.core_3.5.2.v_981_R35x.jar", "/Users/eobie3/android_PV/Code/Java/Software Performance/libs/org.eclipse.osgi_3.5.2.R35x_v20100126.jar"}, new String[] {"/Users/eobie3/android_PV/Code/Java/Software Performance/src"}, new String[] {"UTF-8"}, false);
        parser.setUnitName(file.getName());
    //    parser.setEnvironment(classpath, sources, new String[] {"UTF-8"}, true);
        //parser.setEnvironment(new String[] {"/Library/Java/JavaVirtualMachines/jdk1.8.0_45.jdk/Contents/Home/jre/lib/rt.jar"}, new String[] {"/Users/eobie3/AlarmClock/android/alarmclock/src"}, new String[] {"UTF-8"}, true);
        parser.setEnvironment(classpath, new String[] {"/Users/eobie3/AlarmClock/android/alarmclock/src"}, new String[] {"UTF-8"}, true);
        parser.setSource(str.toCharArray());
     //   parser.setSource(JavaCore.createCompilationUnitFrom((IFile) file));

        parser.setResolveBindings(true);
        parser.setBindingsRecovery(true);
        parser.setStatementsRecovery(true);

        parser.setKind(ASTParser.K_COMPILATION_UNIT);

        final CompilationUnit cu = (CompilationUnit) parser.createAST(null);

        cu.accept(new ASTVisitor() {
            Set names = new HashSet();

            public boolean visit(MethodDeclaration node) {
                SimpleName name = node.getName();
                List classes = cu.types();
                TypeDeclaration typeDec = (TypeDeclaration) classes.get(0);

                // convert imports list to one line
                List importsList = cu.imports();
                List<String> importsListString = new ArrayList<String>();
                for (Object item : importsList) {
                    String importString = item.toString().replaceAll(";\n", "");
                    importsListString.add(importString);
                }

                String fullMethodName = node.resolveBinding().toString();
                int paren = fullMethodName.indexOf("(");
                String parameters = fullMethodName.substring(paren);

                printtoFile(outputFile, (cu.getPackage() != null ? cu.getPackage().getName().toString() : "Null") +
                        ";" + typeDec.getName().toString() + ";" + importsListString + "; " + name.toString() + ";"
                        + parameters + ";" + node.modifiers());

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
    public static void ParseFilesInDir(List<File> files, String outputFile, List<String> classpath) {
        String filePath;
        for (File f : files) {
//            System.out.println(f);
            filePath = f.getAbsolutePath();
            if (f.isFile()) {
   //             System.out.println("FILE BEING PARSED" + f);
                try {
//                    parse(f, outputFile, inputFile);

                    parse(readFileToString(filePath), outputFile, classpath, f);
                } catch (Exception e) {
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

        List<String> classPath = new ArrayList<>();

        System.out.println("Classpath: \n");

        ClassLoader cl = ClassLoader.getSystemClassLoader();

        URL[] urls = ((URLClassLoader)cl).getURLs();

        for(URL url: urls){
            classPath.add(url.getFile());
//            System.out.println(url.getFile());
        }

        PVGUI gui = new PVGUI();
   //     dataBaseListener db = new dataBaseListener();
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
            ParseFilesInDir(fileL, outputPathString, classPath);
        } catch (Exception e) {
            System.err.println("Error parseFilesInDir in main: " + e.getMessage());
            e.printStackTrace();
        }
        System.out.println("Done parsing");
        gui.closeGUI();

        ModuleBuilder moduleBuilder = new ModuleBuilder(outputPathString);
    }
}