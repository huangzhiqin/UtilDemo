package com.first.alina.utilsdemo.retrofitOkHttp.parserjson;



import retrofit2.Call;
import retrofit2.Response;

public abstract class BaseResponseParser {
    public abstract void onParserJson(Call call, Response response);

    public void onRequestFail(int error,String msg){

    }
    public void onParserFail(int error,String msg){

    }




}
