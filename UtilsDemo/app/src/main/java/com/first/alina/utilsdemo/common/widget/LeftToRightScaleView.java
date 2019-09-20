package com.first.alina.utilsdemo.common.widget;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.first.alina.utilsdemo.R;

/**
 * Created by alina on 2019/5/17.
 */

public class LeftToRightScaleView extends LinearLayout{

    private ImageView playVoiceState;
    private View secondView;
    private ImageView closeImageView;
    private boolean isStart;
    private ObjectAnimator stopAnimator;
    private ObjectAnimator startAnimator;

    public LeftToRightScaleView(Context context) {
        this(context,null);
    }

    public LeftToRightScaleView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public LeftToRightScaleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(final Context context){
        View view=inflate(context,R.layout.view_left_right,this);
        LinearLayout layout=view.findViewById(R.id.layout);
        playVoiceState = view.findViewById(R.id.play_voice_state);
        secondView = view.findViewById(R.id.second_view);
        closeImageView = view.findViewById(R.id.close);
        layout.setBackgroundResource(R.drawable.shape_left_to_right);
        playVoiceState.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isStart){
                    stopVoice();
                }else {
                    startVoice();
                }
            }
        });
        closeImageView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Activity activity= (Activity) context;
                activity.finish();

            }
        });
    }

    public void startVoice(){
        if (isStart){
            return;
        }
        isStart=true;
        playVoiceState.setImageResource(R.drawable.music_start);
        startAnimator = ObjectAnimator.ofFloat(closeImageView,"translationX",1,0);
        startAnimator.setDuration(100);
        startAnimator.start();
        startAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if (stopAnimator!=null){
                    stopAnimator.cancel();
                }
                closeImageView.setVisibility(GONE);
                secondView.setVisibility(GONE);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

    }

    public void stopVoice(){
        if (!isStart){
           return;
        }
        isStart=false;
        playVoiceState.setImageResource(R.drawable.music_stop);
        stopAnimator = ObjectAnimator.ofFloat(closeImageView,"translationX",0,1);
        stopAnimator.setDuration(100);
        stopAnimator.start();
        stopAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if (startAnimator!=null){
                    startAnimator.cancel();
                }
                secondView.setVisibility(VISIBLE);
                closeImageView.setVisibility(VISIBLE);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

    }
}
