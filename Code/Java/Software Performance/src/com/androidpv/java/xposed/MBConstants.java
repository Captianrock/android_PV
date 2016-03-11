package com.androidpv.java.xposed;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Erin on 3/10/16.
 */
public final class MBConstants {

    public static final int PACKAGE_INDEX = 0;
    public static final int CLASS_INDEX = 1;
    public static final int IMPORT_INDEX = 2;
    public static final int METHOD_INDEX = 3;
    public static final int PARAMETERS_INDEX = 4;
    public static final int MODIFIERS_INDEX = 5;

    public static final String TRY_STRING = "\t\t\ttry { \n\t";
    public static final String PERIOD = ".";
    public static final String SLASH = "\"";

    // Constants for findAndHookMethod
    public static final String FIND_HOOK_METHOD_STRING = "\t\t\tfindAndHookMethod(\"";
    public static final String LPPARAM_CLASS_LOADER_STRING = "\", lpparam.classLoader, \"";
    public static final String END_OF_FIND_HOOK_METHOD = ", new XC_MethodHook() {\n";

    public static final List<String> PRIMITIVES_LIST
            = Arrays.asList("byte", "short", "int", "long", "float", "double", "boolean", "char");

}
