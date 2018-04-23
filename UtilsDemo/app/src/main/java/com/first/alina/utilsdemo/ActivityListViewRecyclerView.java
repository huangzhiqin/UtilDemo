package com.first.alina.utilsdemo;

import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;

import com.first.alina.utilsdemo.common.utils.SharePrefsUtils;
import com.first.alina.utilsdemo.video.adapters.AdapterRecyclerViewVideo;

import cn.jzvd.JZMediaManager;
import cn.jzvd.JZVideoPlayer;
import cn.jzvd.JZVideoPlayerManager;

/**
 * Created by yujunkui on 16/8/29.
 */
public class ActivityListViewRecyclerView extends AppCompatActivity {
    RecyclerView recyclerView;
    AdapterRecyclerViewVideo adapterVideoList;
    private AudioManager mAudioManager;

    private final String TAG="ActivityRecyclerView";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayUseLogoEnabled(false);
        getSupportActionBar().setTitle("RecyclerView");
        setContentView(R.layout.activity_recyclerview_content);
        mAudioManager= (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        recyclerView =(RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        adapterVideoList = new AdapterRecyclerViewVideo(this);
        recyclerView.setAdapter(adapterVideoList);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
              RecyclerView.LayoutManager layoutManager= recyclerView.getLayoutManager();
                Log.e(TAG, "onScrollReleaseAllVideos: " +layoutManager.getChildAt(0).getTag()+" "+JZMediaManager.instance().positionInList);
                if (layoutManager instanceof LinearLayoutManager){
                    LinearLayoutManager linearLayoutManager= (LinearLayoutManager) layoutManager;
                 int firstVisibleItem=   linearLayoutManager.findFirstVisibleItemPosition();
                    int lastVisibleItem=linearLayoutManager.findLastVisibleItemPosition();
                    int currentPlayPosition = JZMediaManager.instance().positionInList;
                    if (currentPlayPosition >= 0) {
                        if ((currentPlayPosition < firstVisibleItem || currentPlayPosition > (lastVisibleItem - 1))) {
                            if (JZVideoPlayerManager.getCurrentJzvd().currentScreen != JZVideoPlayer.SCREEN_WINDOW_FULLSCREEN) {

                                JZVideoPlayer.releaseAllVideos();//为什么最后一个视频横屏会调用这个，其他地方不会
                            }
                        }
                    }
                }

            }
        });
    }

    @Override
    public void onBackPressed() {
        if (JZVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onPause() {

        SharePrefsUtils mSharePrefsUtils=new SharePrefsUtils(this,"video");
        int currentVolume=mSharePrefsUtils.getInt("volume",mAudioManager.getStreamVolume(AudioManager.STREAM_MUSIC));
        Log.e(TAG,"==>currentVolume "+currentVolume+" "+mAudioManager.getStreamVolume(AudioManager.STREAM_MUSIC));
        Log.e(TAG,"==> onPause");
        mAudioManager.setStreamMute(AudioManager.STREAM_MUSIC,false);
        super.onPause();
        JZVideoPlayer.releaseAllVideos();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
