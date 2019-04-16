package com.first.alina.utilsdemo.common.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by alina on 2019/4/15.
 */

public class BitmapImageView extends ImageView{
    public BitmapImageView(Context context) {
        this(context,null);
    }

    public BitmapImageView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public BitmapImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint=new Paint();
        paint.setFilterBitmap(true);
    }
}
