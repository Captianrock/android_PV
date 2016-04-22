package com.androidpv.java.gui;
import com.androidpv.java.codeParser.Parser;
import com.androidpv.java.apkParser.APKParser;
import com.androidpv.java.xposed.APKBuilder;
import com.androidpv.java.xposed.ModuleBuilder;
import jadx.core.utils.exceptions.JadxException;
import org.apache.commons.io.monitor.FileAlterationListener;
import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
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
    private JTextField jarField;
    private JButton jarButton;
    private JTextField sdkField;
    private JButton sdkButton;
    private JTextField adbField;
    private JButton adbButton;
    private File selectedFile;
    private File jarDir;
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
            dirButton.addActionListener(ae -> {
                JFileChooser fileChooser = new JFileChooser("C:/Users/");
                fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                fileChooser.setAcceptAllFileFilterUsed(false);
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    selectedFile = fileChooser.getSelectedFile();
                    fileField.setText(selectedFile.getAbsolutePath());
                    outputArea.append("A File Has Been Selected\n");
                    outputArea.append(selectedFile.getAbsolutePath() + "\n");
                    outputArea.append("");
                }
            });

            // JFileChooser for Jar Files Directory
            jarButton.addActionListener(ae -> {
                JFileChooser fileChooser = new JFileChooser("C:/Users/");
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                fileChooser.setAcceptAllFileFilterUsed(false);
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    jarDir = fileChooser.getSelectedFile();
                    jarField.setText(jarDir.getAbsolutePath());
                    outputArea.append("A Directory Has Been Selected\n");
                    outputArea.append(jarDir.getAbsolutePath() + "\n");
                    outputArea.append("");
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
                String outputPathString = new File("").getAbsoluteFile().toString() + "/parseData.txt" ;
                public void actionPerformed(ActionEvent e) {

                    if (getfilePath() == null || adbDir == null || sdkDir == null || jarDir == null  ){
                        outputArea.append("Please complete the file fields!\n");
                        outputArea.append("");
                    }

                    // Handles ".apk" File inputs
                    else if (APKParser.isAPK(Paths.get(getfilePath())) && adbDir.isDirectory() && sdkDir.isDirectory() && jarDir.isDirectory()) {
                        try {
                            Path inputPath = Paths.get(getfilePath());
                            outputArea.append("Parsing now...");
                            outputArea.append("");
                            APKParser.parse(inputPath.toFile());
                            List<File> fileL = Parser.getFiles(new File("").getAbsoluteFile().toString() + "/decompiledSource");
                            Parser.parseFilesInDir(fileL, outputPathString, jarDir.getAbsolutePath(), adbDir.getAbsolutePath(), sdkDir.getAbsolutePath(), uName, adbDir.toString());

                            //TODO: Create button to switch to SubmitData
                            int reply = JOptionPane.showConfirmDialog(null, "Your APK is ready, would you like to switch views ", "Submit View", JOptionPane.OK_OPTION);
                            if (reply == JOptionPane.OK_OPTION) {
                                new DataSubmit(uName,adbDir.toString());
                            }
                            else {
                                JOptionPane.showMessageDialog(null, "Okay");
                            }

                        } catch (JadxException j) {
                            System.err.println("Error JadxException in main: " + j.getMessage());
                            j.printStackTrace();
                        }
                    }

                    // Parses Given Directory for Java Files
                   else if (Paths.get(getfilePath()).toFile().isDirectory() && adbDir.isDirectory() && sdkDir.isDirectory() && jarDir.isDirectory()){
                        Path inputPath = Paths.get(getfilePath());
                        List<File> fileL = Parser.getFiles(inputPath.toFile().toString());
                        try {
                            if (jarDir != null) {
                                outputArea.append("#########################################################\n");
                                outputArea.append("");
                                outputArea.append("Parsing now...\n");
                                outputArea.append("");
                                Parser.parseFilesInDir(fileL, outputPathString, jarDir.getAbsolutePath(), adbDir.getAbsolutePath(), sdkDir.getAbsolutePath(), uName, adbDir.toString());
                            }
                            else {
                                outputArea.append("#########################################################\n");
                                outputArea.append("");
                                outputArea.append("Parsing now...\n");
                                outputArea.append("");
                                Parser.parseFilesInDir(fileL, outputPathString, null, adbDir.getAbsolutePath(), sdkDir.getAbsolutePath(), uName, adbDir.toString());
                            }
                        } catch (Exception except) {
                            outputArea.append("Error parseFilesInDir in main: " + except.getMessage());
                            except.printStackTrace();
                        }
                    }

                else {
                        JOptionPane.showMessageDialog(null,"Something went wrong! Please make sure all paths are correct!");
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

    public Path getsrcPath(){
        Path srcPath = null;
        JFileChooser fileChooser = new JFileChooser("C:/Users/");
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.setAcceptAllFileFilterUsed(false);
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION){
            srcPath=  fileChooser.getSelectedFile().toPath();
        }
        return srcPath;
    }

    public String getfilePath(){
        return ((selectedFile == null ? null: selectedFile.getAbsolutePath()));
    }

    public String getJars(){
        return ((!jarDir.getAbsolutePath().isEmpty()? jarDir.getAbsolutePath() : null ));
    }

    public String getOutputPathString() {
        return parsedDataOutputPathString;
    }
}



