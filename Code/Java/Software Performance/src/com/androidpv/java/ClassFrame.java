package com.androidpv.java;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Created by bradley on 2/16/2016.
 */
public class ClassFrame extends JFrame {

   // private static final long serialVersionUID = 2451829341034438685L;

    public static JButton inputButton = new JButton("Send");
    public static JTextArea editTextArea = new JTextArea("Type Here!");
    public static JTextArea uneditTextArea = new JTextArea();

// Your String, defined here and usable throughout the class

    String myString;

    public ClassFrame(String title) {

        // Learn to indent your code properly so that it's more readable to both you
        // and others

        //SET LAYOUT MANAGER (How it arranges components)
        setLayout(new BorderLayout());
        //////CREATE SWING COMPONENTS////////////
        //OUTPUT TEXT AREA
        uneditTextArea.setEditable(false);

        //INPUT TEXT AREA
        editTextArea.setBackground(Color.BLUE);
        editTextArea.setForeground(Color.WHITE);

        //SET CONTENT PANE
        Container c = getContentPane();

        //ADD COMPONENTS TO CONTENT PANE
        c.add(uneditTextArea, BorderLayout.CENTER);
        c.add(editTextArea, BorderLayout.NORTH);
        c.add(inputButton, BorderLayout.SOUTH);

        ClassFrame.inputButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                // Using the class field myString to receive text from text area
                myString = editTextArea.getText();

                // Do this instead.  An empty string is a more clear indication of what's going on
                editTextArea.setText("");
                uneditTextArea.setText(myString);
                //TODO: Handle the string given an input
                System.out.println("This is my input String :D..... " + myString);
                //TODO: Print list of methods to text area
            }
        });
    }
}
