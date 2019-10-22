package com.first.alina.utilsdemo.retrofitOkHttp;

import android.util.Log;

import com.first.alina.utilsdemo.retrofitOkHttp.parserjson.BaseResponseParser;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class APiCallback implements Callback {
    public static final String TAG="APiCallback";
    private BaseResponseParser baseResponseParser;

    public APiCallback(BaseResponseParser baseResponseParser) {
        this.baseResponseParser = baseResponseParser;
    }


    @Override
    public void onResponse(Call call, Response response) {
        if (response.isSuccessful()){
            baseResponseParser.onParserJson(call,response);
        }else {
            baseResponseParser.onRequestFail(response.code(),response.message());
        }

    }

    @Override
    public void onFailure(Call call, Throwable t) {
        Log.e(TAG, "==============> onFailure " + t.toString());
        baseResponseParser.onParserFail(HttpCode.NO_KNOWN_CODE,t.toString());
    }


}
