package com.first.alina.utilsdemo.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

/**
 * Created by alina on 2019/9/20.
 */

public class MarketUtils {
    public static String TAG = "";

    //跳转到应用商店
    public static void toMarket(Activity activity, String packageName) {
        try {
            Uri uri = Uri.parse("market://details?id=" + packageName);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            //intent.setPackage("com.tencent.android.qqdownloader");
            activity.startActivity(intent);

        } catch (Exception e) {
            Toast.makeText(activity, "你还没有安装应用市场", Toast.LENGTH_SHORT).show();
        }

    }

    //跳转到华为应用商店
    public static void toHuaweiMarket(Activity activity, String packageName) {
        try {
            Uri uri = Uri.parse("market://details?id=" + packageName);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setPackage("com.huawei.appmarket");
            activity.startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(activity, "你还没有安装应用市场", Toast.LENGTH_SHORT).show();
        }

    }


    private static void hasBroswer(Context context, Intent intent) {
        PackageManager packageManager = context.getPackageManager();
        List<ResolveInfo> resolveInfos = packageManager.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
        for (ResolveInfo resolveInfo : resolveInfos) {
            Log.e(TAG, "==> hasBroswer " + resolveInfo.activityInfo.packageName + " activityName=" + resolveInfo.activityInfo.name);
        }
    }
}
