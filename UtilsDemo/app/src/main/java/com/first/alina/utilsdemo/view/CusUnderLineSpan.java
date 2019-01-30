package com.first.alina.utilsdemo.view;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.style.ReplacementSpan;

/**
 * Created by alina on 2018/12/7.
 */

public class CusUnderLineSpan extends ReplacementSpan {

    private Paint mPaint;
    private int mWidth;
    private float mY;
    private float mMarginTop;

    public CusUnderLineSpan(int color, float marginTop, float size){
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(color);
        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth(size);
        this.mMarginTop = marginTop;
    }



    @Override
    public int getSize(@NonNull Paint paint, CharSequence text, @IntRange(from = 0) int start, @IntRange(from = 0) int end, @Nullable Paint.FontMetricsInt fm) {
        mWidth = (int) paint.measureText(text, start, end);
        Paint.FontMetrics  fontMetrics = paint.getFontMetrics();

        mY =  fontMetrics.descent   - fontMetrics.top + mMarginTop;
        return mWidth;

    }

    @Override
    public void draw(@NonNull Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, @NonNull Paint paint) {
        canvas.drawLine(x, top + mY, x + mWidth, top + mY, mPaint);
        canvas.drawText(text, start, end, x, y, paint);
    }
}
