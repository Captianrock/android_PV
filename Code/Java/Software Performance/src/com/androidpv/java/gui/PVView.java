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
public class PVView extends JFrame {
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

    public PVView() {
        super("File Chooser");

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
                    outputArea.append("A File Has Been Selected");
                    outputArea.append(selectedFile.getAbsolutePath());
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
                    outputArea.append("A Directory Has Been Selected");
                    outputArea.append(jarDir.getAbsolutePath());
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
                    outputArea.append("A SDK Directory Has Been Selected");
                    outputArea.append(sdkDir.getAbsolutePath());
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
                    outputArea.append("An ADB Directory Has Been Selected");
                    outputArea.append(adbDir.getAbsolutePath());
                }
            });

            // Parser Class set to Parse Button
            parseButton.addActionListener(new ActionListener() {
                String outputPathString = new File("").getAbsoluteFile().toString() + "/parseData.txt" ;
                public void actionPerformed(ActionEvent e) {

                    if (getfilePath() == null){
                        outputArea.append("Please Choose a file or Directory!");
                    }

                    Path inputPath = Paths.get(getfilePath());
                    // Handles ".apk" File inputs
                    if (APKParser.isAPK(inputPath)) try {
                        outputArea.append("Parsing now...");
                        APKParser.parse(inputPath.toFile());
                        List<File> fileL = Parser.getFiles(new File("").getAbsoluteFile().toString() + "/decompiledSource");
                        Parser.parseFilesInDir(fileL, outputPathString);
                        }
                    catch (JadxException j) {
                        System.err.println("Error JadxException in main: " + j.getMessage());
                        j.printStackTrace();
                    }

                    // Parses Given Directory for Java Files
                    if (inputPath.toFile().isDirectory()){
                        List<File> fileL = Parser.getFiles(inputPath.toFile().toString());
                        try {
                            Parser.parseFilesInDir(fileL, outputPathString);
                        } catch (Exception except) {
                            outputArea.append("Error parseFilesInDir in main: " + except.getMessage());
                            except.printStackTrace();
                        }
                        outputArea.append("Done parsing directory!");

                    }
                    fileField.setText("");
                    outputArea.append("Methods Placed in: " + new File("").getAbsoluteFile().toString() + "/data.txt");
                    outputArea.append("Building module");

                    new ModuleBuilder(outputPathString);
                    outputArea.append("Building apk");

                    new APKBuilder(adbDir.getAbsolutePath(), sdkDir.getAbsolutePath());
                    outputArea.append("APK has ben build");

                    try {
                        Thread.sleep(6000); //1000 milliseconds is one second.
                        new DataSubmit();
                        dispose();
                    } catch(InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                }
            });


            setExtendedState(JFrame.MAXIMIZED_BOTH);
            setVisible(true);
        });
    }

    // Updates Output text Area on sperate thread to not block EDT

    public String getfilePath(){
        return ((selectedFile == null ? null: selectedFile.getAbsolutePath()));
    }
    public String getJars(){
        return ((!jarDir.getAbsolutePath().isEmpty()? jarDir.getAbsolutePath() : null ));
    }

    public String getOutputPathString() {
        return parsedDataOutputPathString;
    }

    public static void main(String[] args) {
        PVView pvView = new PVView();
    }
}



