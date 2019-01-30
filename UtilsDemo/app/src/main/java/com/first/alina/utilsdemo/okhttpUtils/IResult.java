package com.first.alina.utilsdemo.okhttpUtils;

/**
 * Created by alina on 2018/12/19.
 */

public interface IResult {
    int NOKNOW=-1;//未知的错误
    int SUCCESS=0;
    int NETERROR=1;
    int JSONPARSEERROR=2;

    int type();

}
