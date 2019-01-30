package com.first.alina.utilsdemo;

import android.app.Application;

import com.first.alina.utilsdemo.common.utils.activityliftcycle.DemoActivityLifecycleCallbacks;
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
    /* MyApplication application= (MyApplication) getApplication();
       application.demoActivityLifecycleCallbacks.count()*/
    @Override
    public void onCreate() {
        super.onCreate();
        FileDownloader.setupOnApplicationOnCreate(this);
        registerActivityLifecycleCallbacks(demoActivityLifecycleCallbacks);//通过activity声明周期，判断当前activity存活状态
        initQiyu();

    }

    private void initQiyu() {
        // appKey 可以在七鱼管理系统->设置->APP接入 页面找到
        Unicorn.init(this, "18e3048008eb409001a6ba895aa6eaba", ysfOptions(), new GlideImageLoader(this));
    }

    private YSFOptions ysfOptions() {
        YSFOptions options = new YSFOptions();
        options.statusBarNotificationConfig = new StatusBarNotificationConfig();
       /* options.statusBarNotificationConfig.notificationSmallIconId = R.drawable.ic_status_bar_notifier;
        options.onBotEventListener = new OnBotEventListener() {
            @Override
            public boolean onUrlClick(Context context, String url) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                context.startActivity(intent);
                return true;
            }
        };*/
        // DemoCache.ysfOptions = options;
        return options;
    }
}
