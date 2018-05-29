package com.first.alina.utilsdemo.activitys;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.util.Pools;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.first.alina.utilsdemo.R;
import com.first.alina.utilsdemo.common.ScreenUtils;

/**
 * Created by alina on 2018/5/18.
 */

public class MoveCommentMainActivity extends AppCompatActivity{
    private LinearLayout moveCommentLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_comment);
        moveCommentLayout= (LinearLayout) findViewById(R.id.move_comment_tv);
        LayoutTransition transition=new LayoutTransition();
        PropertyValuesHolder scaleX=PropertyValuesHolder.ofFloat("scaleX",0,1);
        PropertyValuesHolder scaleY=PropertyValuesHolder.ofFloat("scaleY",0,1);
        ObjectAnimator animator=ObjectAnimator.ofPropertyValuesHolder(null,new PropertyValuesHolder[]{scaleX,scaleY})
                .setDuration(transition.getDuration(LayoutTransition.APPEARING));
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                ObjectAnimator objectAnimator= (ObjectAnimator) animation;
                View view= (View) objectAnimator.getTarget();
                view.setPivotX(0f);
                view.setPivotY(view.getMeasuredHeight()+dp2px(20));
            }
        });
        transition.setAnimator(LayoutTransition.APPEARING,animator);

        ObjectAnimator alphaAnimator=ObjectAnimator.ofFloat(null,"alpha",0,1).setDuration(LayoutTransition.DISAPPEARING);
        transition.setAnimator(LayoutTransition.DISAPPEARING,alphaAnimator);
        moveCommentLayout.setLayoutTransition(transition);
    }
    private int dp2px(float dp) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, displayMetrics);
    }

    private String[] tests = new String[]{
            "火来我在灰烬中等你。",
            "我对这个世界没什么可说的。",
            "侠之大者，为国为民。",
            "为往圣而继绝学"};
    Pools.SimplePool<TextView> textViewPool=new Pools.SimplePool<>(tests.length);

    int index=0;
    private TextView obtainTextView(){
        TextView textView=textViewPool.acquire();
        if (textView==null){
            textView=new TextView(this);
            textView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT));
            textView.setPadding(dp2px(15),dp2px(10),dp2px(15),dp2px(10));
            textView.setTextColor(Color.YELLOW);
            textView.setTextSize(18);
        }
        return textView;
    }

    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what==0&&moveCommentLayout.getChildCount()==4){
                moveCommentLayout.removeViewAt(0);
            }
            if (index==4){
                index=0;
            }
           TextView textView =obtainTextView();
            switch (index) {
                case 0:
                    textView.setBackgroundDrawable(ContextCompat.getDrawable(MoveCommentMainActivity.this, R.drawable.rect_black));
                    break;
                case 1:
                    textView.setBackgroundDrawable(ContextCompat.getDrawable(MoveCommentMainActivity.this, R.drawable.rect_blue));

                    break;
                case 2:
                    textView.setBackgroundDrawable(ContextCompat.getDrawable(MoveCommentMainActivity.this, R.drawable.rect_green));

                    break;
                case 3:
                    textView.setBackgroundDrawable(ContextCompat.getDrawable(MoveCommentMainActivity.this, R.drawable.rect_yellow));

                    break;
            }
            textView.setText(tests[index]);
            moveCommentLayout.addView(textView);
            sendEmptyMessageDelayed(0,2000);
            index++;
        }
    };

    @Override
    protected void onResume() {
        super.onResume();
        handler.sendEmptyMessage(0);
    }

    @Override
    protected void onPause() {
        super.onPause();
        handler.removeMessages(0);
    }
}