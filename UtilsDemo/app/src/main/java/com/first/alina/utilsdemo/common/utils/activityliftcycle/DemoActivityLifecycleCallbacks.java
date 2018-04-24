package com.first.alina.utilsdemo.common.utils.activityliftcycle;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alina on 2018/4/23.
 */

public class DemoActivityLifecycleCallbacks implements Application.ActivityLifecycleCallbacks,ActivityLiftInterface{
    private String TAG="ActivityLifecycle";
    private List<Activity> countActivitys=new ArrayList<>();//总的activity
    private List<Activity> resumeActivity=new ArrayList<>();//当前可见activity
    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        countActivitys.add(activity);
        Log.e(TAG,"==> onActivityCreated "+activity.getClass().getName());

    }

    @Override
    public void onActivityStarted(Activity activity) {

    }

    @Override
    public void onActivityResumed(Activity activity) {
        resumeActivity.add(activity);

    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {
        Log.e(TAG,"==> onActivityDestroyed "+activity.getClass().getName());
        if (countActivitys!=null){
            if (countActivitys.contains(activity)){
                countActivitys.remove(activity);
            }
        }
        if (resumeActivity!=null){
            if (resumeActivity.contains(activity)){
                resumeActivity.remove(activity);
            }
        }

    }

    @Override
    public int count() {
        return countActivitys.size();
    }

    @Override
    public boolean foreGround() {
        return countActivitys.size()>0;
    }

    @Override
    public Activity currentActivity() {
        return countActivitys.size()>0?countActivitys.get(countActivitys.size()-1):null;
    }

    @Override
    public void clearActivity() {
        if (countActivitys!=null){
            countActivitys.clear();
        }
        if (resumeActivity!=null){
            resumeActivity.clear();
        }
    }
}
