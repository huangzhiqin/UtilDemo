package com.first.alina.utilsdemo.okhttp;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import com.first.alina.utilsdemo.R;
import com.first.alina.utilsdemo.okhttp.bean.NewBean;
import com.first.alina.utilsdemo.okhttp.bean.OneBean;
import com.first.alina.utilsdemo.retrofitOkHttp.OneServiceImpl;
import com.first.alina.utilsdemo.retrofitOkHttp.parserjson.JsonListResponseParser;

import java.util.List;



public class OkhttpActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okhttp);

         findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 OneServiceImpl.test("", new JsonListResponseParser<NewBean>() {
                     @Override
                     public void successList(List<NewBean> list) {
                         Log.e("TAG","===========>success OkhttpActivity version= "+list.get(0).user_name+" "+list.get(0).is_online);
                     }

                     @Override
                     public void success(NewBean newBean) {
                         Log.e("TAG","===========>successs OkhttpActivity version= "+newBean.is_online+" "+newBean.user_name);
                     }
                 });
             }
         });


    }
}
