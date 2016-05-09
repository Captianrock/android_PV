package com.androidpv.java.database;

import com.androidpv.java.gui.DataSubmit;
import com.androidpv.java.xposed.MBConstants;

import javax.swing.*;
import java.io.*;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Date;
import java.security.MessageDigest;

/**
 * Created by kim on 3/4/2016.
 */
public class dataBaseListener {
    private Connection connection;

    public dataBaseListener(){

    }
    public static String getMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean addtoMembership(String username, String password){
        Statement stmt;
        String sql;
        String url = "jdbc:mysql://localhost:3306/membership";
        String usernames = "root";
        String passwords = "";
        try (Connection connection = DriverManager.getConnection(url, usernames, passwords)) {
            System.out.println("Database connected!");
            try {
                System.out.println("Inserting member into the table...");
                stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);
                sql = " insert into users (id,username, password)"
                        + " values (?, ?, ?)";
                PreparedStatement preparedStmt = connection.prepareStatement(sql);
                preparedStmt.setString (1, "0");
                preparedStmt.setString (2, username);
                preparedStmt.setString (3, getMD5(password));
                preparedStmt.execute();
                System.out.println("Member added to the table!");
                return true;
            }
            catch(SQLException e){
                System.out.println("SQLException: " + e.getMessage());
                System.out.println("SQLState: " + e.getSQLState());
                System.out.println("VendorError: " + e.getErrorCode());
                return false;
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
            return false;
        }
    }
    public boolean checkMembership(String username, String password){
        Statement stmt;
        ResultSet rs;
        BufferedReader br = null;
        String url = "jdbc:mysql://localhost:3306/membership";
        String usernames = "root";
        String passwords = "";
        try (Connection connection = DriverManager.getConnection(url, usernames, passwords)) {
            System.out.println("Database connected!");
            try {
                stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);
                rs = stmt.executeQuery("SELECT * FROM users WHERE username = '" + username + "' and password = '" + getMD5(password) + "'");
                if (!rs.isBeforeFirst()) {
                    System.out.println("Not a member!");
                    return false;
                }
                return true;
            }
            catch(SQLException e){
                System.out.println("SQLException: " + e.getMessage());
                System.out.println("SQLState: " + e.getSQLState());
                System.out.println("VendorError: " + e.getErrorCode());
                return false;
            }

        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
            JOptionPane.showMessageDialog(null,"Cannot connect the database! Please consult your System Admin");
            //throw new IllegalStateException("Cannot connect the database!", e);
            return false;

        }
    }

    public void enterToDatabase(String uName, String appName){
        Statement stmt;
        ResultSet rs;
        ResultSet userRs;
        String oldFileName = "data.txt";
        BufferedReader br = null;
        BufferedWriter bw = null;
        DataSubmit ds = DataSubmit.instance;

        String url = "jdbc:mysql://localhost:3306/membership";
        String username = "root";
        String password = "";
        //Working values
        String currentUser = uName;
        String application = appName;

        DateFormat df = new SimpleDateFormat("dd/MM/yy-HH:mm:ss");
        Date dateobj = new Date();
        //System.out.println(df.format(dateobj));

        String traceId = currentUser + application  + df.format(dateobj); //TODO: Get current date as traceid

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Database connected!");
            try{
                stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);
                userRs = stmt.executeQuery("SELECT * FROM applications WHERE username = '" + currentUser + "' and application = '" + application+"'");
                if (!userRs.isBeforeFirst() ) {
                    System.out.println("No data in applications");
                    userRs.moveToInsertRow();
                    userRs.updateString(2,currentUser);
                    userRs.updateString(3,application);
                    userRs.insertRow();
                    userRs.moveToCurrentRow();
                }
                stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);
                userRs = stmt.executeQuery("SELECT * FROM traces WHERE traceId = '"+traceId+"'");
                if (!userRs.isBeforeFirst() ) {
                    System.out.println("No data in traces");
                    userRs.moveToInsertRow();
                    userRs.updateString(2,currentUser);
                    userRs.updateString(3,application);
                    userRs.updateString(4,traceId);
                    userRs.insertRow();
                    userRs.moveToCurrentRow();
                }
                stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);
                rs = stmt.executeQuery("SELECT * FROM data WHERE traceId = '"+traceId+"'");
                if(rs.isBeforeFirst()){
                    System.out.println("Data already exists in traces");
                }
                else {
                    // Enter data into database
                    try {
                        System.out.println("Inputting to database");
                        rs = stmt.executeQuery("SELECT * FROM data");

                        br = new BufferedReader(new FileReader(oldFileName));
                        String line;
                        String[] splitline;
                        HashMap<String, ArrayList<String>> stack = new HashMap<>();
                        while ((line = br.readLine()) != null) {
                            splitline = line.split("::");
                            if (splitline.length == 4) {
                                String[] temp = splitline[0].split(" ");
                                String methodName = splitline[1];
                                String packageName = temp[temp.length - 1].substring(MBConstants.LOGCAT_SEP.length());
                                String currentName = packageName + "." + methodName;
                                if (stack.containsKey(currentName)) {
                                    if (splitline[2].equals("methodStart")) {
                                        stack.get(currentName).add(splitline[3]);
                                    } else {
                                        rs.moveToInsertRow();
                                        rs.updateString(2, traceId);
                                        rs.updateString(3, methodName);
                                        rs.updateLong(4, Long.parseLong(stack.get(currentName).remove(0)));
                                        rs.updateLong(5, Long.parseLong(splitline[3]));
                                        rs.updateString(6, packageName);
                                        rs.insertRow();
                                        rs.moveToCurrentRow();
                                        if (stack.get(currentName).size() == 0) {
                                            stack.remove(currentName);
                                        }
                                    }
                                } else {
                                    stack.put(currentName, new ArrayList<String>());
                                    stack.get(currentName).add(splitline[3]);
                                }
                            }
                        }
                        System.out.println("Completed!");
                        ds.updateOutLog("Data Successfully pushed to Database");
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                        JOptionPane.showMessageDialog(null,"Something went wrong submitting the Data! Please try again!");
                        return;
                    } finally {
                        try {
                            if (br != null)
                                br.close();
                                File file = new File(oldFileName);
                                file.deleteOnExit();
                        } catch (IOException e) {
                            //
                        }
                        try {
                            if (bw != null)
                                bw.close();
                        } catch (IOException e) {
                            //
                        }
                    }
                }

            }
            catch (SQLException e){
                System.out.println("SQLException: " + e.getMessage());
                System.out.println("SQLState: " + e.getSQLState());
                System.out.println("VendorError: " + e.getErrorCode());
                JOptionPane.showMessageDialog(null,"Something went wrong submitting the Data! Please try again!");
            }

        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
            JOptionPane.showMessageDialog(null,"Cannot connect the database! Please consult your System Admin");
            throw new IllegalStateException("Cannot connect the database!", e);

        }
    }
}
