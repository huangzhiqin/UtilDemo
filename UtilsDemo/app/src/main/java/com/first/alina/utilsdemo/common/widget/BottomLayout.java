package com.first.alina.utilsdemo.common.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alina on 2019/1/30.
 */

public class BottomLayout extends LinearLayout{

    private LayoutParams itemTabParams;
    private int currentPos;
    private int selectorPos;
    private List<Button> btns=new ArrayList<>();

    public BottomLayout(Context context) {
        super(context,null);
    }

    public BottomLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs,0);
    }

    public BottomLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        setOrientation(HORIZONTAL);
        itemTabParams = new LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT);
        itemTabParams.weight=1;
    }

    public BottomLayout addItem(Button button){
        btns.add(button);
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        return this;
    }
}
