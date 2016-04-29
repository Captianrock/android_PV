package com.androidpv.java.gui;

import com.androidpv.java.codeParser.commandLine;
import com.androidpv.java.database.dataBaseListener;

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
        appField.setText("Enter Application Name");
        dataButton.setVisible(false);
        dataButton.addActionListener(ae ->{
            JOptionPane.showMessageDialog(null,appField.getText());
            if (!dataCheck){
                JOptionPane.showMessageDialog(null,"Please stop the data flow first!");
            }
            else {
                String appname = appField.getText();
                dataBaseListener bd = new dataBaseListener();
                bd.enterToDatabase(uName, appname);
            }

        });

        stopDataBttn.addActionListener(ae ->{
                new commandLine(adbPath);
                dataCheck = true;
                dataButton.setVisible(true);

                }
        );
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
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
