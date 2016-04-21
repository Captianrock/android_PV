package com.androidpv.java.gui;

import com.androidpv.java.codeParser.commandLine;
import com.androidpv.java.database.dataBaseListener;

import javax.swing.*;

/**
 * Created by bradley on 4/8/2016.
 */
public class DataSubmit extends JFrame{
    private JButton backButton;
    private JFormattedTextField usrnameField;
    private JTextField appField;
    private JButton dataButton;
    private JPanel dataPanel;
    private JTextField userField;
    private JButton stopDataBttn;
    private boolean dataCheck = false;

    public DataSubmit(String uName, String adbPath){
            super("Data Submit");
            setContentPane(dataPanel);
            pack();
            setDefaultCloseOperation(DataSubmit.EXIT_ON_CLOSE);

        usrnameField = new JFormattedTextField();
        userField.setText(uName);
        appField = new JFormattedTextField(new String("Enter Application Name"));
        dataButton.setVisible(false);
        dataButton.addActionListener(ae ->{
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
            new PVView(uName);
            dispose();
        });
        setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
