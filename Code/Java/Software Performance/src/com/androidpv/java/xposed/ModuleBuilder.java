package com.androidpv.java.xposed;

import java.io.*;

/**
 * Created by Erin on 2/27/16.
 */
public class ModuleBuilder {

    private File sourceFile;
    private File outputFile;
    private StringBuilder codeBuilder;

    public ModuleBuilder(String fileName) {

        System.out.println("in moduel builder");

        codeBuilder = new StringBuilder();

        this.sourceFile = new File(fileName);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(this.sourceFile));
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("moduleFile.txt")));
            String line;
            addPreferences();

            String packageName = ""; // need to check that package name is different

            while ((line = reader.readLine()) != null) {
                String[] splitString = line.split(",");
                if (!splitString[0].equals(packageName)) {
                    addPackageNameCheck(splitString[0]);
                    packageName = splitString[0];
                    System.out.println(packageName);
                    //          writer.println(line);
                }
            }
            writer.println(codeBuilder.toString());
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void addPackageNameCheck(String packageName) {
        String ifClause = "        if (lpparam.packageName.equals(\"" + packageName + "\")) {\n";
        codeBuilder.append(ifClause);
    }

    private void addPreferences() {

        String preferences =
                "        final XSharedPreferences pref = new XSharedPreferences(\"com.example.kim.softwareperformance\", \"user_settings\");\n" +
                "        pref.makeWorldReadable();\n" +
                "        pref.reload();\n";

        codeBuilder.append(preferences);

    }

}
