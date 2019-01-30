package com.first.alina.utilsdemo.okhttpUtils;

/**
 * Created by alina on 2018/12/19.
 */

public class JsonParseErrorResult extends ErrorResult{
    @Override
    public int type() {
        return JSONPARSEERROR;
    }
}
