package com.androidpv.java.codeParser;

import com.androidpv.java.gui.DataSubmit;
import com.androidpv.java.xposed.MBConstants;
import com.mysql.fabric.xmlrpc.base.Data;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kim on 4/8/2016.
 */
public class commandLine {

    String adbPath;

    public commandLine(String adbPath ){
        this.adbPath = adbPath;
        this.getLogcat();
        this.buildCleanFile();
    }

    private void getLogcat() {

        String currentDir = System.getProperty("user.dir");

        List<String> deployCommands = new ArrayList<>();
        ProcessBuilder deployPB = new ProcessBuilder();
        File adbLoc = new File(this.adbPath);
        deployPB.directory(adbLoc);
        File adb = new File(this.adbPath+ "/adb");
        if (adb.exists()) {
            System.out.println("trueeeeee");
        }
        File dataFile = new File(MBConstants.DIRTY_FILE);
        if (!dataFile.exists()) {
            try {
                dataFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        dataFile.setWritable(true);
        deployCommands.add(deployPB.directory().getAbsolutePath() + "/adb");
        deployCommands.add("logcat");
        deployCommands.add("-d");
        deployCommands.add("-s");
        deployCommands.add("Xposed");
        deployPB.command(deployCommands);
        System.out.println(deployPB.directory().getAbsolutePath());

        try {
            Process p = deployPB.start();
            System.out.println("done waiting");
            FileWriter fw = new FileWriter(dataFile.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String s;
            while ((s = reader.readLine()) != null) {
                bw.write(s +"\n");
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Logcat will keep hooks from old module between reboots. We need to get data from most recent module.
     * A new module is initialized in logcat with 17 dashes. This happens twice. Example:
     *
     * I/Xposed  ( 1672): -----------------
     * I/Xposed  ( 1672): Added Xposed (/data/data/de.robv.android.xposed.installer/bin/XposedBridge.jar) to CLASSPATH.
     * D/Xposed  ( 1672): Using structure member offsets for mode WITH_JIT
     * I/Xposed  ( 1672): Found Xposed class 'de/robv/android/xposed/XposedBridge', now initializing
     * I/Xposed  ( 1672): -----------------
     *
     * We run through dirty file until we hit 17 dashes twice. Because logcat is cleared after APK is installed, these
     * dash pairs should only occur once in the logcat.
     */
    private void buildCleanFile() {

        try {
            String currentDir = System.getProperty("user.dir");

            BufferedReader reader = new BufferedReader(new FileReader(MBConstants.DIRTY_FILE));
            BufferedWriter writer = new BufferedWriter(new FileWriter(MBConstants.CLEAN_FILE));
            String line;
            int dashesFound = 0;

            while ((line = reader.readLine()) != null) {
                if (line.contains(MBConstants.DASHES)) {
                    dashesFound += 1;
                }
                if (dashesFound == 2) {
                    // we are at the correct logcat section. create clean file
                    writer.write(line + "\n");
                }
            }
            reader.close();
            writer.close();

            if (dashesFound == 0) {
                // won't always appear. Just transfer everything from dirty to clean
                reader = new BufferedReader(new FileReader(MBConstants.DIRTY_FILE));
                writer = new BufferedWriter(new FileWriter(MBConstants.CLEAN_FILE));
                while ((line = reader.readLine()) != null) {
                    writer.write(line + "\n");
                }
                reader.close();
                writer.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    // read through data.txt to make sure everything worked
    public boolean parseData() {
        int methodCount = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(MBConstants.CLEAN_FILE));
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.contains(MBConstants.LOGCAT_SEP)) {
                    if (line.contains("Exception") || line.contains("Error") || line.contains("Throwable")) {
                        DataSubmit.getInstance().updateOutLog(
                                "Detected error. Unable to analyze data.\n\tReproducing error message....\n");
                        // get everything related to the error. Will be everything till next logcat separator
                        while (!line.contains(MBConstants.LOGCAT_SEP)) {
                            DataSubmit.getInstance().updateOutLog(line + "\n");
                            line = reader.readLine();
                        }
                        reader.close();

                        return false;
                    }
                }
                if (line.contains("::")) {
                    methodCount += 1;
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (methodCount == 0) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader("data.txt"));
                String line;

                DataSubmit.getInstance().updateOutLog("Unable to hook any methods. Package name may not be correct.\n" +
                        "Showing loaded package names:\n");

                while ((line = reader.readLine()) != null) {
                    DataSubmit.getInstance().updateOutLog(line + "\n");
                }

                reader.close();

                return false;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return true;
    }


}
