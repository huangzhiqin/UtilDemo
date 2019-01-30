package com.first.alina.utilsdemo;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.first.alina.utilsdemo.widget.Bottom1Dialog;
import com.first.alina.utilsdemo.widget.CenterDialog2;
import com.first.alina.utilsdemo.widget.CenterDialog3;


/**
 * Created by alina on 2018/2/27.
 */

public class DialogsActivity extends Activity {
    private String TAG="SingleActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogs);
        findViewById(R.id.tv1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bottom1Dialog bottom1Dialog=new Bottom1Dialog(DialogsActivity.this,R.style.MyDialog1);
                bottom1Dialog.setContent("我是靠近底部的dialog");
                bottom1Dialog.show();
            }
        });
        findViewById(R.id.tv2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CenterDialog2 centerDialog2=new CenterDialog2(DialogsActivity.this);
                centerDialog2.setTitle("dialog");
                centerDialog2.setBrif("我是右上角带有close图标的dialog，啦啦啦啦啦");
                centerDialog2.show();
            }
        });
        findViewById(R.id.tv3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 CenterDialog3.Builder builder=new CenterDialog3.Builder(DialogsActivity.this)
                        .setMessage("我是dialog3的message")
                        .setTitle("我是dialog3的title")
                        .setNegativeButton("拒绝", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            }
                        })
                        .setPositiveButton("接受", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(DialogsActivity.this,"接受", Toast.LENGTH_SHORT).show();
                                dialog.dismiss();
                            }
                        });
                builder.create().show();

            }
        });
        Log.e(TAG,"getTaskId()="+getTaskId()+"  this="+this+"  hashCode="+this.hashCode()+"  "+getClass().getSimpleName());
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
