package com.example.kim.softwareperformance;

import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.widget.TextView;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XSharedPreferences;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;

public class Tutorial implements IXposedHookLoadPackage {
    long startTime,endTime;
    public void handleLoadPackage(final LoadPackageParam lpparam) throws Throwable {
        if (!lpparam.packageName.equals("com.android.systemui"))
            return;
        final XSharedPreferences pref = new XSharedPreferences("com.example.kim.softwareperformance", "user_settings");
        pref.makeWorldReadable();
        pref.reload();
        findAndHookMethod("com.android.systemui.statusbar.policy.Clock", lpparam.classLoader, "updateClock", new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("updateClock::methodStart::" + startTime);
            }

            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                TextView tv = (TextView) param.thisObject;
                //long duration = (endTime - startTime);
                XposedBridge.log("updateClock::methodEnd::" + endTime);
                //Gets the shared preference
                String text = pref.getString("user_text", "");
                XposedBridge.log("Send: " + text);
                //reads the value which is saves, using nothing as default value to use if nothing is saved
                tv.setText(text);
                tv.setTextColor(Color.BLUE);
            }
        });
    }
}