package com.first.alina.utilsdemo.thread_demo;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import com.first.alina.utilsdemo.R;
import com.first.alina.utilsdemo.thread_demo.executorservice.SingleThreadExecutor;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by alina on 2019/4/16.
 */

public class ThreadDemoActivity extends Activity {
    private final String TAG = "ThreadDemoActivity";
    private MyAsyncTask myAsyncTask;
    private ScheduledExecutorService scheduledExecutorService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_demo);
        new MyThread().start();
        MyThreadRunnable myThreadRunnable = new MyThreadRunnable();
        new Thread(myThreadRunnable).start();
        MyCallableThread myCallableThread = new MyCallableThread();
        FutureTask<Integer> futureTask = new FutureTask<Integer>(myCallableThread);
        futureTask.cancel(true);
        new Thread(futureTask).start();


        //new MyAsyncTask("AsyncTask1").executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,"01");
        //new MyAsyncTask("AsyncTask2").executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,"02");

        myAsyncTask = new MyAsyncTask("AsyncTask1");
        //myAsyncTask.execute("01");
        // new MyAsyncTask("AsyncTask2").execute("02");

        findViewById(R.id.start_aysnctask).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //myAsyncTask.execute("01");
                newSingleThreadScheduledExecutor();
            }
        });

        findViewById(R.id.close_aysnctask).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //myAsyncTask.cancel(true);
                scheduledExecutorService.shutdown();
            }
        });


    }

    private class MyThread extends Thread {
        @Override
        public void run() {
            super.run();
            Log.e(TAG, "===>name=" + currentThread().getName());
        }

    }

    private class MyThreadRunnable implements Runnable {
        @Override
        public void run() {
            Log.e(TAG, "===>name=" + Thread.currentThread().getName());
        }
    }

    private class MyCallableThread implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            return 2;
        }
    }

    private class MyAsyncTask extends AsyncTask<String, Integer, String> {
        private String name;
        private volatile boolean isCanceled;

        private MyAsyncTask(String name) {
            this.name = name;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... params) {
            for (int i = 0; i < 100000; i++) {
                if (isCancelled()) {
                    Log.e(TAG, "============> doInBackground 取消");
                    break;
                }
            }
            return params[0];
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            Log.e(TAG, "============> onProgressUpdate " + values[0]);

        }

        @Override
        protected void onCancelled(String s) {
            super.onCancelled(s);
            Log.e(TAG, "============> 取消 " + s);
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
            Log.e(TAG, "============> 取消 ");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "===========>取消 onDestroy");
        myAsyncTask.cancel(true);
    }

    private void newSingleThreadScheduledExecutor(){
          scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
          scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                Log.e(TAG,"===========> "+Thread.currentThread().getName()+"   ");
            }
        },0,2,TimeUnit.SECONDS);

    }
}
