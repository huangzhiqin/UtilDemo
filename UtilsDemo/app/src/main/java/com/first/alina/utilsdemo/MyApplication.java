package com.first.alina.utilsdemo;

import android.app.Application;

import com.first.alina.utilsdemo.common.utils.activityliftcycle.DemoActivityLifecycleCallbacks;
import com.first.alina.utilsdemo.netWorkManager.NetWorkManager;
import com.first.alina.utilsdemo.textas.GlideImageLoader;
import com.liulishuo.filedownloader.FileDownloader;
import com.qiyukf.unicorn.api.StatusBarNotificationConfig;
import com.qiyukf.unicorn.api.Unicorn;
import com.qiyukf.unicorn.api.YSFOptions;

/**
 * Created by alina on 2018/3/18.
 */

public class MyApplication extends Application {
    private static String TAG="MyApplication";
    public DemoActivityLifecycleCallbacks demoActivityLifecycleCallbacks=new DemoActivityLifecycleCallbacks();
    @Override
    public void onCreate() {
        super.onCreate();
        FileDownloader.setupOnApplicationOnCreate(this);
        registerActivityLifecycleCallbacks(demoActivityLifecycleCallbacks);//通过activity声明周期，判断当前activity存活状态
        NetWorkManager.getInstance().init(this);

    }
}
