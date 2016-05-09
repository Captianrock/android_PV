package com.androidpv.java.xposed;

/**
 * Created by Erin on 3/10/16.
 *
 * Constants class containing the constants required by ModuleBuilder
 */
public final class MBConstants {

    // for APKBuilder
    public static final String USER_DIR = "user.dir";
    public static final String ANDROID_TEST_DIR = "AndroidTest";
    public static final String BUILD_FAILED = "BUILD FAILED";


    // for data parsing (commandLine)
    public static final String DIRTY_FILE = "dataOriginal.txt";
    public static final String CLEAN_FILE = "data.txt";
    public static final String DASHES = "-----------------";

    // To build module
    public static final String LOGCAT_SEP = "*!*";
    public static final String FIRST_HALF = "package com.test;\n\n" +
            "import java.lang.reflect.Method;\n" +
            "import java.lang.reflect.Modifier;\n" +
            "import java.util.Enumeration;\n\n" +
            "import dalvik.system.DexFile;\n" +
            "import de.robv.android.xposed.IXposedHookLoadPackage;\n" +
            "import de.robv.android.xposed.XC_MethodHook;\n" +
            "import de.robv.android.xposed.XSharedPreferences;\n" +
            "import de.robv.android.xposed.XposedBridge;\n" +
            "import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;\n\n" +
            "public class Tutorial implements IXposedHookLoadPackage {\n" +
            "    long startTime, endTime;\n" +
            "\n" +
            "    public void handleLoadPackage(final LoadPackageParam lpparam) throws Throwable {\n" +
            "        XposedBridge.log(\"" + LOGCAT_SEP + "Loaded app: \" + lpparam.packageName);\n" +
            "        \n" +
            "        if (!(lpparam.packageName.equals(\"";
    public static final String ANOTHER = "\") || lpparam.packageName.equals(\"";
    public static final String SECOND_HALF = "\"))) {\n" +
            "            return;\n" +
            "        }\n" +
            "\n" +
            "        final XSharedPreferences pref = new XSharedPreferences(\"com.example.kim.softwareperformance\", \"user_settings\");\n" +
            "        pref.makeWorldReadable();\n" +
            "        pref.reload();\n" +
            "\n" +
            "        func0(lpparam);\n" +
            "\n" +
            "    }\n" +
            "\n" +
            "\n" +
            "    public void func0(final LoadPackageParam lpparam) throws Throwable {\n" +
            "\n" +
            "        DexFile dexFile = new DexFile(lpparam.appInfo.sourceDir);\n" +
            "\n" +
            "        Enumeration<String> classNames = dexFile.entries();\n" +
            "        while (classNames.hasMoreElements()) {\n" +
            "            final String className = classNames.nextElement();\n" +
            "\n" +
            "\n" +
            "            if (className.startsWith(lpparam.packageName) // Only listen to package classes\n" +
            "                    && !className.contains(\"BuildConfig\") // Android class that isn't actually used\n" +
            "                    && !className.startsWith(lpparam.packageName + \".R$\") // ^ same here\n" +
            "                    && !className.equals(lpparam.packageName + \".R\")) {\n" +
            "                final Class clazz = Class.forName(className, false, lpparam.classLoader);\n" +
            "\n" +
            "                XposedBridge.hookAllConstructors(clazz, new XC_MethodHook() {\n" +
            "                    @Override\n" +
            "                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {\n" +
            "\n" +
            "                        startTime = System.nanoTime();\n" +
            "                        XposedBridge.log(\"" + LOGCAT_SEP + "\" + clazz.getPackage().getName() + \"::\" + clazz.getSimpleName() +\n" +
            "                                \".constructor::methodStart::\" + startTime);\n" +
            "                    }\n" +
            "\n" +
            "                    @Override\n" +
            "                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {\n" +
            "\n" +
            "                        endTime = System.nanoTime();\n" +
            "                        XposedBridge.log(\"" + LOGCAT_SEP + "\" + clazz.getPackage().getName() + \"::\" + clazz.getSimpleName() +\n" +
            "                                \".constructor::methodEnd::\" + endTime);\n" +
            "                    }\n" +
            "                });\n" +
            "\n" +
            "                for (final Method method : clazz.getDeclaredMethods()) {\n" +
            "                    if (!Modifier.isAbstract(method.getModifiers())) {\n" +
            "                        XposedBridge.hookMethod(method, new XC_MethodHook() {\n" +
            "\n" +
            "                            @Override\n" +
            "                            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {\n" +
            "\n" +
            "                                Class<?>[] params = method.getParameterTypes();\n" +
            "                                String paramString = \"\";\n" +
            "                                for (int i = 0; i < params.length; i++) {\n" +
            "                                    if (i > 0) {\n" +
            "                                        paramString += \", \";\n" +
            "                                    }\n" +
            "                                    paramString += params[i].getSimpleName();\n" +
            "                                }\n" +
            "\n" +
            "                                startTime = System.nanoTime();\n" +
            "                                XposedBridge.log(\"" + LOGCAT_SEP + "\" + clazz.getPackage().getName() + \"::\" + clazz.getSimpleName() +\n" +
            "                                        \".\" + method.getName() + \"(\" + paramString +\n" +
            "                                        \")::methodStart::\" + startTime);\n" +
            "                            }\n" +
            "\n" +
            "                            @Override\n" +
            "                            protected void afterHookedMethod(MethodHookParam param) throws Throwable {\n" +
            "\n" +
            "                                Class<?>[] params = method.getParameterTypes();\n" +
            "                                String paramString = \"\";\n" +
            "                                for (int i = 0; i < params.length; i++) {\n" +
            "                                    if (i > 0) {\n" +
            "                                        paramString += \", \";\n" +
            "                                    }\n" +
            "                                    paramString += params[i].getSimpleName();\n" +
            "                                }\n" +
            "\n" +
            "                                endTime = System.nanoTime();\n" +
            "                                XposedBridge.log(\"" + LOGCAT_SEP + "\" + clazz.getPackage().getName() + \"::\" + clazz.getSimpleName() +\n" +
            "                                        \".\" + method.getName() + \"(\" + paramString +\n" +
            "                                        \")::methodEnd::\" + endTime);\n" +
            "                            }\n" +
            "                        });\n" +
            "                    }\n" +
            "                }\n" +
            "            }\n" +
            "\n" +
            "        }\n" +
            "\n" +
            "    }\n" +
            "}\n" +
            "\n";
}
