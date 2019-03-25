package com.first.alina.utilsdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.first.alina.utilsdemo.test1.RecyclerViewWebActivity;

/**
 * Created by alina on 2019/3/25.
 */

public class TestActivity extends Activity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        findViewById(R.id.web_tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TestActivity.this, RecyclerViewWebActivity.class));
            }
        });
    }
}
