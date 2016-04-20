package com.test;

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

		if (!(lpparam.packageName.equals("com.angrydoughnuts.android.alarmclock"))) {
			return;
		}

		final XSharedPreferences pref = new XSharedPreferences("com.example.kim.softwareperformance", "user_settings");
		pref.makeWorldReadable();
		pref.reload();

		if (lpparam.packageName.equals("com.angrydoughnuts.android.alarmclock")) {
			func0(lpparam);
		}

	}


	public void func0(final LoadPackageParam lpparam) throws Throwable {

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.ActivityAlarmClock", lpparam.classLoader, "onCreate", "android.os.Bundle", new XC_MethodHook() {

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

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.ActivityAlarmClock", lpparam.classLoader, "onResume", new XC_MethodHook() {

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

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.ActivityAlarmClock", lpparam.classLoader, "onPause", new XC_MethodHook() {

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

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.ActivityAlarmClock", lpparam.classLoader, "onDestroy", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("onDestroy::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("onDestroy::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.ActivityAlarmClock", lpparam.classLoader, "onCreateOptionsMenu", "android.view.Menu", new XC_MethodHook() {

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

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.ActivityAlarmClock", lpparam.classLoader, "onOptionsItemSelected", "android.view.MenuItem", new XC_MethodHook() {

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

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.ActivityAlarmClock", lpparam.classLoader, "redraw", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("redraw::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("redraw::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.ActivityAlarmClock", lpparam.classLoader, "onCreateDialog", "int", new XC_MethodHook() {

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

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.ActivityAlarmNotification", lpparam.classLoader, "onCreate", "android.os.Bundle", new XC_MethodHook() {

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

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.ActivityAlarmNotification", lpparam.classLoader, "onResume", new XC_MethodHook() {

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

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.ActivityAlarmNotification", lpparam.classLoader, "onPause", new XC_MethodHook() {

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

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.ActivityAlarmNotification", lpparam.classLoader, "onDestroy", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("onDestroy::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("onDestroy::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.ActivityAlarmNotification", lpparam.classLoader, "onNewIntent", "android.content.Intent", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("onNewIntent::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("onNewIntent::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.ActivityAlarmNotification", lpparam.classLoader, "onCreateDialog", "int", new XC_MethodHook() {

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

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.ActivityAlarmNotification", lpparam.classLoader, "redraw", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("redraw::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("redraw::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.ActivityAlarmSettings", lpparam.classLoader, "onCreate", "android.os.Bundle", new XC_MethodHook() {

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

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.ActivityAlarmSettings", lpparam.classLoader, "onResume", new XC_MethodHook() {

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

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.ActivityAlarmSettings", lpparam.classLoader, "onPause", new XC_MethodHook() {

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

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.ActivityAlarmSettings", lpparam.classLoader, "onDestroy", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("onDestroy::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("onDestroy::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.ActivityAlarmSettings", lpparam.classLoader, "onCreateDialog", "int", new XC_MethodHook() {

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

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.ActivityAlarmSettings$SettingsListClickListener", lpparam.classLoader, "onItemClick", "android.widget.AdapterView", "android.view.View", "int", "long", new XC_MethodHook() {

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

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.ActivityAlarmSettings", lpparam.classLoader, "tryParseInt", "java.lang.String", "int", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("tryParseInt::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("tryParseInt::methodEnd::" + endTime);
				}
			});

			findAndHookConstructor("com.angrydoughnuts.android.alarmclock.ActivityAlarmSettings$SettingsAdapter", lpparam.classLoader, "com.angrydoughnuts.android.alarmclock.ActivityAlarmSettings", "android.content.Context", "java.util.List", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("SettingsAdapter::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("SettingsAdapter::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.ActivityAlarmSettings$SettingsAdapter", lpparam.classLoader, "getView", "int", "android.view.View", "android.view.ViewGroup", new XC_MethodHook() {

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

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.ActivityAppSettings", lpparam.classLoader, "onCreate", "android.os.Bundle", new XC_MethodHook() {

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

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.ActivityAppSettings", lpparam.classLoader, "onCreateDialog", "int", new XC_MethodHook() {

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

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.ActivityPendingAlarms", lpparam.classLoader, "onCreate", "android.os.Bundle", new XC_MethodHook() {

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

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.ActivityPendingAlarms", lpparam.classLoader, "onResume", new XC_MethodHook() {

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

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.ActivityPendingAlarms", lpparam.classLoader, "onPause", new XC_MethodHook() {

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

		try {
			findAndHookMethod("com.angrydoughnuts.android.alarmclock.ActivityPendingAlarms$1", lpparam.classLoader, "onServiceConnected", "android.content.ComponentName", "android.os.IBinder", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("onServiceConnected::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("onServiceConnected::methodEnd::" + endTime);
				}
			});

		}
		catch (Throwable t) {
			System.err.println(t.getMessage());
		}

		try {
			findAndHookMethod("com.angrydoughnuts.android.alarmclock.ActivityPendingAlarms$1", lpparam.classLoader, "onServiceDisconnected", "android.content.ComponentName", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("onServiceDisconnected::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("onServiceDisconnected::methodEnd::" + endTime);
				}
			});

		}
		catch (Throwable t) {
			System.err.println(t.getMessage());
		}

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.AlarmClockInterfaceStub", lpparam.classLoader, "pendingAlarm", "long", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("pendingAlarm::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("pendingAlarm::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.AlarmClockInterfaceStub", lpparam.classLoader, "pendingAlarmTimes", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("pendingAlarmTimes::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("pendingAlarmTimes::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.AlarmClockInterfaceStub", lpparam.classLoader, "createAlarm", "com.angrydoughnuts.android.alarmclock.AlarmTime", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("createAlarm::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("createAlarm::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.AlarmClockInterfaceStub", lpparam.classLoader, "deleteAlarm", "long", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("deleteAlarm::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("deleteAlarm::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.AlarmClockInterfaceStub", lpparam.classLoader, "deleteAllAlarms", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("deleteAllAlarms::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("deleteAllAlarms::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.AlarmClockInterfaceStub", lpparam.classLoader, "scheduleAlarm", "long", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("scheduleAlarm::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("scheduleAlarm::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.AlarmClockInterfaceStub", lpparam.classLoader, "unscheduleAlarm", "long", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("unscheduleAlarm::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("unscheduleAlarm::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.AlarmClockInterfaceStub", lpparam.classLoader, "acknowledgeAlarm", "long", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("acknowledgeAlarm::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("acknowledgeAlarm::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.AlarmClockInterfaceStub", lpparam.classLoader, "snoozeAlarm", "long", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("snoozeAlarm::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("snoozeAlarm::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.AlarmClockInterfaceStub", lpparam.classLoader, "snoozeAlarmFor", "long", "int", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("snoozeAlarmFor::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("snoozeAlarmFor::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.AlarmClockInterfaceStub", lpparam.classLoader, "debugToast", "java.lang.String", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("debugToast::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("debugToast::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.AlarmClockService", lpparam.classLoader, "onCreate", new XC_MethodHook() {

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

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.AlarmClockService", lpparam.classLoader, "onStart", "android.content.Intent", "int", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("onStart::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("onStart::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.AlarmClockService", lpparam.classLoader, "onStartCommand", "android.content.Intent", "int", "int", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("onStartCommand::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("onStartCommand::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.AlarmClockService", lpparam.classLoader, "handleStart", "android.content.Intent", "int", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("handleStart::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("handleStart::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.AlarmClockService", lpparam.classLoader, "refreshNotification", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("refreshNotification::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("refreshNotification::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.AlarmClockService", lpparam.classLoader, "fixPersistentSettings", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("fixPersistentSettings::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("fixPersistentSettings::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.AlarmClockService", lpparam.classLoader, "onDestroy", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("onDestroy::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("onDestroy::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.AlarmClockService", lpparam.classLoader, "onBind", "android.content.Intent", new XC_MethodHook() {

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

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.AlarmClockService", lpparam.classLoader, "onUnbind", "android.content.Intent", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("onUnbind::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("onUnbind::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.AlarmClockService", lpparam.classLoader, "pendingAlarm", "long", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("pendingAlarm::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("pendingAlarm::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.AlarmClockService", lpparam.classLoader, "pendingAlarmTimes", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("pendingAlarmTimes::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("pendingAlarmTimes::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.AlarmClockService", lpparam.classLoader, "createAlarm", "com.angrydoughnuts.android.alarmclock.AlarmTime", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("createAlarm::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("createAlarm::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.AlarmClockService", lpparam.classLoader, "deleteAlarm", "long", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("deleteAlarm::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("deleteAlarm::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.AlarmClockService", lpparam.classLoader, "deleteAllAlarms", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("deleteAllAlarms::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("deleteAllAlarms::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.AlarmClockService", lpparam.classLoader, "scheduleAlarm", "long", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("scheduleAlarm::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("scheduleAlarm::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.AlarmClockService", lpparam.classLoader, "acknowledgeAlarm", "long", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("acknowledgeAlarm::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("acknowledgeAlarm::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.AlarmClockService", lpparam.classLoader, "dismissAlarm", "long", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("dismissAlarm::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("dismissAlarm::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.AlarmClockService", lpparam.classLoader, "snoozeAlarm", "long", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("snoozeAlarm::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("snoozeAlarm::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.AlarmClockService", lpparam.classLoader, "snoozeAlarmFor", "long", "int", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("snoozeAlarmFor::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("snoozeAlarmFor::methodEnd::" + endTime);
				}
			});

			findAndHookConstructor("com.angrydoughnuts.android.alarmclock.AlarmClockServiceBinder", lpparam.classLoader, "android.content.Context", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("AlarmClockServiceBinder::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("AlarmClockServiceBinder::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.AlarmClockServiceBinder", lpparam.classLoader, "clock", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("clock::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("clock::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.AlarmClockServiceBinder", lpparam.classLoader, "bind", new XC_MethodHook() {

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

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.AlarmClockServiceBinder", lpparam.classLoader, "unbind", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("unbind::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("unbind::methodEnd::" + endTime);
				}
			});

		try {
			findAndHookMethod("com.angrydoughnuts.android.alarmclock.AlarmClockServiceBinder$1", lpparam.classLoader, "onServiceConnected", "android.content.ComponentName", "android.os.IBinder", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("onServiceConnected::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("onServiceConnected::methodEnd::" + endTime);
				}
			});

		}
		catch (Throwable t) {
			System.err.println(t.getMessage());
		}

		try {
			findAndHookMethod("com.angrydoughnuts.android.alarmclock.AlarmClockServiceBinder$1", lpparam.classLoader, "onServiceDisconnected", "android.content.ComponentName", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("onServiceDisconnected::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("onServiceDisconnected::methodEnd::" + endTime);
				}
			});

		}
		catch (Throwable t) {
			System.err.println(t.getMessage());
		}

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.AlarmClockServiceBinder", lpparam.classLoader, "runOrDefer", "com.angrydoughnuts.android.alarmclock.AlarmClockServiceBinder$ServiceCallback", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("runOrDefer::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("runOrDefer::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.AlarmClockServiceBinder", lpparam.classLoader, "createAlarm", "com.angrydoughnuts.android.alarmclock.AlarmTime", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("createAlarm::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("createAlarm::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.AlarmClockServiceBinder", lpparam.classLoader, "deleteAlarm", "long", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("deleteAlarm::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("deleteAlarm::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.AlarmClockServiceBinder", lpparam.classLoader, "deleteAllAlarms", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("deleteAllAlarms::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("deleteAllAlarms::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.AlarmClockServiceBinder", lpparam.classLoader, "scheduleAlarm", "long", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("scheduleAlarm::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("scheduleAlarm::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.AlarmClockServiceBinder", lpparam.classLoader, "unscheduleAlarm", "long", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("unscheduleAlarm::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("unscheduleAlarm::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.AlarmClockServiceBinder", lpparam.classLoader, "acknowledgeAlarm", "long", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("acknowledgeAlarm::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("acknowledgeAlarm::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.AlarmClockServiceBinder", lpparam.classLoader, "snoozeAlarm", "long", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("snoozeAlarm::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("snoozeAlarm::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.AlarmClockServiceBinder", lpparam.classLoader, "snoozeAlarmFor", "long", "int", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("snoozeAlarmFor::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("snoozeAlarmFor::methodEnd::" + endTime);
				}
			});

			findAndHookConstructor("com.angrydoughnuts.android.alarmclock.AlarmInfo", lpparam.classLoader, "android.database.Cursor", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("AlarmInfo::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("AlarmInfo::methodEnd::" + endTime);
				}
			});

			findAndHookConstructor("com.angrydoughnuts.android.alarmclock.AlarmInfo", lpparam.classLoader, "com.angrydoughnuts.android.alarmclock.AlarmTime", "boolean", "java.lang.String", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("AlarmInfo::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("AlarmInfo::methodEnd::" + endTime);
				}
			});

			findAndHookConstructor("com.angrydoughnuts.android.alarmclock.AlarmInfo", lpparam.classLoader, "com.angrydoughnuts.android.alarmclock.AlarmInfo", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("AlarmInfo::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("AlarmInfo::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.AlarmInfo", lpparam.classLoader, "equals", "java.lang.Object", new XC_MethodHook() {

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

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.AlarmInfo", lpparam.classLoader, "contentValues", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("contentValues::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("contentValues::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.AlarmInfo", lpparam.classLoader, "contentColumns", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("contentColumns::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("contentColumns::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.AlarmInfo", lpparam.classLoader, "getAlarmId", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("getAlarmId::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("getAlarmId::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.AlarmInfo", lpparam.classLoader, "getTime", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("getTime::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("getTime::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.AlarmInfo", lpparam.classLoader, "setTime", "com.angrydoughnuts.android.alarmclock.AlarmTime", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("setTime::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("setTime::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.AlarmInfo", lpparam.classLoader, "enabled", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("enabled::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("enabled::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.AlarmInfo", lpparam.classLoader, "setEnabled", "boolean", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("setEnabled::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("setEnabled::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.AlarmInfo", lpparam.classLoader, "getName", new XC_MethodHook() {

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

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.AlarmInfo", lpparam.classLoader, "setName", "java.lang.String", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("setName::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("setName::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.AlarmInfo", lpparam.classLoader, "TimeToInteger", "com.angrydoughnuts.android.alarmclock.AlarmTime", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("TimeToInteger::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("TimeToInteger::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.AlarmInfo", lpparam.classLoader, "WeekToInteger", "com.angrydoughnuts.android.alarmclock.AlarmTime", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("WeekToInteger::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("WeekToInteger::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.AlarmInfo", lpparam.classLoader, "BuildAlarmTime", "int", "int", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("BuildAlarmTime::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("BuildAlarmTime::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.AlarmSettings", lpparam.classLoader, "contentValues", "long", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("contentValues::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("contentValues::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.AlarmSettings", lpparam.classLoader, "contentColumns", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("contentColumns::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("contentColumns::methodEnd::" + endTime);
				}
			});

			findAndHookConstructor("com.angrydoughnuts.android.alarmclock.AlarmSettings", lpparam.classLoader, new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("AlarmSettings::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("AlarmSettings::methodEnd::" + endTime);
				}
			});

			findAndHookConstructor("com.angrydoughnuts.android.alarmclock.AlarmSettings", lpparam.classLoader, "com.angrydoughnuts.android.alarmclock.AlarmSettings", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("AlarmSettings::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("AlarmSettings::methodEnd::" + endTime);
				}
			});

			findAndHookConstructor("com.angrydoughnuts.android.alarmclock.AlarmSettings", lpparam.classLoader, "android.database.Cursor", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("AlarmSettings::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("AlarmSettings::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.AlarmSettings", lpparam.classLoader, "equals", "java.lang.Object", new XC_MethodHook() {

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

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.AlarmSettings", lpparam.classLoader, "getTone", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("getTone::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("getTone::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.AlarmSettings", lpparam.classLoader, "setTone", "android.net.Uri", "java.lang.String", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("setTone::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("setTone::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.AlarmSettings", lpparam.classLoader, "getToneName", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("getToneName::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("getToneName::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.AlarmSettings", lpparam.classLoader, "getSnoozeMinutes", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("getSnoozeMinutes::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("getSnoozeMinutes::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.AlarmSettings", lpparam.classLoader, "setSnoozeMinutes", "int", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("setSnoozeMinutes::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("setSnoozeMinutes::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.AlarmSettings", lpparam.classLoader, "getVibrate", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("getVibrate::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("getVibrate::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.AlarmSettings", lpparam.classLoader, "setVibrate", "boolean", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("setVibrate::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("setVibrate::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.AlarmSettings", lpparam.classLoader, "getVolumeStartPercent", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("getVolumeStartPercent::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("getVolumeStartPercent::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.AlarmSettings", lpparam.classLoader, "setVolumeStartPercent", "int", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("setVolumeStartPercent::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("setVolumeStartPercent::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.AlarmSettings", lpparam.classLoader, "getVolumeEndPercent", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("getVolumeEndPercent::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("getVolumeEndPercent::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.AlarmSettings", lpparam.classLoader, "setVolumeEndPercent", "int", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("setVolumeEndPercent::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("setVolumeEndPercent::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.AlarmSettings", lpparam.classLoader, "getVolumeChangeTimeSec", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("getVolumeChangeTimeSec::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("getVolumeChangeTimeSec::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.AlarmSettings", lpparam.classLoader, "setVolumeChangeTimeSec", "int", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("setVolumeChangeTimeSec::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("setVolumeChangeTimeSec::methodEnd::" + endTime);
				}
			});

			findAndHookConstructor("com.angrydoughnuts.android.alarmclock.AlarmTime", lpparam.classLoader, "com.angrydoughnuts.android.alarmclock.AlarmTime", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("AlarmTime::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("AlarmTime::methodEnd::" + endTime);
				}
			});

			findAndHookConstructor("com.angrydoughnuts.android.alarmclock.AlarmTime", lpparam.classLoader, "int", "int", "int", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("AlarmTime::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("AlarmTime::methodEnd::" + endTime);
				}
			});

			findAndHookConstructor("com.angrydoughnuts.android.alarmclock.AlarmTime", lpparam.classLoader, "int", "int", "int", "com.angrydoughnuts.android.alarmclock.Week", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("AlarmTime::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("AlarmTime::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.AlarmTime", lpparam.classLoader, "findNextOccurrence", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("findNextOccurrence::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("findNextOccurrence::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.AlarmTime", lpparam.classLoader, "compareTo", "com.angrydoughnuts.android.alarmclock.AlarmTime", new XC_MethodHook() {

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

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.AlarmTime", lpparam.classLoader, "equals", "java.lang.Object", new XC_MethodHook() {

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

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.AlarmTime", lpparam.classLoader, "toString", new XC_MethodHook() {

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

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.AlarmTime", lpparam.classLoader, "localizedString", "android.content.Context", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("localizedString::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("localizedString::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.AlarmTime", lpparam.classLoader, "calendar", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("calendar::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("calendar::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.AlarmTime", lpparam.classLoader, "getDaysOfWeek", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("getDaysOfWeek::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("getDaysOfWeek::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.AlarmTime", lpparam.classLoader, "repeats", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("repeats::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("repeats::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.AlarmTime", lpparam.classLoader, "timeUntilString", "android.content.Context", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("timeUntilString::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("timeUntilString::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.AlarmTime", lpparam.classLoader, "snoozeInMillisUTC", "int", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("snoozeInMillisUTC::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("snoozeInMillisUTC::methodEnd::" + endTime);
				}
			});

			findAndHookConstructor("com.angrydoughnuts.android.alarmclock.AlarmTime", lpparam.classLoader, "android.os.Parcel", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("AlarmTime::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("AlarmTime::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.AlarmTime", lpparam.classLoader, "writeToParcel", "android.os.Parcel", "int", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("writeToParcel::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("writeToParcel::methodEnd::" + endTime);
				}
			});

		try {
			findAndHookMethod("com.angrydoughnuts.android.alarmclock.AlarmTime$1", lpparam.classLoader, "createFromParcel", "android.os.Parcel", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("createFromParcel::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("createFromParcel::methodEnd::" + endTime);
				}
			});

		}
		catch (Throwable t) {
			System.err.println(t.getMessage());
		}

		try {
			findAndHookMethod("com.angrydoughnuts.android.alarmclock.AlarmTime$1", lpparam.classLoader, "newArray", "int", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("newArray::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("newArray::methodEnd::" + endTime);
				}
			});

		}
		catch (Throwable t) {
			System.err.println(t.getMessage());
		}

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.AlarmTime", lpparam.classLoader, "describeContents", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("describeContents::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("describeContents::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.AlarmUtil", lpparam.classLoader, "alarmIdToUri", "long", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("alarmIdToUri::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("alarmIdToUri::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.AlarmUtil", lpparam.classLoader, "alarmUriToId", "android.net.Uri", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("alarmUriToId::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("alarmUriToId::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.AlarmUtil$Interval", lpparam.classLoader, "millis", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("millis::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("millis::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.AlarmUtil", lpparam.classLoader, "millisTillNextInterval", "com.angrydoughnuts.android.alarmclock.AlarmUtil$Interval", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("millisTillNextInterval::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("millisTillNextInterval::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.AlarmUtil", lpparam.classLoader, "nextIntervalInUTC", "com.angrydoughnuts.android.alarmclock.AlarmUtil$Interval", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("nextIntervalInUTC::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("nextIntervalInUTC::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.AlarmUtil", lpparam.classLoader, "getDefaultAlarmUri", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("getDefaultAlarmUri::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("getDefaultAlarmUri::methodEnd::" + endTime);
				}
			});

			findAndHookConstructor("com.angrydoughnuts.android.alarmclock.AlarmViewAdapter", lpparam.classLoader, "android.app.Activity", "com.angrydoughnuts.android.alarmclock.DbAccessor", "com.angrydoughnuts.android.alarmclock.AlarmClockServiceBinder", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("AlarmViewAdapter::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("AlarmViewAdapter::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.AlarmViewAdapter", lpparam.classLoader, "loadData", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("loadData::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("loadData::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.AlarmViewAdapter", lpparam.classLoader, "requery", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("requery::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("requery::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.AlarmViewAdapter", lpparam.classLoader, "getView", "int", "android.view.View", "android.view.ViewGroup", new XC_MethodHook() {

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

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.AppSettings", lpparam.classLoader, "displayNotificationIcon", "android.content.Context", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("displayNotificationIcon::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("displayNotificationIcon::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.AppSettings", lpparam.classLoader, "lockScreenString", "android.content.Context", "com.angrydoughnuts.android.alarmclock.AlarmTime", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("lockScreenString::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("lockScreenString::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.AppSettings", lpparam.classLoader, "isDebugMode", "android.content.Context", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("isDebugMode::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("isDebugMode::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.AppSettings", lpparam.classLoader, "alarmTimeOutMins", "android.content.Context", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("alarmTimeOutMins::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("alarmTimeOutMins::methodEnd::" + endTime);
				}
			});

			findAndHookConstructor("com.angrydoughnuts.android.alarmclock.DbAccessor", lpparam.classLoader, "android.content.Context", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("DbAccessor::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("DbAccessor::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.DbAccessor", lpparam.classLoader, "closeConnections", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("closeConnections::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("closeConnections::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.DbAccessor", lpparam.classLoader, "newAlarm", "com.angrydoughnuts.android.alarmclock.AlarmTime", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("newAlarm::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("newAlarm::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.DbAccessor", lpparam.classLoader, "deleteAlarm", "long", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("deleteAlarm::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("deleteAlarm::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.DbAccessor", lpparam.classLoader, "enableAlarm", "long", "boolean", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("enableAlarm::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("enableAlarm::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.DbAccessor", lpparam.classLoader, "getEnabledAlarms", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("getEnabledAlarms::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("getEnabledAlarms::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.DbAccessor", lpparam.classLoader, "getAllAlarms", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("getAllAlarms::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("getAllAlarms::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.DbAccessor", lpparam.classLoader, "writeAlarmInfo", "long", "com.angrydoughnuts.android.alarmclock.AlarmInfo", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("writeAlarmInfo::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("writeAlarmInfo::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.DbAccessor", lpparam.classLoader, "readAlarmInfo", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("readAlarmInfo::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("readAlarmInfo::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.DbAccessor", lpparam.classLoader, "readAlarmInfo", "long", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("readAlarmInfo::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("readAlarmInfo::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.DbAccessor", lpparam.classLoader, "writeAlarmSettings", "long", "com.angrydoughnuts.android.alarmclock.AlarmSettings", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("writeAlarmSettings::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("writeAlarmSettings::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.DbAccessor", lpparam.classLoader, "readAlarmSettings", "long", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("readAlarmSettings::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("readAlarmSettings::methodEnd::" + endTime);
				}
			});

			findAndHookConstructor("com.angrydoughnuts.android.alarmclock.DbHelper", lpparam.classLoader, "android.content.Context", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("DbHelper::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("DbHelper::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.DbHelper", lpparam.classLoader, "onCreate", "android.database.sqlite.SQLiteDatabase", new XC_MethodHook() {

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

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.DbHelper", lpparam.classLoader, "onUpgrade", "android.database.sqlite.SQLiteDatabase", "int", "int", new XC_MethodHook() {

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

			findAndHookConstructor("com.angrydoughnuts.android.alarmclock.LoggingUncaughtExceptionHandler", lpparam.classLoader, "java.lang.String", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("LoggingUncaughtExceptionHandler::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("LoggingUncaughtExceptionHandler::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.LoggingUncaughtExceptionHandler", lpparam.classLoader, "uncaughtException", "java.lang.Thread", "java.lang.Throwable", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("uncaughtException::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("uncaughtException::methodEnd::" + endTime);
				}
			});

			findAndHookConstructor("com.angrydoughnuts.android.alarmclock.MediaAlbumsView", lpparam.classLoader, "android.content.Context", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("MediaAlbumsView::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("MediaAlbumsView::methodEnd::" + endTime);
				}
			});

			findAndHookConstructor("com.angrydoughnuts.android.alarmclock.MediaAlbumsView", lpparam.classLoader, "android.content.Context", "android.util.AttributeSet", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("MediaAlbumsView::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("MediaAlbumsView::methodEnd::" + endTime);
				}
			});

			findAndHookConstructor("com.angrydoughnuts.android.alarmclock.MediaAlbumsView", lpparam.classLoader, "android.content.Context", "android.util.AttributeSet", "int", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("MediaAlbumsView::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("MediaAlbumsView::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.MediaAlbumsView", lpparam.classLoader, "setCursorManager", "android.app.Activity", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("setCursorManager::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("setCursorManager::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.MediaAlbumsView", lpparam.classLoader, "addToFlipper", "android.widget.ViewFlipper", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("addToFlipper::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("addToFlipper::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.MediaAlbumsView", lpparam.classLoader, "setMediaPlayer", "android.media.MediaPlayer", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("setMediaPlayer::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("setMediaPlayer::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.MediaAlbumsView", lpparam.classLoader, "query", "android.net.Uri", new XC_MethodHook() {

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

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.MediaAlbumsView", lpparam.classLoader, "query", "android.net.Uri", "java.lang.String", new XC_MethodHook() {

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

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.MediaAlbumsView", lpparam.classLoader, "setMediaPickListener", "com.angrydoughnuts.android.alarmclock.MediaListView$OnItemPickListener", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("setMediaPickListener::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("setMediaPickListener::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.MediaAlbumsView", lpparam.classLoader, "onItemClick", "android.widget.AdapterView", "android.view.View", "int", "long", new XC_MethodHook() {

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

			findAndHookConstructor("com.angrydoughnuts.android.alarmclock.MediaArtistsView", lpparam.classLoader, "android.content.Context", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("MediaArtistsView::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("MediaArtistsView::methodEnd::" + endTime);
				}
			});

			findAndHookConstructor("com.angrydoughnuts.android.alarmclock.MediaArtistsView", lpparam.classLoader, "android.content.Context", "android.util.AttributeSet", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("MediaArtistsView::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("MediaArtistsView::methodEnd::" + endTime);
				}
			});

			findAndHookConstructor("com.angrydoughnuts.android.alarmclock.MediaArtistsView", lpparam.classLoader, "android.content.Context", "android.util.AttributeSet", "int", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("MediaArtistsView::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("MediaArtistsView::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.MediaArtistsView", lpparam.classLoader, "setCursorManager", "android.app.Activity", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("setCursorManager::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("setCursorManager::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.MediaArtistsView", lpparam.classLoader, "addToFlipper", "android.widget.ViewFlipper", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("addToFlipper::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("addToFlipper::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.MediaArtistsView", lpparam.classLoader, "setMediaPlayer", "android.media.MediaPlayer", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("setMediaPlayer::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("setMediaPlayer::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.MediaArtistsView", lpparam.classLoader, "query", "android.net.Uri", new XC_MethodHook() {

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

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.MediaArtistsView", lpparam.classLoader, "query", "android.net.Uri", "java.lang.String", new XC_MethodHook() {

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

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.MediaArtistsView", lpparam.classLoader, "setMediaPickListener", "com.angrydoughnuts.android.alarmclock.MediaListView$OnItemPickListener", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("setMediaPickListener::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("setMediaPickListener::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.MediaArtistsView", lpparam.classLoader, "onItemClick", "android.widget.AdapterView", "android.view.View", "int", "long", new XC_MethodHook() {

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

			findAndHookConstructor("com.angrydoughnuts.android.alarmclock.MediaListView", lpparam.classLoader, "android.content.Context", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("MediaListView::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("MediaListView::methodEnd::" + endTime);
				}
			});

			findAndHookConstructor("com.angrydoughnuts.android.alarmclock.MediaListView", lpparam.classLoader, "android.content.Context", "android.util.AttributeSet", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("MediaListView::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("MediaListView::methodEnd::" + endTime);
				}
			});

			findAndHookConstructor("com.angrydoughnuts.android.alarmclock.MediaListView", lpparam.classLoader, "android.content.Context", "android.util.AttributeSet", "int", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("MediaListView::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("MediaListView::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.MediaListView", lpparam.classLoader, "setMediaPlayer", "android.media.MediaPlayer", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("setMediaPlayer::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("setMediaPlayer::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.MediaListView", lpparam.classLoader, "getMediaPlayer", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("getMediaPlayer::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("getMediaPlayer::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.MediaListView", lpparam.classLoader, "addToFlipper", "android.widget.ViewFlipper", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("addToFlipper::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("addToFlipper::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.MediaListView", lpparam.classLoader, "getFlipper", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("getFlipper::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("getFlipper::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.MediaListView", lpparam.classLoader, "setCursorManager", "android.app.Activity", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("setCursorManager::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("setCursorManager::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.MediaListView", lpparam.classLoader, "manageCursor", "android.database.Cursor", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("manageCursor::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("manageCursor::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.MediaListView", lpparam.classLoader, "overrideSortOrder", "java.lang.String", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("overrideSortOrder::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("overrideSortOrder::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.MediaListView", lpparam.classLoader, "includeStaticCursor", "android.database.Cursor", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("includeStaticCursor::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("includeStaticCursor::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.MediaListView", lpparam.classLoader, "getLastSelectedName", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("getLastSelectedName::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("getLastSelectedName::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.MediaListView", lpparam.classLoader, "getLastSelectedUri", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("getLastSelectedUri::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("getLastSelectedUri::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.MediaListView", lpparam.classLoader, "setMediaPickListener", "com.angrydoughnuts.android.alarmclock.MediaListView$OnItemPickListener", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("setMediaPickListener::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("setMediaPickListener::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.MediaListView", lpparam.classLoader, "onItemClick", "android.widget.AdapterView", "android.view.View", "int", "long", new XC_MethodHook() {

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

			findAndHookConstructor("com.angrydoughnuts.android.alarmclock.MediaPickerDialog", lpparam.classLoader, "android.app.Activity", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("MediaPickerDialog::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("MediaPickerDialog::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.MediaPickerDialog", lpparam.classLoader, "setPickListener", "com.angrydoughnuts.android.alarmclock.MediaPickerDialog$OnMediaPickListener", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("setPickListener::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("setPickListener::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.MediaPickerDialog", lpparam.classLoader, "onStop", new XC_MethodHook() {

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

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.MediaPickerDialog", lpparam.classLoader, "finalize", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("finalize::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("finalize::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.MediaPickerDialog", lpparam.classLoader, "setButton", "java.lang.CharSequence", "android.os.Message", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("setButton::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("setButton::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.MediaPickerDialog", lpparam.classLoader, "setButton", "java.lang.CharSequence", "android.content.DialogInterface$OnClickListener", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("setButton::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("setButton::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.MediaPickerDialog", lpparam.classLoader, "setButton", "int", "java.lang.CharSequence", "android.os.Message", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("setButton::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("setButton::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.MediaPickerDialog", lpparam.classLoader, "setButton", "int", "java.lang.CharSequence", "android.content.DialogInterface$OnClickListener", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("setButton::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("setButton::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.MediaPickerDialog", lpparam.classLoader, "setButton2", "java.lang.CharSequence", "android.os.Message", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("setButton2::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("setButton2::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.MediaPickerDialog", lpparam.classLoader, "setButton2", "java.lang.CharSequence", "android.content.DialogInterface$OnClickListener", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("setButton2::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("setButton2::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.MediaPickerDialog", lpparam.classLoader, "setButton3", "java.lang.CharSequence", "android.os.Message", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("setButton3::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("setButton3::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.MediaPickerDialog", lpparam.classLoader, "setButton3", "java.lang.CharSequence", "android.content.DialogInterface$OnClickListener", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("setButton3::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("setButton3::methodEnd::" + endTime);
				}
			});

			findAndHookConstructor("com.angrydoughnuts.android.alarmclock.MediaSongsView", lpparam.classLoader, "android.content.Context", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("MediaSongsView::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("MediaSongsView::methodEnd::" + endTime);
				}
			});

			findAndHookConstructor("com.angrydoughnuts.android.alarmclock.MediaSongsView", lpparam.classLoader, "android.content.Context", "android.util.AttributeSet", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("MediaSongsView::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("MediaSongsView::methodEnd::" + endTime);
				}
			});

			findAndHookConstructor("com.angrydoughnuts.android.alarmclock.MediaSongsView", lpparam.classLoader, "android.content.Context", "android.util.AttributeSet", "int", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("MediaSongsView::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("MediaSongsView::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.MediaSongsView", lpparam.classLoader, "query", "android.net.Uri", new XC_MethodHook() {

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

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.MediaSongsView", lpparam.classLoader, "query", "android.net.Uri", "java.lang.String", new XC_MethodHook() {

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

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.MediaSongsView", lpparam.classLoader, "onItemClick", "android.widget.AdapterView", "android.view.View", "int", "long", new XC_MethodHook() {

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

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.MediaSongsView", lpparam.classLoader, "includeDefault", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("includeDefault::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("includeDefault::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.NotificationService$MediaSingleton", lpparam.classLoader, "normalizeVolume", "android.content.Context", "float", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("normalizeVolume::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("normalizeVolume::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.NotificationService$MediaSingleton", lpparam.classLoader, "setVolume", "float", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("setVolume::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("setVolume::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.NotificationService$MediaSingleton", lpparam.classLoader, "resetVolume", "android.content.Context", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("resetVolume::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("resetVolume::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.NotificationService$MediaSingleton", lpparam.classLoader, "useContext", "android.content.Context", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("useContext::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("useContext::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.NotificationService$MediaSingleton", lpparam.classLoader, "ensureSound", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("ensureSound::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("ensureSound::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.NotificationService$MediaSingleton", lpparam.classLoader, "vibrate", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("vibrate::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("vibrate::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.NotificationService$MediaSingleton", lpparam.classLoader, "play", "android.content.Context", "android.net.Uri", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("play::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("play::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.NotificationService$MediaSingleton", lpparam.classLoader, "stop", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("stop::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("stop::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.NotificationService", lpparam.classLoader, "onBind", "android.content.Intent", new XC_MethodHook() {

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

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.NotificationService", lpparam.classLoader, "onCreate", new XC_MethodHook() {

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

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.NotificationService", lpparam.classLoader, "onDestroy", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("onDestroy::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("onDestroy::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.NotificationService", lpparam.classLoader, "onStart", "android.content.Intent", "int", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("onStart::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("onStart::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.NotificationService", lpparam.classLoader, "onStartCommand", "android.content.Intent", "int", "int", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("onStartCommand::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("onStartCommand::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.NotificationService", lpparam.classLoader, "handleStart", "android.content.Intent", "int", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("handleStart::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("handleStart::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.NotificationService", lpparam.classLoader, "currentAlarmId", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("currentAlarmId::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("currentAlarmId::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.NotificationService", lpparam.classLoader, "firingAlarmCount", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("firingAlarmCount::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("firingAlarmCount::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.NotificationService", lpparam.classLoader, "volume", new XC_MethodHook() {

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

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.NotificationService", lpparam.classLoader, "acknowledgeCurrentNotification", "int", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("acknowledgeCurrentNotification::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("acknowledgeCurrentNotification::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.NotificationService", lpparam.classLoader, "soundAlarm", "long", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("soundAlarm::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("soundAlarm::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.NotificationService", lpparam.classLoader, "stopNotifying", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("stopNotifying::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("stopNotifying::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.NotificationService$VolumeIncreaser", lpparam.classLoader, "volume", new XC_MethodHook() {

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

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.NotificationService$VolumeIncreaser", lpparam.classLoader, "reset", "com.angrydoughnuts.android.alarmclock.AlarmSettings", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("reset::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("reset::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.NotificationService$VolumeIncreaser", lpparam.classLoader, "run", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("run::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("run::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.NotificationServiceBinder", lpparam.classLoader, "bind", new XC_MethodHook() {

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

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.NotificationServiceBinder", lpparam.classLoader, "unbind", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("unbind::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("unbind::methodEnd::" + endTime);
				}
			});

		try {
			findAndHookMethod("com.angrydoughnuts.android.alarmclock.NotificationServiceBinder$1", lpparam.classLoader, "onServiceConnected", "android.content.ComponentName", "android.os.IBinder", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("onServiceConnected::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("onServiceConnected::methodEnd::" + endTime);
				}
			});

		}
		catch (Throwable t) {
			System.err.println(t.getMessage());
		}

		try {
			findAndHookMethod("com.angrydoughnuts.android.alarmclock.NotificationServiceBinder$1", lpparam.classLoader, "onServiceDisconnected", "android.content.ComponentName", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("onServiceDisconnected::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("onServiceDisconnected::methodEnd::" + endTime);
				}
			});

		}
		catch (Throwable t) {
			System.err.println(t.getMessage());
		}

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.NotificationServiceBinder", lpparam.classLoader, "call", "com.angrydoughnuts.android.alarmclock.NotificationServiceBinder$ServiceCallback", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("call::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("call::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.NotificationServiceBinder", lpparam.classLoader, "acknowledgeCurrentNotification", "int", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("acknowledgeCurrentNotification::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("acknowledgeCurrentNotification::methodEnd::" + endTime);
				}
			});

			findAndHookConstructor("com.angrydoughnuts.android.alarmclock.NotificationServiceInterfaceStub", lpparam.classLoader, "com.angrydoughnuts.android.alarmclock.NotificationService", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("NotificationServiceInterfaceStub::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("NotificationServiceInterfaceStub::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.NotificationServiceInterfaceStub", lpparam.classLoader, "currentAlarmId", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("currentAlarmId::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("currentAlarmId::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.NotificationServiceInterfaceStub", lpparam.classLoader, "firingAlarmCount", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("firingAlarmCount::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("firingAlarmCount::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.NotificationServiceInterfaceStub", lpparam.classLoader, "volume", new XC_MethodHook() {

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

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.NotificationServiceInterfaceStub", lpparam.classLoader, "acknowledgeCurrentNotification", "int", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("acknowledgeCurrentNotification::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("acknowledgeCurrentNotification::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.NotificationServiceInterfaceStub", lpparam.classLoader, "debugToast", "java.lang.String", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("debugToast::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("debugToast::methodEnd::" + endTime);
				}
			});

			findAndHookConstructor("com.angrydoughnuts.android.alarmclock.PendingAlarmList", lpparam.classLoader, "android.content.Context", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("PendingAlarmList::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("PendingAlarmList::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.PendingAlarmList", lpparam.classLoader, "size", new XC_MethodHook() {

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

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.PendingAlarmList", lpparam.classLoader, "put", "long", "com.angrydoughnuts.android.alarmclock.AlarmTime", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("put::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("put::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.PendingAlarmList", lpparam.classLoader, "remove", "long", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("remove::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("remove::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.PendingAlarmList", lpparam.classLoader, "nextAlarmTime", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("nextAlarmTime::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("nextAlarmTime::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.PendingAlarmList", lpparam.classLoader, "pendingTime", "long", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("pendingTime::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("pendingTime::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.PendingAlarmList", lpparam.classLoader, "pendingTimes", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("pendingTimes::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("pendingTimes::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.PendingAlarmList", lpparam.classLoader, "pendingAlarms", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("pendingAlarms::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("pendingAlarms::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.PendingAlarmList$PendingAlarm", lpparam.classLoader, "time", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("time::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("time::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.PendingAlarmList$PendingAlarm", lpparam.classLoader, "pendingIntent", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("pendingIntent::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("pendingIntent::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.ReceiverAlarm", lpparam.classLoader, "onReceive", "android.content.Context", "android.content.Intent", new XC_MethodHook() {

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

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.ReceiverDeviceBoot", lpparam.classLoader, "onReceive", "android.content.Context", "android.content.Intent", new XC_MethodHook() {

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

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.ReceiverNotificationRefresh", lpparam.classLoader, "startRefreshing", "android.content.Context", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("startRefreshing::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("startRefreshing::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.ReceiverNotificationRefresh", lpparam.classLoader, "stopRefreshing", "android.content.Context", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("stopRefreshing::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("stopRefreshing::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.ReceiverNotificationRefresh", lpparam.classLoader, "intent", "android.content.Context", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("intent::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("intent::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.ReceiverNotificationRefresh", lpparam.classLoader, "pendingIntent", "android.content.Context", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("pendingIntent::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("pendingIntent::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.ReceiverNotificationRefresh", lpparam.classLoader, "onReceive", "android.content.Context", "android.content.Intent", new XC_MethodHook() {

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

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.RecevierTimeZoneChange", lpparam.classLoader, "onReceive", "android.content.Context", "android.content.Intent", new XC_MethodHook() {

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

			findAndHookConstructor("com.angrydoughnuts.android.alarmclock.Slider", lpparam.classLoader, "android.content.Context", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("Slider::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("Slider::methodEnd::" + endTime);
				}
			});

			findAndHookConstructor("com.angrydoughnuts.android.alarmclock.Slider", lpparam.classLoader, "android.content.Context", "android.util.AttributeSet", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("Slider::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("Slider::methodEnd::" + endTime);
				}
			});

			findAndHookConstructor("com.angrydoughnuts.android.alarmclock.Slider", lpparam.classLoader, "android.content.Context", "android.util.AttributeSet", "int", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("Slider::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("Slider::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.Slider", lpparam.classLoader, "setOnCompleteListener", "com.angrydoughnuts.android.alarmclock.Slider$OnCompleteListener", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("setOnCompleteListener::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("setOnCompleteListener::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.Slider", lpparam.classLoader, "reset", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("reset::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("reset::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.Slider", lpparam.classLoader, "onLayout", "boolean", "int", "int", "int", "int", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("onLayout::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("onLayout::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.Slider", lpparam.classLoader, "onMeasure", "int", "int", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("onMeasure::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("onMeasure::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.Slider", lpparam.classLoader, "withinX", "android.view.View", "float", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("withinX::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("withinX::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.Slider", lpparam.classLoader, "withinY", "android.view.View", "float", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("withinY::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("withinY::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.Slider", lpparam.classLoader, "slideDotHome", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("slideDotHome::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("slideDotHome::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.Slider", lpparam.classLoader, "isComplete", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("isComplete::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("isComplete::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.Slider", lpparam.classLoader, "finishSlider", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("finishSlider::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("finishSlider::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.Slider", lpparam.classLoader, "onTouchEvent", "android.view.MotionEvent", new XC_MethodHook() {

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

			findAndHookConstructor("com.angrydoughnuts.android.alarmclock.TimePickerDialog", lpparam.classLoader, "android.content.Context", "java.lang.String", "int", "int", "int", "boolean", "com.angrydoughnuts.android.alarmclock.TimePickerDialog$OnTimeSetListener", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("TimePickerDialog::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("TimePickerDialog::methodEnd::" + endTime);
				}
			});

			findAndHookConstructor("com.angrydoughnuts.android.alarmclock.TimePickerDialog", lpparam.classLoader, "android.content.Context", "java.lang.String", "boolean", "com.angrydoughnuts.android.alarmclock.TimePickerDialog$OnTimeSetListener", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("TimePickerDialog::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("TimePickerDialog::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.TimePickerDialog", lpparam.classLoader, "dialogRefresh", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("dialogRefresh::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("dialogRefresh::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.TimePickerDialog$IncrementValue", lpparam.classLoader, "value", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("value::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("value::methodEnd::" + endTime);
				}
			});

			findAndHookConstructor("com.angrydoughnuts.android.alarmclock.TimePickerDialog$PickerView", lpparam.classLoader, "com.angrydoughnuts.android.alarmclock.TimePickerDialog", "int", "java.lang.String", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("PickerView::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("PickerView::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.TimePickerDialog$PickerView", lpparam.classLoader, "inflate", "android.view.View", "int", "boolean", "com.angrydoughnuts.android.alarmclock.TimePickerDialog$IncrementValue", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("inflate::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("inflate::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.TimePickerDialog$PickerView", lpparam.classLoader, "pickerRefresh", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("pickerRefresh::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("pickerRefresh::methodEnd::" + endTime);
				}
			});

			findAndHookConstructor("com.angrydoughnuts.android.alarmclock.TimePickerDialog$PickerView$Increment", lpparam.classLoader, "com.angrydoughnuts.android.alarmclock.TimePickerDialog$PickerView", "com.angrydoughnuts.android.alarmclock.TimePickerDialog$IncrementValue", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("Increment::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("Increment::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.TimePickerDialog$PickerView$Increment", lpparam.classLoader, "nextValue", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("nextValue::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("nextValue::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.TimePickerDialog$PickerView$Increment", lpparam.classLoader, "cycleToNext", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("cycleToNext::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("cycleToNext::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.TimePickerDialog$PickerView$Increment", lpparam.classLoader, "value", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("value::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("value::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.TimePickerDialog$PickerView$TimeAdjustListener", lpparam.classLoader, "adjust", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("adjust::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("adjust::methodEnd::" + endTime);
				}
			});

		try {
			findAndHookMethod("com.angrydoughnuts.android.alarmclock.TimePickerDialog$PickerView$TimeAdjustListener$1", lpparam.classLoader, "run", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("run::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("run::methodEnd::" + endTime);
				}
			});

		}
		catch (Throwable t) {
			System.err.println(t.getMessage());
		}

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.TimePickerDialog$PickerView$TimeAdjustListener", lpparam.classLoader, "onClick", "android.view.View", new XC_MethodHook() {

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

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.TimePickerDialog$PickerView$TimeAdjustListener", lpparam.classLoader, "onLongClick", "android.view.View", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("onLongClick::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("onLongClick::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.TimePickerDialog$PickerView$TimeAdjustListener", lpparam.classLoader, "onTouch", "android.view.View", "android.view.MotionEvent", new XC_MethodHook() {

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

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.TimePickerDialog$PickerView$TimeIncrementListener", lpparam.classLoader, "sign", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("sign::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("sign::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.TimePickerDialog$PickerView$TimeDecrementListener", lpparam.classLoader, "sign", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("sign::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("sign::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.TimePickerDialog$PickerView$TextChangeListener", lpparam.classLoader, "handleChange", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("handleChange::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("handleChange::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.TimePickerDialog$PickerView$TextChangeListener", lpparam.classLoader, "onFocusChange", "android.view.View", "boolean", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("onFocusChange::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("onFocusChange::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.TimePickerDialog$PickerView$TextChangeListener", lpparam.classLoader, "onEditorAction", "android.widget.TextView", "int", "android.view.KeyEvent", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("onEditorAction::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("onEditorAction::methodEnd::" + endTime);
				}
			});

			findAndHookConstructor("com.angrydoughnuts.android.alarmclock.WakeLock$WakeLockException", lpparam.classLoader, "java.lang.String", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("WakeLockException::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("WakeLockException::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.WakeLock", lpparam.classLoader, "acquire", "android.content.Context", "long", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("acquire::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("acquire::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.WakeLock", lpparam.classLoader, "assertHeld", "long", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("assertHeld::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("assertHeld::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.WakeLock", lpparam.classLoader, "assertAtLeastOneHeld", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("assertAtLeastOneHeld::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("assertAtLeastOneHeld::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.WakeLock", lpparam.classLoader, "assertNoneHeld", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("assertNoneHeld::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("assertNoneHeld::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.WakeLock", lpparam.classLoader, "release", "long", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("release::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("release::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.Week$Day", lpparam.classLoader, "stringId", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("stringId::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("stringId::methodEnd::" + endTime);
				}
			});

			findAndHookConstructor("com.angrydoughnuts.android.alarmclock.Week", lpparam.classLoader, "android.os.Parcel", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("Week::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("Week::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.Week", lpparam.classLoader, "writeToParcel", "android.os.Parcel", "int", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("writeToParcel::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("writeToParcel::methodEnd::" + endTime);
				}
			});

			findAndHookConstructor("com.angrydoughnuts.android.alarmclock.Week", lpparam.classLoader, new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("Week::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("Week::methodEnd::" + endTime);
				}
			});

			findAndHookConstructor("com.angrydoughnuts.android.alarmclock.Week", lpparam.classLoader, "com.angrydoughnuts.android.alarmclock.Week", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("Week::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("Week::methodEnd::" + endTime);
				}
			});

			findAndHookConstructor("com.angrydoughnuts.android.alarmclock.Week", lpparam.classLoader, "[Z", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("Week::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("Week::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.Week", lpparam.classLoader, "bitmask", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("bitmask::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("bitmask::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.Week", lpparam.classLoader, "addDay", "com.angrydoughnuts.android.alarmclock.Week$Day", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("addDay::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("addDay::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.Week", lpparam.classLoader, "removeDay", "com.angrydoughnuts.android.alarmclock.Week$Day", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("removeDay::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("removeDay::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.Week", lpparam.classLoader, "hasDay", "com.angrydoughnuts.android.alarmclock.Week$Day", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("hasDay::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("hasDay::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.Week", lpparam.classLoader, "names", "android.content.Context", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("names::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("names::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.Week", lpparam.classLoader, "toString", "android.content.Context", new XC_MethodHook() {

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

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.Week", lpparam.classLoader, "equals", "java.lang.Object", new XC_MethodHook() {

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

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.Week", lpparam.classLoader, "describeContents", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("describeContents::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("describeContents::methodEnd::" + endTime);
				}
			});

		try {
			findAndHookMethod("com.angrydoughnuts.android.alarmclock.Week$1", lpparam.classLoader, "createFromParcel", "android.os.Parcel", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("createFromParcel::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("createFromParcel::methodEnd::" + endTime);
				}
			});

		}
		catch (Throwable t) {
			System.err.println(t.getMessage());
		}

		try {
			findAndHookMethod("com.angrydoughnuts.android.alarmclock.Week$1", lpparam.classLoader, "newArray", "int", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("newArray::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("newArray::methodEnd::" + endTime);
				}
			});

		}
		catch (Throwable t) {
			System.err.println(t.getMessage());
		}

			findAndHookMethod("com.angrydoughnuts.android.alarmclock.Week", lpparam.classLoader, "calendarToDay", "int", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("calendarToDay::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("calendarToDay::methodEnd::" + endTime);
				}
			});

		}

}

