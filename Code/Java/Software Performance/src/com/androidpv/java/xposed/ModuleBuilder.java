package com.androidpv.java.xposed;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Erin on 2/27/16.
 */
public class ModuleBuilder {

    private File sourceFile;
    private File outputFile;

    public ModuleBuilder(String fileName) {

        System.out.println("in moduel builder");

        this.sourceFile = new File(fileName);

        try {
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("moduleFile.txt")));
            writer.println(addModulePackageName());
            writer.println(addImports());
            writer.println(addClassNameAndMainMethod());
            writer.println(addMainIfClausePackages(this.sourceFile));
            writer.println(addPreferences());

            // Header of code done. Now need to write hooks for each method

            BufferedReader reader = new BufferedReader(new FileReader(this.sourceFile));
            String line;

            String packageName = ""; // need to check that package name is different

            while ((line = reader.readLine()) != null) {
                String[] splitString = line.split(",");
                if (!splitString[0].equals(packageName)) {
                    writer.println(addPackageNameCheck(splitString[0]));
                    packageName = splitString[0];
                    System.out.println(packageName);
                }
                writer.println(addFindHook(splitString));
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }  // End of Constructor




    private String addFindHook(String[] methodInfo) {

        StringBuilder hookMethodBuilder = new StringBuilder();

        String packageName = methodInfo[0];
        String className = methodInfo[1];
        String methodName = methodInfo[2];
        // any remainders are parameter info

        String findHookMethodPt1 = "\t\t\tfindAndHookMethod(\"" + packageName + "." + className
                + "\", lpparam.classLoader, \"" + methodName + "\"";

        hookMethodBuilder.append(findHookMethodPt1);
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
                hookMethodBuilder.append(paramString);
                i++;
            }
        }
        String endOfMethod = ", new XC_MethodHook() {\n";
        hookMethodBuilder.append(endOfMethod);

        return hookMethodBuilder.toString();
    }

    private void addBeforeHook() {

    }

    private void addAfterHook() {

    }

    private String addPackageNameCheck(String packageName) {
        String ifClause = "\t\tif (lpparam.packageName.equals(\"" + packageName + "\")) {\n";

        return ifClause;
    }

    private String addPreferences() {

        String preferences =
                "\t\tfinal XSharedPreferences pref = new XSharedPreferences(\"com.example.kim.softwareperformance\", \"user_settings\");\n" +
                "\t\tpref.makeWorldReadable();\n" +
                "\t\tpref.reload();\n";

        return preferences;
    }


    private String addMainIfClausePackages(File file) {
        List<String> packageNamesList = getPackages(file);
        StringBuilder ifClause = new StringBuilder();
        ifClause.append("\t\tif (!(lpparam.packageName.equals(\"");

        int i = 0;
        while (i < packageNamesList.size()) {
            ifClause.append(packageNamesList.get(i));
            i++;
            if (i != packageNamesList.size()) {
                ifClause.append(") || lpparam.packageName.equals(\"");
            }
        }
        ifClause.append("\"))) {\n" +
                        "\t\t\treturn;\n" +
                        "\t\t}");

        return ifClause.toString();
    }


    // collects the package names for initial if clauses
    // This is our first run through of the output file - we will be running through it twice
    private List<String> getPackages(File file) {
        List<String> packageNamesList = new ArrayList<String>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;

            String packageName = ""; // need to check that package name is different

            while ((line = reader.readLine()) != null) {
                String[] splitString = line.split(",");
                if (!splitString[0].equals(packageName)) {
                    packageName = splitString[0];
                    packageNamesList.add(packageName);
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return packageNamesList;
    }


    private String addClassNameAndMainMethod() {
        String className = "public class Tutorial implements IXposedHookLoadPackage {\n" +
                "\tlong startTime,endTime;\n" +
                "\tpublic void handleLoadPackage(final LoadPackageParam lpparam) throws Throwable {\n" +
                "\t\tXposedBridge.log(\"Loaded app: \" + lpparam.packageName);";
        return className;
    }


    private String addModulePackageName() {
        String packageName = "package com.example.kim.softwareperformance;\n";
        return packageName;
    }


    private String addImports() {
        String imports = "import de.robv.android.xposed.IXposedHookLoadPackage;\n" +
                "import de.robv.android.xposed.XC_MethodHook;\n" +
                "import de.robv.android.xposed.XSharedPreferences;\n" +
                "import de.robv.android.xposed.XposedBridge;\n" +
                "import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;\n" +
                "\n" +
                "import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;";
        return imports;
    }

}
