package com.first.alina.utilsdemo;

import android.app.Application;

import com.liulishuo.filedownloader.FileDownloader;

/**
 * Created by alina on 2018/3/18.
 */

public class MyApplication extends Application {



    @Override
    public void onCreate() {
        super.onCreate();
        FileDownloader.setupOnApplicationOnCreate(this);

    }

}
