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
                if (!splitString[MBConstants.PACKAGE_INDEX].equals(packageName)) {
                    if (!beginningOfFile) {
                        writer.println(addEndOfIfClause());
                    }
                    beginningOfFile = false;
                    writer.println(addPackageNameCheck(splitString[MBConstants.PACKAGE_INDEX]));
                    packageName = splitString[MBConstants.PACKAGE_INDEX];
                    System.out.println(packageName);
                }

                String findHook = addFindHook(splitString);

                if (!DO_NOT_PRINT) {

                    writer.println(findHook);

//                writer.println(addFindHook(splitString));
                    writer.println(addBeforeHook(splitString[MBConstants.METHOD_INDEX]));
                    writer.println(addAfterHook(splitString[MBConstants.METHOD_INDEX]));

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

        StringBuilder hookMethodBuilder = new StringBuilder();

        String packageName = methodInfo[MBConstants.PACKAGE_INDEX];
        String className = methodInfo[MBConstants.CLASS_INDEX];
        String imports = methodInfo[MBConstants.IMPORT_INDEX];
        String methodName = methodInfo[MBConstants.METHOD_INDEX];
        String parameters = methodInfo[MBConstants.PARAMETERS_INDEX];
        String modifiers = methodInfo[MBConstants.MODIFIERS_INDEX];

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

        if (!parameters.equals("[]")) {
            // we have parameters

            List<List<String>> importStatementsList = getParameterImports(imports, packageName);
            List<String> starImports = importStatementsList.get(0);
            List<String> standardImports = importStatementsList.get(1);

            boolean nonPrimitiveParam = false;

            // remove the brackets
            parameters = parameters.substring(1, parameters.length()-1);
            String[] parameterPairs = parameters.split(",");

            List<String> parameterTypes = getParameterTypesList(parameterPairs);

            for (String param : parameterTypes) {
                if (!MBConstants.PRIMITIVES_LIST.contains(param)) {
                    nonPrimitiveParam = true;
                }
            }

            if (!nonPrimitiveParam) {   // we only have primitive parameters - no try block needed
                hookMethodBuilder.append(findHookMethodPt1);
                for (String param : parameterTypes) {
                    String paramString = ", \"" + param + "\"";
                    hookMethodBuilder.append(paramString);
                }
                hookMethodBuilder.append(MBConstants.END_OF_FIND_HOOK_METHOD);
            }
            else {  // we have non-primitive parameters. We might need try block if they aren't star imports

                // check if all are normal imports first - no try block will be needed
                boolean parameterImportCheck = checkIfNormalParameterImports(parameterTypes, standardImports);
                if (parameterImportCheck) { // no try block needed
                    // match parameters with import statements
                    List<String> parameterList = matchFullParameters(parameterTypes, standardImports);
                    hookMethodBuilder.append(findHookMethodPt1);
                    for (String param : parameterList) {
                        String paramString = ", \"" + param + "\"";
                        hookMethodBuilder.append(paramString);
                    }
                    hookMethodBuilder.append(MBConstants.END_OF_FIND_HOOK_METHOD);
                }
                else {  // we are going to need multiple try blocks
                    DO_NOT_PRINT = true;







                }





                int i = 0;
                while (i < parameterPairs.length) {
                    String paramPair = parameterPairs[i];

                    paramPair = paramPair.trim();
                    String[] paramTuple = paramPair.split(" ");
                    String param = paramTuple[0];
                    String paramString;
                    if (MBConstants.PRIMITIVES_LIST.contains(param)) {
                        paramString = ", \"" + param + "\"";
                        hookMethodBuilder.append(paramString);
                    } else {  // parameter is not primitive. Must search imports

                        // first check if class is in standardImports
                        boolean found = false;
                        int importIter = 0;
                        while ((!found) && (importIter < standardImports.size())) {
                            String[] standardImportStatement = standardImports.get(importIter).split("\\.");
                            if (standardImportStatement[standardImportStatement.length - 1].equals(param)) {
                                found = true;
                            }
                            importIter++;
                        }
                        if (!found) {   // must try all star imports. This means we need a try block for each star import
                            for (String starImportStatement : starImports) {
                                hookMethodBuilder.append(MBConstants.TRY_STRING);


                            }

                        } else {
                            hookMethodBuilder.append(findHookMethodPt1);

                            // add the parameter with import statement
                        }


                        paramString = param;
                    }

                    hookMethodBuilder.append(paramString);
                    i++;
                }
            }
        }
        else {
            hookMethodBuilder.append(findHookMethodPt1);
        }
        hookMethodBuilder.append(MBConstants.END_OF_FIND_HOOK_METHOD);

        return hookMethodBuilder.toString();
    }


    private List<List<List<String>>> getParamImportPermutations(String[] parameters, String[] imports) {
        // create list of list of list of parameter matched with each import
        List<List<List<String>>> paramImportsList = new ArrayList<>();
            // [[[Param1, Import1], [Param1, Import2]], [[Param2, Import1], [Param2, Import2]]]

        for (String param : parameters) {
            List<List<String>> paramList = new ArrayList<>();   // [[Param, Import], [Param, Import]]
            for (String importLine : imports) {
                List<String> paramImportTuple = new ArrayList<>();  // [Param, Import]
                paramImportTuple.add(param);
                paramImportTuple.add(importLine);
                paramList.add(paramImportTuple);
            }
            paramImportsList.add(paramList);
        }

        return paramImportsList;
    }


    /*
        @param - all parameter types, including primitives
        @param - all standard import statements

        @return - list of parameters in order
     */
    private List<String> matchFullParameters(List<String> parameters, List<String> imports) {
        List<String> fullParamsList = new ArrayList<>();

        for (String param : parameters) {
            if (MBConstants.PRIMITIVES_LIST.contains(param)) {
                fullParamsList.add(param);
            }
            else {  // must check against imports
                boolean importFound = false;
                int importIter = 0;
                while (!importFound) {
                    String[] importBits = imports.get(importIter).split("\\.");
                    if (param.equals(importBits[importBits.length-1])) {
                        importFound = true;
                        fullParamsList.add(imports.get(MBConstants.IMPORT_INDEX));
                    }
                    importIter++;
                }
            }
        }

        return fullParamsList;
    }

    /*
        Method compares each parameter at a time to list of standard imports. If any parameter does not have a
        corresponding import statement, return false.

        @param parameters - list of parameter types
        @param imports are the standard ones
     */
    private boolean checkIfNormalParameterImports(List<String> parameters, List<String> imports) {
        boolean allStandard = true;

        for (String param : parameters) {
            boolean foundImportForParam = false;
            for (String importStatement : imports) {
                String[] importBits = importStatement.split("\\.");
                if (param.equals(importBits[importBits.length - 1])) {
                    foundImportForParam = true;
                }
            }
            if (!foundImportForParam) {
                if (!MBConstants.PRIMITIVES_LIST.contains(param)) {
                    allStandard = false;
                }
            }
        }

        return allStandard;
    }



    private List<List<String>> getParameterImports(String imports, String packageName) {
        // remove the brackets
        imports = imports.substring(1, imports.length()-1);

        List<String> importList = new ArrayList<>(Arrays.asList(imports.split(",")));
        for (int importIter = 0; importIter < importList.size(); importIter++) {
            String importStatement = importList.get(importIter).replaceFirst("import", "");
            importList.set(importIter, importStatement);
        }

        // initialize starImports and add defaults
        List<String> starImports = new ArrayList<>();
        starImports.add("java.lang.*");
        starImports.add(packageName + ".*");

        // now run through importList to see if there are any * imports
        for (String importString : importList) {
            if (importString.charAt(importString.length() - 1) == '*') {
                starImports.add(importString);
                importList.remove(importString); // has * - importList is full imports
            }
        }

        List<List<String>> bigImportList = new ArrayList<>();
        bigImportList.add(starImports);
        bigImportList.add(importList);

        return bigImportList;
    }

    private List<String> getParameterTypesList(String[] parameters) {
        // parameter is comma separated parameter pairs

        List<String> paramTypes = new ArrayList<>();
        for (String paramPair : parameters) {
            String[] paramType = paramPair.split(" ");
            paramTypes.add(paramType[0]);
        }

        return paramTypes;
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
