package com.first.alina.utilsdemo.common.utils;

import android.content.Context;
import android.os.Environment;

import java.io.File;

/**
 * Created by alina on 2018/4/8.
 */

public class CacheUtil {
    public static String getDiskCacheDir(Context context) {
        String cachePath;
        //Environment.getExtemalStorageState() 获取SDcard的状态   Environment.MEDIA_MOUNTED 手机装有SDCard,并且可以进行读写
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())
                || !Environment.isExternalStorageRemovable()) {
            if(context.getExternalCacheDir()!=null){
                cachePath = context.getExternalCacheDir().getPath();
            }else {
                cachePath = context.getCacheDir().getPath();
            }
        } else {
            cachePath = context.getCacheDir().getPath();
        }
        return cachePath;
    }

    public static String getAdvertPath(Context context){
        // return CommonUtils.getDiskCacheDir(context)+ File.separator+ Constants.ADVERTPATH;
        return Environment.getExternalStorageDirectory().getAbsolutePath()+ File.separator+ "textss";
    }
}
