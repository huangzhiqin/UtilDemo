package com.first.alina.utilsdemo.thread_demo;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.first.alina.utilsdemo.R;

import java.util.concurrent.Callable;

/**
 * Created by alina on 2019/4/16.
 */

public class ThreadDemoActivity extends Activity{
    private final String TAG="ThreadDemoActivity";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_demo);
        new MyThread().start();
        MyThreadRunnable myThreadRunnable=new MyThreadRunnable();
        new Thread(myThreadRunnable).start();

    }

    private class MyThread extends Thread{
        @Override
        public void run() {
            super.run();
            Log.e(TAG,"===>name="+currentThread().getName());
        }
    }

    private class MyThreadRunnable implements Runnable{
        @Override
        public void run() {
            Log.e(TAG,"===>name="+Thread.currentThread().getName());
        }
    }

    private class MyCallableThread implements Callable{

        @Override
        public Object call() throws Exception {
            return null;
        }
    }
}
