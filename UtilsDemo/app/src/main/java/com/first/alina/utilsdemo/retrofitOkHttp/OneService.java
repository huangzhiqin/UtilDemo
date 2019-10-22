package com.first.alina.utilsdemo.retrofitOkHttp;

import com.first.alina.utilsdemo.okhttp.bean.NewBean;
import com.first.alina.utilsdemo.okhttp.bean.OneBean;
import com.first.alina.utilsdemo.retrofitOkHttp.bean.ArrayBean;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface OneService {

    @GET("getSingleJoke")
    Call<NewBean> test();
}
