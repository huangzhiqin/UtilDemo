package com.first.alina.utilsdemo.netWorkManager;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkRequest;

/**
 * Created by alina on 2019/4/10.
 */

public class NetWorkManager {
    private static  volatile NetWorkManager netWorkManager;
    private Application application;

    private NetWorkManager() {
    }

    public static NetWorkManager getInstance(){
        if (netWorkManager==null){
            synchronized (NetWorkManager.class){
                if (netWorkManager==null){
                    netWorkManager=new NetWorkManager();
                }
            }
        }
        return netWorkManager;
    }

    public void init(Application application){
        this.application=application;
        ConnectivityManager.NetworkCallback networkCallback=new NetworkCallbackImpl();
        ConnectivityManager manager= (ConnectivityManager) application.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (manager!=null){
            manager.registerNetworkCallback(new NetworkRequest.Builder().build(),networkCallback);
        }
    }

    public Application getApplication(){
        if (application==null){
            throw new RuntimeException("applicaiton !==null");
        }
        return application;
    }
}
