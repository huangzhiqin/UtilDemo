package com.first.alina.utilsdemo.okhttpUtils;

/**
 * Created by alina on 2018/12/19.
 */

public class NetWorkErrorResult extends ErrorResult{

    public String url;
    public Exception exception;

    @Override
    public int type() {
        return NETERROR;
    }
}
