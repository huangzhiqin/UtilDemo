package com.example.alina.savedemo;

import android.app.IntentService;
import android.content.Intent;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.alina.savedemo.common.utils.DownLoadUtil;

import java.io.File;

/**
 * Created by alina on 2018/3/17.
 */

public class DownLoadAdService extends IntentService{
    private final String TAG="DownLoadAdService";
    private String url;
    private DownLoadUtil downLoadUtil;
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public DownLoadAdService(String name) {
        super(name);
    }

    public DownLoadAdService() {
        super("download");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        boolean sdcarkExist=Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
        if (sdcarkExist){
            url=Environment.getExternalStorageDirectory().getAbsolutePath()+ File.separator+"text";
            downLoadUtil=new DownLoadUtil();
            downLoadUtil.downLoad(Constant.URLS,url);
            Log.e(TAG,"==>down url  "+url);
        }
        if (intent.getBooleanExtra("stop",false)){
            downLoadUtil.onPauseAll();
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
