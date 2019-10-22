package com.first.alina.utilsdemo.retrofitOkHttp;

import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RetrofitManager {

    private static OkHttpClient okHttpClient;

    private static OkHttpClient  getOkHttpClient(){
        if (okHttpClient==null){
            synchronized (RetrofitManager.class){
                if (okHttpClient==null){
                    okHttpClient=new OkHttpClient.Builder()
                    .build();
                }
            }
        }
        return okHttpClient;
    }

    public static<T> T create(boolean isBasePath1,String basePath,Class<T> tClass){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(isBasePath1?HttpConfig.basePath1:basePath)
                .client(getOkHttpClient())
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(new HttpGsonConvertFactory(new Gson()))
                .build();
        return retrofit.create(tClass);
    }


}
