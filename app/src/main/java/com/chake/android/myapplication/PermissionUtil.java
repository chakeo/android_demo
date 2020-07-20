package com.chake.android.myapplication;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class PermissionUtil {

    public static void requestPermission(Activity context,String permission){
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(context, new String[]{permission}, 1);
        }
    }

    public static boolean checkPermission(Activity context,String permission){
        boolean b = ContextCompat.checkSelfPermission(context, permission)
                == PackageManager.PERMISSION_GRANTED;
        return b;
    }
}
