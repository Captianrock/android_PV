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
            String line;
            addPreferences();

            String packageName = ""; // need to check that package name is different

            while ((line = reader.readLine()) != null) {
                String[] splitString = line.split(",");
                if (!splitString[0].equals(packageName)) {
                    addPackageNameCheck(splitString[0]);
                    packageName = splitString[0];
                    System.out.println(packageName);
                }
                addFindHook(splitString);
            }
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("moduleFile.txt")));
            writer.println(codeBuilder.toString());
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void addFindHook(String[] methodInfo) {
        String packageName = methodInfo[0];
        String className = methodInfo[1];
        String methodName = methodInfo[2];
        // any remainders are parameter info

        String findHookMethodPt1 = "\t\t\tfindAndHookMethod(\"" + packageName + "." + className
                + "\", lpparam.classLoader, \"" + methodName + "\"";

        codeBuilder.append(findHookMethodPt1);
        // now need to add parameters
        if (!methodInfo[3].equals("[]")) {
            // we have parameters
            int i = 3;
            while (i < methodInfo.length) {
                String param = methodInfo[i];

                // can't just do replace because of arrays
                if (param.charAt(0) == '[') {
                    param = param.substring(1);
                }
                if (param.charAt(param.length()-1) == ']') {
                    param = param.substring(0, param.length()-2);
                }

                String paramString = ", \"" + param + "\"";
                codeBuilder.append(paramString);
                i++;
            }
        }
        String endOfMethod = ", new XC_MethodHook() {\n";
        codeBuilder.append(endOfMethod);
    }

    private void addBeforeHook() {

    }

    private void addAfterHook() {

    }

    private void addPackageNameCheck(String packageName) {
        String ifClause = "\t\tif (lpparam.packageName.equals(\"" + packageName + "\")) {\n";
        codeBuilder.append(ifClause);
    }

    private void addPreferences() {

        String preferences =
                "\t\tfinal XSharedPreferences pref = new XSharedPreferences(\"com.example.kim.softwareperformance\", \"user_settings\");\n" +
                "\t\tpref.makeWorldReadable();\n" +
                "\t\tpref.reload();\n";

        codeBuilder.append(preferences);

    }

}
