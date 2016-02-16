package com.androidpv.java;

/**
 * Created by bradley on 2/15/2016.
 */
import java.io.File;

public class GetFileExtension {

    /**
     * Get File extension in java
     * @param args
     */
    public static void main(String[] args) {
        File file = new File("/Users/pankaj/java.txt");
        System.out.println("File extension is: "+getFileExtension(file));
        //file name without extension
        file = new File("/Users/pankaj/temp");
        System.out.println("File extension is: "+getFileExtension(file));
        //file name with dot
        file = new File("/Users/pankaj/java.util.txt");
        System.out.println("File extension is: "+getFileExtension(file));
        //hidden files without extension
        file = new File("/Users/pankaj/.htaccess");
        System.out.println("File extension is: "+getFileExtension(file));
    }

    public static String getFileExtension(File file) {
        String fileName = file.getName();
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
            return fileName.substring(fileName.lastIndexOf(".")+1);
        else return "";
    }

}