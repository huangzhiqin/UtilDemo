package com.first.alina.utilsdemo.retrofitOkHttp;

import android.text.TextUtils;
import android.util.Log;

import com.first.alina.utilsdemo.okhttp.bean.NewBean;
import com.first.alina.utilsdemo.retrofitOkHttp.bean.HttpResultBean;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import okhttp3.MediaType;
import okhttp3.ResponseBody;
import retrofit2.Converter;

import static java.nio.charset.StandardCharsets.UTF_8;

public final class ResponseConverter<T> implements Converter<ResponseBody, T> {
    private final String TAG="ResponseConverter";
    private final Gson gson;
    private final TypeAdapter<T> adapter;

     public ResponseConverter(Gson gson, TypeAdapter<T> adapter) {
         this.gson = gson;
         this.adapter = adapter;
     }

     @Override
    public T convert(ResponseBody value) throws IOException {
         String result = value.string();
        /* result="[ \n" +
                 "                  { \n" +
                 "                \"is_online\": 1, \"user_name\": \"guanghui.li\",\"birthday\": \"2014-10-21\" },\n" +
                 "                  {\n" +
                 "                \"is_online\": 1,\"user_name\": \"111\",\"birthday\": \"2015-09-07\" } \n" +
                 "                 ]";*/
         Log.e(TAG, "==========>convert " +result+"    ");

         //如果是1（数据正常返回），我们正常解析
         MediaType mediaType=MediaType.parse("application/json");
        // MediaType mediaType = value.contentType();
         Charset charset = mediaType != null ? mediaType.charset(UTF_8) : UTF_8;
         ByteArrayInputStream bis = new ByteArrayInputStream(result.getBytes());
         InputStreamReader reader = new InputStreamReader(bis, charset);
         JsonReader jsonReader = gson.newJsonReader(reader);
         try {
             return adapter.read(jsonReader);
         } finally {
             value.close();
         }
     }

}
