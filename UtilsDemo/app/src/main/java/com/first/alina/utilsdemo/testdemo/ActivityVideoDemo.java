package com.first.alina.utilsdemo.testdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.first.alina.utilsdemo.R;

/**
 * Created by alina on 2018/8/9.
 */

public class ActivityVideoDemo extends Activity{
    private Button button;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        button=findViewById(R.id.video);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent videoIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                videoIntent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 1);
                //限制时长
                videoIntent.putExtra(MediaStore.EXTRA_DURATION_LIMIT, 15);
                startActivity(videoIntent);
            }
        });
    }
}
