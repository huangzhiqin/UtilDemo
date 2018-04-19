package com.example.alina.savedemo.floats;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.alina.savedemo.R;
import com.example.alina.savedemo.floats.widget.ATFloatingOrderView;

/**
 * Created by alina on 2018/4/13.
 */

public class FloatActivity extends Activity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_float);
        ATFloatingOrderView floatingOrderView=findViewById(R.id.float_atf);
        floatingOrderView.setCenterText("收到红包","偷红包","红包没啦");
    }
}
