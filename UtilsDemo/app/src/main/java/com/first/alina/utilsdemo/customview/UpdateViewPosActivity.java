package com.first.alina.utilsdemo.customview;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;

import com.first.alina.utilsdemo.R;

public class UpdateViewPosActivity extends Activity {
    private View updatePosView;
    private Button btn;
    private int height;
    private int top = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_view_pos);
        updatePosView=findViewById(R.id.move_view);
        btn=findViewById(R.id.btn);
        updatePosView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                updatePosView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                height=updatePosView.getHeight();
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for (int i=0;i<20;i++){
                    top = top +10;
                    updatePosView.layout(updatePosView.getLeft(), top,updatePosView.getRight(),height+ top);
                }
            }
        });



    }
}
