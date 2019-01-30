package com.first.alina.utilsdemo.okhttpUtils;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by alina on 2018/12/19.
 */

public class OkhttpResponseCallback implements Callback{

    private ResponseHandler responseHandler;

    public OkhttpResponseCallback(ResponseHandler responseHandler) {
        this.responseHandler = responseHandler;
    }

    @Override
    public void onFailure(Call call, IOException e) {
        NetWorkErrorResult netWorkErrorResult=new NetWorkErrorResult();
        netWorkErrorResult.url=call.request().url().toString();
        netWorkErrorResult.exception=e;
        responseHandler.postProcess(netWorkErrorResult);

    }

    @Override
    public void onResponse(Call call, Response response) throws IOException {
       //if (response)
    }
}
