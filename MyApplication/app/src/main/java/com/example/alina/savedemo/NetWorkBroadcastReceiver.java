package com.example.alina.savedemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.example.alina.savedemo.common.utils.NetworkUtils;

/**
 * Created by alina on 2018/3/17.
 */

public class NetWorkBroadcastReceiver extends BroadcastReceiver{
    private final String TAG="NetWorkReceiver";
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e(TAG,"==>NetWorkBroadcastReceiver onReceive");
        if (NetworkUtils.isWifi(context)){
            Log.e(TAG,"==> wifi已连接");
            Intent intent1=new Intent(context,DownLoadAdService.class);
            context.startService(intent1);
        }else {
            Intent intent2=new Intent(context,DownLoadAdService.class);
            intent2.putExtra("stop",true);
            context.stopService(intent2);
            Log.e(TAG,"==>wifi 已断开 ");
        }
    }
}
