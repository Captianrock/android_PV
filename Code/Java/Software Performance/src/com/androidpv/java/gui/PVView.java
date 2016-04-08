package com.androidpv.java.gui;
import com.androidpv.java.codeParser.Parser;
import com.androidpv.java.apkParser.APKParser;
import com.androidpv.java.xposed.APKBuilder;
import com.androidpv.java.xposed.ModuleBuilder;
import jadx.core.utils.exceptions.JadxException;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
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
    private File selectedFile;
    private File jarDir;
    private String parsedDataOutputPathString;

    public PVView(){
        super("File Chooser");

        parsedDataOutputPathString = new File("").getAbsoluteFile().toString() + "/parseData.txt" ;

        SwingUtilities.invokeLater(() -> {
            setContentPane(rootPanel);
            pack();
            setDefaultCloseOperation(PVView.EXIT_ON_CLOSE);

            // JFileChooser set to  Directory Button
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

            // Parser Class set to Parse Button
            parseButton.addActionListener(new ActionListener() {
                String outputPathString = new File("").getAbsoluteFile().toString() + "/parseData.txt" ;
                public void actionPerformed(ActionEvent e) {


                    if (getfilePath().equals(null)){
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
                    new APKBuilder();
                }
            });

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



