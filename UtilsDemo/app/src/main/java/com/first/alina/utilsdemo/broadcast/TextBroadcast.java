package com.first.alina.utilsdemo.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by alina on 2018/11/19.
 */

public class TextBroadcast extends BroadcastReceiver{
    private final String TAG="TextBroadcast";
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e(TAG,"==>开启广播 ");

    }
}
