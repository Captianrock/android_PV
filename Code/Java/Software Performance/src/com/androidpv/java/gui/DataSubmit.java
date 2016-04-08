package com.androidpv.java.gui;

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
        backButton.addActionListener(ae -> {
            new PVView();
            dispose();
        });

    }
}
