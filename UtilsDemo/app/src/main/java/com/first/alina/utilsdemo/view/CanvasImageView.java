package com.first.alina.utilsdemo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.util.Log;

import com.first.alina.utilsdemo.R;

/**
 * Created by alina on 2018/11/5.
 */

public class CanvasImageView extends AppCompatImageView {
    private final String TAG = "CanvasImageView";
    int curentX, currentY = 200;
    private Drawable drawable;

    public CanvasImageView(Context context) {
        this(context, null);
    }

    public CanvasImageView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CanvasImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        drawable = getResources().getDrawable(R.color.ysf_blue_61a7ea);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
       /* Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        paint.setColor(Color.RED);
        paint.setStrokeWidth(5);
        Path path = new Path();
        for (int i=0;i<60;i++){
            curentX=50*(i+1);
            if (i%2==0){
               currentY= currentY+40;
            }else {
                currentY=currentY+20;
            }
           path.lineTo(curentX,currentY);
        }

        //path.cubicTo(100, 200, 220, 390, 500, 100);
        Path path1=new Path();
       // drawable.setBounds(curentX);
        canvas.clipPath(path);
        canvas.drawPath(path, paint);*/
        Log.e(TAG, "==> width=" + canvas.getWidth());
        canvas.translate(canvas.getWidth() / 2, canvas.getHeight()/2);//把坐标原点移动到画布(CanvasImageView的宽高确定)的中心


        Paint paint1 = new Paint();
        paint1.setStrokeWidth(10);
        paint1.setColor(Color.RED);
        paint1.setAntiAlias(true);
        paint1.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(0, 0, 300, paint1);
        Paint paint2 = new Paint(paint1);
        paint2.setStrokeWidth(5);
        Paint paint5 = new Paint(paint2);
        paint5.setStrokeWidth(2);

        //刻度原理：先画下面的 刻度，然后旋转画布，画剩余刻度。
        float y = 300;
        int count = 60;
        for (int i = 0; i < count; i++) {
            if (i % 5 == 0) {
                if (i==0){
                    paint1.setColor(Color.YELLOW);
                }else {
                    paint1.setColor(Color.RED);
                }
                canvas.drawLine(0, -y, 0, -(y + 24f), paint1);
            } else {
                if (i==0){
                    paint2.setColor(Color.BLUE);
                }else if (i==1){
                    paint2.setColor(Color.GRAY);
                }else if (i==2){
                    paint2.setColor(Color.GREEN);
                }
                else {
                    paint2.setColor(Color.RED);
                }
                canvas.drawLine(0, -y, 0, -(y + 12f), paint2);
            }
            canvas.rotate(360/count, 0, 0);
        }
        Paint paint3 = new Paint(paint2);
        paint3.setStrokeWidth(8);
        canvas.drawLine(0, 50, 0, -200, paint3);
        Paint tmpPaint = new Paint(paint1);
        tmpPaint.setStrokeWidth(7);
        tmpPaint.setColor(Color.GRAY);
        tmpPaint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(0, 0, 15, tmpPaint);
        Paint paint4 = new Paint(tmpPaint);
        paint4.setStrokeWidth(5);
        paint4.setColor(Color.RED);
        paint4.setStyle(Paint.Style.FILL);
        canvas.drawCircle(0, 0, 10, paint4);


    }


}
