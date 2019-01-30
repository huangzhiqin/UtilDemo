package com.first.alina.utilsdemo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by alina on 2018/9/20.
 */

public class View1 extends View{
    private float lineArray[]={0,20,40,80,60,100,80,120};
    float[] pts={50,50,400,50,
            400,50,400,600,
            400,600,50,600,
            50,600,50,50};

    float[] pt={450,50,800,50,
            800,50,800,600,
            800,600,450,600,
            450,600,450,50};
    public View1(Context context) {
        super(context);
    }

    public View1(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public View1(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint=new Paint();//画笔
        paint.setColor(Color.RED);
        paint.setStrokeWidth(5);
        paint.setAntiAlias(true);//设置锯齿
        //paint.setShadowLayer(50,15,15,Color.YELLOW);//画阴影
        paint.setStyle(Paint.Style.FILL);
        canvas.drawColor(Color.GREEN);//画布设置颜色
        canvas.drawPoint(100,100,paint);//画点
       // canvas.drawPoints(new float[]{100,100,200,100,300,100},paint);
        //canvas.drawLine(0,260,1300,262,paint);
        canvas.drawLines(pts,paint);//一个矩形有八个点
        //canvas.drawLines(pts,3,12,paint);//int offset:集合中跳过的数值个数，注意不是点的个数！一个点是两个数值；count:参与绘制的数值的个数，指pts[]里人数值个数，而不是点的个数，因为一个点是两个数值
        canvas.drawCircle(490,200,50,paint);//绘制圆
        //canvas.drawCircle(150,150,1,paint);
      //  Rect rect=new Rect(100,100,300,300);
        //canvas.drawRect(rect,paint);//绘制矩形

        RectF rectF=new RectF(100,100,300,300);
        canvas.drawRoundRect(rectF,20,20,paint);//画圆角矩形

        //绘制椭圆(绘制椭圆的点是，矩形的对角线的两个点)
        // 第一种
        RectF rectFs = new RectF(100,100,800,400);
        canvas.drawOval(rectFs,paint);
       // 第二种
        canvas.drawOval(100,100,800,400,paint);


    }
}
