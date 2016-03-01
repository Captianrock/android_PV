package com.androidpv.java.apkParser;
import com.androidpv.java.GetFileExtension;
import jadx.api.JadxDecompiler;
import jadx.core.utils.exceptions.JadxException;
import java.io.File;
import java.nio.file.Path;


/**
 * Created by bradley on 2/27/2016.
 */
public class APKParser {

    public static void main(String[] args) throws JadxException {
        File f = new File (new File("").getAbsoluteFile().toString() + "/src/BBCNews.apk");
        if (isAPK(f.toPath())){
            parse(f);
            System.out.println(f + " Is an APK File");
        }
    }
    public static boolean isAPK (Path p){
        String ext = GetFileExtension.getFileExtension(p.toFile());
        if (ext.equals("apk")) {return true;}
        else {return false;}

    }
    public static void parse(File f) throws JadxException {
        JadxDecompiler jadx = new JadxDecompiler();
        jadx.loadFile(f);
        jadx.setOutputDir(new File("decompiledSource"));
        jadx.save();
    }
}