package com.first.alina.utilsdemo.activitys;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import com.first.alina.utilsdemo.R;

/**
 * Created by alina on 2018/5/29.
 */

public class TextViewSwitchActivity extends Activity{
    private TextSwitcher textSwitcher;
    private String[] news={"双11回馈活动产品利率增长0.05%","国家大数据发展纲要","郑重公告","某某网站会员须知","网站维护公告"};
    private int index=0;//上下滚动下标
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            textSwitcher.setText(news[index%news.length]);
            index++;
            handler.sendEmptyMessageDelayed(1,2000);
        }
    };
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textview_switch);
        textSwitcher=findViewById(R.id.switch_text);
        switchTextView();
        handler.sendEmptyMessage(1);
        textSwitcher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(TextViewSwitchActivity.this,"点击"+news[index==0?0:index-1%news.length],Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void switchTextView(){
        textSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView textView=new TextView(TextViewSwitchActivity.this);
                textView.setSingleLine();
                textView.setTextSize(22);
                textView.setTextColor(Color.GREEN);
                textView.setEllipsize(TextUtils.TruncateAt.END);
                FrameLayout.LayoutParams layoutParams=new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT);
                layoutParams.gravity= Gravity.CENTER_VERTICAL;
                textView.setLayoutParams(layoutParams);
                return textView;
            }
        });
    }
}
