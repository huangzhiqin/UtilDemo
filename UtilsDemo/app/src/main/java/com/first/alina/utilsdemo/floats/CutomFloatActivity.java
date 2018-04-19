package com.first.alina.utilsdemo.floats;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.first.alina.utilsdemo.R;
import com.first.alina.utilsdemo.widget.CutomFloatView;


/**
 * Created by alina on 2018/4/18.
 */

public class CutomFloatActivity extends Activity {
    private final String TAG="CutomFloatActivity";
    private CutomFloatView cutomFloatView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cutom_float);
        cutomFloatView=findViewById(R.id.cutom_float);

    }
}
