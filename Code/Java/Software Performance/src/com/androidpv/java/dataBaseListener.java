package com.androidpv.java;

import java.sql.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by kim on 3/4/2016.
 */
public class dataBaseListener {

    public dataBaseListener(){
        String url = "jdbc:mysql://localhost:3306/methodexec";
        String username = "root";
        String password = "";
        Statement stmt;
        ResultSet rs;
        String oldFileName = "data.txt";
        BufferedReader br = null;
        BufferedWriter bw = null;
        System.out.println("Connecting database...");
        System.out.println("Working Directory = " +
                System.getProperty("user.dir"));

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Database connected!");
           try{
               stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                       ResultSet.CONCUR_UPDATABLE);
               rs = stmt.executeQuery("SELECT * FROM times");
               long dup = 0;
               if(rs.last()){
                   dup = rs.getLong(3);
               }
               try {
                   br = new BufferedReader(new FileReader(oldFileName));
                   String line;
                   String[] splitline;
                   HashMap<String,String> stack = new HashMap<>();
                   while ((line = br.readLine()) != null) {
                       splitline = line.split("::");
                       String[] temp = splitline[0].split(" ");
                       String currentName = temp[temp.length - 1];
                       if(splitline.length == 3){
                           if(stack.containsKey(currentName)){
                              // System.out.println(dup);
                               if( Long.parseLong(splitline[2]) > dup){
                                   rs.moveToInsertRow();
                                   rs.updateString(1, currentName);
                                   rs.updateLong(2, Long.parseLong(stack.get(currentName)));
                                   rs.updateLong(3, Long.parseLong(splitline[2]));
                                   rs.insertRow();
                                   rs.moveToCurrentRow();
                                   stack.remove(currentName);
                               }
                           }
                           else{
                               stack.put(currentName,splitline[2]);
                           }
                       }
                   }
                   System.out.println("Completed!");
               } catch (Exception e) {
                   System.out.println("Error: " + e.getMessage());
                   return;
               } finally {
                   try {
                       if(br != null)
                           br.close();
                   } catch (IOException e) {
                       //
                   }
                   try {
                       if(bw != null)
                           bw.close();
                   } catch (IOException e) {
                       //
                   }
               }

           }
           catch (SQLException e){
               System.out.println("SQLException: " + e.getMessage());
               System.out.println("SQLState: " + e.getSQLState());
               System.out.println("VendorError: " + e.getErrorCode());
           }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
            throw new IllegalStateException("Cannot connect the database!", e);
        }
    }
}
