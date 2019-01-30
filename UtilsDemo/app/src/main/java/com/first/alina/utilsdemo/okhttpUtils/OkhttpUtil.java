package com.first.alina.utilsdemo.okhttpUtils;

import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by alina on 2018/12/19.
 */

public class OkhttpUtil {

    public static void getRequest(String url){
        OkHttpClient okHttpClient=new OkHttpClient.Builder().readTimeout(5, TimeUnit.SECONDS).build();
        Request request=new Request.Builder().url(url).get().build();
        Call call=okHttpClient.newCall(request);
       // call.enqueue(new OkhttpResponseCallback());
    }
}
