package com.first.alina.utilsdemo.common.utils.activityliftcycle;

import android.app.Activity;

/**
 * Created by alina on 2018/4/23.
 */

public interface ActivityLiftInterface {
    int count();//当前已存活的activity总数

    boolean foreGround();//当前app是否处于前台

    Activity currentActivity();//最后一个压入栈的activity

    void clearActivity();//清除整个activity

}
