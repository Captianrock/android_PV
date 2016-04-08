package com.example.kim.softwareperformance;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import android.preference.PreferenceManager;

public class MainActivity extends AppCompatActivity {
    LogReader logReader;
    StringBuilder stringBuilder;
    @SuppressWarnings("deprecation")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button button = (Button) findViewById(R.id.button);
       // PreferenceManager.setDefaultValues(this, R.xml.settings, false);
      //  SharedPreferences pref = getSharedPreferences("user_settings", MODE_WORLD_READABLE);
      //  SharedPreferences.Editor editor = pref.edit();
       // editor.putString("user_text", "Hello World");
       // SharedPreferences pref = getSharedPreferences("user_settings", Context.MODE_WORLD_READABLE);
       // SharedPreferences.Editor editor = pref.edit();
       // editor.putString("user_text", "Hello World");
       // editor.commit();
       // String text = pref.getString("user_text", "");
       // System.out.println("Returned: " + text);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                stringBuilder = logReader.getLog();
                //System.out.println(stringBuilder.toString());
                generateNoteOnSD("LogCacheNew", stringBuilder.toString());
            }
        });
    }
    public void generateNoteOnSD(String sFileName, String sBody){
        try
        {
            File root = new File(Environment.getExternalStorageDirectory(), "Notes");
            if (!root.exists()) {
                root.mkdirs();
            }
            File gpxfile = new File(root, sFileName);
            FileWriter writer = new FileWriter(gpxfile);
            writer.write(sBody);
            writer.flush();
            writer.close();
            Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

}
