package com.first.alina.utilsdemo.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

import com.first.alina.utilsdemo.R;

/**
 * Created by alina on 2018/11/6.
 */

public class CircleImageView extends AppCompatImageView {
    private int resourceId;
    private int circleWidth;
    private int circleHeight;
    private Bitmap bitmap;

    public CircleImageView(Context context) {
        this(context, null);
    }

    public CircleImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircleImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context, attrs);
    }

    private void initView(Context context, AttributeSet attrs) {
        TypedArray typeArray = context.obtainStyledAttributes(attrs, R.styleable.circleImageview);
        resourceId = typeArray.getResourceId(R.styleable.circleImageview_circle_background, R.drawable.ysf_def_avatar_user);
        circleHeight = typeArray.getDimensionPixelSize(R.styleable.circleImageview_circle_height, 50);
        circleWidth = typeArray.getDimensionPixelSize(R.styleable.circleImageview_cirlce_width, 50);
        typeArray.recycle();
        super.setScaleType(ScaleType.CENTER_CROP);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //画圆形头像
        Paint paint = new Paint();
        paint.setColor(Color.GRAY);
        paint.setStrokeWidth(5);
        paint.setStyle(Paint.Style.FILL);
        bitmap = ((BitmapDrawable) getResources().getDrawable(resourceId)).getBitmap();
        bitmap = Bitmap.createScaledBitmap(bitmap, this.circleWidth, this.circleHeight, false);
        //bitmap = Bitmap.createScaledBitmap(bitmap, this.circleWidth/2, this.circleHeight/2, false);换成此行代码，会有神奇的效果
        BitmapShader shader = new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);//创建位图渲染
        paint.setShader(shader);
        canvas.drawCircle(circleWidth / 2, circleWidth / 2, circleWidth / 5, paint);
        Paint paint1 = new Paint();
        paint1.setStyle(Paint.Style.STROKE);
        paint1.setColor(Color.YELLOW);
        paint1.setStrokeWidth(5);
        canvas.drawCircle(circleWidth / 2, circleWidth / 2, (circleWidth / 5), paint1);

        //画圆角矩形
        canvas.drawRoundRect(this.getLeft()+(this.getWidth()-circleWidth/2),this.getTop()+this.getHeight()-circleHeight/2,
                this.getRight()-(this.getWidth()-circleWidth/2),this.getBottom()-this.getHeight()-circleHeight/2,10,20,paint1);

        bitmap.recycle();
    }
}
