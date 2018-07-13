package com.first.alina.utilsdemo.common.utils;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.view.View;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by alina on 2018/7/13.
 */

public class ScreenShot {

    public static Bitmap takeScreenShot(Activity activity){
      View view= activity.getWindow().getDecorView();
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        Bitmap bitmap=view.getDrawingCache();
        //获取状态栏高度
        Rect rect=new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int statusHeight=rect.top;

        //获取屏幕长和高
        int width=activity.getWindowManager().getDefaultDisplay().getWidth();
        int height=activity.getWindowManager().getDefaultDisplay().getHeight();

        Bitmap cutBitmap;
        if (statusHeight>0){
            cutBitmap=Bitmap.createBitmap(bitmap,0,statusHeight,width,height-statusHeight);
        }else {
            cutBitmap=bitmap;
        }
        view.destroyDrawingCache();
        return cutBitmap;
    }

    private static void savePic(Bitmap bitmap, File filePath){
        FileOutputStream fileOutputStream=null;
        try {
            fileOutputStream=new FileOutputStream(filePath);
            if (null!=fileOutputStream){
                bitmap.compress(Bitmap.CompressFormat.JPEG,100,fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void shoot(Activity activity,String filePath,String fileName){
        if (filePath==null){
            return;
        }

        File file=new File(filePath,fileName);
        if (!file.exists()){
            file.mkdirs();
        }
        savePic(takeScreenShot(activity),file);
    }
}
