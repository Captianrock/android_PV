package com.androidpv.java.gui;

import com.androidpv.java.database.dataBaseListener;

import javax.print.DocFlavor;
import javax.swing.*;

/**
 * Created by bradley on 4/8/2016.
 */
public class DataSubmit extends JFrame{
    private JButton backButton;
    private JFormattedTextField usrnameField;
    private JFormattedTextField appField;
    private JButton dataButton;
    private JPanel panel;

    public DataSubmit(){
        SwingUtilities.invokeLater(() -> {
            setContentPane(panel);
            pack();
            setDefaultCloseOperation(DataSubmit.EXIT_ON_CLOSE);

            // Back button to previous view

    });}

    private void createUIComponents() {
        // TODO: place custom component creation code here
        usrnameField = new JFormattedTextField(new String("Enter User Name"));
        appField = new JFormattedTextField(new String("Enter Application Name"));

        dataButton.addActionListener(ae ->{
            //TODO: Get create button to get data from android device and submit data to database
            String username = usrnameField.getValue().toString();
            String appname = appField.getValue().toString();

            dataBaseListener bd = new dataBaseListener();
            bd.enterToDatabase();

        });

        backButton.addActionListener(ae -> {
            new PVView();
            dispose();
        });



    }
}
