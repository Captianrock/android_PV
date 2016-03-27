package com.androidpv.java.xposed;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Erin on 3/10/16.
 *
 * Constants class containing the constants required by ModuleBuilder
 */
public final class MBConstants {

    // JAR_FILES is used in Parser
    public static final String JAR_FILES = "/parseLibs";

    public static final int PACKAGE_INDEX = 0;
    public static final int CLASS_INDEX = 1;
    public static final int PARENT_INDEX = 2;
    public static final int ANON_CLASS_INDEX = 3;
    public static final int METHOD_INDEX = 4;
    public static final int PARAMETERS_INDEX = 5;
    public static final int MODIFIERS_INDEX = 6;
    public static final int CONSTRUCTOR_BOOL_INDEX = 7;
    public static final int INTERFACE_BOOL_INDEX = 8;


    public static final String PARSED_FILE_SEPARATOR = ";";


    public static final String END_OF_CODE = "\t\t}\n\t}\n}\n";


    // Constants for findAndHookMethod
    public static final String PACKAGE_NAME_IF_BEGINNING = "\t\tif (lpparam.packageName.equals(\"";
    public static final String PACKAGE_NAME_IF_END = "\")) {\n";
    public static final String FIND_HOOK_METHOD_STRING = "\t\t\tfindAndHookMethod(\"";
    public static final String FIND_HOOK_CONSTRUCTOR_STRING = "\t\t\tfindAndHookConstructor(\"";
    public static final String LPPARAM_CLASS_LOADER_STRING = "\", lpparam.classLoader";
    public static final String COMMA_QUOTE = ", \"";
    public static final String END_OF_FIND_HOOK_METHOD = ", new XC_MethodHook() {\n";
    public static final String END_OF_IF_CLAUSE = "\t\t}\n\n";

    // if we need try block for findAndHookMethods
    public static final String TRY_BLOCK_BEGINNING = "\t\t\t\ttry {";
    public static final String TRY_BLOCK_END_FULL = "\t\t\t\t}\n" +
            "\t\t\t\tcatch (Throwable t) {\n\t\t\t\t\tSystem.err.println(t.getMessage());\n\t\t\t\t}";
    public static final String TRY_BLOCK_END_1 = "\t\t\t\t}\n" +
            "\t\t\t\tcatch (Throwable t) {\n\t\t\t\t\tSystem.err.println(\"Cannot find ";
    public static final String TRY_BLOCK_END_2 = "\" in \"";
    public static final String TRY_BLOCK_END_3 = ");\n\t\t\t\t\tSystem.err.println(t.getMessage());\n\t\t\t\t}";

    // Constants for addHook methods
    public static final String ADD_HOOK_METHOD_BEGINNING = "\t\t\t\t@Override\n\t\t\t\tprotected void ";
    public static final String BEFORE_STRING = "before";
    public static final String AFTER_STRING = "after";
    public static final String ADD_HOOK_METHOD_END = "HookedMethod(MethodHookParam param) throws Throwable {\n" +
        "\t\t\t\t\tendTime = System.nanoTime();\n\t\t\t\t\tXposedBridge.log(\"";
    public static final String METHOD_START_TIME = "::methodStart::\" + startTime);\n\t\t\t\t}";
    public static final String METHOD_END_TIME = "::methodEnd::\" + endTime);\n\t\t\t\t}\n\t\t\t});\n";


    // Constants for creating code header
    public static final String MODULE_PACKAGE_NAME = "package com.example.kim.softwareperformance;\n";
    public static final String IMPORTS = "import de.robv.android.xposed.IXposedHookLoadPackage;\n" +
        "import de.robv.android.xposed.XC_MethodHook;\n" +
        "import de.robv.android.xposed.XSharedPreferences;\n" +
        "import de.robv.android.xposed.XposedBridge;\n" +
        "import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;\n\n" +
        "import static de.robv.android.xposed.XposedHelpers.findAndHookConstructor;\n" +
        "import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;\n";
    public static final String CLASS_NAME_MAIN_METHOD = "public class Tutorial implements IXposedHookLoadPackage {\n" +
        "\tlong startTime,endTime;\n" +
        "\tpublic void handleLoadPackage(final LoadPackageParam lpparam) throws Throwable {\n" +
        "\t\tXposedBridge.log(\"Loaded app: \" + lpparam.packageName);\n";
    public static final String PREFERENCES = "\t\tfinal XSharedPreferences pref = new XSharedPreferences(" +
        "\"com.example.kim.softwareperformance\", \"user_settings\");\n\t\tpref.makeWorldReadable();\n" +
        "\t\tpref.reload();\n";
    public static final String MAIN_PACKAGE_IF_CLAUSE_BEGINNING = "\t\tif (!(";
    public static final String MAIN_LPPARAM_PACKAGENAME_EQUALS = "lpparam.packageName.equals(\"";
    public static final String MAIN_PACKAGE_IF_CLAUSE_OR = "\") || ";
    public static final String MAIN_PACKAGE_IF_CLAUSE_END = "\"))) {\n\t\t\treturn;\n\t\t}\n";


    public static final List<String> PRIMITIVES_LIST = Arrays.asList("boolean", "byte", "char", "short", "int", "long",
            "float", "double");
}
