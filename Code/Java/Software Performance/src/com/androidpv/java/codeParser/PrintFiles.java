package com.androidpv.java.codeParser;
/**
 * Created by bradley on 2/15/2016.
 */

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.FileVisitResult.*;

public  class PrintFiles extends SimpleFileVisitor<Path> {
    List<File> fileL = new ArrayList<File>();
    // Print information about
    // each type of file.
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attr) {
        String ext = GetFileExtension.getFileExtension(file.toFile());
        if (ext.equals("java")) {
            // Adds file object to the list
            fileL.add(file.toFile());
        }
        //System.out.println("(" + attr.size() + "bytes)");
        return CONTINUE;
    }
    // Print each directory visited.
    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) {
        //System.out.format("Directory: %s%n", dir);
        return CONTINUE;
    }

    // If there is some error accessing
    // the file, let the user know.
    // If you don't override this method
    // and an error occurs, an IOException
    // is thrown.
    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) {
        System.err.println(exc);
        return CONTINUE;
    }

    public List<File> getFileL() {
        return fileL;
    }
}

