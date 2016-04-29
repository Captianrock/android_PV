package com.androidpv.java.xposed;

import com.androidpv.java.gui.PVView;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Erin on 4/7/16.
 */
public class APKBuilder {

    public APKBuilder() { }

    public boolean tryPing(String adbLoc) {
        boolean success = ping(adbLoc, "/");

        if (!success) {
            success = ping(adbLoc, "\\");
            if (!success) {
                return false;
            }
        }
        return true;
    }

    public boolean ping(String adbLoc, String slash) {

        List<String> pingCommands = new ArrayList<>();
        ProcessBuilder runPing = new ProcessBuilder();
        File adbLocFile = new File(adbLoc);
        runPing.directory(adbLocFile);

        pingCommands.add(runPing.directory().getAbsolutePath() + slash + "adb");
        pingCommands.add("devices");
        runPing.command(pingCommands);
        System.out.println("Test ping: " + runPing.directory().getAbsolutePath());

        try {
            Process p = runPing.start();
            p.waitFor();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String s;
            System.out.println(p);
            int count = 0; // if no device, will print header and newline
            while ((s = reader.readLine()) != null) {
                System.out.println(s);
                count += 1;
            }
            if (count == 2) {
                System.out.println("No device connected.");
                return false;
            }
            System.out.println("pinged?");
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public void tryToBuildAPK(String adbLoc, String sdkLoc) {
        boolean success = buildAPK(adbLoc, sdkLoc, "/", "gradlew");

        if (!success) {
            buildAPK(adbLoc, sdkLoc, "\\", "gradlew.bat");
        }
    }

    private boolean buildAPK(String adbLoc, String sdkLoc, String slash, String gradle) {
        String currentDir = System.getProperty(MBConstants.USER_DIR);

        try {
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(currentDir + slash + MBConstants.ANDROID_TEST_DIR + slash + "local.properties")));
            writer.println("sdk.dir = " + sdkLoc);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // to build apk
        List<String> commandsList = new ArrayList<>();
        ProcessBuilder pb = new ProcessBuilder();
        File wd = new File(currentDir + slash + MBConstants.ANDROID_TEST_DIR);
        pb.directory(wd);
        File f = new File(currentDir + slash + MBConstants.ANDROID_TEST_DIR + slash + gradle);

        commandsList.add(pb.directory().getAbsolutePath() + slash + gradle);
        commandsList.add("build");

        List<String> makeAPK = new ArrayList<>();
        makeAPK.add(pb.directory().getAbsolutePath() + slash + gradle);
        makeAPK.add("assembleDebug");
        pb.command(commandsList);
        System.out.println(pb.directory().getAbsolutePath());

        PVView.getInstance().updateOutLog("Building APK...\n");


        try {
            Process p = pb.start();
            p.waitFor();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String s;
            System.out.println(p);
            while ((s = reader.readLine()) != null) {
                System.out.println(s);
            }
            pb.command(makeAPK);
            p = pb.start();
            p.waitFor();
            System.out.println(p);
            while ((s = reader.readLine()) != null) {
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }

        PVView.instance.updateOutLog("APK Built.  Installing....\n");

        String apkLoc = currentDir + slash + MBConstants.ANDROID_TEST_DIR + slash + "build" + slash + "outputs" + slash +
                "apk" + slash + "AndroidTest-debug.apk";

        installAPK(adbLoc, apkLoc, slash);

        return true;
    }


    public void tryToInstallAPK(String adbLoc, String apkLoc) {
        boolean success = installAPK(adbLoc, apkLoc, "/");

        if (!success) {
            installAPK(adbLoc, apkLoc, "\\");
        }
    }


    public boolean installAPK(String adbLoc, String apkLoc, String slash) {

        // to deploy apk
        List<String> deployCommands = new ArrayList<>();
        ProcessBuilder deployPB = new ProcessBuilder();
        File adbLocFile = new File(adbLoc);
        deployPB.directory(adbLocFile);
        File adb = new File(adbLoc + slash + "adb");

        deployCommands.add(deployPB.directory().getAbsolutePath() + slash + "adb");
        deployCommands.add("install");
        deployCommands.add("-r");
        deployCommands.add(apkLoc);
        deployPB.command(deployCommands);
        System.out.println(deployPB.directory().getAbsolutePath());

        try {
            Process p = deployPB.start();
            p.waitFor();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String s;
            System.out.println(p);
            while ((s = reader.readLine()) != null) {
                System.out.println(s);
            }
            System.out.println("installed?");
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }
}
