package com.first.alina.utilsdemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.first.alina.utilsdemo.widget.RatingBarView;


/**
 * Created by alina on 2018/5/22.
 */

public class RatingBarActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ratingbar);

        RatingBarView ratingBarView = findViewById(R.id.starView);
        ratingBarView.setBarCount(4,2);

    }
}
