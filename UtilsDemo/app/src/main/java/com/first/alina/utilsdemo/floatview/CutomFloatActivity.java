package com.first.alina.utilsdemo.floatview;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.first.alina.utilsdemo.R;
import com.first.alina.utilsdemo.widget.CutomFloatView;
import com.first.alina.utilsdemo.widget.FloatView2;
import com.first.alina.utilsdemo.widget.WealDialog;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by alina on 2018/4/18.
 */

public class CutomFloatActivity extends Activity {
    private final String TAG="CutomFloatActivity";
    private CutomFloatView cutomFloatView;
    private Button btn1,btn2,btn3;
    private FloatView2 floatView2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cutom_float);
        cutomFloatView=findViewById(R.id.cutom_float);
        cutomFloatView.setLeftImageRes(R.drawable.float_left_white);
        cutomFloatView.setRightImageRes(R.drawable.float_right_white);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        floatView2=findViewById(R.id.float_view2);

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
                List<String> list=new ArrayList();
                for (int i=0;i<3;i++){
                    list.add("10"+i);
                }
                 WealDialog dialog=new WealDialog.Builder(CutomFloatActivity.this)
                        .setTitle("重阳节到啦")
                         .setMessage1("全场通用，现金抵扣")
                         .setDataList(list)
                        .setBottomOnClickListener(new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Log.e(TAG,"==> onClick ");
                                dialog.dismiss();
                            }
                        })
                        .setRightOnClickListener(new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).create();
                dialog.show();
            }
        });
        floatView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(CutomFloatActivity.this,"我是第二种浮窗",Toast.LENGTH_SHORT).show();
            }
        });






    }

    @Override
    public void finish() {
        super.finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
