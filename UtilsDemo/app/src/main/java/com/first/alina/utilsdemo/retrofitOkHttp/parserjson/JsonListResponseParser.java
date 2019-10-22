package com.first.alina.utilsdemo.retrofitOkHttp.parserjson;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;


public abstract class JsonListResponseParser<T> extends BaseResponseParser {
    public static final String TAG="JsonListResponseParser";

    @SuppressWarnings("unchecked")
    @Override
    public void onParserJson(Call call, Response response) {

       Object object= response.body();
        String result=new Gson().toJson(response.body());
       /* result="[ \n" +
                "                  { \n" +
                "                \"is_online\": 1, \"user_name\": \"guanghui.li\",\"birthday\": \"2014-10-21\" },\n" +
                "                  {\n" +
                "                \"is_online\": 1,\"user_name\": \"111\",\"birthday\": \"2015-09-07\" } \n" +
                "                 ]";*/
        Log.e(TAG, "==============> onResponse " +" "+call.request().url()+"\n"+result);
       if (object!=null){
           Class<T> tClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
           Gson gson = new Gson();
           JsonElement jsonElement = new JsonParser().parse(result);
           if (jsonElement.isJsonObject()){
               T t = gson.fromJson(result, tClass);
               success(t);
           }else if (jsonElement.isJsonArray()){
               ArrayList<T> arrayList = new ArrayList<>();
               JsonArray jsonElements = jsonElement.getAsJsonArray();
               for (JsonElement json : jsonElements) {
                   arrayList.add(gson.fromJson(json, tClass));
               }
               successList(arrayList);
           }

       }
    }

    public  void successList(List<T> list){

    }

    public void success(T t) {

    }


}
