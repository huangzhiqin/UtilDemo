package com.example.alina.savedemo.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.alina.savedemo.R;
import com.example.alina.savedemo.common.ScreenUtils;

import cn.jzvd.JZMediaManager;
import cn.jzvd.JZUserActionStandard;
import cn.jzvd.JZVideoPlayerStandard;

/**
 * Created by alina on 2018/3/17.
 */

public class AdVideoViewPlayer extends JZVideoPlayerStandard {
    private SeekBar seekBar;
    private LinearLayout mBottom;
    private ProgressBar progressBar;
    private ImageView imageView;
    private RelativeLayout topLayout;
    private ProgressBar loading;
    private LinearLayout startLayout;
    private TextView timeTv;
    private LinearLayout retryLayout;
    private Context mContext;

    public AdVideoViewPlayer(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AdVideoViewPlayer(Context context) {
        super(context);
    }

    @Override
    public void init(Context context) {
        super.init(context);
        mContext=context;
        seekBar=findViewById(R.id.bottom_seek_progress);
        mBottom=findViewById(R.id.layout_bottom);
        progressBar=findViewById(R.id.bottom_progress);
        imageView=findViewById(R.id.back_tiny);
        topLayout=findViewById(R.id.layout_top);
        loading=findViewById(R.id.loading);
        startLayout=findViewById(R.id.start_layout);
        timeTv=findViewById(R.id.replay_text);
        retryLayout=findViewById(R.id.retry_layout);
        retryLayout.setVisibility(GONE);
        timeTv.setVisibility(GONE);
        startLayout.setVisibility(GONE);
        loading.setVisibility(GONE);
        topLayout.setVisibility(GONE);
        imageView.setVisibility(GONE);
        progressBar.setVisibility(GONE);
        mBottom.setVisibility(GONE);
        seekBar.setVisibility(GONE);
    }

    @Override
    public int getLayoutId() {
        return R.layout.layout_standard;
    }


    @Override
    public void startVideo() {
        super.startVideo();
    }
    public void setAllControlsVisiblity(int topCon, int bottomCon, int startBtn, int loadingPro,
                                        int thumbImg, int bottomPro, int retryLayout) {
        topContainer.setVisibility(GONE);
        bottomContainer.setVisibility(GONE);
        startButton.setVisibility(GONE);
        loadingProgressBar.setVisibility(GONE);
        thumbImageView.setVisibility(thumbImg);
        bottomProgressBar.setVisibility(GONE);
        mRetryLayout.setVisibility(GONE);
    }

    @Override
    public void updateStartImage() {
        if (currentState == CURRENT_STATE_PLAYING) {
            startButton.setVisibility(GONE);
            startButton.setImageResource(cn.jzvd.R.drawable.jz_click_pause_selector);
            replayTextView.setVisibility(GONE);
        } else if (currentState == CURRENT_STATE_ERROR) {
            startButton.setVisibility(GONE);
            replayTextView.setVisibility(GONE);
        } else if (currentState == CURRENT_STATE_AUTO_COMPLETE) {
            startButton.setVisibility(GONE);
            startButton.setImageResource(cn.jzvd.R.drawable.jz_click_replay_selector);
            replayTextView.setVisibility(GONE);
        } else {
            startButton.setImageResource(cn.jzvd.R.drawable.jz_click_play_selector);
            replayTextView.setVisibility(GONE);
        }
    }
    @Override
    public void onStateAutoComplete() {
        super.onStateAutoComplete();
        bottomContainer.setVisibility(GONE);
        Log.e(TAG,"==> onStateAutoComplete ");
        startVideo();
    }

    @Override
    public void onStatePlaying() {
        super.onStatePlaying();
        Log.e(TAG,"==> onStatePlaying ");
    }

    @Override
    public void onStateNormal() {
        super.onStateNormal();
        Log.e(TAG,"==> onStateNormal ");
    }

    @Override
    public void onStatePrepared() {
        super.onStatePrepared();
        Log.e(TAG,"==> onStatePrepared ");
    }

    @Override
    public void onStatePreparing() {
        super.onStatePreparing();
        Log.e(TAG,"==> onStatePreparing ");
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return true;
    }

    @Override
    public void onStatePreparingChangingUrl(int urlMapIndex, long seekToInAdvance) {
        super.onStatePreparingChangingUrl(urlMapIndex, seekToInAdvance);
        loadingProgressBar.setVisibility(GONE);
    }

    @Override
    public void onVideoSizeChanged() {
        super.onVideoSizeChanged();
        if (JZMediaManager.textureView!=null){
            JZMediaManager.textureView.setVideoSize(RelativeLayout.LayoutParams.MATCH_PARENT, ScreenUtils.getScreenWidth(mContext)*9/16);
        }
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return false;
    }
/*    private SeekBar seekBar;
    private LinearLayout mBottom;
    private ProgressBar progressBar;
    private ImageView imageView;
    private RelativeLayout topLayout;
    private ProgressBar loading;
    private LinearLayout startLayout;
    private TextView timeTv;
    private LinearLayout retryLayout;

    public AdVideoViewPlayer(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AdVideoViewPlayer(Context context) {
        super(context);
    }

    @Override
    public void init(Context context) {
        super.init(context);
        seekBar=findViewById(R.id.bottom_seek_progress);
        mBottom=findViewById(R.id.layout_bottom);
        progressBar=findViewById(R.id.bottom_progress);
        imageView=findViewById(R.id.back_tiny);
        topLayout=findViewById(R.id.layout_top);
        loading=findViewById(R.id.loading);
        startLayout=findViewById(R.id.start_layout);
        timeTv=findViewById(R.id.replay_text);
        retryLayout=findViewById(R.id.retry_layout);
        retryLayout.setVisibility(GONE);
        timeTv.setVisibility(GONE);
        startLayout.setVisibility(GONE);
        loading.setVisibility(GONE);
        topLayout.setVisibility(GONE);
        imageView.setVisibility(GONE);
        progressBar.setVisibility(GONE);
        mBottom.setVisibility(GONE);
        seekBar.setVisibility(GONE);
    }

    @Override
    public int getLayoutId() {
        return R.layout.layout_standard;
    }


    @Override
    public void startVideo() {
        super.startVideo();
    }
    public void setAllControlsVisiblity(int topCon, int bottomCon, int startBtn, int loadingPro,
                                        int thumbImg, int bottomPro, int retryLayout) {
        topContainer.setVisibility(GONE);
        bottomContainer.setVisibility(GONE);
        startButton.setVisibility(GONE);
        loadingProgressBar.setVisibility(GONE);
        thumbImageView.setVisibility(thumbImg);
        bottomProgressBar.setVisibility(GONE);
        mRetryLayout.setVisibility(GONE);
    }

    @Override
    public void updateStartImage() {
        if (currentState == CURRENT_STATE_PLAYING) {
            startButton.setVisibility(GONE);
            startButton.setImageResource(cn.jzvd.R.drawable.jz_click_pause_selector);
            replayTextView.setVisibility(GONE);
        } else if (currentState == CURRENT_STATE_ERROR) {
            startButton.setVisibility(GONE);
            replayTextView.setVisibility(GONE);
        } else if (currentState == CURRENT_STATE_AUTO_COMPLETE) {
            startButton.setVisibility(GONE);
            startButton.setImageResource(cn.jzvd.R.drawable.jz_click_replay_selector);
            replayTextView.setVisibility(GONE);
        } else {
            startButton.setImageResource(cn.jzvd.R.drawable.jz_click_play_selector);
            replayTextView.setVisibility(GONE);
        }
    }
    @Override
    public void onStateAutoComplete() {
        super.onStateAutoComplete();
        bottomContainer.setVisibility(GONE);
        Log.e(TAG,"==> onStateAutoComplete ");
        startVideo();
    }

    @Override
    public void onStatePlaying() {
        super.onStatePlaying();
        Log.e(TAG,"==> onStatePlaying ");
    }

    @Override
    public void onStateNormal() {
        super.onStateNormal();
        Log.e(TAG,"==> onStateNormal ");
    }

    @Override
    public void onStatePrepared() {
        super.onStatePrepared();
        Log.e(TAG,"==> onStatePrepared ");
    }

    @Override
    public void onStatePreparing() {
        super.onStatePreparing();
        Log.e(TAG,"==> onStatePreparing ");
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
 *//*       int id = v.getId();
        if (id == cn.jzvd.R.id.surface_container) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    break;
                case MotionEvent.ACTION_MOVE:
                    break;
                case MotionEvent.ACTION_UP:
                    //startDismissControlViewTimer();
                    if (mChangePosition) {
                        long duration = getDuration();
                        int progress = (int) (mSeekTimePosition * 100 / (duration == 0 ? 1 : duration));
                        bottomProgressBar.setProgress(progress);
                        bottomContainer.setVisibility(GONE);
                        bottomProgressBar.setVisibility(GONE);
                    }
                    if (!mChangePosition && !mChangeVolume) {
                        onEvent(JZUserActionStandard.ON_CLICK_BLANK);
                       // onClickUiToggle();
                    }
                    break;
            }
        } else if (id == cn.jzvd.R.id.bottom_seek_progress) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    //cancelDismissControlViewTimer();
                    break;
                case MotionEvent.ACTION_UP:
                   // startDismissControlViewTimer();
                    break;
            }
        }
        return super.onTouch(v, event);*//*

     return true;
    }

    @Override
    public void onStatePreparingChangingUrl(int urlMapIndex, long seekToInAdvance) {
        super.onStatePreparingChangingUrl(urlMapIndex, seekToInAdvance);
        loadingProgressBar.setVisibility(GONE);
    }*/
}
