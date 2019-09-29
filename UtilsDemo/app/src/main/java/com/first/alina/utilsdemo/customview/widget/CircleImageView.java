package com.first.alina.utilsdemo.customview.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

import com.first.alina.utilsdemo.R;

public class CircleImageView extends AppCompatImageView {
    private Paint bitmapPaint = new Paint();
    private Paint borderPaint = new Paint();
    private Paint bgPaint = new Paint();
    private RectF rectF=new RectF();
    private int strockWodth;

    public CircleImageView(Context context) {
        this(context, null);
    }

    public CircleImageView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircleImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        bitmapPaint.setAntiAlias(true);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.meinv);
        BitmapShader shader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        bitmapPaint.setShader(shader);

        strockWodth=10;
        borderPaint.setAntiAlias(true);
        borderPaint.setColor(Color.BLUE);
        borderPaint.setStrokeWidth(strockWodth);
        borderPaint.setStyle(Paint.Style.STROKE);

        rectF.set(calculateBounds());
    }
    private RectF calculateBounds() {
        int availableWidth  = getWidth() - getPaddingLeft() - getPaddingRight();
        int availableHeight = getHeight() - getPaddingTop() - getPaddingBottom();

        int sideLength = Math.min(availableWidth, availableHeight);

        float left = getPaddingLeft() + (availableWidth - sideLength) / 2f;
        float top = getPaddingTop() + (availableHeight - sideLength) / 2f;

        return new RectF(left, top, left + sideLength, top + sideLength);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(rectF.centerX() / 2, rectF.centerY()/ 2, (rectF.height()) / 2, borderPaint);
        canvas.drawCircle(getWidth()/2.0f,getHeight()/2.0f,getWidth()/2.0f,bitmapPaint);
    }
}
