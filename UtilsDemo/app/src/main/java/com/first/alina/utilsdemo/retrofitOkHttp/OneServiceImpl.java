package com.first.alina.utilsdemo.retrofitOkHttp;

import com.first.alina.utilsdemo.okhttp.bean.NewBean;
import com.first.alina.utilsdemo.okhttp.bean.OneBean;
import com.first.alina.utilsdemo.retrofitOkHttp.parserjson.JsonListResponseParser;

import retrofit2.Call;

public class OneServiceImpl {

    public static void test(String phone, JsonListResponseParser<NewBean> callback){
       Call<NewBean> call= RetrofitManager.create(true,null,OneService.class).test();
       call.enqueue(new APiCallback(callback));
    }

}
