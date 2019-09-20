package com.first.alina.utilsdemo.main.bean;

import android.support.annotation.NonNull;
import android.util.Log;

/**
 * Created by alina on 2019/4/28.
 */

public class ReflectionBean implements Comparable{
    private String TAG="ReflectionBean";
    private String str;

    public ReflectionBean() {
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
        Log.e(TAG,"=====> "+this.str);
    }

    @Override
    public int compareTo(@NonNull Object o) {
        return 0;
    }
}
