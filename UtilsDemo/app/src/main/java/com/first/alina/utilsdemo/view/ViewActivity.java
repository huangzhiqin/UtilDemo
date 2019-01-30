package com.first.alina.utilsdemo.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.RelativeLayout;

import com.first.alina.utilsdemo.R;

/**
 * Created by alina on 2018/9/20.
 */

public class ViewActivity extends Activity{
    private RelativeLayout relativeLayout;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        relativeLayout=findViewById(R.id.layout);
        relativeLayout.addView(new View1(this));
    }
}
