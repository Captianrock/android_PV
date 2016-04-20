package com.androidpv.java.xposed;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Erin on 4/7/16.
 */
public class APKBuilder {

    public APKBuilder(String adbLoc, String sdkLoc) {

        String currentDir = System.getProperty(MBConstants.USER_DIR);

        try {
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(currentDir + MBConstants.ANDROID_TEST_DIR + "/local.properties")));
            writer.println("sdk.dir = " + sdkLoc);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // to build apk
        List<String> commandsList = new ArrayList<>();
        ProcessBuilder pb = new ProcessBuilder();
        File wd = new File(currentDir + MBConstants.ANDROID_TEST_DIR);
        pb.directory(wd);
        File f = new File(currentDir + MBConstants.ANDROID_TEST_DIR + "/gradlew");
        if (f.exists()) {
            System.out.println("trueeeeee");
        }
        commandsList.add(pb.directory().getAbsolutePath() + "/gradlew");
        commandsList.add("build");

        List<String> makeAPK = new ArrayList<>();
        makeAPK.add(pb.directory().getAbsolutePath() + "/gradlew");
        makeAPK.add("assembleDebug");
        pb.command(commandsList);
        System.out.println(pb.directory().getAbsolutePath());

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
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        // to deploy apk
        List<String> deployCommands = new ArrayList<>();
        ProcessBuilder deployPB = new ProcessBuilder();
        File adbLocFile = new File(adbLoc);
        deployPB.directory(adbLocFile);
        File adb = new File(adbLoc + "/adb");
        if (adb.exists()) {
            System.out.println("trueeeeee");
        }
        deployCommands.add(deployPB.directory().getAbsolutePath() + "/adb");
        deployCommands.add("install");
        deployCommands.add("-r");
        deployCommands.add(currentDir + MBConstants.ANDROID_TEST_DIR + "/build/outputs/apk/AndroidTest-debug.apk");
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
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
