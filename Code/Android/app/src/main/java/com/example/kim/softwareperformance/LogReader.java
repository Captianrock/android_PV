package com.example.kim.softwareperformance;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class LogReader {

    private static final String TAG = LogReader.class.getCanonicalName();
    private static final String processId = Integer.toString(android.os.Process
            .myPid());

    public static StringBuilder getLog() {

        Process process = null;
        try {
            process = Runtime.getRuntime().exec("logcat -d *:I");
            process.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(process.getInputStream()));

        StringBuilder log=new StringBuilder();
        String line = "";
        try {
            while ((line = bufferedReader.readLine()) != null) {
                log.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return log;
    }
}
