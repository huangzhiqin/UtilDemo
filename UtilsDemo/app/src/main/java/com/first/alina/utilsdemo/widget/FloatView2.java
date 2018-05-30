package com.first.alina.utilsdemo.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.Scroller;

import com.first.alina.utilsdemo.common.ScreenUtils;

/**
 * Created by alina on 2018/4/22.
 * 第二种可以全屏滑动的浮窗
 */

public class FloatView2 extends android.support.v7.widget.AppCompatImageView{
    private String TAG="FloatView2";
    private int screenWidth;
    private int screenHeight;
    private int lastX;
    private int lastY;
    public Context context;
    private int top,bottom,left,right;
    private int height,width;
    private Scroller scroller;
    private float rawX;
    private float rawY;

    public FloatView2(Context context) {
        super(context);
        this.context=context;
        getInitData();
    }

    public FloatView2(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context=context;
        getInitData();
    }

    public FloatView2(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context=context;
        getInitData();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        height=getMeasuredHeight();
        width=getMeasuredWidth();
    }

    private void getInitData(){
        screenWidth= ScreenUtils.getScreenWidth(context);
        screenHeight=ScreenUtils.getScreenHeight(context);

    }

    private void smoothScrollTo(int destX,int destY){
      /*  int scrollX=getScrollX();
        int deltaX=destX-scrollX;
        int scrollY=getScrollY();
        int deltaY=destY-scrollY;*/
        scroller.startScroll(0,destY,0,destY-1);
        invalidate();
    }

    @Override
    public void computeScroll() {
      //  super.computeScroll();
        if (scroller!=null&&scroller.computeScrollOffset()){
                int currentX=scroller.getCurrX();
                int currentY=scroller.getCurrY();
                Log.e(TAG,"==>computeScroll currentX="+currentX+" currentY="+currentY);
                scrollTo(currentX,currentY);
                postInvalidate();

        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        scroller=new Scroller(context);
        int x=(int)event.getX();
        int y=(int)event.getY();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                lastY=y;
                lastX=x;
                break;
            case MotionEvent.ACTION_MOVE:
              /*   int xDistance =x - lastX;
                 int yDistance = y - lastY;
                xDistance=xDistance*-1;
                yDistance=yDistance*-1;
               scrollBy(xDistance,yDistance);*/
             /// smoothScrollTo();

                int deltaX=x-lastX;
                int deltaY=y-lastY;
                int translationX=(int) getTranslationX()+deltaX;
                int translationY=(int)getTranslationY()+deltaY;
                setTranslationX(translationX);
                setTranslationY(translationY);
                top=getTop();
                break;
            case MotionEvent.ACTION_UP:
                if (event.getRawX() >= screenWidth / 2) {
                    Log.e(TAG,"==> 右边 getTop "+(int)getY());
                    //smoothScrollTo(screenHeight-width,getScrollY());
                    setTranslationX(getTranslationX()+(screenWidth-width-event.getX()));
                   /* this.layout(screenWidth - width, top, screenWidth, bottom);
                    ObjectAnimator rightAnimator = ObjectAnimator.ofFloat(this, "rotation", -18, 9, -18, -9);
                    rightAnimator.setDuration(1500);
                    rightAnimator.start();*/
                } else {
                    Log.e(TAG,"==> getTop "+(int)getY());
                    setTranslationX(getTranslationX()+event.getX());
                   // smoothScrollTo(0,getScrollY());
                   /* ObjectAnimator rightAnimator = ObjectAnimator.ofFloat(this, "rotation", 18, -9, 18, 9);
                    rightAnimator.setDuration(1500);
                    rightAnimator.start();
*/
                }
                break;
            default:

                break;
        }

        lastY=y;
        lastX=x;
        return true;
    }
}
