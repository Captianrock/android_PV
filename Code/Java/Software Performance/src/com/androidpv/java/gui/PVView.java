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
                    appendNewText("A File Has Been Selected");
                    appendNewText(selectedFile.getAbsolutePath());
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
                    appendNewText("A Directory Has Been Selected");
                    appendNewText(jarDir.getAbsolutePath());
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
                    appendNewText("A SDK Directory Has Been Selected");
                    appendNewText(sdkDir.getAbsolutePath());
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
                    appendNewText("An ADB Directory Has Been Selected");
                    appendNewText(adbDir.getAbsolutePath());
                }
            });

            // Parser Class set to Parse Button
            parseButton.addActionListener(new ActionListener() {
                String outputPathString = new File("").getAbsoluteFile().toString() + "/parseData.txt" ;
                public void actionPerformed(ActionEvent e) {

                    if (getfilePath() == null){
                        appendNewText("Please Choose a file or Directory!");
                    }
                    appendNewText("Parsing now...");
                    Path inputPath = Paths.get(getfilePath());
                    // Handles ".apk" File inputs
                    if (APKParser.isAPK(inputPath)) try {
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
                            System.err.println("Error parseFilesInDir in main: " + except.getMessage());
                            except.printStackTrace();
                        }
                        appendNewText("Done parsing directory!");

                    }
                    fileField.setText("");
                    appendNewText("Methods Placed in: " + new File("").getAbsoluteFile().toString() + "/data.txt");
                    appendNewText("Building module");
                    new ModuleBuilder(outputPathString);
                    appendNewText("Building apk");
                    new APKBuilder(adbDir.getAbsolutePath(), sdkDir.getAbsolutePath());
                }
            });

            // Listens for the data file to be created, checks every 5 seconds
            String FOLDER = System.getProperty("user.dir" + "AndroidTest/build/outputs/apk/");
            final long pollingInterval = 5 * 1000;
            File folder = new File(FOLDER);
            if (!folder.exists()) {
                // Test to see if monitored folder exists
                throw new RuntimeException("Directory not found: " + FOLDER);
            }
            FileAlterationObserver observer = new FileAlterationObserver(folder);
            FileAlterationMonitor monitor =
                    new FileAlterationMonitor(pollingInterval);
            FileAlterationListener listener = new FileAlterationListenerAdaptor() {
                // Is triggered when a file is created in the monitored folder
                @Override
                public void onFileCreate(File file) {
                    // "file" is the reference to the newly created file
                    try { //TODO: Get path to apk
                            System.out.println("File created: "
                                    + file.getCanonicalPath());
                            new DataSubmit();
                            dispose();
                    } catch (IOException e) {
                        e.printStackTrace(System.err);
                    }
                }
            };
            observer.addListener(listener);
            monitor.addObserver(observer);
            try {
                monitor.start();
            } catch (Exception e) {
                e.printStackTrace();
            }

            setExtendedState(JFrame.MAXIMIZED_BOTH);
            setVisible(true);
        });
    }

    // Updates Output text Area on sperate thread to not block EDT
    public void appendNewText (String txt) {
        Thread thread = new Thread(() -> {
            outputArea.append(txt + "\n");
        });
        thread.start();
    }

    public String getfilePath(){
        return ((!selectedFile.getAbsolutePath().isEmpty()? selectedFile.getAbsolutePath() : null ));
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



