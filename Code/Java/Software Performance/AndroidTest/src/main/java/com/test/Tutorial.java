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

		if (!(lpparam.packageName.equals("anupam.acrylic"))) {
			return;
		}

		final XSharedPreferences pref = new XSharedPreferences("com.example.kim.softwareperformance", "user_settings");
		pref.makeWorldReadable();
		pref.reload();

		if (lpparam.packageName.equals("anupam.acrylic")) {
			func0(lpparam);
		}

	}


	public void func0(final LoadPackageParam lpparam) throws Throwable {

			findAndHookMethod("anupam.acrylic.AboutActivity", lpparam.classLoader, "onCreate", "android.os.Bundle", new XC_MethodHook() {

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

			findAndHookMethod("anupam.acrylic.ColorPickerDialog", lpparam.classLoader, "onCreate", "android.os.Bundle", new XC_MethodHook() {

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

			findAndHookMethod("anupam.acrylic.ColorPickerDialog$ColorPickerView", lpparam.classLoader, "onDraw", "android.graphics.Canvas", new XC_MethodHook() {

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

			findAndHookMethod("anupam.acrylic.ColorPickerDialog$ColorPickerView", lpparam.classLoader, "onMeasure", "int", "int", new XC_MethodHook() {

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

			findAndHookMethod("anupam.acrylic.ColorPickerDialog$ColorPickerView", lpparam.classLoader, "floatToByte", "float", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("floatToByte::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("floatToByte::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("anupam.acrylic.ColorPickerDialog$ColorPickerView", lpparam.classLoader, "pinToByte", "int", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("pinToByte::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("pinToByte::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("anupam.acrylic.ColorPickerDialog$ColorPickerView", lpparam.classLoader, "ave", "int", "int", "float", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("ave::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("ave::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("anupam.acrylic.ColorPickerDialog$ColorPickerView", lpparam.classLoader, "interpColor", "[I", "float", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("interpColor::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("interpColor::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("anupam.acrylic.ColorPickerDialog$ColorPickerView", lpparam.classLoader, "rotateColor", "int", "float", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("rotateColor::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("rotateColor::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("anupam.acrylic.ColorPickerDialog$ColorPickerView", lpparam.classLoader, "onTouchEvent", "android.view.MotionEvent", new XC_MethodHook() {

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

			findAndHookConstructor("anupam.acrylic.ColorPickerDialog", lpparam.classLoader, "android.content.Context", "anupam.acrylic.ColorPickerDialog$OnColorChangedListener", "int", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("ColorPickerDialog::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("ColorPickerDialog::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("anupam.acrylic.EasyPaint", lpparam.classLoader, "onCreate", "android.os.Bundle", new XC_MethodHook() {

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

			findAndHookMethod("anupam.acrylic.EasyPaint", lpparam.classLoader, "onBackPressed", new XC_MethodHook() {

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

			findAndHookMethod("anupam.acrylic.EasyPaint", lpparam.classLoader, "colorChanged", "int", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("colorChanged::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("colorChanged::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("anupam.acrylic.EasyPaint$MyView$LinePath", lpparam.classLoader, "getLastX", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("getLastX::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("getLastX::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("anupam.acrylic.EasyPaint$MyView$LinePath", lpparam.classLoader, "getLastY", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("getLastY::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("getLastY::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("anupam.acrylic.EasyPaint$MyView$LinePath", lpparam.classLoader, "touchStart", "float", "float", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("touchStart::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("touchStart::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("anupam.acrylic.EasyPaint$MyView$LinePath", lpparam.classLoader, "touchMove", "float", "float", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("touchMove::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("touchMove::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("anupam.acrylic.EasyPaint$MyView$LinePath", lpparam.classLoader, "isDisassociatedFromPointer", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("isDisassociatedFromPointer::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("isDisassociatedFromPointer::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("anupam.acrylic.EasyPaint$MyView$LinePath", lpparam.classLoader, "isAssociatedToPointer", "int", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("isAssociatedToPointer::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("isAssociatedToPointer::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("anupam.acrylic.EasyPaint$MyView$LinePath", lpparam.classLoader, "disassociateFromPointer", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("disassociateFromPointer::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("disassociateFromPointer::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("anupam.acrylic.EasyPaint$MyView$LinePath", lpparam.classLoader, "associateToPointer", "int", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("associateToPointer::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("associateToPointer::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("anupam.acrylic.EasyPaint$MyView$MultiLinePathManager", lpparam.classLoader, "findLinePathFromPointer", "int", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("findLinePathFromPointer::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("findLinePathFromPointer::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("anupam.acrylic.EasyPaint$MyView$MultiLinePathManager", lpparam.classLoader, "addLinePathWithPointer", "int", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("addLinePathWithPointer::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("addLinePathWithPointer::methodEnd::" + endTime);
				}
			});

			findAndHookConstructor("anupam.acrylic.EasyPaint$MyView", lpparam.classLoader, "anupam.acrylic.EasyPaint", "android.content.Context", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("MyView::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("MyView::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("anupam.acrylic.EasyPaint$MyView", lpparam.classLoader, "onSizeChanged", "int", "int", "int", "int", new XC_MethodHook() {

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

			findAndHookMethod("anupam.acrylic.EasyPaint$MyView", lpparam.classLoader, "onDraw", "android.graphics.Canvas", new XC_MethodHook() {

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

			findAndHookMethod("anupam.acrylic.EasyPaint$MyView", lpparam.classLoader, "onTouchEvent", "android.view.MotionEvent", new XC_MethodHook() {

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

			findAndHookMethod("anupam.acrylic.EasyPaint", lpparam.classLoader, "onCreateOptionsMenu", "android.view.Menu", new XC_MethodHook() {

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

			findAndHookMethod("anupam.acrylic.EasyPaint", lpparam.classLoader, "onPrepareOptionsMenu", "android.view.Menu", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("onPrepareOptionsMenu::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("onPrepareOptionsMenu::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("anupam.acrylic.EasyPaint", lpparam.classLoader, "onOptionsItemSelected", "android.view.MenuItem", new XC_MethodHook() {

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

			findAndHookMethod("anupam.acrylic.EasyPaint", lpparam.classLoader, "takeScreenshot", "boolean", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("takeScreenshot::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("takeScreenshot::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("anupam.acrylic.EasyPaint", lpparam.classLoader, "isFirstTime", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("isFirstTime::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("isFirstTime::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("anupam.acrylic.EasyPaint", lpparam.classLoader, "getStrokeSize", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("getStrokeSize::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("getStrokeSize::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("anupam.acrylic.GraphicsActivity", lpparam.classLoader, "onCreate", "android.os.Bundle", new XC_MethodHook() {

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

			findAndHookMethod("anupam.acrylic.GraphicsActivity", lpparam.classLoader, "setContentView", "android.view.View", new XC_MethodHook() {

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

			findAndHookConstructor("anupam.acrylic.PictureLayout", lpparam.classLoader, "android.content.Context", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("PictureLayout::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("PictureLayout::methodEnd::" + endTime);
				}
			});

			findAndHookConstructor("anupam.acrylic.PictureLayout", lpparam.classLoader, "android.content.Context", "android.util.AttributeSet", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("PictureLayout::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("PictureLayout::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("anupam.acrylic.PictureLayout", lpparam.classLoader, "addView", "android.view.View", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("addView::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("addView::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("anupam.acrylic.PictureLayout", lpparam.classLoader, "addView", "android.view.View", "int", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("addView::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("addView::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("anupam.acrylic.PictureLayout", lpparam.classLoader, "addView", "android.view.View", "android.view.ViewGroup$LayoutParams", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("addView::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("addView::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("anupam.acrylic.PictureLayout", lpparam.classLoader, "addView", "android.view.View", "int", "android.view.ViewGroup$LayoutParams", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("addView::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("addView::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("anupam.acrylic.PictureLayout", lpparam.classLoader, "generateDefaultLayoutParams", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("generateDefaultLayoutParams::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("generateDefaultLayoutParams::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("anupam.acrylic.PictureLayout", lpparam.classLoader, "onMeasure", "int", "int", new XC_MethodHook() {

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

			findAndHookMethod("anupam.acrylic.PictureLayout", lpparam.classLoader, "drawPict", "android.graphics.Canvas", "int", "int", "int", "int", "float", "float", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("drawPict::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("drawPict::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("anupam.acrylic.PictureLayout", lpparam.classLoader, "dispatchDraw", "android.graphics.Canvas", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("dispatchDraw::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("dispatchDraw::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("anupam.acrylic.PictureLayout", lpparam.classLoader, "invalidateChildInParent", "[I", "android.graphics.Rect", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("invalidateChildInParent::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("invalidateChildInParent::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("anupam.acrylic.PictureLayout", lpparam.classLoader, "onLayout", "boolean", "int", "int", "int", "int", new XC_MethodHook() {

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

			findAndHookMethod("anupam.acrylic.Places", lpparam.classLoader, "getScreenshotFolder", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("getScreenshotFolder::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("getScreenshotFolder::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("anupam.acrylic.Places", lpparam.classLoader, "getCameraTempFolder", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("getCameraTempFolder::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("getCameraTempFolder::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("anupam.acrylic.Places", lpparam.classLoader, "getCameraTempFile", new XC_MethodHook() {

				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					startTime = System.nanoTime();
					XposedBridge.log("getCameraTempFile::methodStart::" + startTime);
				}
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					endTime = System.nanoTime();
					XposedBridge.log("getCameraTempFile::methodEnd::" + endTime);
				}
			});

			findAndHookMethod("anupam.acrylic.Splash", lpparam.classLoader, "onCreate", "android.os.Bundle", new XC_MethodHook() {

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

		}

}

