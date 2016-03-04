package com.androidpv.java.xposed;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Erin on 2/27/16.
 */
public class ModuleBuilder {

    private File sourceFile;
    private File outputFile;

    private boolean DO_NOT_PRINT = false;

    public ModuleBuilder(String fileName) {

        System.out.println("in moduel builder");

        this.sourceFile = new File(fileName);
        boolean beginningOfFile = true;

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
                String[] splitString = line.split(";");
                if (!splitString[0].equals(packageName)) {
                    if (!beginningOfFile) {
                        writer.println(addEndOfIfClause());
                    }
                    beginningOfFile = false;
                    writer.println(addPackageNameCheck(splitString[0]));
                    packageName = splitString[0];
                    System.out.println(packageName);
                }

                String findHook = addFindHook(splitString);

                if (!DO_NOT_PRINT) {

                    writer.println(findHook);

//                writer.println(addFindHook(splitString));
                    writer.println(addBeforeHook(splitString[2]));
                    writer.println(addAfterHook(splitString[2]));

                }

                DO_NOT_PRINT = false;

            }
            writer.println(addEndOfCode());
            reader.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.sourceFile.deleteOnExit();
        System.out.println("Module built.");
    }  // End of Constructor


    private String addFindHook(String[] methodInfo) {

        DO_NOT_PRINT = false;

        List<String> primitives = Arrays.asList("byte", "short", "int", "long", "float", "double", "boolean", "char");

        StringBuilder hookMethodBuilder = new StringBuilder();

        String packageName = methodInfo[0];
        String className = methodInfo[1];
        String methodName = methodInfo[2];
        String parameters = methodInfo[3];
        String modifiers = methodInfo[4];
        // any remainders are parameter info

        if (modifiers.contains("abstract")) {
            DO_NOT_PRINT = true;
        }
        if (!modifiers.contains("private")) {
            if (!modifiers.contains("public")) {
                if (!modifiers.contains("protected")) {
                    DO_NOT_PRINT = true;
                }
            }
        }

        String findHookMethodPt1 = "\t\t\tfindAndHookMethod(\"" + packageName + "." + className
                + "\", lpparam.classLoader, \"" + methodName + "\"";

        hookMethodBuilder.append(findHookMethodPt1);
        // now need to add parameters
        if (!parameters.equals("[]")) {
            // we have parameters
            String[] parameterPairs = parameters.split(",");
            int i = 0;
            while (i < parameterPairs.length) {
                String paramPair = parameterPairs[i];

                // clean the parameter - remove brackets
                    // can't just do replace because of arrays
                if (paramPair.charAt(0) == '[') {
                    paramPair = paramPair.substring(1);
                }
                if (paramPair.charAt(paramPair.length()-1) == ']') {
                    paramPair = paramPair.substring(0, paramPair.length()-1);
                }

                paramPair = paramPair.trim();
                String[] paramTuple = paramPair.split(" ");
                String param = paramTuple[0];
                String paramString;
                if (primitives.contains(param)) {
                    paramString = ", \"" + param + "\"";
                }
                else {
                    paramString = ", " + param + ".class";

                    DO_NOT_PRINT = true;
                }

                hookMethodBuilder.append(paramString);
                i++;
            }
        }
        String endOfMethod = ", new XC_MethodHook() {\n";
        hookMethodBuilder.append(endOfMethod);

        return hookMethodBuilder.toString();
    }

    private String addBeforeHook(String method) {

        String beforeHook = "\t\t\t\t@Override\n" +
                "\t\t\t\tprotected void beforeHookedMethod(MethodHookParam param) throws Throwable {\n" +
                "\t\t\t\t\tstartTime = System.nanoTime();\n" +
                "\t\t\t\t\tXposedBridge.log(\"" + method + "::methodStart::\" + startTime);\n" +
                "\t\t\t\t}";

        return beforeHook;
    }

    private String addAfterHook(String method) {

        String afterHook = "\t\t\t\t@Override\n" +
                "\t\t\t\tprotected void afterHookedMethod(MethodHookParam param) throws Throwable {\n" +
                "\t\t\t\t\tendTime = System.nanoTime();\n" +
                "\t\t\t\t\tXposedBridge.log(\"" + method + "::methodEnd::\" + endTime);\n" +
                "\t\t\t\t}\n" +
                "\t\t\t});\n";

        return afterHook;
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
                ifClause.append("\") || lpparam.packageName.equals(\"");
            }
        }
        ifClause.append("\"))) {\n" +
                        "\t\t\treturn;\n" +
                        "\t\t}\n");

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
                String[] splitString = line.split(";");
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
                "\t\tXposedBridge.log(\"Loaded app: \" + lpparam.packageName);\n";
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
                "import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;\n\n" +
                "import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;\n";
        return imports;
    }


    // Done for all but last if clause
    private String addEndOfIfClause() {
        return "\t\t}\n\n";
    }


    private String addEndOfCode() {
        return "\t\t}\n" +
                "\t}\n" +
                "}\n";
    }

}
