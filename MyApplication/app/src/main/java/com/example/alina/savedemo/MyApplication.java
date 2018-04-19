package com.example.alina.savedemo;

import android.app.Application;
import android.content.IntentFilter;

import com.liulishuo.filedownloader.FileDownloader;

/**
 * Created by alina on 2018/3/18.
 */

public class MyApplication extends Application{



    @Override
    public void onCreate() {
        super.onCreate();
        FileDownloader.setupOnApplicationOnCreate(this);

    }

}
