package com.chake.android.myapplication;

import android.os.Environment;

import java.io.File;

public class FileUtil {

    private static String sFolder = "audio";

    public static String getDirPath(String fileName){
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if(externalStorageDirectory == null){
            return null;
        }
        String path = externalStorageDirectory.toString() + "/" + sFolder +"/";
        File directory = new File(path);
        if (!directory.isDirectory()) {
            if (!directory.mkdirs()) {
                return null;
            }
        }
        return path+fileName;
    }

    public static boolean isFileExist(String path){
        File file = new File(path);
        return file.exists();
    }


}
