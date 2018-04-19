package com.example.alina.savedemo;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.AbsListView;
import android.widget.ListView;

import com.example.alina.savedemo.adapters.AdapterVideoList;

import java.util.ArrayList;
import java.util.List;

import cn.jzvd.JZVideoPlayer;

/**
 * Created by alina on 2018/4/4.
 */

public class ActivityListViewNormal extends AppCompatActivity {
    private ListView listView;

    SensorManager sensorManager;
    JZVideoPlayer.JZAutoFullscreenListener sensorEventListener;
    private List<String> mVideoList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayUseLogoEnabled(false);
        getSupportActionBar().setTitle("NormalListView");
        setContentView(R.layout.activity_listview_normal);
        mVideoList=new ArrayList<>();
        for (int i=0;i<30;i++){
            /*if (i/2==0){
                mVideoList.add("http://image.cailianpress.com/admin/20180323/111944tT9Usc76pUCf.mp4");
            }else if (i/3==0){
                mVideoList.add("http://image.cailianpress.com/admin/20180322/144533j81NQGEAmtHl.mp4");
            }else if (i/5==0){
                mVideoList.add("http://image.cailianpress.com/admin/20180321/171834R6FoOXPZIrmp.mp4");
            }
            else {
                mVideoList.add("http://jzvd.nathen.cn/342a5f7ef6124a4a8faf00e738b8bee4/cf6d9db0bd4d41f59d09ea0a81e918fd-5287d2089db37e62345123a1be272f8b.mp4");
            }*/
            mVideoList.add("http://image.cailianpress.com/admin/20180323/111944tT9Usc76pUCf.mp4");
        }
        listView =(ListView) findViewById(R.id.video_listview);
        listView.setAdapter(new AdapterVideoList(this,
                mVideoList));

        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                JZVideoPlayer.onScrollReleaseAllVideos(view, firstVisibleItem, visibleItemCount, totalItemCount);
            }
        });

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensorEventListener = new JZVideoPlayer.JZAutoFullscreenListener();
    }

    @Override
    public void onBackPressed() {
        if (JZVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Sensor accelerometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(sensorEventListener, accelerometerSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(sensorEventListener);
        JZVideoPlayer.releaseAllVideos();
        //JZMediaSystem
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
