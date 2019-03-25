package com.first.alina.utilsdemo.utils;

import android.content.Context;

/**
 * Created by alina on 2019/2/28.
 */

public class SingleInstance {
    private static volatile SingleInstance instance;

    private SingleInstance() {
    }

    public static SingleInstance getInstance(Context context){
        if (instance==null){
            synchronized (SingleInstance.class){
                if (instance==null){
                    instance=new SingleInstance();
                }
            }
        }
        return instance;
    }

    public void get(){

    }
}
