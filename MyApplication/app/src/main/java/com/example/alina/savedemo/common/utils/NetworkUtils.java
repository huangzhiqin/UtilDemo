package com.example.alina.savedemo.common.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by alina on 2018/3/17.
 */

public class NetworkUtils {
/**
 * 判断当前网络是否是wifi网络
 * if(activeNetInfo.getType()==ConnectivityManager.TYPE_MOBILE) { //判断3G网
 *
 * @param context
 * @return boolean
 */
public static boolean isWifi(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context
        .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetInfo != null
        && activeNetInfo.getType() == ConnectivityManager.TYPE_WIFI) {
        return true;
        }
        return false;
        }

/**
 * 判断当前网络是否是3G网络
 *
 * @param context
 * @return boolean
 */
public static boolean is3G(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context
        .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetInfo != null
        && activeNetInfo.getType() == ConnectivityManager.TYPE_MOBILE) {
        return true;
        }
        return false;
        }

public static NetworkInfo currentActiveNetworkInfo(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context
        .getSystemService(Context.CONNECTIVITY_SERVICE);
        return connectivityManager.getActiveNetworkInfo();
        }


public static boolean isNetWorkAvailable(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context
        .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm == null) {
        return false;
        }
        NetworkInfo ni = cm.getActiveNetworkInfo();
        if (ni == null || !ni.isAvailable()) {
        return false;
        }
        return true;
        }
        }
