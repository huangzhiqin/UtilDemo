package com.example.alina.savedemo.common.utils;

import android.util.Log;

import com.liulishuo.filedownloader.BaseDownloadTask;
import com.liulishuo.filedownloader.FileDownloadListener;
import com.liulishuo.filedownloader.FileDownloadQueueSet;
import com.liulishuo.filedownloader.FileDownloader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alina on 2018/3/18.
 */

public class DownLoadUtil {
    private final String TAG="DownLoadUtil";
    private String mFileName;

    public DownLoadUtil() {
    }

    public void downLoad(String [] urls,String path){
        FileDownloadListener parleTarget=createListener();
        List<BaseDownloadTask> taskList=new ArrayList<>();
        for (String url: urls){
            taskList.add(FileDownloader.getImpl().create(url));
            Log.e(TAG,"==> downLoad "+url);
        }
        FileDownloadQueueSet fileDownloadQueueSet= new FileDownloadQueueSet(parleTarget);
        fileDownloadQueueSet.setCallbackProgressTimes(1);
        fileDownloadQueueSet.downloadTogether(taskList);
        fileDownloadQueueSet.setDirectory(path);

        fileDownloadQueueSet.setWifiRequired(true);
        fileDownloadQueueSet.start();
    }


    public void onPauseAll(){
       FileDownloader.getImpl().pauseAll();
        Log.e(TAG,"==> onPauseAll");
    }

    public void onPause(int id){
        FileDownloader.getImpl().pause(id);
    }
    private FileDownloadListener createListener(){
        return new FileDownloadListener(){

            @Override
            protected void pending(BaseDownloadTask task, int soFarBytes, int totalBytes) {
                Log.e(TAG,"==>pending ");

            }

            @Override
            protected void progress(BaseDownloadTask task, int soFarBytes, int totalBytes) {
                Log.e(TAG,"==>progress soFarBytes "+soFarBytes+" totalBytes "+totalBytes);
            }

            @Override
            protected void completed(BaseDownloadTask task) {
                Log.e(TAG,"==>completed ");
            }

            @Override
            protected void paused(BaseDownloadTask task, int soFarBytes, int totalBytes) {
                Log.e(TAG,"==>paused ");
            }

            @Override
            protected void error(BaseDownloadTask task, Throwable e) {
                Log.e(TAG,"==>error "+e.getMessage());
            }

            @Override
            protected void warn(BaseDownloadTask task) {

            }
        };
    }
}
