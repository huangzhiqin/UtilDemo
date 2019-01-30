package com.first.alina.utilsdemo.okhttpUtils;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by alina on 2018/12/19.
 */

public abstract class ResponseHandler {

    public abstract IResult preProcess(Call call, Response response);

    public abstract void postProcess(IResult result);
}
