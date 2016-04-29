package com.androidpv.java.codeParser;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kim on 4/8/2016.
 */
public class commandLine {
    public commandLine(String adbPath ){
        String currentDir = System.getProperty("user.dir");

        List<String> deployCommands = new ArrayList<>();
        ProcessBuilder deployPB = new ProcessBuilder();
        File adbLoc = new File(adbPath);
        deployPB.directory(adbLoc);
        File adb = new File(adbPath+ "/adb");
        if (adb.exists()) {
            System.out.println("trueeeeee");
        }
        File dataFile = new File(currentDir + "/data.txt");
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
}
