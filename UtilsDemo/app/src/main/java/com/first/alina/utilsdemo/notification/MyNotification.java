package com.first.alina.utilsdemo.notification;

import android.content.Intent;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.first.alina.utilsdemo.common.Contant;
import com.first.alina.utilsdemo.utils.SharePrefsUtils;

/**
 * Created by alina on 2019/5/29.
 */

public class MyNotification extends NotificationListenerService{
    private final String TAG="MyNotification";
    private SharePrefsUtils sharePrefsUtils=new SharePrefsUtils(this, Contant.NOTIFICATION_KEY);
    private StringBuilder stringBuilder=new StringBuilder();
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent!=null){
            Log.e(TAG,"========>onStartCommand "+intent.getStringExtra("data"));
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onNotificationPosted(StatusBarNotification sbn) {
        super.onNotificationPosted(sbn);
        if (sbn!=null&&sbn.getNotification()!=null&&sbn.getNotification().tickerText!=null){
            String title= sbn.getNotification().tickerText.toString();
            String packName=sbn.getPackageName();
            if (!TextUtils.isEmpty(title)){
                String str=sharePrefsUtils.getString(Contant.NOTIFICATION_SAVE_KEY,"");
                if (!TextUtils.isEmpty(str)){
                    stringBuilder.append(str).append("\n").append("\n").append("\n").append(packName).append("\n");
                }
                stringBuilder.append(title);
                sharePrefsUtils.setString(Contant.NOTIFICATION_SAVE_KEY,stringBuilder.toString());

                Toast.makeText(this,title,Toast.LENGTH_LONG).show();
                Log.e(TAG,"========> onNotificationPosted title="+title+" sbn.getPackageName()="+packName);
            }
            Log.e(TAG,"========> haha onNotificationPosted title="+title);
        }


    }
}
