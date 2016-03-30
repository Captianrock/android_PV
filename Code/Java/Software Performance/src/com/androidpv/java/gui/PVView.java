package com.androidpv.java.gui;
import com.androidpv.java.Parser;
import com.androidpv.java.apkParser.APKParser;
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
    private File selectedFile;

    public PVView(){
        super("File Chooser");
        SwingUtilities.invokeLater(() -> {
            setContentPane(rootPanel);
            pack();
            setDefaultCloseOperation(PVView.EXIT_ON_CLOSE);

            // JFileChooser set to  Directory Button
            dirButton.addActionListener(ae -> {
                JFileChooser fileChooser = new JFileChooser("C:/Users/");
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    selectedFile = fileChooser.getSelectedFile();
                    fileField.setText(selectedFile.getAbsolutePath());
                    appendNewText("A File Has Been Selected");
                    appendNewText(selectedFile.getAbsolutePath());
                }
            });

            // Parser Class set to Parse Button
            parseButton.addActionListener(new ActionListener() {
                String outputPathString = new File("").getAbsoluteFile().toString() + "/data.txt" ;
                public void actionPerformed(ActionEvent e) {
                    appendNewText("Parsing now...");
                    Path inputPath = Paths.get(getfilePath());

                    // Handles ".apk" File inputs
                    if (APKParser.isAPK(inputPath)) try {
                        APKParser.parse(inputPath.toFile());
                        List<File> fileL = Parser.getFiles(new File("").getAbsoluteFile().toString() + "/decompiledSource");
                        Parser.parseFilesInDir(fileL, outputPathString);

                    } catch (JadxException j) {
                        System.err.println("Error JadxException in main: " + j.getMessage());
                        j.printStackTrace();
                    }

                    // Parses Given Directory for Java Files
                    if (inputPath.toFile().isDirectory()){
                        //appendNewText("Parsing Directory NOW");
                        Parser.parse(inputPath.toString(), outputPathString);
                        appendNewText("Done parsing directory!");

                    }
                    fileField.setText("");
                    appendNewText("Methods Placed in: " + new File("").getAbsoluteFile().toString() + "/data.txt");
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

    public static void main(String[] args) {
        PVView pvView = new PVView();
    }


}



