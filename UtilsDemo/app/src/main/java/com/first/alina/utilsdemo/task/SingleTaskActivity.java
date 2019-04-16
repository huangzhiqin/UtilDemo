package com.first.alina.utilsdemo.task;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.first.alina.utilsdemo.R;

/**
 * Created by alina on 2018/12/17.
 */

public class SingleTaskActivity extends Activity{
    private final String TAG="SingleActivity";
    private TextView tv;
    private TextView startSingleTaskTv;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singletop);
        tv = findViewById(R.id.start);
        startSingleTaskTv=findViewById(R.id.tv2);
        startSingleTaskTv.setText("SingleTaskActivity");
        startSingleTaskTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(SingleTaskActivity.this,SingleTopActivity.class));
                finish();
            }
        });
        tv.setText("single task");
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SingleTaskActivity.this,SingleTopActivity.class));

            }
        });
        Log.e(TAG,"getTaskId()="+getTaskId()+"  this="+this+"  hashCode="+this.hashCode()+"  "+getClass().getSimpleName());

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

    }
}
