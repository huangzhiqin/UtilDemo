package com.first.alina.utilsdemo.brocastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by alina on 2019/5/29.
 */

public class MyBroadcastReceiver extends BroadcastReceiver{
    private String TAG="MyBroadcastReceiver";
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e(TAG,"=============>fd "+Thread.currentThread().getName());
        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.e(TAG,"=============> "+Thread.currentThread().getName());
            }
        }).start();

    }
}
