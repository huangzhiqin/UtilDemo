package com.first.alina.utilsdemo.floats;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.first.alina.utilsdemo.R;
import com.first.alina.utilsdemo.widget.CutomFloatView;


/**
 * Created by alina on 2018/4/18.
 */

public class CutomFloatActivity extends Activity {
    private final String TAG="CutomFloatActivity";
    private CutomFloatView cutomFloatView;
    private Button btn1,btn2,btn3;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cutom_float);
        cutomFloatView=findViewById(R.id.cutom_float);
        cutomFloatView.setLeftImageRes(R.drawable.float_left);
        cutomFloatView.setRightImageRes(R.drawable.float_right);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CutomFloatActivity.this,"按钮1",Toast.LENGTH_SHORT).show();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CutomFloatActivity.this,"按钮2",Toast.LENGTH_SHORT).show();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CutomFloatActivity.this,"按钮3",Toast.LENGTH_SHORT).show();
            }
        });
        cutomFloatView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CutomFloatActivity.this,"悬浮窗点击事件被触发了",Toast.LENGTH_SHORT).show();
            }
        });

    }
}
