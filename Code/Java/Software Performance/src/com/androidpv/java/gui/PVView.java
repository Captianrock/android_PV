package com.androidpv.java.gui;
import com.androidpv.java.xposed.ModuleBuilder;
import javafx.scene.input.MouseEvent;
import org.jetbrains.annotations.Nullable;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;

/**
 * Created by bradley on 3/21/2016.
 */
public final class PVView extends JFrame {
    private JPanel rootPanel;
    private JTextField fileField;
    private JButton dirButton;
    private JButton parseButton;
    private JTextArea outputArea;
    private JTextField apkField;
    private JButton apkButton;
    private JTextField sdkField;
    private JButton sdkButton;
    private JTextField adbField;
    private JButton adbButton;
    private JScrollPane scrollPane;
    private JLabel packLabel;
    private File selectedFile;
    private File apk;
    private File sdkDir;
    private File adbDir;
    private String parsedDataOutputPathString;
    private static String usrName;
    public static volatile PVView instance;

   public PVView(String uName) {
        super("Directory Parser");
        this.usrName = uName;
        parsedDataOutputPathString = new File("").getAbsoluteFile().toString() + "/parseData.txt" ;
        SwingUtilities.invokeLater(() -> {
            setContentPane(rootPanel);
            pack();
            setDefaultCloseOperation(PVView.EXIT_ON_CLOSE);

            // JFileChooser set to Directory Button
//            dirButton.addActionListener(ae -> {
//                JFileChooser fileChooser = new JFileChooser("C:/Users/");
//                fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
//                fileChooser.setAcceptAllFileFilterUsed(false);
//                int returnValue = fileChooser.showOpenDialog(null);
//                if (returnValue == JFileChooser.APPROVE_OPTION) {
//                    selectedFile = fileChooser.getSelectedFile();
//                    fileField.setText(selectedFile.getAbsolutePath());
//                    outputArea.append("A File Has Been Selected\n");
//                    outputArea.append(selectedFile.getAbsolutePath() + "\n");
//                    outputArea.append("");
//                }
//            });

            // JFileChooser for APK
            final int[] clicks = {0};
            apkButton.addActionListener((ActionEvent ae) -> {
                Object source = ae.getSource();
                if(source == apkButton){
                    if(clicks[0] %2 == 0){
                        JFileChooser fileChooser = new JFileChooser("C:/Users/");
                        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                        fileChooser.setAcceptAllFileFilterUsed(false);
                        int returnValue = fileChooser.showOpenDialog(null);
                        if (returnValue == JFileChooser.APPROVE_OPTION) {
                            apk = fileChooser.getSelectedFile();
                            apkField.setText(apk.getAbsolutePath());
                            outputArea.append("Apk Has Been Selected\n");
                            outputArea.append(apk.getAbsolutePath() + "\n");
                            outputArea.append("");
                        };
                        apkButton.setText("Clear Apk");
                    }
                    if(clicks[0] %2 == 1){
                        apkField.setText(null);
                        apkButton.setText("Install Apk");
                    }
                    System.out.println(clicks[0]);
                    clicks[0]++;
                }

            });

            // JFileChooser for SDK Directory
            sdkButton.addActionListener(ae -> {
                JFileChooser fileChooser = new JFileChooser("C:/Users/");
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                fileChooser.setAcceptAllFileFilterUsed(false);
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    sdkDir = fileChooser.getSelectedFile();
                    sdkField.setText(sdkDir.getAbsolutePath());
                    outputArea.append("A SDK Directory Has Been Selected\n");
                    outputArea.append(sdkDir.getAbsolutePath() + "\n");
                    outputArea.append("");
                }
            });

            // JFileCHooser for ADB Directory
            adbButton.addActionListener(ae -> {
                JFileChooser fileChooser = new JFileChooser("C:/Users/");
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                fileChooser.setAcceptAllFileFilterUsed(false);
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    adbDir = fileChooser.getSelectedFile();
                    adbField.setText(adbDir.getAbsolutePath());
                    outputArea.append("An ADB Directory Has Been Selected\n");
                    outputArea.append(adbDir.getAbsolutePath() + "\n");
                    outputArea.append("");
                }
            });

            // Parser Class set to Parse Button
            parseButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                   // updateOutLog(fileField.getText());

                    if (getfileField().equals("") || adbDir == null || sdkDir == null  ){
                        outputArea.append("Please complete the file fields!\n");
                        outputArea.append("");
                    }
                    // Parses Given Directory for Java Files
                   else {

                        String apkString = "";
                        if (apk != null) {
                            apkString = apk.getAbsolutePath();
                        }

                        new ModuleBuilder(getfileField(), apkString, adbDir.getAbsolutePath(), sdkDir.getAbsolutePath(), uName, adbDir.toString());
                    }
                }
            });

            //setExtendedState(JFrame.MAXIMIZED_BOTH);
            setVisible(true);
        });
    }

    public static PVView getInstance() {

        if (instance == null ) {
            synchronized (PVView.class) {
                if (instance == null) {
                    instance = new PVView(usrName);
                }
            }
        }
        return instance;
    }
    public void updateOutLog(String str){
        outputArea.append(str);
    }


    @Nullable
    public String getfilePath(){
        return ((selectedFile == null ? null: selectedFile.getAbsolutePath()));
    }

    @Nullable
    public String get(){
        return ((!apk.getAbsolutePath().isEmpty()? apk.getAbsolutePath() : null ));
    }

    public String getfileField() {
        return fileField.getText();
    }
}



