package com.androidpv.java.gui;

/**
 * Created by bradley on 4/18/2016.
 */
import com.androidpv.java.database.dataBaseListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class NewUser extends JFrame {
    JButton create;
    JButton backBttn;
    JPanel newUserPanel;
    JTextField usernmae;
    JTextField password;
    JLabel unLabel;
    JLabel pwLabel;


    public NewUser(){
        super("Registration");
        create = new JButton("Create");
        backBttn = new JButton("Back");
        newUserPanel = new JPanel();
        usernmae = new JTextField(15);
        password = new JPasswordField(15);
        unLabel = new JLabel("Username:");
        pwLabel = new JLabel("Password:");

        setSize(300,200);
        setLocation(500,280);
        newUserPanel.setLayout (null);


        usernmae.setBounds(70,30,150,20);
        password.setBounds(70,65,150,20);
        create.setBounds(110,100,80,20);
        backBttn.setBounds(110,140,80,20);
        unLabel.setBounds(5,28,80,20);
        pwLabel.setBounds(5,63,80,20);


        newUserPanel.add(create);
        newUserPanel.add(backBttn);
        newUserPanel.add(usernmae);
        newUserPanel.add(password);
        newUserPanel.add(unLabel);
        newUserPanel.add(pwLabel);
        usernmae.setText("");
        password.setText("");


        getContentPane().add(newUserPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        dataBaseListener db = new dataBaseListener();

        create.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(usernmae.getText().isEmpty() && password.getText().isEmpty() || usernmae.getText().isEmpty() || password.getText().isEmpty() ){
                    JOptionPane.showMessageDialog(null,"Please insert Username and Password");
                }

                else if(db.checkMembership(usernmae.getText() , password.getText())) {
                    JOptionPane.showMessageDialog(null,"Username is already in use");
                    usernmae.setText("");
                    password.setText("");
                    usernmae.requestFocus();
                }

                else {
                    JPasswordField pf = new JPasswordField();
                    JOptionPane.showConfirmDialog(null, pf, "Confirm Password", JOptionPane.OK_OPTION, JOptionPane.PLAIN_MESSAGE);
                        String pw = new String(pf.getPassword());
                        System.err.println("You entered: " + pw);
                    if (pw.equals(password.getText()) && db.addtoMembership(usernmae.getText(), password.getText())) {
                        JOptionPane.showMessageDialog(null, "Account has been created.");
                        dispose();
                        new LoginGui();
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Something went wrong, please try again!");
                    }
                }

            }
        });
        backBttn.addActionListener(ae ->{
            new LoginGui();
            dispose();
        });
    }
}