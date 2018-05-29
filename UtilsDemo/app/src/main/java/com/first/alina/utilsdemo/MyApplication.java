package com.first.alina.utilsdemo;

import android.app.Application;

import com.first.alina.utilsdemo.common.utils.activityliftcycle.DemoActivityLifecycleCallbacks;
import com.liulishuo.filedownloader.FileDownloader;

/**
 * Created by alina on 2018/3/18.
 */

public class MyApplication extends Application {
    private static String TAG="MyApplication";
    public DemoActivityLifecycleCallbacks demoActivityLifecycleCallbacks=new DemoActivityLifecycleCallbacks();
    /* MyApplication application= (MyApplication) getApplication();
       application.demoActivityLifecycleCallbacks.count()*/
    @Override
    public void onCreate() {
        super.onCreate();
        FileDownloader.setupOnApplicationOnCreate(this);
        registerActivityLifecycleCallbacks(demoActivityLifecycleCallbacks);//通过activity声明周期，判断当前activity存活状态
    }
}
