package com.androidpv.java.gui;

import com.androidpv.java.codeParser.commandLine;
import com.androidpv.java.database.dataBaseListener;
import com.androidpv.java.xposed.APKBuilder;

import javax.swing.*;

/**
 * Created by bradley on 4/8/2016.
 */
public class DataSubmit extends JFrame{
    private JButton backButton;
    private JTextField appField;
    private JButton dataButton;
    private JPanel dataPanel;
    private JTextField userField;
    private JButton stopDataBttn;
    private JTextArea outputArea;
    private boolean dataCheck = false;
    public static volatile DataSubmit instance;

    public DataSubmit(String uName, String adbPath){
        super("Data Submit");
        setContentPane(dataPanel);
        pack();
        setDefaultCloseOperation(DataSubmit.EXIT_ON_CLOSE);
        userField.setText(uName);
        dataButton.setVisible(false);
        dataButton.addActionListener(ae ->{
            if (!dataCheck || appField.getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"Please Enter the Application Name!");
            }
            else {
                String appname = appField.getText();
                dataBaseListener bd = new dataBaseListener();
                bd.enterToDatabase(uName, appname);
            }

        });

        stopDataBttn.addActionListener(ae ->{

            // check that device is still connected
            APKBuilder builder = new APKBuilder();
            boolean ping = builder.tryPing(adbPath);
            if (!ping) {
                JOptionPane.showMessageDialog(null,"Please Connect ADB Device. Data may be\ncorrupted if device was disconnected.");
            }
            else {
                // add check after commandLine to make sure data has no errors
                commandLine cmdLine = new commandLine(adbPath);
                boolean success = cmdLine.parseData();
                if (success) {
                    dataCheck = true;
                    dataButton.setVisible(true);
                    stopDataBttn.setVisible(false);
                }
            }
        });
        // Back button to previous view
        backButton.addActionListener(ae -> {
            PVView.getInstance().setVisible(true);
            dispose();
        });
        setVisible(true);
    }

    public static DataSubmit getInstance() {

        if (instance == null ) {
            synchronized (PVView.class) {
                if (instance == null) {
                    instance = new DataSubmit("User" , "Password");
                }
            }
        }
        return instance;
    }
    public void updateOutLog(String str){
        outputArea.append(str);
        outputArea.append("");
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
