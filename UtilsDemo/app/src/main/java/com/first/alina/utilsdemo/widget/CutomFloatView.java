package com.first.alina.utilsdemo.widget;

import android.content.Context;
import android.support.v4.view.ViewConfigurationCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.first.alina.utilsdemo.R;
import com.first.alina.utilsdemo.common.ScreenUtils;


/**
 * Created by alina on 2018/4/18.
 */

public class CutomFloatView extends android.support.v7.widget.AppCompatImageView{
    private final String TAG="CutomFloatView";
    private float downX;
    private float downY;
    private int width;
    private int height;
    private int screenWidth;
    private int screenHeight;
    private Context context;
    private int minScroll;
    private int leftImage;
    private int rightImage;
    private int top,bottom;
    private boolean isClick;
    private float rawX;
    private float rawY;
    public CutomFloatView(Context context) {
        super(context);
        this.context=context;
    }

    public CutomFloatView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context=context;
    }

    public CutomFloatView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context=context;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width=getMeasuredWidth();
        height=getMeasuredHeight();
        screenHeight= ScreenUtils.getScreenHeight(context);
        screenWidth=ScreenUtils.getScreenWidth(context);
        minScroll=ViewConfiguration.get(context).getScaledTouchSlop();
        setLeftImageRes(leftImage);
        setEnabled(false);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                isClick=true;
                downX=event.getX();
                downY=event.getY();
                rawX=event.getRawX();
                rawY=event.getRawY();
                break;
            case MotionEvent.ACTION_MOVE:
                final float xDistance=event.getX()-downX;
                final float yDistance=event.getY()-downY;
                int l,r;
                if (Math.abs(xDistance)>10|| Math.abs(yDistance)>10){

                    l=(int)(getLeft()+xDistance);
                    r=l+width;
                    top=(int)(getTop()+yDistance);
                    bottom=top+height;
                    if(l<0){
                        l=0;
                        r=l+width;
                    }else if(r>screenWidth){
                        r=screenWidth;
                        l=r-width;
                    }
                    if(top<0){
                        bottom=0;
                        bottom=bottom+height;
                    }else if(bottom>screenHeight){
                        bottom=screenHeight;
                        top=bottom-height;
                    }
                    this.layout(l,top,r,bottom);

                }
                break;
            case MotionEvent.ACTION_UP:
                float currentX=event.getX();
                float currentY=event.getY();
                Log.e(TAG,"==> xDistance="+Math.abs(event.getRawX()-rawX)+" yDistance="+Math.abs(currentY-downY)+" currentY="+currentY+" downX="+downX+" downY="+downY+" currentX="+currentX);
                if (Math.abs(event.getRawX()-rawX)<=minScroll&&Math.abs(event.getRawY()-rawY)<=minScroll){
                    Log.e(TAG,"==> 点击事件");
                    isClick=true;
                    setEnabled(true);
                }else {
                    isClick=false;
                    Log.e(TAG,"==> 拖动事件");
                    setEnabled(false);//在拖动的过程中，禁止View点击事件
                }
                if (event.getRawX()>=screenWidth/2){
                    this.layout(screenWidth-width,getTop(),screenWidth,getBottom());
                    changeImageRes(rightImage);
                    Log.e(TAG,"==> 右边 "+" top="+top+" bottom="+bottom+" screenWidth-width ="+(screenWidth-width)+" getTop "+getTop()+" getBottom "+getBottom());
                }else {
                    this.layout(0,getTop(),width,getBottom());
                    changeImageRes(leftImage);
                    Log.e(TAG,"==>左边 "+" top="+top+" bottom="+bottom+" getTop "+getTop()+" getBottom "+getBottom());
                }
                    postInvalidate();
                break;
            case MotionEvent.ACTION_CANCEL:
                Log.e(TAG,"==> action_cancel");
                break;

        }
        Log.e(TAG,"==>isClick "+isClick);
        return true;
    }


    public void setLeftImageRes(int res){
        this.setImageResource(res);
        leftImage=res;
    }
    public int getLeftImageRes(){
        return leftImage;
    }


    public void setRightImageRes(int res){
        this.setImageResource(res);
        rightImage=res;
    }
    public int getRightImageRes(){
       return rightImage;
    }

    private void changeImageRes(int res){
        this.setImageResource(res);
    }

}
