package com.first.alina.utilsdemo.floats;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.first.alina.utilsdemo.MainActivity;
import com.first.alina.utilsdemo.R;
import com.first.alina.utilsdemo.widget.CutomFloatView;
import com.first.alina.utilsdemo.widget.WealDialog;


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
                final WealDialog dialog=new WealDialog.Builder(CutomFloatActivity.this)
                        .setTitle("重阳节到啦")
                        .setMessage("重阳节，重阳节，重阳节，重阳节，重阳节，重阳节")
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

    }
}
