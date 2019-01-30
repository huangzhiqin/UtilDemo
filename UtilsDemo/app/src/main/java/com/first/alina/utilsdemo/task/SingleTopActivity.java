package com.first.alina.utilsdemo.task;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.first.alina.utilsdemo.DialogsActivity;
import com.first.alina.utilsdemo.R;

/**
 * Created by alina on 2018/12/13.
 */

public class SingleTopActivity extends Activity{
    private final String TAG="SingleTopActivity";
    private final String imageUrl="http://imgsrc.baidu.com/forum/w=580/sign=eb1509cbf1d3572c66e29cd4ba126352/5f0f9890f603738d48b35200b01bb051f819ec23.jpg";
    private final String pikaxiuUrl="http://b-ssl.duitang.com/uploads/blog/201308/24/20130824172634_iLEzt.gif";
    private final String maoUrl="http://hbimg.b0.upaiyun.com/49808ae2fa27fc419a3c16db5e9cd89b4c099a3544d9c1-5HmEsv_fw658";
    private final String gifUrl="https://cloud.githubusercontent.com/assets/6345749/21304827/bde1f438-c602-11e6-904a-97f60e79b118.gif";
    private final String gifUrl2="https://media1.giphy.com/media/WJfhOzOgXOLle/giphy.gif";
    private final String gifUrl3="http://wx3.sinaimg.cn/large/d74391e9gy1fwqnvbjnl7g20ks0bou1e.gif";//3.1M
    private int index;
    private TextView tv;

    private ImageView gifImageView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singletop);
        tv = findViewById(R.id.start);
        Log.e(TAG,"==> onCreate");
        gifImageView=findViewById(R.id.gif_img);
        Glide.with(this).load(R.drawable.gif1).into(gifImageView);
        Intent intent=getIntent();
        index=intent.getIntExtra("index",0);
        tv.setText("SingleTopActivity");
        Log.e(TAG,"getTaskId()="+getTaskId()+"  this="+this+"  hashCode="+this.hashCode()+"  "+getClass().getSimpleName()+" index="+index);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(SingleTopActivity.this,SingleTopActivity.class));
                //startActivity(new Intent(SingleTopActivity.this, DialogsActivity.class));

            }
        });
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        index=intent.getIntExtra("index",0);
        Log.e(TAG,"==> onNewIntent");
        index++;
        tv.setText("开始 "+index);
    }
}
