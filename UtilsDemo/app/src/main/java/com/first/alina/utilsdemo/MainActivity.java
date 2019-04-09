package com.first.alina.utilsdemo;

import android.app.ActivityManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.helper.mvp.test.MVPActivity;
import android.text.Spannable;
import android.text.SpannableString;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.first.alina.utilsdemo.activitys.MoveCommentMainActivity;
import com.first.alina.utilsdemo.activitys.TextViewSwitchActivity;
import com.first.alina.utilsdemo.banner.BannerActivity;
import com.first.alina.utilsdemo.broadcast.TextBroadcast;
import com.first.alina.utilsdemo.dialogs.BottomDialogActivity;
import com.first.alina.utilsdemo.floatview.CutomFloatActivity;
import com.first.alina.utilsdemo.floatview.FloatActivity;
import com.first.alina.utilsdemo.fragmentAndActivity.FragmentActivity;
import com.first.alina.utilsdemo.kline.BrokenLine1Activity;
import com.first.alina.utilsdemo.markets.Utils;
import com.first.alina.utilsdemo.recyclerviews.SideSlipRecyclerViewActivity;
import com.first.alina.utilsdemo.scrollview.activitys.ScaleScrollActivity;
import com.first.alina.utilsdemo.scrollview.activitys.ScrollViewTopActivity;
import com.first.alina.utilsdemo.surfaceviews.SurfaceViewActivity;
import com.first.alina.utilsdemo.task.SingleTaskActivity;
import com.first.alina.utilsdemo.task.SingleTopActivity;
import com.first.alina.utilsdemo.test.activity.ChatMainActivity;
import com.first.alina.utilsdemo.test1.RecyclerViewWebActivity;
import com.first.alina.utilsdemo.testdemo.ActivityVideoDemo;
import com.first.alina.utilsdemo.view.CanvasActivity;
import com.first.alina.utilsdemo.view.CusUnderLineSpan;
import com.first.alina.utilsdemo.view.ViewActivity;
import com.first.alina.utilsdemo.view.WebViewActivity;
import com.first.alina.utilsdemo.widget.WealDialog;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "MainActivity";
    private TextBroadcast textBroadcast;
    private TextView textView;
    private TextView textView2;
    private TextView textView3;
    private TextView mvpTv;
    private List<String> list = new ArrayList<>();
    private String text = "你你看见深V好几年都发不记得你方便你的#PLATE_MARK#奥飞娱乐#PLATE_MARK#放到,你你的加不加还是放到,你你的加不加还是放到，你你的加不加还是放到，你你的加不加#PLATE_MARK#科大讯飞#PLATE_MARK#还是放到，" +
            "你你的加#PLATE_MARK#国药#PLATE_MARK#不加还是放到，你你的加不加还是放到，#PLATE_MARK#腾讯#PLATE_MARK#你你的加不加还是放到";
    private String textChild="#PLATE_MARK#";
    //private int array[] =new int []{5,10,15,20,30,35};
    private List<Integer> indexList=new ArrayList<>();
    private String textParent=text.replaceAll(textChild,"");
    private Long time;
    private long time2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.tv1);
        textView2=(TextView)findViewById(R.id.tv_count);
        mvpTv= (TextView) findViewById(R.id.mvp_tv);
        mvpTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(MainActivity.this, MVPActivity.class));
                WindowManager manager= (WindowManager) MainActivity.this.getSystemService(Context.WINDOW_SERVICE);
                DisplayMetrics displayMetrics=new DisplayMetrics();
                manager.getDefaultDisplay().getMetrics(displayMetrics);
                Log.e(TAG,"==> width="+displayMetrics.widthPixels+"  height="+displayMetrics.heightPixels);
            }
        });
        Log.e(TAG,"==> flag="+getIntent().getFlags());

        SpannableString spannableString=new SpannableString(textParent);
        int index=0;
        while (text.indexOf(textChild,index)!=-1){
            int childIndex=text.indexOf(textChild,index);
            indexList.add(childIndex);
            index=text.indexOf(textChild,index);
            text=text.replaceFirst(textChild,"");
        }
        for (int i=0;i<indexList.size();i=i+2){
            spannableString.setSpan(new CusUnderLineSpan(Color.RED,10,2),indexList.get(i),indexList.get(i+1),0);
        }
        textView.setText(spannableString);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utils.toMarket(MainActivity.this, "https://www.baidu.com/");
                // startActivity(new Intent(MainActivity.this,TextViewActivity.class));

            }
        });
        findViewById(R.id.tv2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, FragmentActivity.class));
            }
        });
        findViewById(R.id.tv3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ActivityListViewNormal.class));
            }
        });
        findViewById(R.id.tv4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, VideoActivity.class));
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
                final WealDialog dialog = new WealDialog.Builder(MainActivity.this)
                        .setTitle("重阳节到啦")
                        .setMessage1("重阳节，重阳节，重阳节，重阳节，重阳节，重阳节")
                        .setBottomOnClickListener(new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Log.e(TAG, "==> onClick ");
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

        findViewById(R.id.scrollView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ScrollViewTopActivity.class));
            }

        });
        findViewById(R.id.image).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ImageLoaderActivity.class));

            }
        });
        findViewById(R.id.scale_image).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ScaleScrollActivity.class));
            }
        });
        findViewById(R.id.video).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ActivityVideoDemo.class));
            }
        });
        findViewById(R.id.dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, BottomDialogActivity.class));
            }
        });

        findViewById(R.id.broken1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, BrokenLine1Activity.class));
            }
        });
        findViewById(R.id.webview).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(MainActivity.this, WebViewActivity.class));
                startActivity(new Intent(MainActivity.this, RecyclerViewWebActivity.class));
            }
        });
        findViewById(R.id.view1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ViewActivity.class));
            }
        });
        findViewById(R.id.banner).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, BannerActivity.class));
            }
        });

        findViewById(R.id.canvasTv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CanvasActivity.class));
            }
        });
        Handler handler=new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
            }
        };
        handler.removeMessages(0);
        Message message=new Message();



    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "==> onResume");
        Toast.makeText(this, Thread.currentThread().getName(), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "==> onStart");

    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode==KeyEvent.KEYCODE_BACK){
            try {
                this.finish();
                ActivityManager manager = (ActivityManager) this
                        .getSystemService(Context.ACTIVITY_SERVICE);
                if (manager != null) {
                    manager.killBackgroundProcesses(this.getPackageName());
                }
                System.exit(0);
            } catch (Exception e) {
                e.printStackTrace();
            }

            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}

