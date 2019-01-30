package com.first.alina.utilsdemo.okhttpUtils;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by alina on 2018/12/19.
 */

public abstract class abstactJsonResponseHandler extends ResponseHandler{

    public abstract IResult preProcess(Call call, Response response);

    @Override
    public void postProcess(IResult result) {
        switch (result.type()){
            case IResult.SUCCESS:
                success();
                break;
            case IResult.NETERROR:
                netWorkFail();
                break;
            case IResult.JSONPARSEERROR:
                jsonParseFail();
                break;
            case IResult.NOKNOW:
                noKonwFial();
                break;
            default:
                fail();
                break;
        }

    }

    protected abstract void fail();

    protected abstract void netWorkFail();

    protected abstract void noKonwFial();

    protected abstract void jsonParseFail();

    protected abstract void success();


}
