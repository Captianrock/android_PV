package com.androidpv.java.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Created by bradley on 2/16/2016.
 */
public class PVGUI {

    private String inputPath;
    private String outputPath;
    private boolean buttonPressed;


    public PVGUI() {
        buttonPressed = false;
    }

    public void createGUI() {

        JTextField inputField = new JTextField();
        JTextField outputField = new JTextField();

        JFrame window = new JFrame("Android Performance Visualization");

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                // get text from input fields
                inputPath = inputField.getText();
                outputPath = outputField.getText();

                System.out.println("input string: " + inputPath);
                System.out.println("output string: " + outputPath);

                buttonPressed = true;

                // closes the window once program ends
                window.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                window.dispatchEvent(new WindowEvent(window, WindowEvent.WINDOW_CLOSING));
            }
        });

        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Input Path"));
        inputPanel.add(inputField);

        JLabel inputLabel = new JLabel("Input Path");
        JLabel outputLabel = new JLabel("Output Path");

        JPanel content = new JPanel();
        content.setLayout(new BorderLayout());

        JPanel textFieldsContent = new JPanel();
        GroupLayout layout = new GroupLayout(textFieldsContent);
        textFieldsContent.setLayout(layout);

        // setting to true creates gaps between components
        layout.setAutoCreateGaps(true);
        // setting to true creates gaps between components and edge of container
        layout.setAutoCreateContainerGaps(true);

        // horizontal axis
        GroupLayout.SequentialGroup horizontalGroup = layout.createSequentialGroup();
        // each sequential group contains two parallel groups.
        //  one will contain labels, other will contain text fields
        horizontalGroup.addGroup(layout.createParallelGroup()
                .addComponent(inputLabel).addComponent(outputLabel));
        horizontalGroup.addGroup(layout.createParallelGroup()
                .addComponent(inputField).addComponent(outputField));
        layout.setHorizontalGroup(horizontalGroup);

        // vertical axis
        GroupLayout.SequentialGroup verticalGroup = layout.createSequentialGroup();
        verticalGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(inputLabel).addComponent(inputField));
        verticalGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(outputLabel).addComponent(outputField));
        layout.setVerticalGroup(verticalGroup);

        content.add(textFieldsContent, BorderLayout.CENTER);
        content.add(submitButton, BorderLayout.PAGE_END);

        window.setContentPane(content);
        window.setSize(350, 200);
        window.setLocation(100, 100);
        window.setVisible(true);
    }

    public String getInputPath() {
        return inputPath;
    }

    public String getOutputPath() {
        return outputPath;
    }

    public boolean returnButtonPressed() {
        return buttonPressed;
    }

}
