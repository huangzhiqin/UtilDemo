package com.first.alina.utilsdemo.retrofitOkHttp;

import com.bumptech.glide.load.model.ByteArrayLoader;
import com.first.alina.utilsdemo.retrofitOkHttp.parserjson.StringDefaultAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

public class StringConvertFactory extends Converter.Factory {
    private Gson gson;

    public StringConvertFactory(Gson gson) {
        if (gson==null){
            throw new NullPointerException("Gson==null");
        }
       /* gson=new GsonBuilder()
                .registerTypeAdapter(String.class,new StringDefaultAdapter())
                .create();*/
        this.gson = gson;
    }

    @Override
    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {
        TypeAdapter<?> adapter=gson.getAdapter(TypeToken.get(type));
        return new RequestBodyConvert<>(gson,adapter);
    }

    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        if (type == String.class){
            new StringConverter();
        }
        return null;
    }

}
