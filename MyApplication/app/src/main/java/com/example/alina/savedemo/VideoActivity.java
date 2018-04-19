package com.example.alina.savedemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.AbsListView;
import android.widget.ListView;

import com.bumptech.glide.Glide;
import com.example.alina.savedemo.adapters.VideoAdapter;
import com.example.alina.savedemo.widget.AdVideoViewPlayer;

import java.util.ArrayList;
import java.util.List;

import cn.jzvd.JZVideoPlayer;
import cn.jzvd.JZVideoPlayerStandard;

/**
 * Created by alina on 2018/3/17.
 */

public class VideoActivity extends Activity {
    private final String TAG = "VideoActivity";
   // private AdVideoViewPlayer mAdVideoViewPlayer;
    private ListView listview;
    private List<String> mVideoList;
    private VideoAdapter videoAdapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        listview=findViewById(R.id.listview);
       // mAdVideoViewPlayer = findViewById(R.id.videoplayer);
        mVideoList=new ArrayList<>();
        videoAdapter=new VideoAdapter(this);
        for (int i=0;i<30;i++){
            if (i/2==0){
                mVideoList.add("http://image.cailianpress.com/admin/20180323/111944tT9Usc76pUCf.mp4");
            }else if (i/3==0){
                mVideoList.add("http://image.cailianpress.com/admin/20180322/144533j81NQGEAmtHl.mp4");
            }else if (i/5==0){
                mVideoList.add("http://image.cailianpress.com/admin/20180321/171834R6FoOXPZIrmp.mp4");
            }
            else {
                mVideoList.add("http://jzvd.nathen.cn/342a5f7ef6124a4a8faf00e738b8bee4/cf6d9db0bd4d41f59d09ea0a81e918fd-5287d2089db37e62345123a1be272f8b.mp4");
            }
        }
        listview.setAdapter(videoAdapter);
        videoAdapter.setData(mVideoList);

        listview.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                JZVideoPlayer.onScrollReleaseAllVideos(view,firstVisibleItem,visibleItemCount,totalItemCount);

            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        JZVideoPlayer.releaseAllVideos();
    }
}
