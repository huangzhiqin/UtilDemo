package com.first.alina.utilsdemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.first.alina.utilsdemo.widget.RatingBarView;


/**
 * Created by alina on 2018/5/22.
 */

public class RatingBarActivity extends Activity {
    int y;
    private LinearLayout layout;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ratingbar);

        RatingBarView ratingBarView = findViewById(R.id.starView);
        ratingBarView.setBarCount(4,2);

        layout = findViewById(R.id.layout);

        textView = findViewById(R.id.tv);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for (int i=0;i<20;i++){
                    y=y+10;
                    Log.e("TAG","===========> onClick y="+y);
                    //layout.setWillNotDraw(false);
                    //layout.postInvalidate(layout.getLeft(),y, layout.getRight(),y+100);
                   layout.layout(layout.getLeft(),y, layout.getRight(),y+100);
                }
            }
        });


    }
}
