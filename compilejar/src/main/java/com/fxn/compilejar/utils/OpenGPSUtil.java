package com.fxn.compilejar.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.LocationManager;
import android.provider.Settings;

public class OpenGPSUtil {
    /**
     * 判断GPS是否开启，GPS或者AGPS开启一个就认为是开启的
     * @param context
     * @return true 表示开启
     */
    public static final boolean isOPen(final Context context) {
        boolean isOpen;
        LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        isOpen = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        return isOpen;
    }

    /**
     * 强制帮用户打开GPS
     * @param context
     */
    public static final void openGPS(final Activity context, String title, String message) {
        new AlertDialog.Builder(context).setTitle("打开GPS")
                .setMessage("为了定位流畅,请打开GPS")
                //  取消选项
                .setNegativeButton("取消",new DialogInterface.OnClickListener(){

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })
                //  确认选项
                .setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //跳转到手机原生设置页面
                        Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                        context.startActivityForResult(intent,1);
                    }
                })
                .setCancelable(false)
                .show();
    }
}
