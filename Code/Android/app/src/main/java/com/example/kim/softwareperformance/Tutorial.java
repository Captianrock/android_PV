package com.example.kim.softwareperformance;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XSharedPreferences;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;

import static de.robv.android.xposed.XposedHelpers.findAndHookConstructor;
import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;

public class Tutorial implements IXposedHookLoadPackage {
    long startTime,endTime;
    public void handleLoadPackage(final LoadPackageParam lpparam) throws Throwable {
        XposedBridge.log("  Loaded app: " + lpparam.packageName);

        if (!(lpparam.packageName.equals("me.kuehle.carreport") || lpparam.packageName.equals("me.kuehle.chartlib"))) {
            return;
        }

        final XSharedPreferences pref = new XSharedPreferences("com.example.kim.softwareperformance", "user_settings");
        pref.makeWorldReadable();
        pref.reload();

        if (lpparam.packageName.equals("me.kuehle.carreport")) {
            func0(lpparam);
        }

        if (lpparam.packageName.equals("me.kuehle.chartlib")) {
            func1(lpparam);
        }

    }


    public void func0(final LoadPackageParam lpparam) throws Throwable {



            findAndHookMethod("me.kuehle.carreport.Application",lpparam.classLoader, "getContext",new XC_MethodHook() {

                @Override
                protected void beforeHookedMethod (MethodHookParam param)throws Throwable {
                    startTime = System.nanoTime();
                    XposedBridge.log("getContext::methodStart::" + startTime);
                }
                @Override
                protected void afterHookedMethod (MethodHookParam param)throws Throwable {
                    endTime = System.nanoTime();
                    XposedBridge.log("getContext::methodEnd::" + endTime);
                }
            });


        findAndHookMethod("me.kuehle.carreport.Application", lpparam.classLoader, "reinitializeDatabase", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("reinitializeDatabase::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("reinitializeDatabase::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.Application", lpparam.classLoader, "onCreate", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onCreate::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onCreate::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.Application", lpparam.classLoader, "upgradeOldSyncServiceToNewSyncAdapterWithAccounts", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("upgradeOldSyncServiceToNewSyncAdapterWithAccounts::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("upgradeOldSyncServiceToNewSyncAdapterWithAccounts::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.Application", lpparam.classLoader, "setupDataChangeObserver", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("setupDataChangeObserver::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("setupDataChangeObserver::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.Application", lpparam.classLoader, "updateReminders", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("updateReminders::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("updateReminders::methodEnd::" + endTime);
            }
        });

        findAndHookConstructor("me.kuehle.carreport.data.balancing.BalancedRefuelingCursor", lpparam.classLoader, "android.database.Cursor", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("BalancedRefuelingCursor::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("BalancedRefuelingCursor::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.balancing.BalancedRefuelingCursor", lpparam.classLoader, "getValid", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getValid::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getValid::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.balancing.BalancedRefuelingCursor", lpparam.classLoader, "getGuessed", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getGuessed::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getGuessed::methodEnd::" + endTime);
            }
        });

        findAndHookConstructor("me.kuehle.carreport.data.balancing.RefuelingBalancer$BalancedRefueling", lpparam.classLoader, "me.kuehle.carreport.data.balancing.RefuelingBalancer", "me.kuehle.carreport.provider.refueling.RefuelingCursor", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("BalancedRefueling::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("BalancedRefueling::methodEnd::" + endTime);
            }
        });

        findAndHookConstructor("me.kuehle.carreport.data.balancing.RefuelingBalancer$BalancedRefueling", lpparam.classLoader, "me.kuehle.carreport.data.balancing.RefuelingBalancer", "long", "java.util.Date", "int", "float", "float", "boolean", "java.lang.String", "long", "long", "java.lang.String", "java.lang.String", "java.lang.String", "int", "int", "java.util.Date", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("BalancedRefueling::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("BalancedRefueling::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.balancing.RefuelingBalancer$BalancedRefueling", lpparam.classLoader, "values", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("values::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("values::methodEnd::" + endTime);
            }
        });

        findAndHookConstructor("me.kuehle.carreport.data.balancing.RefuelingBalancer", lpparam.classLoader, "android.content.Context", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("RefuelingBalancer::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("RefuelingBalancer::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.balancing.RefuelingBalancer", lpparam.classLoader, "getBalancedRefuelings", "long", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getBalancedRefuelings::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getBalancedRefuelings::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.balancing.RefuelingBalancer", lpparam.classLoader, "getBalancedRefuelings", "long", "boolean", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getBalancedRefuelings::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getBalancedRefuelings::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.balancing.RefuelingBalancer", lpparam.classLoader, "getBalancedRefuelings", "long", "java.lang.String", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getBalancedRefuelings::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getBalancedRefuelings::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.balancing.RefuelingBalancer", lpparam.classLoader, "getBalancedRefuelings", "long", "java.lang.String", "boolean", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getBalancedRefuelings::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getBalancedRefuelings::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.balancing.RefuelingBalancer", lpparam.classLoader, "getBalancedRefuelings", "me.kuehle.carreport.provider.refueling.RefuelingSelection", "boolean", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getBalancedRefuelings::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getBalancedRefuelings::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.balancing.RefuelingBalancer", lpparam.classLoader, "calculateBalancedRefuelings", "java.util.List", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("calculateBalancedRefuelings::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("calculateBalancedRefuelings::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.balancing.RefuelingBalancer", lpparam.classLoader, "getBalancedAverageConsumption", "java.util.List", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getBalancedAverageConsumption::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getBalancedAverageConsumption::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.balancing.RefuelingBalancer", lpparam.classLoader, "getBalancedAverageDistanceOfFullRefuelings", "java.util.List", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getBalancedAverageDistanceOfFullRefuelings::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getBalancedAverageDistanceOfFullRefuelings::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.balancing.RefuelingBalancer", lpparam.classLoader, "getAveragePricePerUnit", "java.util.List", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getAveragePricePerUnit::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getAveragePricePerUnit::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.balancing.RefuelingBalancer", lpparam.classLoader, "areRefuelingsValid", "java.util.List", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("areRefuelingsValid::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("areRefuelingsValid::methodEnd::" + endTime);
            }
        });

        findAndHookConstructor("me.kuehle.carreport.data.calculation.AbstractCalculation$ForceLoadContentObserver", lpparam.classLoader, "me.kuehle.carreport.data.calculation.AbstractCalculation", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("ForceLoadContentObserver::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("ForceLoadContentObserver::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.calculation.AbstractCalculation$ForceLoadContentObserver", lpparam.classLoader, "deliverSelfNotifications", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("deliverSelfNotifications::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("deliverSelfNotifications::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.calculation.AbstractCalculation$ForceLoadContentObserver", lpparam.classLoader, "onChange", "boolean", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onChange::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onChange::methodEnd::" + endTime);
            }
        });

        findAndHookConstructor("me.kuehle.carreport.data.calculation.AbstractCalculation", lpparam.classLoader, "android.content.Context", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("AbstractCalculation::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("AbstractCalculation::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.calculation.AbstractCalculation", lpparam.classLoader, "registerContentObserver", "android.database.ContentObserver", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("registerContentObserver::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("registerContentObserver::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.calculation.AbstractCalculation", lpparam.classLoader, "unregisterContentObserver", "android.database.ContentObserver", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("unregisterContentObserver::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("unregisterContentObserver::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.calculation.AbstractCalculation", lpparam.classLoader, "calculate", "double", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("calculate::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("calculate::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.calculation.AbstractCalculation", lpparam.classLoader, "contentChanged", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("contentChanged::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("contentChanged::methodEnd::" + endTime);
            }
        });

        findAndHookConstructor("me.kuehle.carreport.data.calculation.AbstractDistancePriceCalculation", lpparam.classLoader, "android.content.Context", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("AbstractDistancePriceCalculation::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("AbstractDistancePriceCalculation::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.calculation.AbstractDistancePriceCalculation", lpparam.classLoader, "onLoadData", "android.database.ContentObserver", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onLoadData::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onLoadData::methodEnd::" + endTime);
            }
        });

        findAndHookConstructor("me.kuehle.carreport.data.calculation.AbstractPriceVolumeCalculation", lpparam.classLoader, "android.content.Context", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("AbstractPriceVolumeCalculation::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("AbstractPriceVolumeCalculation::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.calculation.AbstractPriceVolumeCalculation", lpparam.classLoader, "onLoadData", "android.database.ContentObserver", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onLoadData::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onLoadData::methodEnd::" + endTime);
            }
        });

        findAndHookConstructor("me.kuehle.carreport.data.calculation.AbstractVolumeDistanceCalculation", lpparam.classLoader, "android.content.Context", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("AbstractVolumeDistanceCalculation::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("AbstractVolumeDistanceCalculation::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.calculation.AbstractVolumeDistanceCalculation", lpparam.classLoader, "onLoadData", "android.database.ContentObserver", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onLoadData::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onLoadData::methodEnd::" + endTime);
            }
        });

        findAndHookConstructor("me.kuehle.carreport.data.calculation.CalculationItem", lpparam.classLoader, "java.lang.String", "double", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("CalculationItem::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("CalculationItem::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.calculation.CalculationItem", lpparam.classLoader, "getName", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getName::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getName::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.calculation.CalculationItem", lpparam.classLoader, "getValue", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getValue::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getValue::methodEnd::" + endTime);
            }
        });

        findAndHookConstructor("me.kuehle.carreport.data.calculation.DistanceToPriceCalculation", lpparam.classLoader, "android.content.Context", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("DistanceToPriceCalculation::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("DistanceToPriceCalculation::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.calculation.DistanceToPriceCalculation", lpparam.classLoader, "getName", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getName::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getName::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.calculation.DistanceToPriceCalculation", lpparam.classLoader, "getInputUnit", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getInputUnit::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getInputUnit::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.calculation.DistanceToPriceCalculation", lpparam.classLoader, "getOutputUnit", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getOutputUnit::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getOutputUnit::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.calculation.DistanceToPriceCalculation", lpparam.classLoader, "onCalculate", "double", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onCalculate::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onCalculate::methodEnd::" + endTime);
            }
        });

        findAndHookConstructor("me.kuehle.carreport.data.calculation.DistanceToVolumeCalculation", lpparam.classLoader, "android.content.Context", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("DistanceToVolumeCalculation::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("DistanceToVolumeCalculation::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.calculation.DistanceToVolumeCalculation", lpparam.classLoader, "getName", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getName::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getName::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.calculation.DistanceToVolumeCalculation", lpparam.classLoader, "getInputUnit", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getInputUnit::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getInputUnit::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.calculation.DistanceToVolumeCalculation", lpparam.classLoader, "getOutputUnit", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getOutputUnit::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getOutputUnit::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.calculation.DistanceToVolumeCalculation", lpparam.classLoader, "onCalculate", "double", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onCalculate::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onCalculate::methodEnd::" + endTime);
            }
        });

        findAndHookConstructor("me.kuehle.carreport.data.calculation.PriceToDistanceCalculation", lpparam.classLoader, "android.content.Context", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("PriceToDistanceCalculation::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("PriceToDistanceCalculation::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.calculation.PriceToDistanceCalculation", lpparam.classLoader, "getName", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getName::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getName::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.calculation.PriceToDistanceCalculation", lpparam.classLoader, "getInputUnit", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getInputUnit::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getInputUnit::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.calculation.PriceToDistanceCalculation", lpparam.classLoader, "getOutputUnit", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getOutputUnit::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getOutputUnit::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.calculation.PriceToDistanceCalculation", lpparam.classLoader, "onCalculate", "double", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onCalculate::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onCalculate::methodEnd::" + endTime);
            }
        });

        findAndHookConstructor("me.kuehle.carreport.data.calculation.PriceToVolumeCalculation", lpparam.classLoader, "android.content.Context", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("PriceToVolumeCalculation::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("PriceToVolumeCalculation::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.calculation.PriceToVolumeCalculation", lpparam.classLoader, "getName", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getName::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getName::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.calculation.PriceToVolumeCalculation", lpparam.classLoader, "getInputUnit", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getInputUnit::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getInputUnit::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.calculation.PriceToVolumeCalculation", lpparam.classLoader, "getOutputUnit", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getOutputUnit::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getOutputUnit::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.calculation.PriceToVolumeCalculation", lpparam.classLoader, "onCalculate", "double", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onCalculate::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onCalculate::methodEnd::" + endTime);
            }
        });

        findAndHookConstructor("me.kuehle.carreport.data.calculation.VolumeToDistanceCalculation", lpparam.classLoader, "android.content.Context", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("VolumeToDistanceCalculation::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("VolumeToDistanceCalculation::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.calculation.VolumeToDistanceCalculation", lpparam.classLoader, "getName", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getName::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getName::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.calculation.VolumeToDistanceCalculation", lpparam.classLoader, "getInputUnit", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getInputUnit::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getInputUnit::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.calculation.VolumeToDistanceCalculation", lpparam.classLoader, "getOutputUnit", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getOutputUnit::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getOutputUnit::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.calculation.VolumeToDistanceCalculation", lpparam.classLoader, "onCalculate", "double", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onCalculate::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onCalculate::methodEnd::" + endTime);
            }
        });

        findAndHookConstructor("me.kuehle.carreport.data.calculation.VolumeToPriceCalculation", lpparam.classLoader, "android.content.Context", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("VolumeToPriceCalculation::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("VolumeToPriceCalculation::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.calculation.VolumeToPriceCalculation", lpparam.classLoader, "getName", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getName::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getName::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.calculation.VolumeToPriceCalculation", lpparam.classLoader, "getInputUnit", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getInputUnit::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getInputUnit::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.calculation.VolumeToPriceCalculation", lpparam.classLoader, "getOutputUnit", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getOutputUnit::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getOutputUnit::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.calculation.VolumeToPriceCalculation", lpparam.classLoader, "onCalculate", "double", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onCalculate::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onCalculate::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.query.CarQueries", lpparam.classLoader, "getCount", "android.content.Context", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getCount::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getCount::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.query.CarQueries", lpparam.classLoader, "getUsedFuelTypeCategories", "android.content.Context", "long", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getUsedFuelTypeCategories::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getUsedFuelTypeCategories::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.query.CarQueries", lpparam.classLoader, "getLatestMileage", "android.content.Context", "long", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getLatestMileage::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getLatestMileage::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.query.FuelTypeQueries", lpparam.classLoader, "getAllCategories", "android.content.Context", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getAllCategories::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getAllCategories::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.query.FuelTypeQueries", lpparam.classLoader, "ensureAtLeastOne", "android.content.Context", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("ensureAtLeastOne::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("ensureAtLeastOne::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.query.FuelTypeQueries", lpparam.classLoader, "getMostUsedId", "android.content.Context", "long", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getMostUsedId::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getMostUsedId::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.query.FuelTypeQueries", lpparam.classLoader, "isUsed", "android.content.Context", "long", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("isUsed::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("isUsed::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.query.OtherCostQueries", lpparam.classLoader, "getTitles", "android.content.Context", "boolean", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getTitles::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getTitles::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.query.RefuelingQueries", lpparam.classLoader, "getPrevious", "android.content.Context", "long", "java.util.Date", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getPrevious::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getPrevious::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.query.RefuelingQueries", lpparam.classLoader, "getNext", "android.content.Context", "long", "java.util.Date", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getNext::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getNext::methodEnd::" + endTime);
            }
        });

        findAndHookConstructor("me.kuehle.carreport.data.query.ReminderQueries", lpparam.classLoader, "android.content.Context", "me.kuehle.carreport.provider.reminder.ReminderCursor", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("ReminderQueries::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("ReminderQueries::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.query.ReminderQueries", lpparam.classLoader, "getDistanceToDue", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getDistanceToDue::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getDistanceToDue::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.query.ReminderQueries", lpparam.classLoader, "getTimeToDue", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getTimeToDue::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getTimeToDue::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.query.ReminderQueries", lpparam.classLoader, "isSnoozed", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("isSnoozed::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("isSnoozed::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.query.ReminderQueries", lpparam.classLoader, "isDue", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("isDue::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("isDue::methodEnd::" + endTime);
            }
        });

        findAndHookConstructor("me.kuehle.carreport.data.report.AbstractReport$AbstractListItem", lpparam.classLoader, "java.lang.String", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("AbstractListItem::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("AbstractListItem::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.report.AbstractReport$AbstractListItem", lpparam.classLoader, "getLabel", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getLabel::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getLabel::methodEnd::" + endTime);
            }
        });

        findAndHookConstructor("me.kuehle.carreport.data.report.AbstractReport$Item", lpparam.classLoader, "java.lang.String", "java.lang.String", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("Item::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("Item::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.report.AbstractReport$Item", lpparam.classLoader, "compareTo", "me.kuehle.carreport.data.report.AbstractReport$AbstractListItem", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("compareTo::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("compareTo::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.report.AbstractReport$Item", lpparam.classLoader, "getValue", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getValue::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getValue::methodEnd::" + endTime);
            }
        });

        findAndHookConstructor("me.kuehle.carreport.data.report.AbstractReport$Section", lpparam.classLoader, "java.lang.String", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("Section::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("Section::methodEnd::" + endTime);
            }
        });

        findAndHookConstructor("me.kuehle.carreport.data.report.AbstractReport$Section", lpparam.classLoader, "java.lang.String", "int", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("Section::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("Section::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.report.AbstractReport$Section", lpparam.classLoader, "addItem", "me.kuehle.carreport.data.report.AbstractReport$Item", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("addItem::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("addItem::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.report.AbstractReport$Section", lpparam.classLoader, "compareTo", "me.kuehle.carreport.data.report.AbstractReport$AbstractListItem", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("compareTo::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("compareTo::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.report.AbstractReport$Section", lpparam.classLoader, "equals", "java.lang.Object", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("equals::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("equals::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.report.AbstractReport$Section", lpparam.classLoader, "getColor", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getColor::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getColor::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.report.AbstractReport$Section", lpparam.classLoader, "getItems", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getItems::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getItems::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.report.AbstractReport$Section", lpparam.classLoader, "getOrder", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getOrder::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getOrder::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.report.AbstractReport$Section", lpparam.classLoader, "hashCode", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("hashCode::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("hashCode::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.report.AbstractReport", lpparam.classLoader, "newInstance", "java.lang.Class", "android.content.Context", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("newInstance::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("newInstance::methodEnd::" + endTime);
            }
        });

        try {
            findAndHookMethod("me.kuehle.carreport.data.report.AbstractReport$1", lpparam.classLoader, "formatLabel", "double", new XC_MethodHook() {

                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    startTime = System.nanoTime();
                    XposedBridge.log("formatLabel::methodStart::" + startTime);
                }
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    endTime = System.nanoTime();
                    XposedBridge.log("formatLabel::methodEnd::" + endTime);
                }
            });

        }
        catch (Throwable t) {
            System.err.println(t.getMessage());
        }

        findAndHookConstructor("me.kuehle.carreport.data.report.AbstractReport", lpparam.classLoader, "android.content.Context", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("AbstractReport::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("AbstractReport::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.report.AbstractReport", lpparam.classLoader, "getChart", "boolean", "boolean", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getChart::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getChart::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.report.AbstractReport", lpparam.classLoader, "getChartOption", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getChartOption::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getChartOption::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.report.AbstractReport", lpparam.classLoader, "getData", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getData::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getData::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.report.AbstractReport", lpparam.classLoader, "getData", "boolean", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getData::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getData::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.report.AbstractReport", lpparam.classLoader, "isShowTrend", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("isShowTrend::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("isShowTrend::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.report.AbstractReport", lpparam.classLoader, "isShowOverallTrend", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("isShowOverallTrend::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("isShowOverallTrend::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.report.AbstractReport", lpparam.classLoader, "registerContentObserver", "android.database.ContentObserver", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("registerContentObserver::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("registerContentObserver::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.report.AbstractReport", lpparam.classLoader, "setChartOption", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("setChartOption::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("setChartOption::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.report.AbstractReport", lpparam.classLoader, "setShowTrend", "boolean", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("setShowTrend::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("setShowTrend::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.report.AbstractReport", lpparam.classLoader, "setShowOverallTrend", "boolean", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("setShowOverallTrend::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("setShowOverallTrend::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.report.AbstractReport", lpparam.classLoader, "update", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("update::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("update::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.report.AbstractReport", lpparam.classLoader, "addDataSection", "java.lang.String", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("addDataSection::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("addDataSection::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.report.AbstractReport", lpparam.classLoader, "addDataSection", "java.lang.String", "int", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("addDataSection::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("addDataSection::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.report.AbstractReport", lpparam.classLoader, "applyDefaultChartStyles", "me.kuehle.chartlib.chart.Chart", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("applyDefaultChartStyles::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("applyDefaultChartStyles::methodEnd::" + endTime);
            }
        });

        findAndHookConstructor("me.kuehle.carreport.data.report.AbstractReportGraphData$OverallTrendReportData", lpparam.classLoader, "me.kuehle.carreport.data.report.AbstractReportGraphData", "me.kuehle.carreport.data.report.AbstractReportGraphData", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("OverallTrendReportData::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("OverallTrendReportData::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.report.AbstractReportGraphData$OverallTrendReportData", lpparam.classLoader, "applySeriesStyle", "int", "me.kuehle.chartlib.renderer.AbstractRenderer", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("applySeriesStyle::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("applySeriesStyle::methodEnd::" + endTime);
            }
        });

        findAndHookConstructor("me.kuehle.carreport.data.report.AbstractReportGraphData$TrendReportData", lpparam.classLoader, "me.kuehle.carreport.data.report.AbstractReportGraphData", "me.kuehle.carreport.data.report.AbstractReportGraphData", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("TrendReportData::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("TrendReportData::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.report.AbstractReportGraphData$TrendReportData", lpparam.classLoader, "applySeriesStyle", "int", "me.kuehle.chartlib.renderer.AbstractRenderer", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("applySeriesStyle::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("applySeriesStyle::methodEnd::" + endTime);
            }
        });

        findAndHookConstructor("me.kuehle.carreport.data.report.AbstractReportGraphData", lpparam.classLoader, "android.content.Context", "java.lang.String", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("AbstractReportGraphData::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("AbstractReportGraphData::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.report.AbstractReportGraphData", lpparam.classLoader, "applySeriesStyle", "int", "me.kuehle.chartlib.renderer.AbstractRenderer", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("applySeriesStyle::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("applySeriesStyle::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.report.AbstractReportGraphData", lpparam.classLoader, "createOverallTrendData", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("createOverallTrendData::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("createOverallTrendData::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.report.AbstractReportGraphData", lpparam.classLoader, "createTrendData", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("createTrendData::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("createTrendData::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.report.AbstractReportGraphData", lpparam.classLoader, "getSeries", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getSeries::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getSeries::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.report.AbstractReportGraphData", lpparam.classLoader, "isEmpty", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("isEmpty::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("isEmpty::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.report.AbstractReportGraphData", lpparam.classLoader, "size", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("size::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("size::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.report.AbstractReportGraphData", lpparam.classLoader, "sort", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("sort::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("sort::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.report.AbstractReportGraphData", lpparam.classLoader, "getTrendColor", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getTrendColor::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getTrendColor::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.report.AbstractReportGraphData", lpparam.classLoader, "markLastLine", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("markLastLine::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("markLastLine::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.report.AbstractReportGraphData", lpparam.classLoader, "markLastPoint", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("markLastPoint::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("markLastPoint::methodEnd::" + endTime);
            }
        });

        findAndHookConstructor("me.kuehle.carreport.data.report.CostsReport$ReportGraphData", lpparam.classLoader, "me.kuehle.carreport.data.report.CostsReport", "android.content.Context", "java.lang.String", "int", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("ReportGraphData::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("ReportGraphData::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.report.CostsReport$ReportGraphData", lpparam.classLoader, "add", "org.joda.time.DateTime", "double", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("add::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("add::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.report.CostsReport$ReportGraphData", lpparam.classLoader, "createOverallTrendData", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("createOverallTrendData::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("createOverallTrendData::methodEnd::" + endTime);
            }
        });

        findAndHookConstructor("me.kuehle.carreport.data.report.CostsReport", lpparam.classLoader, "android.content.Context", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("CostsReport::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("CostsReport::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.report.CostsReport", lpparam.classLoader, "getAvailableChartOptions", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getAvailableChartOptions::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getAvailableChartOptions::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.report.CostsReport", lpparam.classLoader, "getTitle", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getTitle::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getTitle::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.report.CostsReport", lpparam.classLoader, "onGetChart", "boolean", "boolean", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onGetChart::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onGetChart::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.report.CostsReport", lpparam.classLoader, "onUpdate", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onUpdate::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onUpdate::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.report.CostsReport", lpparam.classLoader, "getXValues", "me.kuehle.chartlib.data.Dataset", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getXValues::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getXValues::methodEnd::" + endTime);
            }
        });

        findAndHookConstructor("me.kuehle.carreport.data.report.FuelConsumptionReport$ReportGraphData", lpparam.classLoader, "me.kuehle.carreport.data.report.FuelConsumptionReport", "android.content.Context", "me.kuehle.carreport.provider.car.CarCursor", "java.lang.String", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("ReportGraphData::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("ReportGraphData::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.report.FuelConsumptionReport$ReportGraphData", lpparam.classLoader, "getAverageConsumption", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getAverageConsumption::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getAverageConsumption::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.report.FuelConsumptionReport$ReportGraphData", lpparam.classLoader, "getUsedCursors", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getUsedCursors::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getUsedCursors::methodEnd::" + endTime);
            }
        });

        findAndHookConstructor("me.kuehle.carreport.data.report.FuelConsumptionReport", lpparam.classLoader, "android.content.Context", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("FuelConsumptionReport::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("FuelConsumptionReport::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.report.FuelConsumptionReport", lpparam.classLoader, "getAvailableChartOptions", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getAvailableChartOptions::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getAvailableChartOptions::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.report.FuelConsumptionReport", lpparam.classLoader, "getTitle", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getTitle::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getTitle::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.report.FuelConsumptionReport", lpparam.classLoader, "onGetChart", "boolean", "boolean", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onGetChart::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onGetChart::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.report.FuelConsumptionReport", lpparam.classLoader, "onUpdate", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onUpdate::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onUpdate::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.report.FuelConsumptionReport", lpparam.classLoader, "addDataSection", "me.kuehle.carreport.provider.car.CarCursor", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("addDataSection::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("addDataSection::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.report.FuelConsumptionReport", lpparam.classLoader, "addDataSection", "me.kuehle.carreport.provider.car.CarCursor", "java.lang.String", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("addDataSection::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("addDataSection::methodEnd::" + endTime);
            }
        });

        findAndHookConstructor("me.kuehle.carreport.data.report.FuelPriceReport$ReportGraphData", lpparam.classLoader, "me.kuehle.carreport.data.report.FuelPriceReport", "android.content.Context", "me.kuehle.carreport.provider.fueltype.FuelTypeCursor", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("ReportGraphData::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("ReportGraphData::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.report.FuelPriceReport$ReportGraphData", lpparam.classLoader, "getUsedCursors", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getUsedCursors::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getUsedCursors::methodEnd::" + endTime);
            }
        });

        findAndHookConstructor("me.kuehle.carreport.data.report.FuelPriceReport", lpparam.classLoader, "android.content.Context", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("FuelPriceReport::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("FuelPriceReport::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.report.FuelPriceReport", lpparam.classLoader, "getAvailableChartOptions", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getAvailableChartOptions::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getAvailableChartOptions::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.report.FuelPriceReport", lpparam.classLoader, "getTitle", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getTitle::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getTitle::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.report.FuelPriceReport", lpparam.classLoader, "onGetChart", "boolean", "boolean", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onGetChart::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onGetChart::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.report.FuelPriceReport", lpparam.classLoader, "onUpdate", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onUpdate::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onUpdate::methodEnd::" + endTime);
            }
        });

        findAndHookConstructor("me.kuehle.carreport.data.report.MileageReport$ReportGraphDataAccumulated", lpparam.classLoader, "me.kuehle.carreport.data.report.MileageReport", "android.content.Context", "me.kuehle.carreport.provider.car.CarCursor", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("ReportGraphDataAccumulated::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("ReportGraphDataAccumulated::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.report.MileageReport$ReportGraphDataAccumulated", lpparam.classLoader, "getUsedCursors", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getUsedCursors::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getUsedCursors::methodEnd::" + endTime);
            }
        });

        findAndHookConstructor("me.kuehle.carreport.data.report.MileageReport$ReportGraphDataPerRefueling", lpparam.classLoader, "me.kuehle.carreport.data.report.MileageReport", "android.content.Context", "me.kuehle.carreport.provider.car.CarCursor", "java.lang.String", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("ReportGraphDataPerRefueling::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("ReportGraphDataPerRefueling::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.report.MileageReport$ReportGraphDataPerRefueling", lpparam.classLoader, "getUsedCursors", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getUsedCursors::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getUsedCursors::methodEnd::" + endTime);
            }
        });

        findAndHookConstructor("me.kuehle.carreport.data.report.MileageReport$ReportGraphDataPerMonth", lpparam.classLoader, "me.kuehle.carreport.data.report.MileageReport", "android.content.Context", "me.kuehle.carreport.provider.car.CarCursor", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("ReportGraphDataPerMonth::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("ReportGraphDataPerMonth::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.report.MileageReport$ReportGraphDataPerMonth", lpparam.classLoader, "getUsedCursors", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getUsedCursors::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getUsedCursors::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.report.MileageReport$ReportGraphDataPerMonth", lpparam.classLoader, "getMonthTime", "long", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getMonthTime::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getMonthTime::methodEnd::" + endTime);
            }
        });

        findAndHookConstructor("me.kuehle.carreport.data.report.MileageReport", lpparam.classLoader, "android.content.Context", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("MileageReport::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("MileageReport::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.report.MileageReport", lpparam.classLoader, "getAvailableChartOptions", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getAvailableChartOptions::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getAvailableChartOptions::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.report.MileageReport", lpparam.classLoader, "getTitle", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getTitle::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getTitle::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.report.MileageReport", lpparam.classLoader, "onGetChart", "boolean", "boolean", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onGetChart::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onGetChart::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.data.report.MileageReport", lpparam.classLoader, "onUpdate", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onUpdate::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onUpdate::methodEnd::" + endTime);
            }
        });

        findAndHookConstructor("me.kuehle.carreport.FuelConsumption", lpparam.classLoader, "android.content.Context", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("FuelConsumption::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("FuelConsumption::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.FuelConsumption", lpparam.classLoader, "findConsumptionType", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("findConsumptionType::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("findConsumptionType::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.FuelConsumption", lpparam.classLoader, "reload", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("reload::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("reload::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.FuelConsumption", lpparam.classLoader, "setConsumptionType", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("setConsumptionType::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("setConsumptionType::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.FuelConsumption", lpparam.classLoader, "setUnitVolume", "java.lang.String", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("setUnitVolume::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("setUnitVolume::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.FuelConsumption", lpparam.classLoader, "setUnitDistance", "java.lang.String", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("setUnitDistance::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("setUnitDistance::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.FuelConsumption", lpparam.classLoader, "computeFuelConsumption", "me.kuehle.carreport.FuelConsumption$Type", "double", "double", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("computeFuelConsumption::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("computeFuelConsumption::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.FuelConsumption", lpparam.classLoader, "computeFuelConsumption", "double", "double", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("computeFuelConsumption::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("computeFuelConsumption::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.FuelConsumption", lpparam.classLoader, "getUnitLabel", "me.kuehle.carreport.FuelConsumption$Type", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getUnitLabel::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getUnitLabel::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.FuelConsumption", lpparam.classLoader, "getUnitLabel", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getUnitLabel::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getUnitLabel::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.FuelConsumption", lpparam.classLoader, "getUnitsEntries", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getUnitsEntries::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getUnitsEntries::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.FuelConsumption", lpparam.classLoader, "getUnitsEntryValues", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getUnitsEntryValues::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getUnitsEntryValues::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.AbstractDataDetailFragment", lpparam.classLoader, "onActivityCreated", "android.os.Bundle", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onActivityCreated::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onActivityCreated::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.AbstractDataDetailFragment", lpparam.classLoader, "onAttach", "android.app.Activity", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onAttach::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onAttach::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.AbstractDataDetailFragment", lpparam.classLoader, "onCreate", "android.os.Bundle", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onCreate::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onCreate::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.AbstractDataDetailFragment", lpparam.classLoader, "onCreateOptionsMenu", "android.view.Menu", "android.view.MenuInflater", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onCreateOptionsMenu::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onCreateOptionsMenu::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.AbstractDataDetailFragment", lpparam.classLoader, "onCreateView", "android.view.LayoutInflater", "android.view.ViewGroup", "android.os.Bundle", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onCreateView::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onCreateView::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.AbstractDataDetailFragment", lpparam.classLoader, "onDestroyView", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onDestroyView::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onDestroyView::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.AbstractDataDetailFragment", lpparam.classLoader, "onDialogNegativeClick", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onDialogNegativeClick::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onDialogNegativeClick::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.AbstractDataDetailFragment", lpparam.classLoader, "onDialogPositiveClick", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onDialogPositiveClick::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onDialogPositiveClick::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.AbstractDataDetailFragment", lpparam.classLoader, "onOptionsItemSelected", "android.view.MenuItem", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onOptionsItemSelected::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onOptionsItemSelected::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.AbstractDataDetailFragment", lpparam.classLoader, "getDoubleFromEditText", "android.widget.EditText", "double", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getDoubleFromEditText::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getDoubleFromEditText::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.AbstractDataDetailFragment", lpparam.classLoader, "getIntegerFromEditText", "android.widget.EditText", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getIntegerFromEditText::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getIntegerFromEditText::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.AbstractDataDetailFragment", lpparam.classLoader, "isInEditMode", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("isInEditMode::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("isInEditMode::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.AbstractDataDetailFragment", lpparam.classLoader, "addUnitToHint", "android.widget.EditText", "int", "java.lang.CharSequence", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("addUnitToHint::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("addUnitToHint::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.AbstractDataListFragment", lpparam.classLoader, "onActivityCreated", "android.os.Bundle", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onActivityCreated::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onActivityCreated::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.AbstractDataListFragment", lpparam.classLoader, "onAttach", "android.app.Activity", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onAttach::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onAttach::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.AbstractDataListFragment", lpparam.classLoader, "onCreate", "android.os.Bundle", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onCreate::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onCreate::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.AbstractDataListFragment", lpparam.classLoader, "onDialogNegativeClick", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onDialogNegativeClick::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onDialogNegativeClick::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.AbstractDataListFragment", lpparam.classLoader, "onDialogPositiveClick", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onDialogPositiveClick::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onDialogPositiveClick::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.AbstractDataListFragment", lpparam.classLoader, "onListItemClick", "android.widget.ListView", "android.view.View", "int", "long", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onListItemClick::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onListItemClick::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.AbstractDataListFragment", lpparam.classLoader, "onPause", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onPause::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onPause::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.AbstractDataListFragment", lpparam.classLoader, "onSaveInstanceState", "android.os.Bundle", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onSaveInstanceState::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onSaveInstanceState::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.AbstractDataListFragment", lpparam.classLoader, "onLoadFinished", "android.support.v4.content.Loader", "android.database.Cursor", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onLoadFinished::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onLoadFinished::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.AbstractDataListFragment", lpparam.classLoader, "onLoaderReset", "android.support.v4.content.Loader", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onLoaderReset::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onLoaderReset::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.AbstractDataListFragment", lpparam.classLoader, "unselectItem", "boolean", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("unselectItem::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("unselectItem::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.AbstractDataListFragment", lpparam.classLoader, "setCurrentPosition", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("setCurrentPosition::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("setCurrentPosition::methodEnd::" + endTime);
            }
        });

        findAndHookConstructor("me.kuehle.carreport.gui.AbstractDataListFragment$DataListAdapter", lpparam.classLoader, "me.kuehle.carreport.gui.AbstractDataListFragment", "android.content.Context", "android.database.Cursor", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("DataListAdapter::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("DataListAdapter::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.AbstractDataListFragment$DataListAdapter", lpparam.classLoader, "newView", "android.content.Context", "android.database.Cursor", "android.view.ViewGroup", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("newView::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("newView::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.AbstractDataListFragment$DataListAdapter", lpparam.classLoader, "bindView", "android.view.View", "android.content.Context", "android.database.Cursor", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("bindView::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("bindView::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.AbstractDataListFragment$DataListAdapter", lpparam.classLoader, "getItemViewType", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getItemViewType::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getItemViewType::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.AbstractDataListFragment$DataListAdapter", lpparam.classLoader, "getItemViewType", "android.database.Cursor", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getItemViewType::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getItemViewType::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.AbstractDataListFragment$DataListAdapter", lpparam.classLoader, "getViewTypeCount", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getViewTypeCount::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getViewTypeCount::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.AbstractDataListFragment$DataListAdapter", lpparam.classLoader, "isEnabled", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("isEnabled::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("isEnabled::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.AbstractDataListFragment$DataListMultiChoiceModeListener", lpparam.classLoader, "onActionItemClicked", "android.view.ActionMode", "android.view.MenuItem", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onActionItemClicked::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onActionItemClicked::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.AbstractDataListFragment$DataListMultiChoiceModeListener", lpparam.classLoader, "onCreateActionMode", "android.view.ActionMode", "android.view.Menu", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onCreateActionMode::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onCreateActionMode::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.AbstractDataListFragment$DataListMultiChoiceModeListener", lpparam.classLoader, "onDestroyActionMode", "android.view.ActionMode", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onDestroyActionMode::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onDestroyActionMode::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.AbstractDataListFragment$DataListMultiChoiceModeListener", lpparam.classLoader, "onItemCheckedStateChanged", "android.view.ActionMode", "int", "long", "boolean", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onItemCheckedStateChanged::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onItemCheckedStateChanged::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.AbstractDataListFragment$DataListMultiChoiceModeListener", lpparam.classLoader, "onPrepareActionMode", "android.view.ActionMode", "android.view.Menu", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onPrepareActionMode::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onPrepareActionMode::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.AuthenticatorAddAccountActivity", lpparam.classLoader, "onCreate", "android.os.Bundle", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onCreate::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onCreate::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.AuthenticatorAddAccountActivity", lpparam.classLoader, "onItemClick", "android.widget.AdapterView", "android.view.View", "int", "long", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onItemClick::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onItemClick::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.AuthenticatorAddAccountActivity", lpparam.classLoader, "onAuthenticationResult", "java.lang.String", "java.lang.String", "java.lang.String", "org.json.JSONObject", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onAuthenticationResult::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onAuthenticationResult::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.AuthenticatorAddAccountActivity", lpparam.classLoader, "onResume", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onResume::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onResume::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.AuthenticatorAddAccountActivity", lpparam.classLoader, "onActivityResult", "int", "int", "android.content.Intent", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onActivityResult::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onActivityResult::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.AuthenticatorAddAccountActivity", lpparam.classLoader, "startFirstSync", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("startFirstSync::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("startFirstSync::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.AuthenticatorAddAccountActivity", lpparam.classLoader, "performFirstSync", "boolean", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("performFirstSync::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("performFirstSync::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.AuthenticatorAddAccountActivity", lpparam.classLoader, "handleFirstSyncError", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("handleFirstSyncError::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("handleFirstSyncError::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.AuthenticatorAddAccountActivity$SyncProviderAdapter", lpparam.classLoader, "getCount", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getCount::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getCount::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.AuthenticatorAddAccountActivity$SyncProviderAdapter", lpparam.classLoader, "getItem", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getItem::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getItem::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.AuthenticatorAddAccountActivity$SyncProviderAdapter", lpparam.classLoader, "getItemId", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getItemId::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getItemId::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.AuthenticatorAddAccountActivity$SyncProviderAdapter", lpparam.classLoader, "hasStableIds", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("hasStableIds::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("hasStableIds::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.AuthenticatorAddAccountActivity$SyncProviderAdapter", lpparam.classLoader, "getView", "int", "android.view.View", "android.view.ViewGroup", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getView::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getView::methodEnd::" + endTime);
            }
        });

        findAndHookConstructor("me.kuehle.carreport.gui.CalculatorFragment$ForceLoadContentObserver", lpparam.classLoader, "me.kuehle.carreport.gui.CalculatorFragment", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("ForceLoadContentObserver::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("ForceLoadContentObserver::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.CalculatorFragment$ForceLoadContentObserver", lpparam.classLoader, "deliverSelfNotifications", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("deliverSelfNotifications::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("deliverSelfNotifications::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.CalculatorFragment$ForceLoadContentObserver", lpparam.classLoader, "onChange", "boolean", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onChange::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onChange::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.CalculatorFragment", lpparam.classLoader, "onAttach", "android.app.Activity", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onAttach::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onAttach::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.CalculatorFragment", lpparam.classLoader, "onCreateView", "android.view.LayoutInflater", "android.view.ViewGroup", "android.os.Bundle", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onCreateView::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onCreateView::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.CalculatorFragment", lpparam.classLoader, "onSaveInstanceState", "android.os.Bundle", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onSaveInstanceState::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onSaveInstanceState::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.CalculatorFragment", lpparam.classLoader, "calculate", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("calculate::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("calculate::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.CalculatorFragment", lpparam.classLoader, "getXValues", "me.kuehle.chartlib.data.Series", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getXValues::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getXValues::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.DataDetailActivity", lpparam.classLoader, "onCreate", "android.os.Bundle", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onCreate::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onCreate::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.DataDetailActivity", lpparam.classLoader, "onItemSaved", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onItemSaved::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onItemSaved::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.DataDetailActivity", lpparam.classLoader, "onItemCanceled", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onItemCanceled::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onItemCanceled::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.DataDetailActivity", lpparam.classLoader, "onItemDeleted", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onItemDeleted::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onItemDeleted::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.DataDetailCarFragment", lpparam.classLoader, "onCreateOptionsMenu", "android.view.Menu", "android.view.MenuInflater", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onCreateOptionsMenu::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onCreateOptionsMenu::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.DataDetailCarFragment", lpparam.classLoader, "onDialogNegativeClick", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onDialogNegativeClick::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onDialogNegativeClick::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.DataDetailCarFragment", lpparam.classLoader, "onDialogPositiveClick", "int", "java.util.Date", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onDialogPositiveClick::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onDialogPositiveClick::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.DataDetailCarFragment", lpparam.classLoader, "onDialogPositiveClick", "int", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onDialogPositiveClick::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onDialogPositiveClick::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.DataDetailCarFragment", lpparam.classLoader, "onSaveInstanceState", "android.os.Bundle", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onSaveInstanceState::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onSaveInstanceState::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.DataDetailCarFragment", lpparam.classLoader, "fillFields", "android.os.Bundle", "android.view.View", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("fillFields::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("fillFields::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.DataDetailCarFragment", lpparam.classLoader, "getAlertDeleteMessage", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getAlertDeleteMessage::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getAlertDeleteMessage::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.DataDetailCarFragment", lpparam.classLoader, "getLayout", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getLayout::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getLayout::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.DataDetailCarFragment", lpparam.classLoader, "getTitleForEdit", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getTitleForEdit::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getTitleForEdit::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.DataDetailCarFragment", lpparam.classLoader, "getTitleForNew", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getTitleForNew::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getTitleForNew::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.DataDetailCarFragment", lpparam.classLoader, "getToastDeletedMessage", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getToastDeletedMessage::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getToastDeletedMessage::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.DataDetailCarFragment", lpparam.classLoader, "getToastSavedMessage", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getToastSavedMessage::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getToastSavedMessage::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.DataDetailCarFragment", lpparam.classLoader, "initFields", "android.os.Bundle", "android.view.View", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("initFields::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("initFields::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.DataDetailCarFragment", lpparam.classLoader, "save", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("save::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("save::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.DataDetailCarFragment", lpparam.classLoader, "delete", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("delete::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("delete::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.DataDetailCarFragment", lpparam.classLoader, "validate", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("validate::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("validate::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.DataDetailOtherFragment", lpparam.classLoader, "newInstance", "long", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("newInstance::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("newInstance::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.DataDetailOtherFragment", lpparam.classLoader, "onDialogPositiveClick", "int", "java.util.Date", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onDialogPositiveClick::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onDialogPositiveClick::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.DataDetailOtherFragment", lpparam.classLoader, "fillFields", "android.os.Bundle", "android.view.View", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("fillFields::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("fillFields::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.DataDetailOtherFragment", lpparam.classLoader, "getAlertDeleteMessage", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getAlertDeleteMessage::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getAlertDeleteMessage::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.DataDetailOtherFragment", lpparam.classLoader, "getLayout", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getLayout::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getLayout::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.DataDetailOtherFragment", lpparam.classLoader, "getTitleForEdit", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getTitleForEdit::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getTitleForEdit::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.DataDetailOtherFragment", lpparam.classLoader, "getTitleForNew", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getTitleForNew::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getTitleForNew::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.DataDetailOtherFragment", lpparam.classLoader, "getToastDeletedMessage", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getToastDeletedMessage::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getToastDeletedMessage::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.DataDetailOtherFragment", lpparam.classLoader, "getToastSavedMessage", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getToastSavedMessage::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getToastSavedMessage::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.DataDetailOtherFragment", lpparam.classLoader, "initFields", "android.os.Bundle", "android.view.View", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("initFields::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("initFields::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.DataDetailOtherFragment", lpparam.classLoader, "save", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("save::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("save::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.DataDetailOtherFragment", lpparam.classLoader, "delete", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("delete::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("delete::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.DataDetailOtherFragment", lpparam.classLoader, "validate", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("validate::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("validate::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.DataDetailOtherFragment", lpparam.classLoader, "isExpenditure", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("isExpenditure::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("isExpenditure::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.DataDetailRefuelingFragment", lpparam.classLoader, "newInstance", "long", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("newInstance::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("newInstance::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.DataDetailRefuelingFragment", lpparam.classLoader, "onDialogPositiveClick", "int", "java.util.Date", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onDialogPositiveClick::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onDialogPositiveClick::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.DataDetailRefuelingFragment", lpparam.classLoader, "fillFields", "android.os.Bundle", "android.view.View", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("fillFields::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("fillFields::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.DataDetailRefuelingFragment", lpparam.classLoader, "getAlertDeleteMessage", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getAlertDeleteMessage::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getAlertDeleteMessage::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.DataDetailRefuelingFragment", lpparam.classLoader, "getLayout", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getLayout::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getLayout::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.DataDetailRefuelingFragment", lpparam.classLoader, "getTitleForEdit", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getTitleForEdit::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getTitleForEdit::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.DataDetailRefuelingFragment", lpparam.classLoader, "getTitleForNew", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getTitleForNew::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getTitleForNew::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.DataDetailRefuelingFragment", lpparam.classLoader, "getToastDeletedMessage", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getToastDeletedMessage::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getToastDeletedMessage::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.DataDetailRefuelingFragment", lpparam.classLoader, "getToastSavedMessage", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getToastSavedMessage::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getToastSavedMessage::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.DataDetailRefuelingFragment", lpparam.classLoader, "initFields", "android.os.Bundle", "android.view.View", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("initFields::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("initFields::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.DataDetailRefuelingFragment", lpparam.classLoader, "validate", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("validate::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("validate::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.DataDetailRefuelingFragment", lpparam.classLoader, "save", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("save::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("save::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.DataDetailRefuelingFragment", lpparam.classLoader, "delete", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("delete::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("delete::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.DataDetailRefuelingFragment", lpparam.classLoader, "getPreviousRefueling", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getPreviousRefueling::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getPreviousRefueling::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.DataDetailRefuelingFragment", lpparam.classLoader, "getNextRefueling", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getNextRefueling::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getNextRefueling::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.DataDetailReminderFragment", lpparam.classLoader, "onDialogPositiveClick", "int", "java.util.Date", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onDialogPositiveClick::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onDialogPositiveClick::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.DataDetailReminderFragment", lpparam.classLoader, "getAlertDeleteMessage", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getAlertDeleteMessage::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getAlertDeleteMessage::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.DataDetailReminderFragment", lpparam.classLoader, "getLayout", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getLayout::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getLayout::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.DataDetailReminderFragment", lpparam.classLoader, "getTitleForEdit", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getTitleForEdit::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getTitleForEdit::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.DataDetailReminderFragment", lpparam.classLoader, "getTitleForNew", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getTitleForNew::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getTitleForNew::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.DataDetailReminderFragment", lpparam.classLoader, "getToastDeletedMessage", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getToastDeletedMessage::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getToastDeletedMessage::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.DataDetailReminderFragment", lpparam.classLoader, "getToastSavedMessage", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getToastSavedMessage::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getToastSavedMessage::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.DataDetailReminderFragment", lpparam.classLoader, "initFields", "android.os.Bundle", "android.view.View", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("initFields::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("initFields::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.DataDetailReminderFragment", lpparam.classLoader, "fillFields", "android.os.Bundle", "android.view.View", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("fillFields::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("fillFields::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.DataDetailReminderFragment", lpparam.classLoader, "validate", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("validate::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("validate::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.DataDetailReminderFragment", lpparam.classLoader, "save", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("save::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("save::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.DataDetailReminderFragment", lpparam.classLoader, "delete", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("delete::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("delete::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.DataFragment$DataListBackStackListener", lpparam.classLoader, "onBackStackChanged", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onBackStackChanged::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onBackStackChanged::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.DataFragment$DataListBackStackListener", lpparam.classLoader, "skipNextIfPop", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("skipNextIfPop::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("skipNextIfPop::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.DataFragment$DataListOnPageChangeListener", lpparam.classLoader, "onPageSelected", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onPageSelected::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onPageSelected::methodEnd::" + endTime);
            }
        });

        findAndHookConstructor("me.kuehle.carreport.gui.DataFragment$DataListPagerAdapter", lpparam.classLoader, "me.kuehle.carreport.gui.DataFragment", "android.support.v4.app.FragmentManager", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("DataListPagerAdapter::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("DataListPagerAdapter::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.DataFragment$DataListPagerAdapter", lpparam.classLoader, "getCount", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getCount::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getCount::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.DataFragment$DataListPagerAdapter", lpparam.classLoader, "getItem", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getItem::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getItem::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.DataFragment$DataListPagerAdapter", lpparam.classLoader, "getPageTitle", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getPageTitle::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getPageTitle::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.DataFragment$DataListPagerAdapter", lpparam.classLoader, "restoreState", "android.os.Parcelable", "java.lang.ClassLoader", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("restoreState::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("restoreState::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.DataFragment", lpparam.classLoader, "onCreate", "android.os.Bundle", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onCreate::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onCreate::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.DataFragment", lpparam.classLoader, "onCreateView", "android.view.LayoutInflater", "android.view.ViewGroup", "android.os.Bundle", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onCreateView::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onCreateView::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.DataFragment", lpparam.classLoader, "onItemCanceled", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onItemCanceled::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onItemCanceled::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.DataFragment", lpparam.classLoader, "onItemDeleted", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onItemDeleted::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onItemDeleted::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.DataFragment", lpparam.classLoader, "onItemSaved", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onItemSaved::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onItemSaved::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.DataFragment", lpparam.classLoader, "onViewCreated", "android.widget.ListView", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onViewCreated::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onViewCreated::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.DataFragment", lpparam.classLoader, "onItemSelected", "int", "long", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onItemSelected::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onItemSelected::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.DataFragment", lpparam.classLoader, "onItemUnselected", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onItemUnselected::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onItemUnselected::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.DataFragment", lpparam.classLoader, "setNoEntrySelectedTextVisible", "boolean", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("setNoEntrySelectedTextVisible::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("setNoEntrySelectedTextVisible::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.DataListOtherFragment", lpparam.classLoader, "onCreate", "android.os.Bundle", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onCreate::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onCreate::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.DataListOtherFragment", lpparam.classLoader, "onCreateLoader", "int", "android.os.Bundle", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onCreateLoader::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onCreateLoader::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.DataListOtherFragment", lpparam.classLoader, "getAlertDeleteManyMessage", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getAlertDeleteManyMessage::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getAlertDeleteManyMessage::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.DataListOtherFragment", lpparam.classLoader, "getExtraEdit", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getExtraEdit::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getExtraEdit::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.DataListOtherFragment", lpparam.classLoader, "getItemData", "android.database.Cursor", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getItemData::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getItemData::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.DataListOtherFragment", lpparam.classLoader, "isMissingData", "android.database.Cursor", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("isMissingData::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("isMissingData::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.DataListOtherFragment", lpparam.classLoader, "isInvalidData", "android.database.Cursor", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("isInvalidData::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("isInvalidData::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.DataListOtherFragment", lpparam.classLoader, "deleteItem", "long", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("deleteItem::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("deleteItem::methodEnd::" + endTime);
            }
        });

        findAndHookConstructor("me.kuehle.carreport.gui.DataListRefuelingFragment$RefuelingLoader", lpparam.classLoader, "android.content.Context", "long", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("RefuelingLoader::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("RefuelingLoader::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.DataListRefuelingFragment$RefuelingLoader", lpparam.classLoader, "loadInBackground", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("loadInBackground::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("loadInBackground::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.DataListRefuelingFragment", lpparam.classLoader, "onCreate", "android.os.Bundle", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onCreate::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onCreate::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.DataListRefuelingFragment", lpparam.classLoader, "onCreateLoader", "int", "android.os.Bundle", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onCreateLoader::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onCreateLoader::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.DataListRefuelingFragment", lpparam.classLoader, "getAlertDeleteManyMessage", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getAlertDeleteManyMessage::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getAlertDeleteManyMessage::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.DataListRefuelingFragment", lpparam.classLoader, "getExtraEdit", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getExtraEdit::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getExtraEdit::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.DataListRefuelingFragment", lpparam.classLoader, "getItemData", "android.database.Cursor", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getItemData::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getItemData::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.DataListRefuelingFragment", lpparam.classLoader, "isMissingData", "android.database.Cursor", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("isMissingData::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("isMissingData::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.DataListRefuelingFragment", lpparam.classLoader, "isInvalidData", "android.database.Cursor", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("isInvalidData::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("isInvalidData::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.DataListRefuelingFragment", lpparam.classLoader, "deleteItem", "long", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("deleteItem::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("deleteItem::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.DataListRefuelingFragment", lpparam.classLoader, "moveToNextNotGuessedRefueling", "me.kuehle.carreport.data.balancing.BalancedRefuelingCursor", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("moveToNextNotGuessedRefueling::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("moveToNextNotGuessedRefueling::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.dialog.EditFuelTypeDialogFragment", lpparam.classLoader, "newInstance", "android.app.Fragment", "int", "long", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("newInstance::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("newInstance::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.dialog.EditFuelTypeDialogFragment", lpparam.classLoader, "onCreate", "android.os.Bundle", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onCreate::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onCreate::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.dialog.EditFuelTypeDialogFragment", lpparam.classLoader, "onCreateDialog", "android.os.Bundle", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onCreateDialog::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onCreateDialog::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.dialog.EditFuelTypeDialogFragment", lpparam.classLoader, "onSaveInstanceState", "android.os.Bundle", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onSaveInstanceState::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onSaveInstanceState::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.dialog.EditFuelTypeDialogFragment", lpparam.classLoader, "getListener", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getListener::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getListener::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.dialog.EditFuelTypeDialogFragment", lpparam.classLoader, "save", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("save::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("save::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.dialog.ListDialogFragment$DialogListAdapter", lpparam.classLoader, "getCount", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getCount::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getCount::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.dialog.ListDialogFragment$DialogListAdapter", lpparam.classLoader, "getItem", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getItem::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getItem::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.dialog.ListDialogFragment$DialogListAdapter", lpparam.classLoader, "getItemId", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getItemId::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getItemId::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.dialog.ListDialogFragment$DialogListAdapter", lpparam.classLoader, "getView", "int", "android.view.View", "android.view.ViewGroup", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getView::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getView::methodEnd::" + endTime);
            }
        });

        try {
            findAndHookMethod("me.kuehle.carreport.gui.dialog.ListDialogFragment$1", lpparam.classLoader, "onDialogNegativeClick", "int", new XC_MethodHook() {

                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    startTime = System.nanoTime();
                    XposedBridge.log("onDialogNegativeClick::methodStart::" + startTime);
                }
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    endTime = System.nanoTime();
                    XposedBridge.log("onDialogNegativeClick::methodEnd::" + endTime);
                }
            });

        }
        catch (Throwable t) {
            System.err.println(t.getMessage());
        }

        try {
            findAndHookMethod("me.kuehle.carreport.gui.dialog.ListDialogFragment$1", lpparam.classLoader, "onDialogPositiveClick", "int", "int", new XC_MethodHook() {

                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    startTime = System.nanoTime();
                    XposedBridge.log("onDialogPositiveClick::methodStart::" + startTime);
                }
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    endTime = System.nanoTime();
                    XposedBridge.log("onDialogPositiveClick::methodEnd::" + endTime);
                }
            });

        }
        catch (Throwable t) {
            System.err.println(t.getMessage());
        }

        findAndHookMethod("me.kuehle.carreport.gui.dialog.ListDialogFragment", lpparam.classLoader, "onCreateDialog", "android.os.Bundle", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onCreateDialog::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onCreateDialog::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.dialog.ListDialogFragment", lpparam.classLoader, "getListener", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getListener::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getListener::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.dialog.MessageDialogFragment", lpparam.classLoader, "newInstance", "android.app.Fragment", "int", "java.lang.Integer", "java.lang.String", "int", "java.lang.Integer", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("newInstance::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("newInstance::methodEnd::" + endTime);
            }
        });

        try {
            findAndHookMethod("me.kuehle.carreport.gui.dialog.MessageDialogFragment$1", lpparam.classLoader, "onDialogPositiveClick", "int", new XC_MethodHook() {

                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    startTime = System.nanoTime();
                    XposedBridge.log("onDialogPositiveClick::methodStart::" + startTime);
                }
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    endTime = System.nanoTime();
                    XposedBridge.log("onDialogPositiveClick::methodEnd::" + endTime);
                }
            });

        }
        catch (Throwable t) {
            System.err.println(t.getMessage());
        }

        try {
            findAndHookMethod("me.kuehle.carreport.gui.dialog.MessageDialogFragment$1", lpparam.classLoader, "onDialogNegativeClick", "int", new XC_MethodHook() {

                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    startTime = System.nanoTime();
                    XposedBridge.log("onDialogNegativeClick::methodStart::" + startTime);
                }
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    endTime = System.nanoTime();
                    XposedBridge.log("onDialogNegativeClick::methodEnd::" + endTime);
                }
            });

        }
        catch (Throwable t) {
            System.err.println(t.getMessage());
        }

        findAndHookMethod("me.kuehle.carreport.gui.dialog.MessageDialogFragment", lpparam.classLoader, "onCreateDialog", "android.os.Bundle", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onCreateDialog::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onCreateDialog::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.dialog.MessageDialogFragment", lpparam.classLoader, "getListener", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getListener::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getListener::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.dialog.ProgressDialogFragment", lpparam.classLoader, "newInstance", "java.lang.String", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("newInstance::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("newInstance::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.dialog.ProgressDialogFragment", lpparam.classLoader, "onCreateDialog", "android.os.Bundle", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onCreateDialog::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onCreateDialog::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.dialog.SetupWebDavSyncDialogActivity", lpparam.classLoader, "onCreate", "android.os.Bundle", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onCreate::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onCreate::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.dialog.SetupWebDavSyncDialogActivity", lpparam.classLoader, "onOkClick", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onOkClick::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onOkClick::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.dialog.SupportColorPickerDialogFragment", lpparam.classLoader, "newInstance", "android.support.v4.app.Fragment", "int", "java.lang.Integer", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("newInstance::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("newInstance::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.dialog.SupportColorPickerDialogFragment", lpparam.classLoader, "onCreateDialog", "android.os.Bundle", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onCreateDialog::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onCreateDialog::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.dialog.SupportColorPickerDialogFragment", lpparam.classLoader, "onSaveInstanceState", "android.os.Bundle", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onSaveInstanceState::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onSaveInstanceState::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.dialog.SupportColorPickerDialogFragment", lpparam.classLoader, "getListener", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getListener::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getListener::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.dialog.SupportDatePickerDialogFragment", lpparam.classLoader, "newInstance", "android.support.v4.app.Fragment", "int", "java.util.Date", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("newInstance::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("newInstance::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.dialog.SupportDatePickerDialogFragment", lpparam.classLoader, "onCreateDialog", "android.os.Bundle", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onCreateDialog::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onCreateDialog::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.dialog.SupportDatePickerDialogFragment", lpparam.classLoader, "onDateSet", "android.widget.DatePicker", "int", "int", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onDateSet::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onDateSet::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.dialog.SupportDatePickerDialogFragment", lpparam.classLoader, "getListener", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getListener::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getListener::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.dialog.SupportMessageDialogFragment", lpparam.classLoader, "newInstance", "android.support.v4.app.Fragment", "int", "java.lang.Integer", "java.lang.String", "int", "java.lang.Integer", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("newInstance::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("newInstance::methodEnd::" + endTime);
            }
        });

        try {
            findAndHookMethod("me.kuehle.carreport.gui.dialog.SupportMessageDialogFragment$1", lpparam.classLoader, "onDialogPositiveClick", "int", new XC_MethodHook() {

                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    startTime = System.nanoTime();
                    XposedBridge.log("onDialogPositiveClick::methodStart::" + startTime);
                }
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    endTime = System.nanoTime();
                    XposedBridge.log("onDialogPositiveClick::methodEnd::" + endTime);
                }
            });

        }
        catch (Throwable t) {
            System.err.println(t.getMessage());
        }

        try {
            findAndHookMethod("me.kuehle.carreport.gui.dialog.SupportMessageDialogFragment$1", lpparam.classLoader, "onDialogNegativeClick", "int", new XC_MethodHook() {

                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    startTime = System.nanoTime();
                    XposedBridge.log("onDialogNegativeClick::methodStart::" + startTime);
                }
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    endTime = System.nanoTime();
                    XposedBridge.log("onDialogNegativeClick::methodEnd::" + endTime);
                }
            });

        }
        catch (Throwable t) {
            System.err.println(t.getMessage());
        }

        findAndHookMethod("me.kuehle.carreport.gui.dialog.SupportMessageDialogFragment", lpparam.classLoader, "onCreateDialog", "android.os.Bundle", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onCreateDialog::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onCreateDialog::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.dialog.SupportMessageDialogFragment", lpparam.classLoader, "getListener", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getListener::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getListener::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.dialog.SupportTimePickerDialogFragment", lpparam.classLoader, "newInstance", "android.support.v4.app.Fragment", "int", "java.util.Date", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("newInstance::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("newInstance::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.dialog.SupportTimePickerDialogFragment", lpparam.classLoader, "onCreateDialog", "android.os.Bundle", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onCreateDialog::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onCreateDialog::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.dialog.SupportTimePickerDialogFragment", lpparam.classLoader, "onTimeSet", "android.widget.TimePicker", "int", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onTimeSet::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onTimeSet::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.dialog.SupportTimePickerDialogFragment", lpparam.classLoader, "getListener", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getListener::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getListener::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.FirstStartActivity", lpparam.classLoader, "onCreate", "android.os.Bundle", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onCreate::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onCreate::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.FirstStartActivity", lpparam.classLoader, "onActivityResult", "int", "int", "android.content.Intent", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onActivityResult::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onActivityResult::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.FirstStartActivity", lpparam.classLoader, "onCreateCarClick", "android.view.View", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onCreateCarClick::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onCreateCarClick::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.FirstStartActivity", lpparam.classLoader, "onSetupSyncClick", "android.view.View", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onSetupSyncClick::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onSetupSyncClick::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.HelpActivity", lpparam.classLoader, "onCreate", "android.os.Bundle", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onCreate::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onCreate::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.HelpActivity", lpparam.classLoader, "onBuildHeaders", "java.util.List", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onBuildHeaders::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onBuildHeaders::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.HelpActivity", lpparam.classLoader, "setContentView", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("setContentView::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("setContentView::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.HelpActivity", lpparam.classLoader, "isValidFragment", "java.lang.String", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("isValidFragment::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("isValidFragment::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.HelpActivity$HelpFragment", lpparam.classLoader, "onCreateView", "android.view.LayoutInflater", "android.view.ViewGroup", "android.os.Bundle", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onCreateView::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onCreateView::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.HelpActivity$HelpFragment", lpparam.classLoader, "getLocalizedDirectory", "java.lang.String", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getLocalizedDirectory::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getLocalizedDirectory::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.HelpActivity$GettingStartedFragment", lpparam.classLoader, "getHelpId", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getHelpId::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getHelpId::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.HelpActivity$TipsFragment", lpparam.classLoader, "getHelpId", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getHelpId::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getHelpId::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.HelpActivity$CalculationsFragment", lpparam.classLoader, "getHelpId", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getHelpId::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getHelpId::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.HelpActivity$CSVFragment", lpparam.classLoader, "getHelpId", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getHelpId::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getHelpId::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.HelpActivity$FuelTypesFragment", lpparam.classLoader, "getHelpId", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getHelpId::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getHelpId::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.MainActivity", lpparam.classLoader, "onCreate", "android.os.Bundle", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onCreate::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onCreate::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.MainActivity", lpparam.classLoader, "onPostCreate", "android.os.Bundle", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onPostCreate::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onPostCreate::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.MainActivity", lpparam.classLoader, "onResume", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onResume::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onResume::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.MainActivity", lpparam.classLoader, "onActivityResult", "int", "int", "android.content.Intent", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onActivityResult::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onActivityResult::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.MainActivity", lpparam.classLoader, "onBackPressed", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onBackPressed::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onBackPressed::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.MainActivity", lpparam.classLoader, "onConfigurationChanged", "android.content.res.Configuration", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onConfigurationChanged::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onConfigurationChanged::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.MainActivity", lpparam.classLoader, "onCreateOptionsMenu", "android.view.Menu", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onCreateOptionsMenu::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onCreateOptionsMenu::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.MainActivity", lpparam.classLoader, "onOptionsItemSelected", "android.view.MenuItem", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onOptionsItemSelected::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onOptionsItemSelected::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.MainActivity", lpparam.classLoader, "onFABAddRefuelingClicked", "android.view.View", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onFABAddRefuelingClicked::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onFABAddRefuelingClicked::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.MainActivity", lpparam.classLoader, "onFABAddOtherExpenditureClicked", "android.view.View", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onFABAddOtherExpenditureClicked::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onFABAddOtherExpenditureClicked::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.MainActivity", lpparam.classLoader, "onFABAddOtherIncomeClicked", "android.view.View", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onFABAddOtherIncomeClicked::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onFABAddOtherIncomeClicked::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.MainActivity", lpparam.classLoader, "setTitle", "java.lang.CharSequence", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("setTitle::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("setTitle::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.MainActivity", lpparam.classLoader, "onPause", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onPause::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onPause::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.MainActivity", lpparam.classLoader, "onSaveInstanceState", "android.os.Bundle", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onSaveInstanceState::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onSaveInstanceState::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.MainActivity", lpparam.classLoader, "onNavigationItemSelected", "android.view.MenuItem", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onNavigationItemSelected::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onNavigationItemSelected::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.MainActivity", lpparam.classLoader, "updateNavigationViewMenu", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("updateNavigationViewMenu::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("updateNavigationViewMenu::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.MainActivity", lpparam.classLoader, "getDetailActivityIntent", "int", "long", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getDetailActivityIntent::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getDetailActivityIntent::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.MainActivity", lpparam.classLoader, "updateSyncMenuItem", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("updateSyncMenuItem::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("updateSyncMenuItem::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.MainActivity", lpparam.classLoader, "getCurrentSyncAccount", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getCurrentSyncAccount::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getCurrentSyncAccount::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.MainActivity", lpparam.classLoader, "closeFABMenu", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("closeFABMenu::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("closeFABMenu::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.MainActivity", lpparam.classLoader, "handleFABClick", "int", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("handleFABClick::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("handleFABClick::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.MainActivity", lpparam.classLoader, "getSupportActionBar", "android.support.v4.app.Fragment", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getSupportActionBar::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getSupportActionBar::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.PreferencesAboutFragment$LicenseDialogFragment", lpparam.classLoader, "newInstance", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("newInstance::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("newInstance::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.PreferencesAboutFragment$LicenseDialogFragment", lpparam.classLoader, "onCreateDialog", "android.os.Bundle", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onCreateDialog::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onCreateDialog::methodEnd::" + endTime);
            }
        });

        try {
            findAndHookMethod("me.kuehle.carreport.gui.PreferencesAboutFragment$1", lpparam.classLoader, "onClick", "android.view.View", new XC_MethodHook() {

                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    startTime = System.nanoTime();
                    XposedBridge.log("onClick::methodStart::" + startTime);
                }
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    endTime = System.nanoTime();
                    XposedBridge.log("onClick::methodEnd::" + endTime);
                }
            });

        }
        catch (Throwable t) {
            System.err.println(t.getMessage());
        }

        findAndHookMethod("me.kuehle.carreport.gui.PreferencesAboutFragment", lpparam.classLoader, "onCreateView", "android.view.LayoutInflater", "android.view.ViewGroup", "android.os.Bundle", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onCreateView::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onCreateView::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.PreferencesActivity", lpparam.classLoader, "onAttachFragment", "android.app.Fragment", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onAttachFragment::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onAttachFragment::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.PreferencesActivity", lpparam.classLoader, "onCreate", "android.os.Bundle", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onCreate::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onCreate::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.PreferencesActivity", lpparam.classLoader, "onBuildHeaders", "java.util.List", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onBuildHeaders::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onBuildHeaders::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.PreferencesActivity", lpparam.classLoader, "onOptionsItemSelected", "android.view.MenuItem", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onOptionsItemSelected::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onOptionsItemSelected::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.PreferencesActivity", lpparam.classLoader, "onActivityResult", "int", "int", "android.content.Intent", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onActivityResult::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onActivityResult::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.PreferencesActivity", lpparam.classLoader, "isValidFragment", "java.lang.String", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("isValidFragment::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("isValidFragment::methodEnd::" + endTime);
            }
        });

        try {
            findAndHookMethod("me.kuehle.carreport.gui.PreferencesBackupFragment$1", lpparam.classLoader, "onPreferenceClick", "android.preference.Preference", new XC_MethodHook() {

                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    startTime = System.nanoTime();
                    XposedBridge.log("onPreferenceClick::methodStart::" + startTime);
                }
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    endTime = System.nanoTime();
                    XposedBridge.log("onPreferenceClick::methodEnd::" + endTime);
                }
            });

        }
        catch (Throwable t) {
            System.err.println(t.getMessage());
        }

        try {
            findAndHookMethod("me.kuehle.carreport.gui.PreferencesBackupFragment$1", lpparam.classLoader, "onPreferenceClick", "android.preference.Preference", new XC_MethodHook() {

                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    startTime = System.nanoTime();
                    XposedBridge.log("onPreferenceClick::methodStart::" + startTime);
                }
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    endTime = System.nanoTime();
                    XposedBridge.log("onPreferenceClick::methodEnd::" + endTime);
                }
            });

        }
        catch (Throwable t) {
            System.err.println(t.getMessage());
        }

        findAndHookMethod("me.kuehle.carreport.gui.PreferencesBackupFragment", lpparam.classLoader, "onAttach", "android.app.Activity", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onAttach::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onAttach::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.PreferencesBackupFragment", lpparam.classLoader, "onCreate", "android.os.Bundle", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onCreate::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onCreate::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.PreferencesBackupFragment", lpparam.classLoader, "onDetach", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onDetach::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onDetach::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.PreferencesBackupFragment", lpparam.classLoader, "onDialogPositiveClick", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onDialogPositiveClick::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onDialogPositiveClick::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.PreferencesBackupFragment", lpparam.classLoader, "onDialogNegativeClick", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onDialogNegativeClick::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onDialogNegativeClick::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.PreferencesBackupFragment", lpparam.classLoader, "doBackup", "boolean", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("doBackup::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("doBackup::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.PreferencesBackupFragment", lpparam.classLoader, "doExportCSV", "boolean", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("doExportCSV::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("doExportCSV::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.PreferencesBackupFragment", lpparam.classLoader, "doImportCSV", "boolean", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("doImportCSV::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("doImportCSV::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.PreferencesBackupFragment", lpparam.classLoader, "doRestore", "boolean", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("doRestore::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("doRestore::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.PreferencesBackupFragment", lpparam.classLoader, "setupImportCSVPreference", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("setupImportCSVPreference::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("setupImportCSVPreference::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.PreferencesBackupFragment", lpparam.classLoader, "setupRestorePreference", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("setupRestorePreference::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("setupRestorePreference::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.PreferencesBackupFragment", lpparam.classLoader, "setupSynchronizationPreference", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("setupSynchronizationPreference::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("setupSynchronizationPreference::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.PreferencesBackupFragment", lpparam.classLoader, "createOnClickListenerToAskForStorageAccess", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("createOnClickListenerToAskForStorageAccess::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("createOnClickListenerToAskForStorageAccess::methodEnd::" + endTime);
            }
        });

        findAndHookConstructor("me.kuehle.carreport.gui.PreferencesCarsFragment$CarAdapter", lpparam.classLoader, "me.kuehle.carreport.gui.PreferencesCarsFragment", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("CarAdapter::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("CarAdapter::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.PreferencesCarsFragment$CarAdapter", lpparam.classLoader, "newView", "android.content.Context", "android.database.Cursor", "android.view.ViewGroup", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("newView::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("newView::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.PreferencesCarsFragment$CarAdapter", lpparam.classLoader, "bindView", "android.view.View", "android.content.Context", "android.database.Cursor", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("bindView::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("bindView::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.PreferencesCarsFragment$CarMultiChoiceModeListener", lpparam.classLoader, "finishActionMode", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("finishActionMode::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("finishActionMode::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.PreferencesCarsFragment$CarMultiChoiceModeListener", lpparam.classLoader, "onActionItemClicked", "android.view.ActionMode", "android.view.MenuItem", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onActionItemClicked::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onActionItemClicked::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.PreferencesCarsFragment$CarMultiChoiceModeListener", lpparam.classLoader, "onCreateActionMode", "android.view.ActionMode", "android.view.Menu", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onCreateActionMode::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onCreateActionMode::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.PreferencesCarsFragment$CarMultiChoiceModeListener", lpparam.classLoader, "onDestroyActionMode", "android.view.ActionMode", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onDestroyActionMode::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onDestroyActionMode::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.PreferencesCarsFragment$CarMultiChoiceModeListener", lpparam.classLoader, "onItemCheckedStateChanged", "android.view.ActionMode", "int", "long", "boolean", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onItemCheckedStateChanged::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onItemCheckedStateChanged::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.PreferencesCarsFragment$CarMultiChoiceModeListener", lpparam.classLoader, "onPrepareActionMode", "android.view.ActionMode", "android.view.Menu", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onPrepareActionMode::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onPrepareActionMode::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.PreferencesCarsFragment", lpparam.classLoader, "onActivityCreated", "android.os.Bundle", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onActivityCreated::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onActivityCreated::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.PreferencesCarsFragment", lpparam.classLoader, "onCreate", "android.os.Bundle", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onCreate::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onCreate::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.PreferencesCarsFragment", lpparam.classLoader, "onCreateOptionsMenu", "android.view.Menu", "android.view.MenuInflater", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onCreateOptionsMenu::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onCreateOptionsMenu::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.PreferencesCarsFragment", lpparam.classLoader, "onListItemClick", "android.widget.ListView", "android.view.View", "int", "long", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onListItemClick::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onListItemClick::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.PreferencesCarsFragment", lpparam.classLoader, "onDialogNegativeClick", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onDialogNegativeClick::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onDialogNegativeClick::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.PreferencesCarsFragment", lpparam.classLoader, "onDialogPositiveClick", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onDialogPositiveClick::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onDialogPositiveClick::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.PreferencesCarsFragment", lpparam.classLoader, "onOptionsItemSelected", "android.view.MenuItem", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onOptionsItemSelected::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onOptionsItemSelected::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.PreferencesCarsFragment", lpparam.classLoader, "onResume", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onResume::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onResume::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.PreferencesCarsFragment", lpparam.classLoader, "onStop", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onStop::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onStop::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.PreferencesCarsFragment", lpparam.classLoader, "onCreateLoader", "int", "android.os.Bundle", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onCreateLoader::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onCreateLoader::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.PreferencesCarsFragment", lpparam.classLoader, "onLoadFinished", "android.content.Loader", "android.database.Cursor", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onLoadFinished::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onLoadFinished::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.PreferencesCarsFragment", lpparam.classLoader, "onLoaderReset", "android.content.Loader", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onLoaderReset::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onLoaderReset::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.PreferencesCarsFragment", lpparam.classLoader, "openCarDetailFragment", "long", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("openCarDetailFragment::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("openCarDetailFragment::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.PreferencesFuelTypesFragment$FuelTypesMultiChoiceModeListener", lpparam.classLoader, "deleteSelectedFuelTypes", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("deleteSelectedFuelTypes::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("deleteSelectedFuelTypes::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.PreferencesFuelTypesFragment$FuelTypesMultiChoiceModeListener", lpparam.classLoader, "finishActionMode", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("finishActionMode::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("finishActionMode::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.PreferencesFuelTypesFragment$FuelTypesMultiChoiceModeListener", lpparam.classLoader, "onActionItemClicked", "android.view.ActionMode", "android.view.MenuItem", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onActionItemClicked::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onActionItemClicked::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.PreferencesFuelTypesFragment$FuelTypesMultiChoiceModeListener", lpparam.classLoader, "onCreateActionMode", "android.view.ActionMode", "android.view.Menu", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onCreateActionMode::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onCreateActionMode::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.PreferencesFuelTypesFragment$FuelTypesMultiChoiceModeListener", lpparam.classLoader, "onDestroyActionMode", "android.view.ActionMode", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onDestroyActionMode::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onDestroyActionMode::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.PreferencesFuelTypesFragment$FuelTypesMultiChoiceModeListener", lpparam.classLoader, "onItemCheckedStateChanged", "android.view.ActionMode", "int", "long", "boolean", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onItemCheckedStateChanged::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onItemCheckedStateChanged::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.PreferencesFuelTypesFragment$FuelTypesMultiChoiceModeListener", lpparam.classLoader, "onPrepareActionMode", "android.view.ActionMode", "android.view.Menu", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onPrepareActionMode::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onPrepareActionMode::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.PreferencesFuelTypesFragment", lpparam.classLoader, "onActivityCreated", "android.os.Bundle", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onActivityCreated::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onActivityCreated::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.PreferencesFuelTypesFragment", lpparam.classLoader, "onCreate", "android.os.Bundle", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onCreate::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onCreate::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.PreferencesFuelTypesFragment", lpparam.classLoader, "onCreateOptionsMenu", "android.view.Menu", "android.view.MenuInflater", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onCreateOptionsMenu::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onCreateOptionsMenu::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.PreferencesFuelTypesFragment", lpparam.classLoader, "onOptionsItemSelected", "android.view.MenuItem", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onOptionsItemSelected::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onOptionsItemSelected::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.PreferencesFuelTypesFragment", lpparam.classLoader, "onListItemClick", "android.widget.ListView", "android.view.View", "int", "long", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onListItemClick::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onListItemClick::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.PreferencesFuelTypesFragment", lpparam.classLoader, "onDialogPositiveClick", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onDialogPositiveClick::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onDialogPositiveClick::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.PreferencesFuelTypesFragment", lpparam.classLoader, "onDialogNegativeClick", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onDialogNegativeClick::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onDialogNegativeClick::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.PreferencesFuelTypesFragment", lpparam.classLoader, "onStop", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onStop::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onStop::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.PreferencesFuelTypesFragment", lpparam.classLoader, "onCreateLoader", "int", "android.os.Bundle", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onCreateLoader::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onCreateLoader::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.PreferencesFuelTypesFragment", lpparam.classLoader, "onLoadFinished", "android.content.Loader", "android.database.Cursor", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onLoadFinished::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onLoadFinished::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.PreferencesFuelTypesFragment", lpparam.classLoader, "onLoaderReset", "android.content.Loader", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onLoaderReset::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onLoaderReset::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.PreferencesGeneralFragment$PreferenceChangeListener", lpparam.classLoader, "onPreferenceChange", "android.preference.Preference", "java.lang.Object", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onPreferenceChange::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onPreferenceChange::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.PreferencesGeneralFragment$PreferenceChangeListener", lpparam.classLoader, "updateFuelConsumptionField", "me.kuehle.carreport.FuelConsumption", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("updateFuelConsumptionField::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("updateFuelConsumptionField::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.PreferencesGeneralFragment$PreferenceChangeListener", lpparam.classLoader, "updateFuelConsumptionField", "me.kuehle.carreport.FuelConsumption", "android.preference.ListPreference", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("updateFuelConsumptionField::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("updateFuelConsumptionField::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.PreferencesGeneralFragment", lpparam.classLoader, "onCreate", "android.os.Bundle", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onCreate::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onCreate::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.PreferencesGeneralFragment", lpparam.classLoader, "onResume", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onResume::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onResume::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.PreferencesGeneralFragment", lpparam.classLoader, "updateReportOrderSummary", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("updateReportOrderSummary::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("updateReportOrderSummary::methodEnd::" + endTime);
            }
        });

        findAndHookConstructor("me.kuehle.carreport.gui.PreferencesRemindersFragment$ReminderAdapter", lpparam.classLoader, "me.kuehle.carreport.gui.PreferencesRemindersFragment", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("ReminderAdapter::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("ReminderAdapter::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.PreferencesRemindersFragment$ReminderAdapter", lpparam.classLoader, "newView", "android.content.Context", "android.database.Cursor", "android.view.ViewGroup", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("newView::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("newView::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.PreferencesRemindersFragment$ReminderAdapter", lpparam.classLoader, "bindView", "android.view.View", "android.content.Context", "android.database.Cursor", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("bindView::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("bindView::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.PreferencesRemindersFragment$ReminderMultiChoiceModeListener", lpparam.classLoader, "finishActionMode", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("finishActionMode::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("finishActionMode::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.PreferencesRemindersFragment$ReminderMultiChoiceModeListener", lpparam.classLoader, "onActionItemClicked", "android.view.ActionMode", "android.view.MenuItem", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onActionItemClicked::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onActionItemClicked::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.PreferencesRemindersFragment$ReminderMultiChoiceModeListener", lpparam.classLoader, "onCreateActionMode", "android.view.ActionMode", "android.view.Menu", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onCreateActionMode::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onCreateActionMode::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.PreferencesRemindersFragment$ReminderMultiChoiceModeListener", lpparam.classLoader, "onDestroyActionMode", "android.view.ActionMode", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onDestroyActionMode::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onDestroyActionMode::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.PreferencesRemindersFragment$ReminderMultiChoiceModeListener", lpparam.classLoader, "onItemCheckedStateChanged", "android.view.ActionMode", "int", "long", "boolean", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onItemCheckedStateChanged::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onItemCheckedStateChanged::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.PreferencesRemindersFragment$ReminderMultiChoiceModeListener", lpparam.classLoader, "onPrepareActionMode", "android.view.ActionMode", "android.view.Menu", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onPrepareActionMode::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onPrepareActionMode::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.PreferencesRemindersFragment", lpparam.classLoader, "onActivityCreated", "android.os.Bundle", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onActivityCreated::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onActivityCreated::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.PreferencesRemindersFragment", lpparam.classLoader, "onListItemClick", "android.widget.ListView", "android.view.View", "int", "long", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onListItemClick::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onListItemClick::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.PreferencesRemindersFragment", lpparam.classLoader, "onCreate", "android.os.Bundle", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onCreate::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onCreate::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.PreferencesRemindersFragment", lpparam.classLoader, "onCreateOptionsMenu", "android.view.Menu", "android.view.MenuInflater", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onCreateOptionsMenu::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onCreateOptionsMenu::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.PreferencesRemindersFragment", lpparam.classLoader, "onDialogNegativeClick", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onDialogNegativeClick::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onDialogNegativeClick::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.PreferencesRemindersFragment", lpparam.classLoader, "onDialogPositiveClick", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onDialogPositiveClick::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onDialogPositiveClick::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.PreferencesRemindersFragment", lpparam.classLoader, "onOptionsItemSelected", "android.view.MenuItem", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onOptionsItemSelected::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onOptionsItemSelected::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.PreferencesRemindersFragment", lpparam.classLoader, "onResume", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onResume::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onResume::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.PreferencesRemindersFragment", lpparam.classLoader, "onStop", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onStop::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onStop::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.PreferencesRemindersFragment", lpparam.classLoader, "onCreateLoader", "int", "android.os.Bundle", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onCreateLoader::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onCreateLoader::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.PreferencesRemindersFragment", lpparam.classLoader, "onLoadFinished", "android.content.Loader", "android.database.Cursor", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onLoadFinished::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onLoadFinished::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.PreferencesRemindersFragment", lpparam.classLoader, "onLoaderReset", "android.content.Loader", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onLoaderReset::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onLoaderReset::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.PreferencesRemindersFragment", lpparam.classLoader, "openReminderDetailFragment", "long", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("openReminderDetailFragment::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("openReminderDetailFragment::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.PreferencesReportOrderFragment", lpparam.classLoader, "onCreateView", "android.view.LayoutInflater", "android.view.ViewGroup", "android.os.Bundle", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onCreateView::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onCreateView::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.PreferencesReportOrderFragment", lpparam.classLoader, "onViewCreated", "android.view.View", "android.os.Bundle", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onViewCreated::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onViewCreated::methodEnd::" + endTime);
            }
        });

        findAndHookConstructor("me.kuehle.carreport.gui.PreferencesReportOrderFragment$ReportOrderViewHolder", lpparam.classLoader, "me.kuehle.carreport.gui.PreferencesReportOrderFragment", "android.view.View", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("ReportOrderViewHolder::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("ReportOrderViewHolder::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.PreferencesReportOrderFragment$ReportOrderViewHolder", lpparam.classLoader, "bind", "me.kuehle.carreport.data.report.AbstractReport", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("bind::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("bind::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.PreferencesReportOrderFragment$ReportOrderViewHolder", lpparam.classLoader, "onTouch", "android.view.View", "android.view.MotionEvent", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onTouch::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onTouch::methodEnd::" + endTime);
            }
        });

        findAndHookConstructor("me.kuehle.carreport.gui.PreferencesReportOrderFragment$ReportOrderAdapter", lpparam.classLoader, "me.kuehle.carreport.gui.PreferencesReportOrderFragment", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("ReportOrderAdapter::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("ReportOrderAdapter::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.PreferencesReportOrderFragment$ReportOrderAdapter", lpparam.classLoader, "onCreateViewHolder", "android.view.ViewGroup", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onCreateViewHolder::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onCreateViewHolder::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.PreferencesReportOrderFragment$ReportOrderAdapter", lpparam.classLoader, "onBindViewHolder", "me.kuehle.carreport.gui.PreferencesReportOrderFragment$ReportOrderViewHolder", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onBindViewHolder::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onBindViewHolder::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.PreferencesReportOrderFragment$ReportOrderAdapter", lpparam.classLoader, "onItemMove", "int", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onItemMove::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onItemMove::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.PreferencesReportOrderFragment$ReportOrderAdapter", lpparam.classLoader, "getItemCount", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getItemCount::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getItemCount::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.PreferencesReportOrderFragment$ReportOrderAdapter", lpparam.classLoader, "saveReportOrder", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("saveReportOrder::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("saveReportOrder::methodEnd::" + endTime);
            }
        });

        findAndHookConstructor("me.kuehle.carreport.gui.PreferencesReportOrderFragment$ReportOrderItemTouchHelperCallback", lpparam.classLoader, "me.kuehle.carreport.gui.PreferencesReportOrderFragment", "me.kuehle.carreport.gui.PreferencesReportOrderFragment$ReportOrderAdapter", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("ReportOrderItemTouchHelperCallback::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("ReportOrderItemTouchHelperCallback::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.PreferencesReportOrderFragment$ReportOrderItemTouchHelperCallback", lpparam.classLoader, "isLongPressDragEnabled", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("isLongPressDragEnabled::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("isLongPressDragEnabled::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.PreferencesReportOrderFragment$ReportOrderItemTouchHelperCallback", lpparam.classLoader, "isItemViewSwipeEnabled", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("isItemViewSwipeEnabled::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("isItemViewSwipeEnabled::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.PreferencesReportOrderFragment$ReportOrderItemTouchHelperCallback", lpparam.classLoader, "getMovementFlags", "android.support.v7.widget.RecyclerView", "android.support.v7.widget.RecyclerView$ViewHolder", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getMovementFlags::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getMovementFlags::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.PreferencesReportOrderFragment$ReportOrderItemTouchHelperCallback", lpparam.classLoader, "onMove", "android.support.v7.widget.RecyclerView", "android.support.v7.widget.RecyclerView$ViewHolder", "android.support.v7.widget.RecyclerView$ViewHolder", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onMove::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onMove::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.PreferencesReportOrderFragment$ReportOrderItemTouchHelperCallback", lpparam.classLoader, "onSwiped", "android.support.v7.widget.RecyclerView$ViewHolder", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onSwiped::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onSwiped::methodEnd::" + endTime);
            }
        });

        findAndHookConstructor("me.kuehle.carreport.gui.ReportFragment$ReportLoader", lpparam.classLoader, "android.content.Context", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("ReportLoader::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("ReportLoader::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.ReportFragment$ReportLoader", lpparam.classLoader, "loadInBackground", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("loadInBackground::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("loadInBackground::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.ReportFragment$ReportLoader", lpparam.classLoader, "onStartLoading", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onStartLoading::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onStartLoading::methodEnd::" + endTime);
            }
        });

        findAndHookConstructor("me.kuehle.carreport.gui.ReportFragment$ReportHolder", lpparam.classLoader, "me.kuehle.carreport.gui.ReportFragment", "android.view.View", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("ReportHolder::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("ReportHolder::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.ReportFragment$ReportHolder", lpparam.classLoader, "bind", "me.kuehle.carreport.data.report.AbstractReport", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("bind::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("bind::methodEnd::" + endTime);
            }
        });

        findAndHookConstructor("me.kuehle.carreport.gui.ReportFragment$ReportAdapter", lpparam.classLoader, "me.kuehle.carreport.gui.ReportFragment", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("ReportAdapter::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("ReportAdapter::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.ReportFragment$ReportAdapter", lpparam.classLoader, "onCreateViewHolder", "android.view.ViewGroup", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onCreateViewHolder::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onCreateViewHolder::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.ReportFragment$ReportAdapter", lpparam.classLoader, "onBindViewHolder", "me.kuehle.carreport.gui.ReportFragment$ReportHolder", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onBindViewHolder::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onBindViewHolder::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.ReportFragment$ReportAdapter", lpparam.classLoader, "getItemCount", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getItemCount::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getItemCount::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.ReportFragment$ReportAdapter", lpparam.classLoader, "setItems", "java.util.List", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("setItems::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("setItems::methodEnd::" + endTime);
            }
        });

        findAndHookConstructor("me.kuehle.carreport.gui.ReportFragment$ReportItemDecoration", lpparam.classLoader, "me.kuehle.carreport.gui.ReportFragment", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("ReportItemDecoration::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("ReportItemDecoration::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.ReportFragment$ReportItemDecoration", lpparam.classLoader, "getItemOffsets", "android.graphics.Rect", "android.view.View", "android.support.v7.widget.RecyclerView", "android.support.v7.widget.RecyclerView$State", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getItemOffsets::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getItemOffsets::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.ReportFragment", lpparam.classLoader, "onBackPressed", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onBackPressed::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onBackPressed::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.ReportFragment", lpparam.classLoader, "onCreateView", "android.view.LayoutInflater", "android.view.ViewGroup", "android.os.Bundle", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onCreateView::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onCreateView::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.ReportFragment", lpparam.classLoader, "onMenuItemClick", "android.view.MenuItem", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onMenuItemClick::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onMenuItemClick::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.ReportFragment", lpparam.classLoader, "onCreateLoader", "int", "android.os.Bundle", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onCreateLoader::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onCreateLoader::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.ReportFragment", lpparam.classLoader, "onLoadFinished", "android.support.v4.content.Loader", "java.util.List", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onLoadFinished::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onLoadFinished::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.ReportFragment", lpparam.classLoader, "onLoaderReset", "android.support.v4.content.Loader", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onLoaderReset::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onLoaderReset::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.ReportFragment", lpparam.classLoader, "hideFullScreenChart", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("hideFullScreenChart::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("hideFullScreenChart::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.ReportFragment", lpparam.classLoader, "showFullScreenChart", "me.kuehle.carreport.data.report.AbstractReport", "android.view.View", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("showFullScreenChart::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("showFullScreenChart::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.ReportFragment", lpparam.classLoader, "toggleReportDetails", "android.view.View", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("toggleReportDetails::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("toggleReportDetails::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.ReportFragment", lpparam.classLoader, "showReportOptions", "me.kuehle.carreport.data.report.AbstractReport", "android.view.View", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("showReportOptions::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("showReportOptions::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.ReportFragment", lpparam.classLoader, "loadGraphSettings", "android.content.Context", "me.kuehle.carreport.data.report.AbstractReport", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("loadGraphSettings::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("loadGraphSettings::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.ReportFragment", lpparam.classLoader, "saveGraphSettings", "android.content.Context", "me.kuehle.carreport.data.report.AbstractReport", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("saveGraphSettings::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("saveGraphSettings::methodEnd::" + endTime);
            }
        });

        findAndHookConstructor("me.kuehle.carreport.gui.util.AbstractFormFieldValidator", lpparam.classLoader, "android.widget.TextView", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("AbstractFormFieldValidator::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("AbstractFormFieldValidator::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.util.AbstractFormFieldValidator", lpparam.classLoader, "clear", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("clear::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("clear::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.util.AbstractFormFieldValidator", lpparam.classLoader, "validate", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("validate::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("validate::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.util.AbstractFormFieldValidator", lpparam.classLoader, "setError", "android.widget.TextView", "java.lang.String", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("setError::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("setError::methodEnd::" + endTime);
            }
        });

        findAndHookConstructor("me.kuehle.carreport.gui.util.DateTimeInput", lpparam.classLoader, "android.widget.EditText", "me.kuehle.carreport.gui.util.DateTimeInput$Mode", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("DateTimeInput::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("DateTimeInput::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.util.DateTimeInput", lpparam.classLoader, "applyOnClickListener", "android.support.v4.app.Fragment", "int", "android.support.v4.app.FragmentManager", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("applyOnClickListener::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("applyOnClickListener::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.util.DateTimeInput", lpparam.classLoader, "getDate", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getDate::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getDate::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.util.DateTimeInput", lpparam.classLoader, "setDate", "java.util.Date", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("setDate::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("setDate::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.util.DateTimeInput", lpparam.classLoader, "getEditText", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getEditText::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getEditText::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.util.DateTimeInput", lpparam.classLoader, "getDateTime", "java.util.Date", "java.util.Date", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getDateTime::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getDateTime::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.util.FloatingActionButtonRevealer", lpparam.classLoader, "setup", "com.github.clans.fab.FloatingActionMenu", "android.support.v7.widget.RecyclerView", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("setup::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("setup::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.util.FloatingActionButtonRevealer", lpparam.classLoader, "setup", "com.github.clans.fab.FloatingActionMenu", "android.widget.ListView", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("setup::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("setup::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.util.FloatingActionButtonRevealer", lpparam.classLoader, "showDelayed", "com.github.clans.fab.FloatingActionMenu", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("showDelayed::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("showDelayed::methodEnd::" + endTime);
            }
        });

        findAndHookConstructor("me.kuehle.carreport.gui.util.FormFieldGreaterZeroValidator", lpparam.classLoader, "android.widget.TextView", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("FormFieldGreaterZeroValidator::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("FormFieldGreaterZeroValidator::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.util.FormFieldGreaterZeroValidator", lpparam.classLoader, "getMessage", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getMessage::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getMessage::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.util.FormFieldGreaterZeroValidator", lpparam.classLoader, "isValid", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("isValid::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("isValid::methodEnd::" + endTime);
            }
        });

        findAndHookConstructor("me.kuehle.carreport.gui.util.FormFieldNotEmptyValidator", lpparam.classLoader, "android.widget.TextView", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("FormFieldNotEmptyValidator::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("FormFieldNotEmptyValidator::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.util.FormFieldNotEmptyValidator", lpparam.classLoader, "getMessage", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getMessage::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getMessage::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.util.FormFieldNotEmptyValidator", lpparam.classLoader, "isValid", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("isValid::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("isValid::methodEnd::" + endTime);
            }
        });

        findAndHookConstructor("me.kuehle.carreport.gui.util.FormValidator", lpparam.classLoader, new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("FormValidator::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("FormValidator::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.util.FormValidator", lpparam.classLoader, "add", "me.kuehle.carreport.gui.util.AbstractFormFieldValidator", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("add::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("add::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.util.FormValidator", lpparam.classLoader, "validate", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("validate::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("validate::methodEnd::" + endTime);
            }
        });

        findAndHookConstructor("me.kuehle.carreport.gui.util.SimpleAnimator", lpparam.classLoader, "android.content.Context", "android.view.View", "me.kuehle.carreport.gui.util.SimpleAnimator$Property", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("SimpleAnimator::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("SimpleAnimator::methodEnd::" + endTime);
            }
        });

        findAndHookConstructor("me.kuehle.carreport.gui.util.SimpleAnimator", lpparam.classLoader, "android.content.Context", "android.view.View", "me.kuehle.carreport.gui.util.SimpleAnimator$Property", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("SimpleAnimator::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("SimpleAnimator::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.util.SimpleAnimator", lpparam.classLoader, "show", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("show::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("show::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.util.SimpleAnimator", lpparam.classLoader, "show", "java.lang.Runnable", "java.lang.Runnable", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("show::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("show::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.util.SimpleAnimator", lpparam.classLoader, "hide", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("hide::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("hide::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.util.SimpleAnimator", lpparam.classLoader, "hide", "java.lang.Runnable", "java.lang.Runnable", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("hide::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("hide::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.util.SimpleAnimator", lpparam.classLoader, "createAnimator", "int", "java.lang.Runnable", "java.lang.Runnable", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("createAnimator::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("createAnimator::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.util.SimpleAnimator", lpparam.classLoader, "applyHeightUpdater", "android.animation.ValueAnimator", "int", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("applyHeightUpdater::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("applyHeightUpdater::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.util.SimpleAnimator", lpparam.classLoader, "applyWeightUpdater", "android.animation.ValueAnimator", "float", "float", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("applyWeightUpdater::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("applyWeightUpdater::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.gui.util.SimpleAnimator", lpparam.classLoader, "attachRunnable", "android.animation.Animator", "java.lang.Runnable", "java.lang.Runnable", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("attachRunnable::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("attachRunnable::methodEnd::" + endTime);
            }
        });

        findAndHookConstructor("me.kuehle.carreport.Preferences", lpparam.classLoader, "android.content.Context", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("Preferences::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("Preferences::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.Preferences", lpparam.classLoader, "getDefaultCar", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getDefaultCar::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getDefaultCar::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.Preferences", lpparam.classLoader, "getDistanceEntryMode", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getDistanceEntryMode::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getDistanceEntryMode::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.Preferences", lpparam.classLoader, "getPriceEntryMode", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getPriceEntryMode::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getPriceEntryMode::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.Preferences", lpparam.classLoader, "getSyncLocalFileRev", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getSyncLocalFileRev::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getSyncLocalFileRev::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.Preferences", lpparam.classLoader, "setSyncLocalFileRev", "java.lang.String", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("setSyncLocalFileRev::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("setSyncLocalFileRev::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.Preferences", lpparam.classLoader, "getReportOrder", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getReportOrder::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getReportOrder::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.Preferences", lpparam.classLoader, "getReminderSnoozeDuration", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getReminderSnoozeDuration::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getReminderSnoozeDuration::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.Preferences", lpparam.classLoader, "getUnitCurrency", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getUnitCurrency::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getUnitCurrency::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.Preferences", lpparam.classLoader, "getUnitDistance", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getUnitDistance::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getUnitDistance::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.Preferences", lpparam.classLoader, "getUnitVolume", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getUnitVolume::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getUnitVolume::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.Preferences", lpparam.classLoader, "getUnitFuelConsumption", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getUnitFuelConsumption::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getUnitFuelConsumption::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.Preferences", lpparam.classLoader, "isAutoGuessMissingDataEnabled", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("isAutoGuessMissingDataEnabled::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("isAutoGuessMissingDataEnabled::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.Preferences", lpparam.classLoader, "isShowCarMenu", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("isShowCarMenu::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("isShowCarMenu::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.Preferences", lpparam.classLoader, "setReportOrder", "java.util.List", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("setReportOrder::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("setReportOrder::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.Preferences", lpparam.classLoader, "getDeprecatedSynchronizationProvider", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getDeprecatedSynchronizationProvider::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getDeprecatedSynchronizationProvider::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.Preferences", lpparam.classLoader, "getDeprecatedDropboxAccount", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getDeprecatedDropboxAccount::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getDeprecatedDropboxAccount::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.Preferences", lpparam.classLoader, "getDeprecatedDropboxAccessToken", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getDeprecatedDropboxAccessToken::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getDeprecatedDropboxAccessToken::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.Preferences", lpparam.classLoader, "getDeprecatedDropboxLocalRev", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getDeprecatedDropboxLocalRev::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getDeprecatedDropboxLocalRev::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.Preferences", lpparam.classLoader, "getDeprecatedGoogleDriveAccount", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getDeprecatedGoogleDriveAccount::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getDeprecatedGoogleDriveAccount::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.Preferences", lpparam.classLoader, "getDeprecatedGoogleDriveLocalModifiedDate", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getDeprecatedGoogleDriveLocalModifiedDate::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getDeprecatedGoogleDriveLocalModifiedDate::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.Preferences", lpparam.classLoader, "removeDeprecatedSyncSettings", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("removeDeprecatedSyncSettings::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("removeDeprecatedSyncSettings::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.base.AbstractContentValues", lpparam.classLoader, "values", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("values::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("values::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.base.AbstractContentValues", lpparam.classLoader, "insert", "android.content.ContentResolver", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("insert::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("insert::methodEnd::" + endTime);
            }
        });

        findAndHookConstructor("me.kuehle.carreport.provider.base.AbstractCursor", lpparam.classLoader, "android.database.Cursor", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("AbstractCursor::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("AbstractCursor::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.base.AbstractCursor", lpparam.classLoader, "getCachedColumnIndexOrThrow", "java.lang.String", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getCachedColumnIndexOrThrow::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getCachedColumnIndexOrThrow::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.base.AbstractCursor", lpparam.classLoader, "getStringOrNull", "java.lang.String", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getStringOrNull::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getStringOrNull::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.base.AbstractCursor", lpparam.classLoader, "getIntegerOrNull", "java.lang.String", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getIntegerOrNull::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getIntegerOrNull::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.base.AbstractCursor", lpparam.classLoader, "getLongOrNull", "java.lang.String", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getLongOrNull::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getLongOrNull::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.base.AbstractCursor", lpparam.classLoader, "getFloatOrNull", "java.lang.String", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getFloatOrNull::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getFloatOrNull::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.base.AbstractCursor", lpparam.classLoader, "getDoubleOrNull", "java.lang.String", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getDoubleOrNull::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getDoubleOrNull::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.base.AbstractCursor", lpparam.classLoader, "getBooleanOrNull", "java.lang.String", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getBooleanOrNull::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getBooleanOrNull::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.base.AbstractCursor", lpparam.classLoader, "getDateOrNull", "java.lang.String", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getDateOrNull::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getDateOrNull::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.base.AbstractCursor", lpparam.classLoader, "getBlobOrNull", "java.lang.String", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getBlobOrNull::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getBlobOrNull::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.base.AbstractSelection", lpparam.classLoader, "addGreaterThan", "java.lang.String", "java.lang.Object", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("addGreaterThan::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("addGreaterThan::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.base.AbstractSelection", lpparam.classLoader, "addGreaterThanOrEquals", "java.lang.String", "java.lang.Object", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("addGreaterThanOrEquals::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("addGreaterThanOrEquals::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.base.AbstractSelection", lpparam.classLoader, "addLessThan", "java.lang.String", "java.lang.Object", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("addLessThan::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("addLessThan::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.base.AbstractSelection", lpparam.classLoader, "addLessThanOrEquals", "java.lang.String", "java.lang.Object", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("addLessThanOrEquals::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("addLessThanOrEquals::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.base.AbstractSelection", lpparam.classLoader, "valueOf", "java.lang.Object", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("valueOf::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("valueOf::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.base.AbstractSelection", lpparam.classLoader, "openParen", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("openParen::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("openParen::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.base.AbstractSelection", lpparam.classLoader, "closeParen", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("closeParen::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("closeParen::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.base.AbstractSelection", lpparam.classLoader, "and", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("and::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("and::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.base.AbstractSelection", lpparam.classLoader, "or", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("or::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("or::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.base.AbstractSelection", lpparam.classLoader, "toObjectArray", "[I", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("toObjectArray::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("toObjectArray::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.base.AbstractSelection", lpparam.classLoader, "toObjectArray", "[J", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("toObjectArray::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("toObjectArray::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.base.AbstractSelection", lpparam.classLoader, "toObjectArray", "[F", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("toObjectArray::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("toObjectArray::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.base.AbstractSelection", lpparam.classLoader, "toObjectArray", "[D", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("toObjectArray::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("toObjectArray::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.base.AbstractSelection", lpparam.classLoader, "toObjectArray", "java.lang.Boolean", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("toObjectArray::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("toObjectArray::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.base.AbstractSelection", lpparam.classLoader, "sel", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("sel::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("sel::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.base.AbstractSelection", lpparam.classLoader, "args", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("args::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("args::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.base.AbstractSelection", lpparam.classLoader, "uri", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("uri::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("uri::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.base.AbstractSelection", lpparam.classLoader, "delete", "android.content.ContentResolver", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("delete::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("delete::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.base.AbstractSelection", lpparam.classLoader, "notify", "boolean", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("notify::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("notify::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.base.AbstractSelection", lpparam.classLoader, "groupBy", "java.lang.String", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("groupBy::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("groupBy::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.base.AbstractSelection", lpparam.classLoader, "having", "java.lang.String", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("having::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("having::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.base.AbstractSelection", lpparam.classLoader, "limit", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("limit::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("limit::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.base.BaseContentProvider", lpparam.classLoader, "onCreate", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onCreate::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onCreate::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.base.BaseContentProvider", lpparam.classLoader, "insert", "android.net.Uri", "android.content.ContentValues", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("insert::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("insert::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.base.BaseContentProvider", lpparam.classLoader, "applyBatch", "java.util.ArrayList", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("applyBatch::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("applyBatch::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.base.BaseContentProvider", lpparam.classLoader, "notify", "android.net.Uri", "boolean", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("notify::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("notify::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.base.BaseContentProvider", lpparam.classLoader, "groupBy", "android.net.Uri", "java.lang.String", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("groupBy::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("groupBy::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.base.BaseContentProvider", lpparam.classLoader, "having", "android.net.Uri", "java.lang.String", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("having::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("having::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.base.BaseContentProvider", lpparam.classLoader, "limit", "android.net.Uri", "java.lang.String", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("limit::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("limit::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.car.CarContentValues", lpparam.classLoader, "uri", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("uri::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("uri::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.car.CarContentValues", lpparam.classLoader, "update", "android.content.ContentResolver", "me.kuehle.carreport.provider.car.CarSelection", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("update::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("update::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.car.CarContentValues", lpparam.classLoader, "putName", "java.lang.String", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("putName::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("putName::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.car.CarContentValues", lpparam.classLoader, "putColor", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("putColor::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("putColor::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.car.CarContentValues", lpparam.classLoader, "putInitialMileage", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("putInitialMileage::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("putInitialMileage::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.car.CarContentValues", lpparam.classLoader, "putSuspendedSince", "java.util.Date", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("putSuspendedSince::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("putSuspendedSince::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.car.CarContentValues", lpparam.classLoader, "putSuspendedSinceNull", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("putSuspendedSinceNull::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("putSuspendedSinceNull::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.car.CarContentValues", lpparam.classLoader, "putSuspendedSince", "java.lang.Long", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("putSuspendedSince::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("putSuspendedSince::methodEnd::" + endTime);
            }
        });

        findAndHookConstructor("me.kuehle.carreport.provider.car.CarCursor", lpparam.classLoader, "android.database.Cursor", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("CarCursor::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("CarCursor::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.car.CarCursor", lpparam.classLoader, "getId", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getId::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getId::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.car.CarCursor", lpparam.classLoader, "getName", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getName::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getName::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.car.CarCursor", lpparam.classLoader, "getColor", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getColor::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getColor::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.car.CarCursor", lpparam.classLoader, "getInitialMileage", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getInitialMileage::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getInitialMileage::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.car.CarCursor", lpparam.classLoader, "getSuspendedSince", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getSuspendedSince::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getSuspendedSince::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.car.CarSelection", lpparam.classLoader, "baseUri", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("baseUri::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("baseUri::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.car.CarSelection", lpparam.classLoader, "query", "android.content.ContentResolver", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("query::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("query::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.car.CarSelection", lpparam.classLoader, "id", "[J", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("id::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("id::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.car.CarSelection", lpparam.classLoader, "color", "[I", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("color::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("color::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.car.CarSelection", lpparam.classLoader, "colorNot", "[I", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("colorNot::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("colorNot::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.car.CarSelection", lpparam.classLoader, "colorGt", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("colorGt::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("colorGt::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.car.CarSelection", lpparam.classLoader, "colorGtEq", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("colorGtEq::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("colorGtEq::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.car.CarSelection", lpparam.classLoader, "colorLt", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("colorLt::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("colorLt::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.car.CarSelection", lpparam.classLoader, "colorLtEq", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("colorLtEq::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("colorLtEq::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.car.CarSelection", lpparam.classLoader, "initialMileage", "[I", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("initialMileage::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("initialMileage::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.car.CarSelection", lpparam.classLoader, "initialMileageNot", "[I", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("initialMileageNot::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("initialMileageNot::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.car.CarSelection", lpparam.classLoader, "initialMileageGt", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("initialMileageGt::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("initialMileageGt::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.car.CarSelection", lpparam.classLoader, "initialMileageGtEq", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("initialMileageGtEq::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("initialMileageGtEq::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.car.CarSelection", lpparam.classLoader, "initialMileageLt", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("initialMileageLt::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("initialMileageLt::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.car.CarSelection", lpparam.classLoader, "initialMileageLtEq", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("initialMileageLtEq::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("initialMileageLtEq::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.car.CarSelection", lpparam.classLoader, "suspendedSinceAfter", "java.util.Date", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("suspendedSinceAfter::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("suspendedSinceAfter::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.car.CarSelection", lpparam.classLoader, "suspendedSinceAfterEq", "java.util.Date", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("suspendedSinceAfterEq::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("suspendedSinceAfterEq::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.car.CarSelection", lpparam.classLoader, "suspendedSinceBefore", "java.util.Date", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("suspendedSinceBefore::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("suspendedSinceBefore::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.car.CarSelection", lpparam.classLoader, "suspendedSinceBeforeEq", "java.util.Date", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("suspendedSinceBeforeEq::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("suspendedSinceBeforeEq::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.DataProvider", lpparam.classLoader, "createSqLiteOpenHelper", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("createSqLiteOpenHelper::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("createSqLiteOpenHelper::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.DataProvider", lpparam.classLoader, "hasDebug", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("hasDebug::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("hasDebug::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.DataProvider", lpparam.classLoader, "getType", "android.net.Uri", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getType::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getType::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.DataProvider", lpparam.classLoader, "insert", "android.net.Uri", "android.content.ContentValues", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("insert::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("insert::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.DataSQLiteOpenHelper", lpparam.classLoader, "getInstance", "android.content.Context", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getInstance::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getInstance::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.DataSQLiteOpenHelper", lpparam.classLoader, "newInstance", "android.content.Context", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("newInstance::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("newInstance::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.DataSQLiteOpenHelper", lpparam.classLoader, "newInstancePreHoneycomb", "android.content.Context", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("newInstancePreHoneycomb::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("newInstancePreHoneycomb::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.DataSQLiteOpenHelper", lpparam.classLoader, "newInstancePostHoneycomb", "android.content.Context", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("newInstancePostHoneycomb::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("newInstancePostHoneycomb::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.DataSQLiteOpenHelper", lpparam.classLoader, "onCreate", "android.database.sqlite.SQLiteDatabase", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onCreate::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onCreate::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.DataSQLiteOpenHelper", lpparam.classLoader, "onOpen", "android.database.sqlite.SQLiteDatabase", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onOpen::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onOpen::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.DataSQLiteOpenHelper", lpparam.classLoader, "setForeignKeyConstraintsEnabled", "android.database.sqlite.SQLiteDatabase", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("setForeignKeyConstraintsEnabled::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("setForeignKeyConstraintsEnabled::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.DataSQLiteOpenHelper", lpparam.classLoader, "setForeignKeyConstraintsEnabledPreJellyBean", "android.database.sqlite.SQLiteDatabase", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("setForeignKeyConstraintsEnabledPreJellyBean::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("setForeignKeyConstraintsEnabledPreJellyBean::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.DataSQLiteOpenHelper", lpparam.classLoader, "setForeignKeyConstraintsEnabledPostJellyBean", "android.database.sqlite.SQLiteDatabase", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("setForeignKeyConstraintsEnabledPostJellyBean::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("setForeignKeyConstraintsEnabledPostJellyBean::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.DataSQLiteOpenHelper", lpparam.classLoader, "onUpgrade", "android.database.sqlite.SQLiteDatabase", "int", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onUpgrade::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onUpgrade::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.DataSQLiteOpenHelperCallbacks", lpparam.classLoader, "onOpen", "android.content.Context", "android.database.sqlite.SQLiteDatabase", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onOpen::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onOpen::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.DataSQLiteOpenHelperCallbacks", lpparam.classLoader, "onPreCreate", "android.content.Context", "android.database.sqlite.SQLiteDatabase", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onPreCreate::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onPreCreate::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.DataSQLiteOpenHelperCallbacks", lpparam.classLoader, "onPostCreate", "android.content.Context", "android.database.sqlite.SQLiteDatabase", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onPostCreate::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onPostCreate::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.DataSQLiteOpenHelperCallbacks", lpparam.classLoader, "onUpgrade", "android.content.Context", "android.database.sqlite.SQLiteDatabase", "int", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onUpgrade::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onUpgrade::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.DataSQLiteOpenHelperCallbacks", lpparam.classLoader, "prepareSqlStatements", "java.lang.String", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("prepareSqlStatements::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("prepareSqlStatements::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.DataSQLiteOpenHelperCallbacks", lpparam.classLoader, "getMigrationFileContent", "android.content.Context", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getMigrationFileContent::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getMigrationFileContent::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.fueltype.FuelTypeContentValues", lpparam.classLoader, "uri", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("uri::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("uri::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.fueltype.FuelTypeContentValues", lpparam.classLoader, "update", "android.content.ContentResolver", "me.kuehle.carreport.provider.fueltype.FuelTypeSelection", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("update::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("update::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.fueltype.FuelTypeContentValues", lpparam.classLoader, "putName", "java.lang.String", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("putName::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("putName::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.fueltype.FuelTypeContentValues", lpparam.classLoader, "putCategory", "java.lang.String", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("putCategory::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("putCategory::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.fueltype.FuelTypeContentValues", lpparam.classLoader, "putCategoryNull", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("putCategoryNull::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("putCategoryNull::methodEnd::" + endTime);
            }
        });

        findAndHookConstructor("me.kuehle.carreport.provider.fueltype.FuelTypeCursor", lpparam.classLoader, "android.database.Cursor", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("FuelTypeCursor::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("FuelTypeCursor::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.fueltype.FuelTypeCursor", lpparam.classLoader, "getId", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getId::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getId::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.fueltype.FuelTypeCursor", lpparam.classLoader, "getName", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getName::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getName::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.fueltype.FuelTypeCursor", lpparam.classLoader, "getCategory", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getCategory::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getCategory::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.fueltype.FuelTypeSelection", lpparam.classLoader, "baseUri", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("baseUri::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("baseUri::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.fueltype.FuelTypeSelection", lpparam.classLoader, "query", "android.content.ContentResolver", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("query::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("query::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.fueltype.FuelTypeSelection", lpparam.classLoader, "id", "[J", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("id::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("id::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.othercost.OtherCostContentValues", lpparam.classLoader, "uri", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("uri::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("uri::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.othercost.OtherCostContentValues", lpparam.classLoader, "update", "android.content.ContentResolver", "me.kuehle.carreport.provider.othercost.OtherCostSelection", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("update::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("update::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.othercost.OtherCostContentValues", lpparam.classLoader, "putTitle", "java.lang.String", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("putTitle::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("putTitle::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.othercost.OtherCostContentValues", lpparam.classLoader, "putDate", "java.util.Date", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("putDate::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("putDate::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.othercost.OtherCostContentValues", lpparam.classLoader, "putDate", "long", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("putDate::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("putDate::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.othercost.OtherCostContentValues", lpparam.classLoader, "putMileage", "java.lang.Integer", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("putMileage::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("putMileage::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.othercost.OtherCostContentValues", lpparam.classLoader, "putMileageNull", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("putMileageNull::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("putMileageNull::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.othercost.OtherCostContentValues", lpparam.classLoader, "putPrice", "float", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("putPrice::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("putPrice::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.othercost.OtherCostContentValues", lpparam.classLoader, "putRecurrenceInterval", "me.kuehle.carreport.provider.othercost.RecurrenceInterval", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("putRecurrenceInterval::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("putRecurrenceInterval::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.othercost.OtherCostContentValues", lpparam.classLoader, "putRecurrenceMultiplier", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("putRecurrenceMultiplier::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("putRecurrenceMultiplier::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.othercost.OtherCostContentValues", lpparam.classLoader, "putEndDate", "java.util.Date", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("putEndDate::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("putEndDate::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.othercost.OtherCostContentValues", lpparam.classLoader, "putEndDateNull", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("putEndDateNull::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("putEndDateNull::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.othercost.OtherCostContentValues", lpparam.classLoader, "putEndDate", "java.lang.Long", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("putEndDate::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("putEndDate::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.othercost.OtherCostContentValues", lpparam.classLoader, "putNote", "java.lang.String", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("putNote::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("putNote::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.othercost.OtherCostContentValues", lpparam.classLoader, "putCarId", "long", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("putCarId::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("putCarId::methodEnd::" + endTime);
            }
        });

        findAndHookConstructor("me.kuehle.carreport.provider.othercost.OtherCostCursor", lpparam.classLoader, "android.database.Cursor", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("OtherCostCursor::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("OtherCostCursor::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.othercost.OtherCostCursor", lpparam.classLoader, "getId", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getId::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getId::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.othercost.OtherCostCursor", lpparam.classLoader, "getTitle", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getTitle::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getTitle::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.othercost.OtherCostCursor", lpparam.classLoader, "getDate", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getDate::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getDate::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.othercost.OtherCostCursor", lpparam.classLoader, "getMileage", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getMileage::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getMileage::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.othercost.OtherCostCursor", lpparam.classLoader, "getPrice", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getPrice::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getPrice::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.othercost.OtherCostCursor", lpparam.classLoader, "getRecurrenceInterval", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getRecurrenceInterval::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getRecurrenceInterval::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.othercost.OtherCostCursor", lpparam.classLoader, "getRecurrenceMultiplier", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getRecurrenceMultiplier::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getRecurrenceMultiplier::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.othercost.OtherCostCursor", lpparam.classLoader, "getEndDate", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getEndDate::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getEndDate::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.othercost.OtherCostCursor", lpparam.classLoader, "getNote", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getNote::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getNote::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.othercost.OtherCostCursor", lpparam.classLoader, "getCarId", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getCarId::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getCarId::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.othercost.OtherCostCursor", lpparam.classLoader, "getCarName", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getCarName::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getCarName::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.othercost.OtherCostCursor", lpparam.classLoader, "getCarColor", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getCarColor::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getCarColor::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.othercost.OtherCostCursor", lpparam.classLoader, "getCarInitialMileage", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getCarInitialMileage::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getCarInitialMileage::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.othercost.OtherCostCursor", lpparam.classLoader, "getCarSuspendedSince", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getCarSuspendedSince::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getCarSuspendedSince::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.othercost.OtherCostSelection", lpparam.classLoader, "baseUri", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("baseUri::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("baseUri::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.othercost.OtherCostSelection", lpparam.classLoader, "query", "android.content.ContentResolver", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("query::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("query::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.othercost.OtherCostSelection", lpparam.classLoader, "id", "[J", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("id::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("id::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.othercost.OtherCostSelection", lpparam.classLoader, "date", "[J", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("date::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("date::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.othercost.OtherCostSelection", lpparam.classLoader, "dateAfter", "java.util.Date", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("dateAfter::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("dateAfter::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.othercost.OtherCostSelection", lpparam.classLoader, "dateAfterEq", "java.util.Date", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("dateAfterEq::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("dateAfterEq::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.othercost.OtherCostSelection", lpparam.classLoader, "dateBefore", "java.util.Date", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("dateBefore::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("dateBefore::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.othercost.OtherCostSelection", lpparam.classLoader, "dateBeforeEq", "java.util.Date", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("dateBeforeEq::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("dateBeforeEq::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.othercost.OtherCostSelection", lpparam.classLoader, "mileageGt", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("mileageGt::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("mileageGt::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.othercost.OtherCostSelection", lpparam.classLoader, "mileageGtEq", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("mileageGtEq::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("mileageGtEq::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.othercost.OtherCostSelection", lpparam.classLoader, "mileageLt", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("mileageLt::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("mileageLt::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.othercost.OtherCostSelection", lpparam.classLoader, "mileageLtEq", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("mileageLtEq::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("mileageLtEq::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.othercost.OtherCostSelection", lpparam.classLoader, "price", "[F", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("price::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("price::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.othercost.OtherCostSelection", lpparam.classLoader, "priceNot", "[F", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("priceNot::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("priceNot::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.othercost.OtherCostSelection", lpparam.classLoader, "priceGt", "float", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("priceGt::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("priceGt::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.othercost.OtherCostSelection", lpparam.classLoader, "priceGtEq", "float", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("priceGtEq::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("priceGtEq::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.othercost.OtherCostSelection", lpparam.classLoader, "priceLt", "float", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("priceLt::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("priceLt::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.othercost.OtherCostSelection", lpparam.classLoader, "priceLtEq", "float", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("priceLtEq::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("priceLtEq::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.othercost.OtherCostSelection", lpparam.classLoader, "recurrenceMultiplier", "[I", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("recurrenceMultiplier::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("recurrenceMultiplier::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.othercost.OtherCostSelection", lpparam.classLoader, "recurrenceMultiplierNot", "[I", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("recurrenceMultiplierNot::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("recurrenceMultiplierNot::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.othercost.OtherCostSelection", lpparam.classLoader, "recurrenceMultiplierGt", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("recurrenceMultiplierGt::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("recurrenceMultiplierGt::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.othercost.OtherCostSelection", lpparam.classLoader, "recurrenceMultiplierGtEq", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("recurrenceMultiplierGtEq::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("recurrenceMultiplierGtEq::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.othercost.OtherCostSelection", lpparam.classLoader, "recurrenceMultiplierLt", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("recurrenceMultiplierLt::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("recurrenceMultiplierLt::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.othercost.OtherCostSelection", lpparam.classLoader, "recurrenceMultiplierLtEq", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("recurrenceMultiplierLtEq::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("recurrenceMultiplierLtEq::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.othercost.OtherCostSelection", lpparam.classLoader, "endDateAfter", "java.util.Date", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("endDateAfter::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("endDateAfter::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.othercost.OtherCostSelection", lpparam.classLoader, "endDateAfterEq", "java.util.Date", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("endDateAfterEq::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("endDateAfterEq::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.othercost.OtherCostSelection", lpparam.classLoader, "endDateBefore", "java.util.Date", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("endDateBefore::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("endDateBefore::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.othercost.OtherCostSelection", lpparam.classLoader, "endDateBeforeEq", "java.util.Date", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("endDateBeforeEq::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("endDateBeforeEq::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.othercost.OtherCostSelection", lpparam.classLoader, "carId", "[J", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("carId::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("carId::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.othercost.OtherCostSelection", lpparam.classLoader, "carIdNot", "[J", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("carIdNot::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("carIdNot::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.othercost.OtherCostSelection", lpparam.classLoader, "carIdGt", "long", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("carIdGt::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("carIdGt::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.othercost.OtherCostSelection", lpparam.classLoader, "carIdGtEq", "long", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("carIdGtEq::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("carIdGtEq::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.othercost.OtherCostSelection", lpparam.classLoader, "carIdLt", "long", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("carIdLt::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("carIdLt::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.othercost.OtherCostSelection", lpparam.classLoader, "carIdLtEq", "long", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("carIdLtEq::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("carIdLtEq::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.othercost.OtherCostSelection", lpparam.classLoader, "carColor", "[I", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("carColor::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("carColor::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.othercost.OtherCostSelection", lpparam.classLoader, "carColorNot", "[I", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("carColorNot::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("carColorNot::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.othercost.OtherCostSelection", lpparam.classLoader, "carColorGt", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("carColorGt::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("carColorGt::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.othercost.OtherCostSelection", lpparam.classLoader, "carColorGtEq", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("carColorGtEq::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("carColorGtEq::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.othercost.OtherCostSelection", lpparam.classLoader, "carColorLt", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("carColorLt::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("carColorLt::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.othercost.OtherCostSelection", lpparam.classLoader, "carColorLtEq", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("carColorLtEq::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("carColorLtEq::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.othercost.OtherCostSelection", lpparam.classLoader, "carInitialMileage", "[I", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("carInitialMileage::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("carInitialMileage::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.othercost.OtherCostSelection", lpparam.classLoader, "carInitialMileageNot", "[I", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("carInitialMileageNot::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("carInitialMileageNot::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.othercost.OtherCostSelection", lpparam.classLoader, "carInitialMileageGt", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("carInitialMileageGt::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("carInitialMileageGt::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.othercost.OtherCostSelection", lpparam.classLoader, "carInitialMileageGtEq", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("carInitialMileageGtEq::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("carInitialMileageGtEq::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.othercost.OtherCostSelection", lpparam.classLoader, "carInitialMileageLt", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("carInitialMileageLt::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("carInitialMileageLt::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.othercost.OtherCostSelection", lpparam.classLoader, "carInitialMileageLtEq", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("carInitialMileageLtEq::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("carInitialMileageLtEq::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.othercost.OtherCostSelection", lpparam.classLoader, "carSuspendedSinceAfter", "java.util.Date", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("carSuspendedSinceAfter::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("carSuspendedSinceAfter::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.othercost.OtherCostSelection", lpparam.classLoader, "carSuspendedSinceAfterEq", "java.util.Date", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("carSuspendedSinceAfterEq::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("carSuspendedSinceAfterEq::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.othercost.OtherCostSelection", lpparam.classLoader, "carSuspendedSinceBefore", "java.util.Date", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("carSuspendedSinceBefore::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("carSuspendedSinceBefore::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.othercost.OtherCostSelection", lpparam.classLoader, "carSuspendedSinceBeforeEq", "java.util.Date", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("carSuspendedSinceBeforeEq::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("carSuspendedSinceBeforeEq::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.refueling.RefuelingContentValues", lpparam.classLoader, "uri", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("uri::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("uri::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.refueling.RefuelingContentValues", lpparam.classLoader, "update", "android.content.ContentResolver", "me.kuehle.carreport.provider.refueling.RefuelingSelection", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("update::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("update::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.refueling.RefuelingContentValues", lpparam.classLoader, "putDate", "java.util.Date", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("putDate::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("putDate::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.refueling.RefuelingContentValues", lpparam.classLoader, "putDate", "long", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("putDate::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("putDate::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.refueling.RefuelingContentValues", lpparam.classLoader, "putMileage", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("putMileage::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("putMileage::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.refueling.RefuelingContentValues", lpparam.classLoader, "putVolume", "float", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("putVolume::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("putVolume::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.refueling.RefuelingContentValues", lpparam.classLoader, "putPrice", "float", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("putPrice::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("putPrice::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.refueling.RefuelingContentValues", lpparam.classLoader, "putPartial", "boolean", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("putPartial::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("putPartial::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.refueling.RefuelingContentValues", lpparam.classLoader, "putNote", "java.lang.String", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("putNote::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("putNote::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.refueling.RefuelingContentValues", lpparam.classLoader, "putFuelTypeId", "long", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("putFuelTypeId::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("putFuelTypeId::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.refueling.RefuelingContentValues", lpparam.classLoader, "putCarId", "long", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("putCarId::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("putCarId::methodEnd::" + endTime);
            }
        });

        findAndHookConstructor("me.kuehle.carreport.provider.refueling.RefuelingCursor", lpparam.classLoader, "android.database.Cursor", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("RefuelingCursor::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("RefuelingCursor::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.refueling.RefuelingCursor", lpparam.classLoader, "getId", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getId::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getId::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.refueling.RefuelingCursor", lpparam.classLoader, "getDate", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getDate::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getDate::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.refueling.RefuelingCursor", lpparam.classLoader, "getMileage", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getMileage::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getMileage::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.refueling.RefuelingCursor", lpparam.classLoader, "getVolume", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getVolume::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getVolume::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.refueling.RefuelingCursor", lpparam.classLoader, "getPrice", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getPrice::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getPrice::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.refueling.RefuelingCursor", lpparam.classLoader, "getPartial", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getPartial::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getPartial::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.refueling.RefuelingCursor", lpparam.classLoader, "getNote", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getNote::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getNote::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.refueling.RefuelingCursor", lpparam.classLoader, "getFuelTypeId", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getFuelTypeId::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getFuelTypeId::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.refueling.RefuelingCursor", lpparam.classLoader, "getFuelTypeName", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getFuelTypeName::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getFuelTypeName::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.refueling.RefuelingCursor", lpparam.classLoader, "getFuelTypeCategory", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getFuelTypeCategory::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getFuelTypeCategory::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.refueling.RefuelingCursor", lpparam.classLoader, "getCarId", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getCarId::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getCarId::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.refueling.RefuelingCursor", lpparam.classLoader, "getCarName", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getCarName::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getCarName::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.refueling.RefuelingCursor", lpparam.classLoader, "getCarColor", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getCarColor::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getCarColor::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.refueling.RefuelingCursor", lpparam.classLoader, "getCarInitialMileage", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getCarInitialMileage::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getCarInitialMileage::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.refueling.RefuelingCursor", lpparam.classLoader, "getCarSuspendedSince", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getCarSuspendedSince::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getCarSuspendedSince::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.refueling.RefuelingSelection", lpparam.classLoader, "baseUri", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("baseUri::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("baseUri::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.refueling.RefuelingSelection", lpparam.classLoader, "query", "android.content.ContentResolver", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("query::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("query::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.refueling.RefuelingSelection", lpparam.classLoader, "id", "[J", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("id::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("id::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.refueling.RefuelingSelection", lpparam.classLoader, "date", "[J", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("date::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("date::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.refueling.RefuelingSelection", lpparam.classLoader, "dateAfter", "java.util.Date", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("dateAfter::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("dateAfter::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.refueling.RefuelingSelection", lpparam.classLoader, "dateAfterEq", "java.util.Date", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("dateAfterEq::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("dateAfterEq::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.refueling.RefuelingSelection", lpparam.classLoader, "dateBefore", "java.util.Date", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("dateBefore::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("dateBefore::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.refueling.RefuelingSelection", lpparam.classLoader, "dateBeforeEq", "java.util.Date", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("dateBeforeEq::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("dateBeforeEq::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.refueling.RefuelingSelection", lpparam.classLoader, "mileage", "[I", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("mileage::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("mileage::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.refueling.RefuelingSelection", lpparam.classLoader, "mileageNot", "[I", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("mileageNot::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("mileageNot::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.refueling.RefuelingSelection", lpparam.classLoader, "mileageGt", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("mileageGt::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("mileageGt::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.refueling.RefuelingSelection", lpparam.classLoader, "mileageGtEq", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("mileageGtEq::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("mileageGtEq::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.refueling.RefuelingSelection", lpparam.classLoader, "mileageLt", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("mileageLt::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("mileageLt::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.refueling.RefuelingSelection", lpparam.classLoader, "mileageLtEq", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("mileageLtEq::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("mileageLtEq::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.refueling.RefuelingSelection", lpparam.classLoader, "volume", "[F", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("volume::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("volume::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.refueling.RefuelingSelection", lpparam.classLoader, "volumeNot", "[F", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("volumeNot::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("volumeNot::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.refueling.RefuelingSelection", lpparam.classLoader, "volumeGt", "float", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("volumeGt::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("volumeGt::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.refueling.RefuelingSelection", lpparam.classLoader, "volumeGtEq", "float", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("volumeGtEq::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("volumeGtEq::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.refueling.RefuelingSelection", lpparam.classLoader, "volumeLt", "float", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("volumeLt::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("volumeLt::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.refueling.RefuelingSelection", lpparam.classLoader, "volumeLtEq", "float", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("volumeLtEq::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("volumeLtEq::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.refueling.RefuelingSelection", lpparam.classLoader, "price", "[F", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("price::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("price::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.refueling.RefuelingSelection", lpparam.classLoader, "priceNot", "[F", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("priceNot::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("priceNot::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.refueling.RefuelingSelection", lpparam.classLoader, "priceGt", "float", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("priceGt::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("priceGt::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.refueling.RefuelingSelection", lpparam.classLoader, "priceGtEq", "float", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("priceGtEq::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("priceGtEq::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.refueling.RefuelingSelection", lpparam.classLoader, "priceLt", "float", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("priceLt::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("priceLt::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.refueling.RefuelingSelection", lpparam.classLoader, "priceLtEq", "float", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("priceLtEq::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("priceLtEq::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.refueling.RefuelingSelection", lpparam.classLoader, "partial", "boolean", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("partial::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("partial::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.refueling.RefuelingSelection", lpparam.classLoader, "fuelTypeId", "[J", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("fuelTypeId::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("fuelTypeId::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.refueling.RefuelingSelection", lpparam.classLoader, "fuelTypeIdNot", "[J", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("fuelTypeIdNot::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("fuelTypeIdNot::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.refueling.RefuelingSelection", lpparam.classLoader, "fuelTypeIdGt", "long", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("fuelTypeIdGt::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("fuelTypeIdGt::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.refueling.RefuelingSelection", lpparam.classLoader, "fuelTypeIdGtEq", "long", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("fuelTypeIdGtEq::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("fuelTypeIdGtEq::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.refueling.RefuelingSelection", lpparam.classLoader, "fuelTypeIdLt", "long", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("fuelTypeIdLt::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("fuelTypeIdLt::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.refueling.RefuelingSelection", lpparam.classLoader, "fuelTypeIdLtEq", "long", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("fuelTypeIdLtEq::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("fuelTypeIdLtEq::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.refueling.RefuelingSelection", lpparam.classLoader, "carId", "[J", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("carId::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("carId::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.refueling.RefuelingSelection", lpparam.classLoader, "carIdNot", "[J", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("carIdNot::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("carIdNot::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.refueling.RefuelingSelection", lpparam.classLoader, "carIdGt", "long", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("carIdGt::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("carIdGt::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.refueling.RefuelingSelection", lpparam.classLoader, "carIdGtEq", "long", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("carIdGtEq::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("carIdGtEq::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.refueling.RefuelingSelection", lpparam.classLoader, "carIdLt", "long", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("carIdLt::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("carIdLt::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.refueling.RefuelingSelection", lpparam.classLoader, "carIdLtEq", "long", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("carIdLtEq::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("carIdLtEq::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.refueling.RefuelingSelection", lpparam.classLoader, "carColor", "[I", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("carColor::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("carColor::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.refueling.RefuelingSelection", lpparam.classLoader, "carColorNot", "[I", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("carColorNot::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("carColorNot::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.refueling.RefuelingSelection", lpparam.classLoader, "carColorGt", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("carColorGt::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("carColorGt::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.refueling.RefuelingSelection", lpparam.classLoader, "carColorGtEq", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("carColorGtEq::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("carColorGtEq::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.refueling.RefuelingSelection", lpparam.classLoader, "carColorLt", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("carColorLt::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("carColorLt::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.refueling.RefuelingSelection", lpparam.classLoader, "carColorLtEq", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("carColorLtEq::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("carColorLtEq::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.refueling.RefuelingSelection", lpparam.classLoader, "carInitialMileage", "[I", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("carInitialMileage::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("carInitialMileage::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.refueling.RefuelingSelection", lpparam.classLoader, "carInitialMileageNot", "[I", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("carInitialMileageNot::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("carInitialMileageNot::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.refueling.RefuelingSelection", lpparam.classLoader, "carInitialMileageGt", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("carInitialMileageGt::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("carInitialMileageGt::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.refueling.RefuelingSelection", lpparam.classLoader, "carInitialMileageGtEq", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("carInitialMileageGtEq::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("carInitialMileageGtEq::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.refueling.RefuelingSelection", lpparam.classLoader, "carInitialMileageLt", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("carInitialMileageLt::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("carInitialMileageLt::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.refueling.RefuelingSelection", lpparam.classLoader, "carInitialMileageLtEq", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("carInitialMileageLtEq::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("carInitialMileageLtEq::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.refueling.RefuelingSelection", lpparam.classLoader, "carSuspendedSinceAfter", "java.util.Date", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("carSuspendedSinceAfter::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("carSuspendedSinceAfter::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.refueling.RefuelingSelection", lpparam.classLoader, "carSuspendedSinceAfterEq", "java.util.Date", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("carSuspendedSinceAfterEq::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("carSuspendedSinceAfterEq::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.refueling.RefuelingSelection", lpparam.classLoader, "carSuspendedSinceBefore", "java.util.Date", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("carSuspendedSinceBefore::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("carSuspendedSinceBefore::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.refueling.RefuelingSelection", lpparam.classLoader, "carSuspendedSinceBeforeEq", "java.util.Date", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("carSuspendedSinceBeforeEq::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("carSuspendedSinceBeforeEq::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.reminder.ReminderContentValues", lpparam.classLoader, "uri", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("uri::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("uri::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.reminder.ReminderContentValues", lpparam.classLoader, "update", "android.content.ContentResolver", "me.kuehle.carreport.provider.reminder.ReminderSelection", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("update::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("update::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.reminder.ReminderContentValues", lpparam.classLoader, "putTitle", "java.lang.String", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("putTitle::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("putTitle::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.reminder.ReminderContentValues", lpparam.classLoader, "putAfterTimeSpanUnit", "me.kuehle.carreport.provider.reminder.TimeSpanUnit", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("putAfterTimeSpanUnit::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("putAfterTimeSpanUnit::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.reminder.ReminderContentValues", lpparam.classLoader, "putAfterTimeSpanUnitNull", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("putAfterTimeSpanUnitNull::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("putAfterTimeSpanUnitNull::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.reminder.ReminderContentValues", lpparam.classLoader, "putAfterTimeSpanCount", "java.lang.Integer", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("putAfterTimeSpanCount::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("putAfterTimeSpanCount::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.reminder.ReminderContentValues", lpparam.classLoader, "putAfterTimeSpanCountNull", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("putAfterTimeSpanCountNull::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("putAfterTimeSpanCountNull::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.reminder.ReminderContentValues", lpparam.classLoader, "putAfterDistance", "java.lang.Integer", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("putAfterDistance::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("putAfterDistance::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.reminder.ReminderContentValues", lpparam.classLoader, "putAfterDistanceNull", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("putAfterDistanceNull::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("putAfterDistanceNull::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.reminder.ReminderContentValues", lpparam.classLoader, "putStartDate", "java.util.Date", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("putStartDate::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("putStartDate::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.reminder.ReminderContentValues", lpparam.classLoader, "putStartDate", "long", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("putStartDate::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("putStartDate::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.reminder.ReminderContentValues", lpparam.classLoader, "putStartMileage", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("putStartMileage::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("putStartMileage::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.reminder.ReminderContentValues", lpparam.classLoader, "putNotificationDismissed", "boolean", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("putNotificationDismissed::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("putNotificationDismissed::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.reminder.ReminderContentValues", lpparam.classLoader, "putSnoozedUntil", "java.util.Date", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("putSnoozedUntil::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("putSnoozedUntil::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.reminder.ReminderContentValues", lpparam.classLoader, "putSnoozedUntilNull", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("putSnoozedUntilNull::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("putSnoozedUntilNull::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.reminder.ReminderContentValues", lpparam.classLoader, "putSnoozedUntil", "java.lang.Long", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("putSnoozedUntil::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("putSnoozedUntil::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.reminder.ReminderContentValues", lpparam.classLoader, "putCarId", "long", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("putCarId::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("putCarId::methodEnd::" + endTime);
            }
        });

        findAndHookConstructor("me.kuehle.carreport.provider.reminder.ReminderCursor", lpparam.classLoader, "android.database.Cursor", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("ReminderCursor::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("ReminderCursor::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.reminder.ReminderCursor", lpparam.classLoader, "getId", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getId::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getId::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.reminder.ReminderCursor", lpparam.classLoader, "getTitle", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getTitle::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getTitle::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.reminder.ReminderCursor", lpparam.classLoader, "getAfterTimeSpanUnit", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getAfterTimeSpanUnit::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getAfterTimeSpanUnit::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.reminder.ReminderCursor", lpparam.classLoader, "getAfterTimeSpanCount", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getAfterTimeSpanCount::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getAfterTimeSpanCount::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.reminder.ReminderCursor", lpparam.classLoader, "getAfterDistance", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getAfterDistance::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getAfterDistance::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.reminder.ReminderCursor", lpparam.classLoader, "getStartDate", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getStartDate::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getStartDate::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.reminder.ReminderCursor", lpparam.classLoader, "getStartMileage", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getStartMileage::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getStartMileage::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.reminder.ReminderCursor", lpparam.classLoader, "getNotificationDismissed", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getNotificationDismissed::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getNotificationDismissed::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.reminder.ReminderCursor", lpparam.classLoader, "getSnoozedUntil", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getSnoozedUntil::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getSnoozedUntil::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.reminder.ReminderCursor", lpparam.classLoader, "getCarId", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getCarId::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getCarId::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.reminder.ReminderCursor", lpparam.classLoader, "getCarName", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getCarName::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getCarName::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.reminder.ReminderCursor", lpparam.classLoader, "getCarColor", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getCarColor::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getCarColor::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.reminder.ReminderCursor", lpparam.classLoader, "getCarInitialMileage", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getCarInitialMileage::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getCarInitialMileage::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.reminder.ReminderCursor", lpparam.classLoader, "getCarSuspendedSince", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getCarSuspendedSince::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getCarSuspendedSince::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.reminder.ReminderSelection", lpparam.classLoader, "baseUri", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("baseUri::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("baseUri::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.reminder.ReminderSelection", lpparam.classLoader, "query", "android.content.ContentResolver", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("query::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("query::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.reminder.ReminderSelection", lpparam.classLoader, "id", "[J", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("id::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("id::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.reminder.ReminderSelection", lpparam.classLoader, "afterTimeSpanCountGt", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("afterTimeSpanCountGt::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("afterTimeSpanCountGt::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.reminder.ReminderSelection", lpparam.classLoader, "afterTimeSpanCountGtEq", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("afterTimeSpanCountGtEq::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("afterTimeSpanCountGtEq::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.reminder.ReminderSelection", lpparam.classLoader, "afterTimeSpanCountLt", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("afterTimeSpanCountLt::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("afterTimeSpanCountLt::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.reminder.ReminderSelection", lpparam.classLoader, "afterTimeSpanCountLtEq", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("afterTimeSpanCountLtEq::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("afterTimeSpanCountLtEq::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.reminder.ReminderSelection", lpparam.classLoader, "afterDistanceGt", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("afterDistanceGt::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("afterDistanceGt::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.reminder.ReminderSelection", lpparam.classLoader, "afterDistanceGtEq", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("afterDistanceGtEq::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("afterDistanceGtEq::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.reminder.ReminderSelection", lpparam.classLoader, "afterDistanceLt", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("afterDistanceLt::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("afterDistanceLt::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.reminder.ReminderSelection", lpparam.classLoader, "afterDistanceLtEq", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("afterDistanceLtEq::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("afterDistanceLtEq::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.reminder.ReminderSelection", lpparam.classLoader, "startDate", "[J", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("startDate::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("startDate::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.reminder.ReminderSelection", lpparam.classLoader, "startDateAfter", "java.util.Date", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("startDateAfter::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("startDateAfter::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.reminder.ReminderSelection", lpparam.classLoader, "startDateAfterEq", "java.util.Date", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("startDateAfterEq::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("startDateAfterEq::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.reminder.ReminderSelection", lpparam.classLoader, "startDateBefore", "java.util.Date", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("startDateBefore::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("startDateBefore::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.reminder.ReminderSelection", lpparam.classLoader, "startDateBeforeEq", "java.util.Date", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("startDateBeforeEq::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("startDateBeforeEq::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.reminder.ReminderSelection", lpparam.classLoader, "startMileage", "[I", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("startMileage::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("startMileage::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.reminder.ReminderSelection", lpparam.classLoader, "startMileageNot", "[I", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("startMileageNot::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("startMileageNot::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.reminder.ReminderSelection", lpparam.classLoader, "startMileageGt", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("startMileageGt::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("startMileageGt::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.reminder.ReminderSelection", lpparam.classLoader, "startMileageGtEq", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("startMileageGtEq::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("startMileageGtEq::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.reminder.ReminderSelection", lpparam.classLoader, "startMileageLt", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("startMileageLt::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("startMileageLt::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.reminder.ReminderSelection", lpparam.classLoader, "startMileageLtEq", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("startMileageLtEq::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("startMileageLtEq::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.reminder.ReminderSelection", lpparam.classLoader, "notificationDismissed", "boolean", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("notificationDismissed::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("notificationDismissed::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.reminder.ReminderSelection", lpparam.classLoader, "snoozedUntilAfter", "java.util.Date", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("snoozedUntilAfter::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("snoozedUntilAfter::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.reminder.ReminderSelection", lpparam.classLoader, "snoozedUntilAfterEq", "java.util.Date", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("snoozedUntilAfterEq::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("snoozedUntilAfterEq::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.reminder.ReminderSelection", lpparam.classLoader, "snoozedUntilBefore", "java.util.Date", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("snoozedUntilBefore::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("snoozedUntilBefore::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.reminder.ReminderSelection", lpparam.classLoader, "snoozedUntilBeforeEq", "java.util.Date", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("snoozedUntilBeforeEq::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("snoozedUntilBeforeEq::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.reminder.ReminderSelection", lpparam.classLoader, "carId", "[J", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("carId::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("carId::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.reminder.ReminderSelection", lpparam.classLoader, "carIdNot", "[J", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("carIdNot::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("carIdNot::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.reminder.ReminderSelection", lpparam.classLoader, "carIdGt", "long", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("carIdGt::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("carIdGt::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.reminder.ReminderSelection", lpparam.classLoader, "carIdGtEq", "long", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("carIdGtEq::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("carIdGtEq::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.reminder.ReminderSelection", lpparam.classLoader, "carIdLt", "long", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("carIdLt::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("carIdLt::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.reminder.ReminderSelection", lpparam.classLoader, "carIdLtEq", "long", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("carIdLtEq::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("carIdLtEq::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.reminder.ReminderSelection", lpparam.classLoader, "carColor", "[I", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("carColor::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("carColor::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.reminder.ReminderSelection", lpparam.classLoader, "carColorNot", "[I", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("carColorNot::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("carColorNot::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.reminder.ReminderSelection", lpparam.classLoader, "carColorGt", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("carColorGt::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("carColorGt::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.reminder.ReminderSelection", lpparam.classLoader, "carColorGtEq", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("carColorGtEq::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("carColorGtEq::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.reminder.ReminderSelection", lpparam.classLoader, "carColorLt", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("carColorLt::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("carColorLt::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.reminder.ReminderSelection", lpparam.classLoader, "carColorLtEq", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("carColorLtEq::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("carColorLtEq::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.reminder.ReminderSelection", lpparam.classLoader, "carInitialMileage", "[I", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("carInitialMileage::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("carInitialMileage::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.reminder.ReminderSelection", lpparam.classLoader, "carInitialMileageNot", "[I", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("carInitialMileageNot::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("carInitialMileageNot::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.reminder.ReminderSelection", lpparam.classLoader, "carInitialMileageGt", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("carInitialMileageGt::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("carInitialMileageGt::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.reminder.ReminderSelection", lpparam.classLoader, "carInitialMileageGtEq", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("carInitialMileageGtEq::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("carInitialMileageGtEq::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.reminder.ReminderSelection", lpparam.classLoader, "carInitialMileageLt", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("carInitialMileageLt::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("carInitialMileageLt::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.reminder.ReminderSelection", lpparam.classLoader, "carInitialMileageLtEq", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("carInitialMileageLtEq::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("carInitialMileageLtEq::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.reminder.ReminderSelection", lpparam.classLoader, "carSuspendedSinceAfter", "java.util.Date", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("carSuspendedSinceAfter::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("carSuspendedSinceAfter::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.reminder.ReminderSelection", lpparam.classLoader, "carSuspendedSinceAfterEq", "java.util.Date", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("carSuspendedSinceAfterEq::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("carSuspendedSinceAfterEq::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.reminder.ReminderSelection", lpparam.classLoader, "carSuspendedSinceBefore", "java.util.Date", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("carSuspendedSinceBefore::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("carSuspendedSinceBefore::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.provider.reminder.ReminderSelection", lpparam.classLoader, "carSuspendedSinceBeforeEq", "java.util.Date", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("carSuspendedSinceBeforeEq::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("carSuspendedSinceBeforeEq::methodEnd::" + endTime);
            }
        });

        findAndHookConstructor("me.kuehle.carreport.util.backup.Backup", lpparam.classLoader, "android.content.Context", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("Backup::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("Backup::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.backup.Backup", lpparam.classLoader, "backup", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("backup::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("backup::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.backup.Backup", lpparam.classLoader, "backupFileExists", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("backupFileExists::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("backupFileExists::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.backup.Backup", lpparam.classLoader, "restore", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("restore::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("restore::methodEnd::" + endTime);
            }
        });

        findAndHookConstructor("me.kuehle.carreport.util.backup.CSVExportImport", lpparam.classLoader, "android.content.Context", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("CSVExportImport::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("CSVExportImport::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.backup.CSVExportImport", lpparam.classLoader, "export", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("export::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("export::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.backup.CSVExportImport", lpparam.classLoader, "exportCars", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("exportCars::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("exportCars::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.backup.CSVExportImport", lpparam.classLoader, "exportFuelTypes", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("exportFuelTypes::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("exportFuelTypes::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.backup.CSVExportImport", lpparam.classLoader, "exportOtherCosts", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("exportOtherCosts::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("exportOtherCosts::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.backup.CSVExportImport", lpparam.classLoader, "exportRefuelings", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("exportRefuelings::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("exportRefuelings::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.backup.CSVExportImport", lpparam.classLoader, "exportReminders", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("exportReminders::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("exportReminders::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.backup.CSVExportImport", lpparam.classLoader, "allExportFilesExist", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("allExportFilesExist::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("allExportFilesExist::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.backup.CSVExportImport", lpparam.classLoader, "anyExportFileExist", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("anyExportFileExist::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("anyExportFileExist::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.backup.CSVExportImport", lpparam.classLoader, "import_", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("import_::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("import_::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.backup.CSVExportImport", lpparam.classLoader, "importCars", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("importCars::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("importCars::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.backup.CSVExportImport", lpparam.classLoader, "importFuelTypes", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("importFuelTypes::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("importFuelTypes::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.backup.CSVExportImport", lpparam.classLoader, "importOtherCosts", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("importOtherCosts::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("importOtherCosts::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.backup.CSVExportImport", lpparam.classLoader, "importRefuelings", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("importRefuelings::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("importRefuelings::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.backup.CSVExportImport", lpparam.classLoader, "importReminders", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("importReminders::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("importReminders::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.Calculator", lpparam.classLoader, "avg", "[D", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("avg::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("avg::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.Calculator", lpparam.classLoader, "avg", "[F", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("avg::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("avg::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.Calculator", lpparam.classLoader, "avg", "[I", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("avg::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("avg::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.Calculator", lpparam.classLoader, "avg", "[J", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("avg::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("avg::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.Calculator", lpparam.classLoader, "max", "[D", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("max::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("max::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.Calculator", lpparam.classLoader, "max", "[F", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("max::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("max::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.Calculator", lpparam.classLoader, "max", "[I", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("max::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("max::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.Calculator", lpparam.classLoader, "max", "[J", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("max::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("max::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.Calculator", lpparam.classLoader, "min", "[D", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("min::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("min::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.Calculator", lpparam.classLoader, "min", "[F", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("min::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("min::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.Calculator", lpparam.classLoader, "min", "[I", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("min::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("min::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.Calculator", lpparam.classLoader, "min", "[J", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("min::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("min::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.Calculator", lpparam.classLoader, "sum", "[D", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("sum::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("sum::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.Calculator", lpparam.classLoader, "sum", "[F", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("sum::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("sum::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.Calculator", lpparam.classLoader, "sum", "[I", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("sum::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("sum::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.Calculator", lpparam.classLoader, "sum", "[J", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("sum::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("sum::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.CSVReader", lpparam.classLoader, "fromFile", "java.io.File", "boolean", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("fromFile::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("fromFile::methodEnd::" + endTime);
            }
        });

        findAndHookConstructor("me.kuehle.carreport.util.CSVReader", lpparam.classLoader, "java.lang.String", "boolean", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("CSVReader::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("CSVReader::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.CSVReader", lpparam.classLoader, "getColumnCount", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getColumnCount::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getColumnCount::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.CSVReader", lpparam.classLoader, "getData", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getData::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getData::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.CSVReader", lpparam.classLoader, "getRowCount", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getRowCount::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getRowCount::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.CSVReader", lpparam.classLoader, "getString", "int", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getString::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getString::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.CSVReader", lpparam.classLoader, "getString", "int", "java.lang.String", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getString::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getString::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.CSVReader", lpparam.classLoader, "getDate", "int", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getDate::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getDate::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.CSVReader", lpparam.classLoader, "getDate", "int", "java.lang.String", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getDate::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getDate::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.CSVReader", lpparam.classLoader, "getFloat", "int", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getFloat::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getFloat::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.CSVReader", lpparam.classLoader, "getFloat", "int", "java.lang.String", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getFloat::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getFloat::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.CSVReader", lpparam.classLoader, "getInteger", "int", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getInteger::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getInteger::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.CSVReader", lpparam.classLoader, "getInteger", "int", "java.lang.String", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getInteger::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getInteger::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.CSVReader", lpparam.classLoader, "getLong", "int", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getLong::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getLong::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.CSVReader", lpparam.classLoader, "getLong", "int", "java.lang.String", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getLong::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getLong::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.CSVReader", lpparam.classLoader, "getBoolean", "int", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getBoolean::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getBoolean::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.CSVReader", lpparam.classLoader, "getBoolean", "int", "java.lang.String", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getBoolean::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getBoolean::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.CSVReader", lpparam.classLoader, "getRecurrenceInterval", "int", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getRecurrenceInterval::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getRecurrenceInterval::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.CSVReader", lpparam.classLoader, "getRecurrenceInterval", "int", "java.lang.String", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getRecurrenceInterval::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getRecurrenceInterval::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.CSVReader", lpparam.classLoader, "getTimeSpanUnit", "int", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getTimeSpanUnit::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getTimeSpanUnit::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.CSVReader", lpparam.classLoader, "getTimeSpanUnit", "int", "java.lang.String", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getTimeSpanUnit::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getTimeSpanUnit::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.CSVReader", lpparam.classLoader, "parseDate", "java.lang.String", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("parseDate::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("parseDate::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.CSVReader", lpparam.classLoader, "parseFloat", "java.lang.String", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("parseFloat::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("parseFloat::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.CSVReader", lpparam.classLoader, "parseInteger", "java.lang.String", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("parseInteger::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("parseInteger::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.CSVReader", lpparam.classLoader, "parseLong", "java.lang.String", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("parseLong::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("parseLong::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.CSVReader", lpparam.classLoader, "parseBoolean", "java.lang.String", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("parseBoolean::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("parseBoolean::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.CSVReader", lpparam.classLoader, "parseRecurrenceInterval", "java.lang.String", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("parseRecurrenceInterval::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("parseRecurrenceInterval::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.CSVReader", lpparam.classLoader, "parseTimeSpanUnit", "java.lang.String", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("parseTimeSpanUnit::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("parseTimeSpanUnit::methodEnd::" + endTime);
            }
        });

        findAndHookConstructor("me.kuehle.carreport.util.CSVWriter", lpparam.classLoader, new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("CSVWriter::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("CSVWriter::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.CSVWriter", lpparam.classLoader, "writeColumn", "java.lang.Object", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("writeColumn::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("writeColumn::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.CSVWriter", lpparam.classLoader, "toFile", "java.io.File", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("toFile::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("toFile::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.CSVWriter", lpparam.classLoader, "toString", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("toString::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("toString::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.CSVWriter", lpparam.classLoader, "format", "java.lang.Enum", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("format::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("format::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.CSVWriter", lpparam.classLoader, "format", "java.util.Date", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("format::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("format::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.CSVWriter", lpparam.classLoader, "format", "java.lang.Float", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("format::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("format::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.DemoData", lpparam.classLoader, "createMenuItem", "android.view.Menu", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("createMenuItem::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("createMenuItem::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.DemoData", lpparam.classLoader, "onOptionsItemSelected", "android.view.MenuItem", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onOptionsItemSelected::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onOptionsItemSelected::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.DemoData", lpparam.classLoader, "addDemoData", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("addDemoData::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("addDemoData::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.DemoData", lpparam.classLoader, "createCar", "android.content.Context", "java.lang.String", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("createCar::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("createCar::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.DemoData", lpparam.classLoader, "createFuelType", "android.content.Context", "java.lang.String", "java.lang.String", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("createFuelType::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("createFuelType::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.DemoData", lpparam.classLoader, "createRefueling", "android.content.Context", "org.joda.time.DateTime", "int", "float", "float", "boolean", "java.lang.String", "long", "long", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("createRefueling::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("createRefueling::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.DemoData", lpparam.classLoader, "createOtherCost", "android.content.Context", "java.lang.String", "org.joda.time.DateTime", "org.joda.time.DateTime", "int", "float", "me.kuehle.carreport.provider.othercost.RecurrenceInterval", "int", "java.lang.String", "long", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("createOtherCost::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("createOtherCost::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.DemoData", lpparam.classLoader, "randInt", "int", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("randInt::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("randInt::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.DemoData", lpparam.classLoader, "randFloat", "int", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("randFloat::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("randFloat::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.DemoData", lpparam.classLoader, "getIdFromUri", "android.net.Uri", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getIdFromUri::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getIdFromUri::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.FileCopyUtil", lpparam.classLoader, "copyFile", "java.io.File", "java.io.File", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("copyFile::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("copyFile::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.FileCopyUtil", lpparam.classLoader, "copyFile", "java.io.InputStream", "java.io.OutputStream", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("copyFile::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("copyFile::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.Recurrences", lpparam.classLoader, "getRecurrencesSince", "me.kuehle.carreport.provider.othercost.RecurrenceInterval", "int", "java.util.Date", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getRecurrencesSince::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getRecurrencesSince::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.Recurrences", lpparam.classLoader, "getRecurrencesBetween", "me.kuehle.carreport.provider.othercost.RecurrenceInterval", "int", "java.util.Date", "java.util.Date", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getRecurrencesBetween::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getRecurrencesBetween::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.reminder.ReminderEnablerReceiver", lpparam.classLoader, "onReceive", "android.content.Context", "android.content.Intent", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onReceive::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onReceive::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.reminder.ReminderEnablerReceiver", lpparam.classLoader, "scheduleAlarms", "android.content.Context", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("scheduleAlarms::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("scheduleAlarms::methodEnd::" + endTime);
            }
        });

        findAndHookConstructor("me.kuehle.carreport.util.reminder.ReminderService", lpparam.classLoader, new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("ReminderService::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("ReminderService::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.reminder.ReminderService", lpparam.classLoader, "onHandleIntent", "android.content.Intent", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onHandleIntent::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onHandleIntent::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.reminder.ReminderService", lpparam.classLoader, "getPendingIntent", "android.content.Context", "java.lang.String", "[J", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getPendingIntent::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getPendingIntent::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.reminder.ReminderService", lpparam.classLoader, "updateNotification", "android.content.Context", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("updateNotification::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("updateNotification::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.reminder.ReminderService", lpparam.classLoader, "markRemindersDone", "android.content.Context", "[J", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("markRemindersDone::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("markRemindersDone::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.reminder.ReminderService", lpparam.classLoader, "dismissReminders", "android.content.Context", "[J", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("dismissReminders::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("dismissReminders::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.reminder.ReminderService", lpparam.classLoader, "snoozeReminders", "android.content.Context", "[J", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("snoozeReminders::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("snoozeReminders::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.reminder.ReminderService", lpparam.classLoader, "buildNotification", "android.content.Context", "[J", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("buildNotification::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("buildNotification::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.sync.AbstractSyncProvider", lpparam.classLoader, "getLocalFileRev", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getLocalFileRev::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getLocalFileRev::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.sync.AbstractSyncProvider", lpparam.classLoader, "setLocalFileRev", "java.lang.String", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("setLocalFileRev::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("setLocalFileRev::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.sync.AbstractSyncProvider", lpparam.classLoader, "getLocalFile", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getLocalFile::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getLocalFile::methodEnd::" + endTime);
            }
        });

        findAndHookConstructor("me.kuehle.carreport.util.sync.AccountUnlinkedException", lpparam.classLoader, new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("AccountUnlinkedException::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("AccountUnlinkedException::methodEnd::" + endTime);
            }
        });

        findAndHookConstructor("me.kuehle.carreport.util.sync.AccountUnlinkedException", lpparam.classLoader, "java.lang.Throwable", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("AccountUnlinkedException::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("AccountUnlinkedException::methodEnd::" + endTime);
            }
        });

        findAndHookConstructor("me.kuehle.carreport.util.sync.Authenticator", lpparam.classLoader, "android.content.Context", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("Authenticator::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("Authenticator::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.sync.Authenticator", lpparam.classLoader, "editProperties", "android.accounts.AccountAuthenticatorResponse", "java.lang.String", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("editProperties::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("editProperties::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.sync.Authenticator", lpparam.classLoader, "confirmCredentials", "android.accounts.AccountAuthenticatorResponse", "android.accounts.Account", "android.os.Bundle", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("confirmCredentials::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("confirmCredentials::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.sync.Authenticator", lpparam.classLoader, "getAuthToken", "android.accounts.AccountAuthenticatorResponse", "android.accounts.Account", "java.lang.String", "android.os.Bundle", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getAuthToken::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getAuthToken::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.sync.Authenticator", lpparam.classLoader, "getAuthTokenLabel", "java.lang.String", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getAuthTokenLabel::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getAuthTokenLabel::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.sync.Authenticator", lpparam.classLoader, "updateCredentials", "android.accounts.AccountAuthenticatorResponse", "android.accounts.Account", "java.lang.String", "android.os.Bundle", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("updateCredentials::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("updateCredentials::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.sync.Authenticator", lpparam.classLoader, "createAuthenticatorAddAccountActivityIntentBundle", "android.accounts.AccountAuthenticatorResponse", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("createAuthenticatorAddAccountActivityIntentBundle::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("createAuthenticatorAddAccountActivityIntentBundle::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.sync.AuthenticatorService", lpparam.classLoader, "onCreate", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onCreate::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onCreate::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.sync.AuthenticatorService", lpparam.classLoader, "onBind", "android.content.Intent", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onBind::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onBind::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.sync.provider.DropboxSyncProvider", lpparam.classLoader, "getId", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getId::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getId::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.sync.provider.DropboxSyncProvider", lpparam.classLoader, "getIcon", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getIcon::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getIcon::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.sync.provider.DropboxSyncProvider", lpparam.classLoader, "getName", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getName::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getName::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.sync.provider.DropboxSyncProvider", lpparam.classLoader, "setup", "android.accounts.Account", "java.lang.String", "java.lang.String", "org.json.JSONObject", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("setup::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("setup::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.sync.provider.DropboxSyncProvider", lpparam.classLoader, "startAuthentication", "me.kuehle.carreport.gui.AuthenticatorAddAccountActivity", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("startAuthentication::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("startAuthentication::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.sync.provider.DropboxSyncProvider", lpparam.classLoader, "continueAuthentication", "me.kuehle.carreport.gui.AuthenticatorAddAccountActivity", "int", "int", "android.content.Intent", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("continueAuthentication::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("continueAuthentication::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.sync.provider.DropboxSyncProvider", lpparam.classLoader, "getRemoteFileRev", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getRemoteFileRev::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getRemoteFileRev::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.sync.provider.DropboxSyncProvider", lpparam.classLoader, "uploadFile", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("uploadFile::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("uploadFile::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.sync.provider.DropboxSyncProvider", lpparam.classLoader, "downloadFile", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("downloadFile::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("downloadFile::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.sync.provider.WebDavSyncProvider", lpparam.classLoader, "getId", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getId::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getId::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.sync.provider.WebDavSyncProvider", lpparam.classLoader, "getIcon", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getIcon::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getIcon::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.sync.provider.WebDavSyncProvider", lpparam.classLoader, "getName", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getName::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getName::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.sync.provider.WebDavSyncProvider", lpparam.classLoader, "setup", "android.accounts.Account", "java.lang.String", "java.lang.String", "org.json.JSONObject", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("setup::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("setup::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.sync.provider.WebDavSyncProvider", lpparam.classLoader, "startAuthentication", "me.kuehle.carreport.gui.AuthenticatorAddAccountActivity", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("startAuthentication::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("startAuthentication::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.sync.provider.WebDavSyncProvider", lpparam.classLoader, "continueAuthentication", "me.kuehle.carreport.gui.AuthenticatorAddAccountActivity", "int", "int", "android.content.Intent", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("continueAuthentication::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("continueAuthentication::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.sync.provider.WebDavSyncProvider", lpparam.classLoader, "getRemoteFileRev", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getRemoteFileRev::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getRemoteFileRev::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.sync.provider.WebDavSyncProvider", lpparam.classLoader, "uploadFile", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("uploadFile::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("uploadFile::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.sync.provider.WebDavSyncProvider", lpparam.classLoader, "downloadFile", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("downloadFile::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("downloadFile::methodEnd::" + endTime);
            }
        });

        findAndHookConstructor("me.kuehle.carreport.util.sync.SyncAdapter", lpparam.classLoader, "android.content.Context", "boolean", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("SyncAdapter::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("SyncAdapter::methodEnd::" + endTime);
            }
        });

        findAndHookConstructor("me.kuehle.carreport.util.sync.SyncAdapter", lpparam.classLoader, "android.content.Context", "boolean", "boolean", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("SyncAdapter::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("SyncAdapter::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.sync.SyncAdapter", lpparam.classLoader, "onPerformSync", "android.accounts.Account", "android.os.Bundle", "java.lang.String", "android.content.ContentProviderClient", "android.content.SyncResult", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onPerformSync::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onPerformSync::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.sync.SyncProviders", lpparam.classLoader, "getSyncProviders", "android.content.Context", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getSyncProviders::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getSyncProviders::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.sync.SyncProviders", lpparam.classLoader, "getSyncProviderById", "android.content.Context", "long", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getSyncProviderById::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getSyncProviderById::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.sync.SyncProviders", lpparam.classLoader, "getSyncProviderByAccount", "android.content.Context", "android.accounts.Account", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getSyncProviderByAccount::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getSyncProviderByAccount::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.sync.SyncProviders", lpparam.classLoader, "getSyncProviderSettings", "android.accounts.Account", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getSyncProviderSettings::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getSyncProviderSettings::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.sync.SyncProviders", lpparam.classLoader, "setSyncProviderSettings", "android.accounts.Account", "org.json.JSONObject", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("setSyncProviderSettings::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("setSyncProviderSettings::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.sync.SyncProviders", lpparam.classLoader, "getRegisteredSyncProviderClassNames", "android.content.Context", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getRegisteredSyncProviderClassNames::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getRegisteredSyncProviderClassNames::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.sync.SyncProviders", lpparam.classLoader, "newAbstractSyncProviderInstance", "java.lang.String", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("newAbstractSyncProviderInstance::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("newAbstractSyncProviderInstance::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.sync.SyncService", lpparam.classLoader, "onCreate", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onCreate::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onCreate::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.sync.SyncService", lpparam.classLoader, "onBind", "android.content.Intent", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onBind::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onBind::methodEnd::" + endTime);
            }
        });

        findAndHookConstructor("me.kuehle.carreport.util.TimeSpan", lpparam.classLoader, "me.kuehle.carreport.provider.reminder.TimeSpanUnit", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("TimeSpan::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("TimeSpan::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.TimeSpan", lpparam.classLoader, "getUnit", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getUnit::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getUnit::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.TimeSpan", lpparam.classLoader, "getCount", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getCount::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getCount::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.TimeSpan", lpparam.classLoader, "addTo", "java.util.Date", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("addTo::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("addTo::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.TimeSpan", lpparam.classLoader, "subtractFrom", "java.util.Date", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("subtractFrom::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("subtractFrom::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.TimeSpan", lpparam.classLoader, "toString", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("toString::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("toString::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.TimeSpan", lpparam.classLoader, "toLocalizedString", "android.content.Context", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("toLocalizedString::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("toLocalizedString::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.TimeSpan", lpparam.classLoader, "fromMillis", "long", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("fromMillis::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("fromMillis::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.TimeSpan", lpparam.classLoader, "fromString", "java.lang.String", "me.kuehle.carreport.util.TimeSpan", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("fromString::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("fromString::methodEnd::" + endTime);
            }
        });

        findAndHookConstructor("me.kuehle.carreport.util.WebDavClient", lpparam.classLoader, "java.lang.String", "java.lang.String", "java.lang.String", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("WebDavClient::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("WebDavClient::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.WebDavClient", lpparam.classLoader, "download", "java.lang.String", "java.io.File", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("download::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("download::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.WebDavClient", lpparam.classLoader, "upload", "java.io.File", "java.lang.String", "java.lang.String", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("upload::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("upload::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.WebDavClient", lpparam.classLoader, "getLastModified", "java.lang.String", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getLastModified::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getLastModified::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.carreport.util.WebDavClient", lpparam.classLoader, "testLogin", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("testLogin::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("testLogin::methodEnd::" + endTime);
            }
        });

    }


    public void func1(final LoadPackageParam lpparam) throws Throwable {

        findAndHookConstructor("me.kuehle.chartlib.axis.AbstractAxis", lpparam.classLoader, "double", "double", "me.kuehle.chartlib.util.Size", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("AbstractAxis::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("AbstractAxis::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.axis.AbstractAxis", lpparam.classLoader, "changeSize", "int", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("changeSize::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("changeSize::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.axis.AbstractAxis", lpparam.classLoader, "generateLabels", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("generateLabels::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("generateLabels::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.axis.AbstractAxis", lpparam.classLoader, "getBottomBound", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getBottomBound::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getBottomBound::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.axis.AbstractAxis", lpparam.classLoader, "getFontColor", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getFontColor::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getFontColor::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.axis.AbstractAxis", lpparam.classLoader, "getFontSize", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getFontSize::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getFontSize::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.axis.AbstractAxis", lpparam.classLoader, "getGridColor", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getGridColor::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getGridColor::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.axis.AbstractAxis", lpparam.classLoader, "getPreferredLabelPadding", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getPreferredLabelPadding::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getPreferredLabelPadding::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.axis.AbstractAxis", lpparam.classLoader, "getTopBound", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getTopBound::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getTopBound::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.axis.AbstractAxis", lpparam.classLoader, "isMovable", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("isMovable::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("isMovable::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.axis.AbstractAxis", lpparam.classLoader, "isShowGrid", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("isShowGrid::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("isShowGrid::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.axis.AbstractAxis", lpparam.classLoader, "isZoomable", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("isZoomable::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("isZoomable::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.axis.AbstractAxis", lpparam.classLoader, "move", "float", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("move::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("move::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.axis.AbstractAxis", lpparam.classLoader, "restoreDefaultBounds", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("restoreDefaultBounds::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("restoreDefaultBounds::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.axis.AbstractAxis", lpparam.classLoader, "setDefaultBottomBound", "double", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("setDefaultBottomBound::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("setDefaultBottomBound::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.axis.AbstractAxis", lpparam.classLoader, "setDefaultTopBound", "double", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("setDefaultTopBound::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("setDefaultTopBound::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.axis.AbstractAxis", lpparam.classLoader, "setFontColor", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("setFontColor::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("setFontColor::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.axis.AbstractAxis", lpparam.classLoader, "setFontSize", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("setFontSize::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("setFontSize::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.axis.AbstractAxis", lpparam.classLoader, "setFontSize", "int", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("setFontSize::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("setFontSize::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.axis.AbstractAxis", lpparam.classLoader, "setGridColor", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("setGridColor::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("setGridColor::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.axis.AbstractAxis", lpparam.classLoader, "setLabelFormatter", "me.kuehle.chartlib.axis.AxisLabelFormatter", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("setLabelFormatter::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("setLabelFormatter::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.axis.AbstractAxis", lpparam.classLoader, "setLabels", "[D", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("setLabels::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("setLabels::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.axis.AbstractAxis", lpparam.classLoader, "setMovable", "boolean", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("setMovable::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("setMovable::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.axis.AbstractAxis", lpparam.classLoader, "setShowGrid", "boolean", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("setShowGrid::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("setShowGrid::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.axis.AbstractAxis", lpparam.classLoader, "setZoomable", "boolean", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("setZoomable::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("setZoomable::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.axis.AbstractAxis", lpparam.classLoader, "zoom", "android.graphics.PointF", "float", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("zoom::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("zoom::methodEnd::" + endTime);
            }
        });

        findAndHookConstructor("me.kuehle.chartlib.axis.DecimalAxisLabelFormatter", lpparam.classLoader, "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("DecimalAxisLabelFormatter::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("DecimalAxisLabelFormatter::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.axis.DecimalAxisLabelFormatter", lpparam.classLoader, "formatLabel", "double", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("formatLabel::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("formatLabel::methodEnd::" + endTime);
            }
        });

        findAndHookConstructor("me.kuehle.chartlib.axis.DomainAxis", lpparam.classLoader, "double", "double", "me.kuehle.chartlib.util.Size", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("DomainAxis::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("DomainAxis::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.axis.DomainAxis", lpparam.classLoader, "draw", "android.graphics.Canvas", "android.graphics.RectF", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("draw::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("draw::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.axis.DomainAxis", lpparam.classLoader, "getMaxLabelSize", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getMaxLabelSize::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getMaxLabelSize::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.axis.DomainAxis", lpparam.classLoader, "isDomain", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("isDomain::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("isDomain::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.axis.DomainAxis", lpparam.classLoader, "measureSize", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("measureSize::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("measureSize::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.axis.IntegerAxisLabelFormatter", lpparam.classLoader, "formatLabel", "double", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("formatLabel::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("formatLabel::methodEnd::" + endTime);
            }
        });

        findAndHookConstructor("me.kuehle.chartlib.axis.RangeAxis", lpparam.classLoader, "double", "double", "me.kuehle.chartlib.util.Size", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("RangeAxis::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("RangeAxis::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.axis.RangeAxis", lpparam.classLoader, "draw", "android.graphics.Canvas", "android.graphics.RectF", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("draw::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("draw::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.axis.RangeAxis", lpparam.classLoader, "getMaxLabelSize", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getMaxLabelSize::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getMaxLabelSize::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.axis.RangeAxis", lpparam.classLoader, "isDomain", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("isDomain::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("isDomain::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.axis.RangeAxis", lpparam.classLoader, "measureSize", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("measureSize::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("measureSize::methodEnd::" + endTime);
            }
        });

        findAndHookConstructor("me.kuehle.chartlib.chart.Chart", lpparam.classLoader, "android.content.Context", "me.kuehle.chartlib.data.Dataset", "me.kuehle.chartlib.renderer.RendererList", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("Chart::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("Chart::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.chart.Chart", lpparam.classLoader, "changeSize", "int", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("changeSize::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("changeSize::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.chart.Chart", lpparam.classLoader, "click", "android.graphics.PointF", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("click::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("click::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.chart.Chart", lpparam.classLoader, "doubleClick", "android.graphics.PointF", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("doubleClick::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("doubleClick::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.chart.Chart", lpparam.classLoader, "draw", "android.graphics.Canvas", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("draw::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("draw::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.chart.Chart", lpparam.classLoader, "getDataset", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getDataset::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getDataset::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.chart.Chart", lpparam.classLoader, "getDomainAxis", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getDomainAxis::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getDomainAxis::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.chart.Chart", lpparam.classLoader, "getLegend", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getLegend::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getLegend::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.chart.Chart", lpparam.classLoader, "getRangeAxis", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getRangeAxis::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getRangeAxis::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.chart.Chart", lpparam.classLoader, "getRenderers", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getRenderers::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getRenderers::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.chart.Chart", lpparam.classLoader, "hasEnoughData", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("hasEnoughData::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("hasEnoughData::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.chart.Chart", lpparam.classLoader, "isShowLegend", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("isShowLegend::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("isShowLegend::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.chart.Chart", lpparam.classLoader, "move", "float", "float", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("move::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("move::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.chart.Chart", lpparam.classLoader, "onGraphDataChanged", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onGraphDataChanged::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onGraphDataChanged::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.chart.Chart", lpparam.classLoader, "setShowLegend", "boolean", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("setShowLegend::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("setShowLegend::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.chart.Chart", lpparam.classLoader, "zoom", "android.graphics.PointF", "float", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("zoom::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("zoom::methodEnd::" + endTime);
            }
        });

        findAndHookConstructor("me.kuehle.chartlib.chart.Legend", lpparam.classLoader, "me.kuehle.chartlib.data.Dataset", "me.kuehle.chartlib.renderer.RendererList", "me.kuehle.chartlib.util.Size", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("Legend::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("Legend::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.chart.Legend", lpparam.classLoader, "draw", "android.graphics.Canvas", "android.graphics.RectF", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("draw::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("draw::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.chart.Legend", lpparam.classLoader, "getFontSize", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getFontSize::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getFontSize::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.chart.Legend", lpparam.classLoader, "isSeriesVisible", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("isSeriesVisible::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("isSeriesVisible::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.chart.Legend", lpparam.classLoader, "setFontSize", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("setFontSize::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("setFontSize::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.chart.Legend", lpparam.classLoader, "setFontSize", "int", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("setFontSize::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("setFontSize::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.chart.Legend", lpparam.classLoader, "setSeriesVisible", "int", "boolean", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("setSeriesVisible::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("setSeriesVisible::methodEnd::" + endTime);
            }
        });

        findAndHookConstructor("me.kuehle.chartlib.chart.RectD", lpparam.classLoader, "double", "double", "double", "double", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("RectD::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("RectD::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.chart.RectD", lpparam.classLoader, "getTop", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getTop::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getTop::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.chart.RectD", lpparam.classLoader, "setTop", "double", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("setTop::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("setTop::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.chart.RectD", lpparam.classLoader, "getRight", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getRight::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getRight::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.chart.RectD", lpparam.classLoader, "setRight", "double", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("setRight::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("setRight::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.chart.RectD", lpparam.classLoader, "getBottom", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getBottom::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getBottom::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.chart.RectD", lpparam.classLoader, "setBottom", "double", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("setBottom::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("setBottom::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.chart.RectD", lpparam.classLoader, "getLeft", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getLeft::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getLeft::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.chart.RectD", lpparam.classLoader, "setLeft", "double", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("setLeft::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("setLeft::methodEnd::" + endTime);
            }
        });

        findAndHookConstructor("me.kuehle.chartlib.ChartView", lpparam.classLoader, "android.content.Context", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("ChartView::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("ChartView::methodEnd::" + endTime);
            }
        });

        findAndHookConstructor("me.kuehle.chartlib.ChartView", lpparam.classLoader, "android.content.Context", "android.util.AttributeSet", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("ChartView::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("ChartView::methodEnd::" + endTime);
            }
        });

        findAndHookConstructor("me.kuehle.chartlib.ChartView", lpparam.classLoader, "android.content.Context", "android.util.AttributeSet", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("ChartView::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("ChartView::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.ChartView", lpparam.classLoader, "getChart", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getChart::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getChart::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.ChartView", lpparam.classLoader, "getNotEnoughDataView", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getNotEnoughDataView::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getNotEnoughDataView::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.ChartView", lpparam.classLoader, "moveAdjustment", "android.view.MotionEvent", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("moveAdjustment::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("moveAdjustment::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.ChartView", lpparam.classLoader, "onDraw", "android.graphics.Canvas", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onDraw::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onDraw::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.ChartView", lpparam.classLoader, "onSizeChanged", "int", "int", "int", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onSizeChanged::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onSizeChanged::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.ChartView", lpparam.classLoader, "onTouchEvent", "android.view.MotionEvent", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("onTouchEvent::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("onTouchEvent::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.ChartView", lpparam.classLoader, "setChart", "me.kuehle.chartlib.chart.Chart", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("setChart::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("setChart::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.ChartView", lpparam.classLoader, "setNotEnoughDataView", "android.view.View", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("setNotEnoughDataView::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("setNotEnoughDataView::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.ChartView", lpparam.classLoader, "zoomAdjustment", "android.view.MotionEvent", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("zoomAdjustment::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("zoomAdjustment::methodEnd::" + endTime);
            }
        });

        findAndHookConstructor("me.kuehle.chartlib.data.Dataset", lpparam.classLoader, new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("Dataset::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("Dataset::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.data.Dataset", lpparam.classLoader, "add", "me.kuehle.chartlib.data.Series", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("add::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("add::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.data.Dataset", lpparam.classLoader, "get", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("get::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("get::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.data.Dataset", lpparam.classLoader, "getAll", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getAll::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getAll::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.data.Dataset", lpparam.classLoader, "graphDataChanged", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("graphDataChanged::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("graphDataChanged::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.data.Dataset", lpparam.classLoader, "maxX", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("maxX::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("maxX::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.data.Dataset", lpparam.classLoader, "maxY", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("maxY::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("maxY::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.data.Dataset", lpparam.classLoader, "minX", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("minX::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("minX::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.data.Dataset", lpparam.classLoader, "minY", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("minY::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("minY::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.data.Dataset", lpparam.classLoader, "setDataChangedListener", "me.kuehle.chartlib.data.Dataset$DataChangedListener", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("setDataChangedListener::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("setDataChangedListener::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.data.Dataset", lpparam.classLoader, "size", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("size::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("size::methodEnd::" + endTime);
            }
        });

        findAndHookConstructor("me.kuehle.chartlib.data.PointD", lpparam.classLoader, "double", "double", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("PointD::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("PointD::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.data.PointD", lpparam.classLoader, "compareTo", "me.kuehle.chartlib.data.PointD", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("compareTo::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("compareTo::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.data.PointD", lpparam.classLoader, "equals", "java.lang.Object", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("equals::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("equals::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.data.PointD", lpparam.classLoader, "hashCode", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("hashCode::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("hashCode::methodEnd::" + endTime);
            }
        });

        findAndHookConstructor("me.kuehle.chartlib.data.Series", lpparam.classLoader, new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("Series::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("Series::methodEnd::" + endTime);
            }
        });

        findAndHookConstructor("me.kuehle.chartlib.data.Series", lpparam.classLoader, "java.lang.String", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("Series::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("Series::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.data.Series", lpparam.classLoader, "add", "double", "double", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("add::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("add::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.data.Series", lpparam.classLoader, "get", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("get::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("get::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.data.Series", lpparam.classLoader, "getTitle", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getTitle::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getTitle::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.data.Series", lpparam.classLoader, "maxX", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("maxX::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("maxX::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.data.Series", lpparam.classLoader, "maxY", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("maxY::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("maxY::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.data.Series", lpparam.classLoader, "minX", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("minX::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("minX::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.data.Series", lpparam.classLoader, "minY", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("minY::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("minY::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.data.Series", lpparam.classLoader, "removeAt", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("removeAt::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("removeAt::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.data.Series", lpparam.classLoader, "setParent", "me.kuehle.chartlib.data.Dataset", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("setParent::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("setParent::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.data.Series", lpparam.classLoader, "setTitle", "java.lang.String", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("setTitle::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("setTitle::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.data.Series", lpparam.classLoader, "size", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("size::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("size::methodEnd::" + endTime);
            }
        });

        findAndHookConstructor("me.kuehle.chartlib.renderer.AbstractRenderer", lpparam.classLoader, "android.content.Context", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("AbstractRenderer::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("AbstractRenderer::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.renderer.AbstractRenderer", lpparam.classLoader, "getSeriesColor", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getSeriesColor::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getSeriesColor::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.renderer.AbstractRenderer", lpparam.classLoader, "getSeriesPaint", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getSeriesPaint::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getSeriesPaint::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.renderer.AbstractRenderer", lpparam.classLoader, "setSeriesColor", "int", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("setSeriesColor::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("setSeriesColor::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.renderer.AbstractRenderer", lpparam.classLoader, "translate", "me.kuehle.chartlib.data.PointD", "android.graphics.RectF", "me.kuehle.chartlib.chart.RectD", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("translate::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("translate::methodEnd::" + endTime);
            }
        });

        findAndHookConstructor("me.kuehle.chartlib.renderer.BarRenderer$PointDataHolder", lpparam.classLoader, "me.kuehle.chartlib.renderer.BarRenderer", "float", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("PointDataHolder::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("PointDataHolder::methodEnd::" + endTime);
            }
        });

        findAndHookConstructor("me.kuehle.chartlib.renderer.BarRenderer", lpparam.classLoader, "android.content.Context", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("BarRenderer::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("BarRenderer::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.renderer.BarRenderer", lpparam.classLoader, "draw", "android.graphics.Canvas", "android.graphics.RectF", "me.kuehle.chartlib.chart.RectD", "android.util.SparseArray", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("draw::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("draw::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.renderer.BarRenderer", lpparam.classLoader, "isEnoughData", "android.util.SparseArray", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("isEnoughData::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("isEnoughData::methodEnd::" + endTime);
            }
        });

        findAndHookConstructor("me.kuehle.chartlib.renderer.LineRenderer", lpparam.classLoader, "android.content.Context", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("LineRenderer::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("LineRenderer::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.renderer.LineRenderer", lpparam.classLoader, "click", "android.graphics.PointF", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("click::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("click::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.renderer.LineRenderer", lpparam.classLoader, "draw", "android.graphics.Canvas", "android.graphics.RectF", "me.kuehle.chartlib.chart.RectD", "android.util.SparseArray", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("draw::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("draw::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.renderer.LineRenderer", lpparam.classLoader, "getPointRadius", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getPointRadius::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getPointRadius::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.renderer.LineRenderer", lpparam.classLoader, "getSeriesFillBelowLineColor", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getSeriesFillBelowLineColor::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getSeriesFillBelowLineColor::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.renderer.LineRenderer", lpparam.classLoader, "getSeriesMarkColor", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getSeriesMarkColor::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getSeriesMarkColor::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.renderer.LineRenderer", lpparam.classLoader, "getSeriesMarkPathEffect", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getSeriesMarkPathEffect::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getSeriesMarkPathEffect::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.renderer.LineRenderer", lpparam.classLoader, "getSeriesLineWidth", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getSeriesLineWidth::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getSeriesLineWidth::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.renderer.LineRenderer", lpparam.classLoader, "getSeriesPaint", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getSeriesPaint::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getSeriesPaint::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.renderer.LineRenderer", lpparam.classLoader, "getSeriesPathEffect", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getSeriesPathEffect::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getSeriesPathEffect::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.renderer.LineRenderer", lpparam.classLoader, "isEnoughData", "android.util.SparseArray", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("isEnoughData::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("isEnoughData::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.renderer.LineRenderer", lpparam.classLoader, "isSeriesDrawPoints", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("isSeriesDrawPoints::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("isSeriesDrawPoints::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.renderer.LineRenderer", lpparam.classLoader, "isSeriesFillBelowLine", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("isSeriesFillBelowLine::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("isSeriesFillBelowLine::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.renderer.LineRenderer", lpparam.classLoader, "isSeriesMarkPoint", "int", "me.kuehle.chartlib.data.PointD", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("isSeriesMarkPoint::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("isSeriesMarkPoint::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.renderer.LineRenderer", lpparam.classLoader, "isSeriesMarkLine", "int", "me.kuehle.chartlib.data.PointD", "me.kuehle.chartlib.data.PointD", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("isSeriesMarkLine::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("isSeriesMarkLine::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.renderer.LineRenderer", lpparam.classLoader, "setOnClickListener", "me.kuehle.chartlib.renderer.OnClickListener", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("setOnClickListener::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("setOnClickListener::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.renderer.LineRenderer", lpparam.classLoader, "setSeriesDrawPoints", "int", "boolean", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("setSeriesDrawPoints::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("setSeriesDrawPoints::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.renderer.LineRenderer", lpparam.classLoader, "setSeriesFillBelowLine", "int", "boolean", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("setSeriesFillBelowLine::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("setSeriesFillBelowLine::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.renderer.LineRenderer", lpparam.classLoader, "setSeriesMarkColor", "int", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("setSeriesMarkColor::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("setSeriesMarkColor::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.renderer.LineRenderer", lpparam.classLoader, "addSeriesMarkPoint", "int", "me.kuehle.chartlib.data.PointD", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("addSeriesMarkPoint::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("addSeriesMarkPoint::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.renderer.LineRenderer", lpparam.classLoader, "addSeriesMarkLine", "int", "me.kuehle.chartlib.data.PointD", "me.kuehle.chartlib.data.PointD", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("addSeriesMarkLine::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("addSeriesMarkLine::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.renderer.LineRenderer", lpparam.classLoader, "setSeriesMarkPathEffect", "int", "android.graphics.PathEffect", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("setSeriesMarkPathEffect::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("setSeriesMarkPathEffect::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.renderer.LineRenderer", lpparam.classLoader, "setSeriesLineWidth", "int", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("setSeriesLineWidth::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("setSeriesLineWidth::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.renderer.LineRenderer", lpparam.classLoader, "setSeriesLineWidth", "int", "int", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("setSeriesLineWidth::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("setSeriesLineWidth::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.renderer.LineRenderer", lpparam.classLoader, "setSeriesPathEffect", "int", "android.graphics.PathEffect", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("setSeriesPathEffect::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("setSeriesPathEffect::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.renderer.LineRenderer", lpparam.classLoader, "drawLine", "int", "me.kuehle.chartlib.data.PointD", "me.kuehle.chartlib.data.PointD", "float", "float", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("drawLine::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("drawLine::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.renderer.LineRenderer", lpparam.classLoader, "drawPoint", "int", "me.kuehle.chartlib.data.PointD", "float", "float", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("drawPoint::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("drawPoint::methodEnd::" + endTime);
            }
        });

        findAndHookConstructor("me.kuehle.chartlib.renderer.RendererList", lpparam.classLoader, new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("RendererList::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("RendererList::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.renderer.RendererList", lpparam.classLoader, "addRenderer", "me.kuehle.chartlib.renderer.AbstractRenderer", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("addRenderer::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("addRenderer::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.renderer.RendererList", lpparam.classLoader, "click", "android.graphics.PointF", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("click::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("click::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.renderer.RendererList", lpparam.classLoader, "getRendererForSeries", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getRendererForSeries::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getRendererForSeries::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.renderer.RendererList", lpparam.classLoader, "mapSeriesToRenderer", "int", "me.kuehle.chartlib.renderer.AbstractRenderer", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("mapSeriesToRenderer::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("mapSeriesToRenderer::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.renderer.RendererList", lpparam.classLoader, "removeRenderer", "me.kuehle.chartlib.renderer.AbstractRenderer", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("removeRenderer::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("removeRenderer::methodEnd::" + endTime);
            }
        });

        findAndHookConstructor("me.kuehle.chartlib.util.Size", lpparam.classLoader, "android.content.Context", "int", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("Size::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("Size::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.util.Size", lpparam.classLoader, "getSize", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getSize::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getSize::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.util.Size", lpparam.classLoader, "setSize", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("setSize::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("setSize::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.util.Size", lpparam.classLoader, "getType", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getType::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getType::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.util.Size", lpparam.classLoader, "setType", "int", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("setType::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("setType::methodEnd::" + endTime);
            }
        });

        findAndHookMethod("me.kuehle.chartlib.util.Size", lpparam.classLoader, "getSizeInPixel", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                startTime = System.nanoTime();
                XposedBridge.log("getSizeInPixel::methodStart::" + startTime);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                endTime = System.nanoTime();
                XposedBridge.log("getSizeInPixel::methodEnd::" + endTime);
            }
        });

    }

}

