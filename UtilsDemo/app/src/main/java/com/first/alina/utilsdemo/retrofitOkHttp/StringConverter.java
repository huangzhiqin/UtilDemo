package com.first.alina.utilsdemo.retrofitOkHttp;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Converter;

public class StringConverter implements   Converter<ResponseBody, String> {
    private final String TAG = "ResponseConverter";

    public StringConverter() {
    }

    @Override
    public String convert(ResponseBody value) throws IOException {

    return value.string();
}
}
