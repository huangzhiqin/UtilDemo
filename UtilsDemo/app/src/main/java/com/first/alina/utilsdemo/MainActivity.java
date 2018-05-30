package com.first.alina.utilsdemo;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.first.alina.utilsdemo.activitys.MoveCommentMainActivity;
import com.first.alina.utilsdemo.activitys.TextViewSwitchActivity;
import com.first.alina.utilsdemo.floats.CutomFloatActivity;
import com.first.alina.utilsdemo.floats.FloatActivity;
import com.first.alina.utilsdemo.recyclerviews.SideSlipRecyclerViewActivity;
import com.first.alina.utilsdemo.test.activity.ChatMainActivity;
import com.first.alina.utilsdemo.widget.WealDialog;

public class MainActivity extends AppCompatActivity {
    private final String TAG="ChatMainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.tv1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,TextViewActivity.class));

            }
        });
        findViewById(R.id.tv2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,DialogsActivity.class));
            }
        });
        findViewById(R.id.tv3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ActivityListViewNormal.class));
            }
        });
        findViewById(R.id.tv4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,VideoActivity.class));
            }
        });
        findViewById(R.id.float_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, FloatActivity.class));
            }
        });
        findViewById(R.id.dialog_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final WealDialog dialog=new WealDialog.Builder(MainActivity.this)
                        .setTitle("重阳节到啦")
                        .setMessage1("重阳节，重阳节，重阳节，重阳节，重阳节，重阳节")
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

        findViewById(R.id.custom_float_tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CutomFloatActivity.class));
            }
        });

        findViewById(R.id.ratingBar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, RatingBarActivity.class));
            }
        });
        findViewById(R.id.soft_key).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ChatMainActivity.class));
            }
        });
        findViewById(R.id.move_comment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MoveCommentMainActivity.class));
            }
        });

        findViewById(R.id.side_slip).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SideSlipRecyclerViewActivity.class));
            }
        });
        findViewById(R.id.switch_tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, TextViewSwitchActivity.class));
            }
        });
    }
}
