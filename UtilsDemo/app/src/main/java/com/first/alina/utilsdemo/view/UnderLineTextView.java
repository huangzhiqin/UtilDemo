package com.first.alina.utilsdemo.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.first.alina.utilsdemo.R;

/**
 * Created by alina on 2018/12/7.
 */

public class UnderLineTextView extends LinearLayout{
    private TextView contentTv;
    private View  contentTagView;
    public UnderLineTextView(Context context) {
        this(context,null);
    }

    public UnderLineTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public UnderLineTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //init(context);
    }

   /* private void init(Context context) {
        View view= LayoutInflater.from(context).inflate(R.layout.textview_underline,this);
        contentTv=view.findViewById(R.id.tv_count);
        contentTagView=view.findViewById(R.id.content_tag);
        contentTv.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                contentTv.getViewTreeObserver().removeOnGlobalLayoutListener(this);
               int lineCount= contentTv.getLineCount();

            }
        });
    }*/



}
