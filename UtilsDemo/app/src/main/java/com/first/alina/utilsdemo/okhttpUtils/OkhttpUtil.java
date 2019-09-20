package com.first.alina.utilsdemo.okhttpUtils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by alina on 2018/12/19.
 */

public class OkhttpUtil {

    public static void getRequest(String url){
        OkHttpClient okHttpClient=new OkHttpClient.Builder().readTimeout(5, TimeUnit.SECONDS).build();
        Request request=new Request.Builder().url(url).get().build();
        okHttpClient.newCall(request).enqueue(new Callback() {
           @Override
           public void onFailure(Call call, IOException e) {

           }

           @Override
           public void onResponse(Call call, Response response) throws IOException {

           }
       });
       // call.enqueue(new OkhttpResponseCallback());
        try {
           Response response= okHttpClient.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
