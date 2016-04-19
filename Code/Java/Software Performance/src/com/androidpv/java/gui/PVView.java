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
                    outputArea.append("A File Has Been Selected\n");
                    outputArea.append(selectedFile.getAbsolutePath() + "\n");
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
                }
            });

            // Parser Class set to Parse Button
            parseButton.addActionListener(new ActionListener() {
                String outputPathString = new File("").getAbsoluteFile().toString() + "/parseData.txt" ;
                public void actionPerformed(ActionEvent e) {

                    if (getfilePath() == null){
                        outputArea.append("Please Choose a file or Directory!\n");
                    }

                    // Handles ".apk" File inputs
                    else if (APKParser.isAPK(Paths.get(getfilePath()))) {
                        try {
                            Path inputPath = Paths.get(getfilePath());
                            outputArea.append("Parsing now...");
                            APKParser.parse(inputPath.toFile());
                            List<File> fileL = Parser.getFiles(new File("").getAbsoluteFile().toString() + "/decompiledSource");
                            Parser.parseFilesInDir(fileL, outputPathString,adbDir.getAbsolutePath(), sdkDir.getAbsolutePath());
                            try {
                                Thread.sleep(6000); //1000 milliseconds is one second.
                                new DataSubmit();
                                dispose();
                            } catch(InterruptedException ex) {
                                Thread.currentThread().interrupt();
                            }
                        } catch (JadxException j) {
                            System.err.println("Error JadxException in main: " + j.getMessage());
                            j.printStackTrace();
                        }
                    }

                    // Parses Given Directory for Java Files
                   else if (Paths.get(getfilePath()).toFile().isDirectory()){
                        Path inputPath = Paths.get(getfilePath());
                        List<File> fileL = Parser.getFiles(inputPath.toFile().toString());
                        try {
                            Parser.parseFilesInDir(fileL, outputPathString,adbDir.getAbsolutePath(), sdkDir.getAbsolutePath());
                            if (jarDir != null) {
                                Parser.parseFilesInDir(fileL, outputPathString, jarDir.getAbsolutePath());
                            }
                            else {
                                Parser.parseFilesInDir(fileL, outputPathString, null);
                            }
                        } catch (Exception except) {
                            outputArea.append("Error parseFilesInDir in main: " + except.getMessage());
                            except.printStackTrace();
                        }
                        outputArea.append("Done parsing directory!");
                        outputArea.append("Building module");
                        try {
                            Thread.sleep(6000); //1000 milliseconds is one second.
                            new DataSubmit();
                            dispose();
                        } catch(InterruptedException ex) {
                            Thread.currentThread().interrupt();
                        }
                    }

                    else{
                        JOptionPane.showMessageDialog(null,"Something went wrong! Please make sure all paths are correct!");
                    }
                    //fileField.setText("");
                    //outputArea.append("Methods Placed in: " + new File("").getAbsoluteFile().toString() + "/data.txt");
                    //outputArea.append("Building module");

                    // new ModuleBuilder(outputPathString);

                   // outputArea.append("Building apk");
                   // new APKBuilder(adbDir.getAbsolutePath(), sdkDir.getAbsolutePath());
                   // outputArea.append("APK has ben build");

                }
            });


            setExtendedState(JFrame.MAXIMIZED_BOTH);
            setVisible(true);
        });
    }

    public void updateOutLog(String str){
        outputArea.append(str);
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
    public File getJarDir() {
        return jarDir;
    }

    public void setJarDir(File jarDir) {
        this.jarDir = jarDir;
    }

    public File getSdkDir() {
        return sdkDir;
    }

    public void setSdkDir(File sdkDir) {
        this.sdkDir = sdkDir;
    }

    public File getAdbDir() {
        return adbDir;
    }

    public void setAdbDir(File adbDir) {
        this.adbDir = adbDir;
    }

    public static void main(String[] args) {
        PVView pvView = new PVView();
    }
}



