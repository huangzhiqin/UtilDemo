package com.first.alina.utilsdemo.retrofitOkHttp;

public interface HttpResultCallback<T> {
    void success(Object t);
    void error(Object object);
    void end();
}
