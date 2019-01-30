package com.first.alina.utilsdemo.test1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by alina on 2018/11/23.
 */

public class testBaseActivity extends Activity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }
    protected void init(){
        if (getLayoutId()!=0){
            setContentView(this.getLayoutId());
        }
        parseIntent();
        initView();
    }

    protected int getLayoutId(){
        return 0;
    }

    protected void parseIntent(){}
    protected void initView(){}

}
