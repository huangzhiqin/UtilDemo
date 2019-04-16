package com.first.alina.utilsdemo.common;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

import com.first.alina.utilsdemo.R;

/**
 * Created by alina on 2019/4/16.
 */

public class NoPaddingTextView extends AppCompatTextView{

    private boolean removePadding;
    private Paint paint=getPaint();
    private Rect rect=new Rect();
    public NoPaddingTextView(Context context) {
        this(context,null);
    }

    public NoPaddingTextView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public NoPaddingTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray=context.obtainStyledAttributes(attrs, R.styleable.NoPaddingTextViews);
        removePadding=typedArray.getBoolean(R.styleable.NoPaddingTextViews_removePadding,false);
        typedArray.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (removePadding){
            calculateTextParams();
            setMeasuredDimension(rect.right-rect.left,rect.bottom-rect.top);
        }

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        drawText(canvas);
    }

    private String calculateTextParams(){
        String text=getText().toString();
        int textLength=text.length();
        paint.getTextBounds(text,0,textLength,rect);
        if (textLength==0){
           rect.right= rect.left;
        }
        return text;
    }

    private void drawText(Canvas canvas){
        String text=calculateTextParams();
        int left=rect.left;
        int bottom=rect.bottom;
        rect.offset(-rect.left,-rect.top);
        paint.setAntiAlias(true);
        canvas.drawText(text,-(float)left,(float) (rect.bottom-bottom),paint);
    }
}
