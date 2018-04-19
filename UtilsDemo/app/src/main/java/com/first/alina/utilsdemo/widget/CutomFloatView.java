package com.first.alina.utilsdemo.widget;

import android.content.Context;
import android.support.v4.view.ViewConfigurationCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.ImageView;

import com.first.alina.utilsdemo.common.ScreenUtils;


/**
 * Created by alina on 2018/4/18.
 */

public class CutomFloatView extends android.support.v7.widget.AppCompatImageView{
    private final String TAG="CutomFloatView";
    private ImageView floatImge;
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
    public CutomFloatView(Context context) {
        super(context);
        this.context=context;
    }

    public CutomFloatView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context=context;
       // initView(context);
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
        minScroll=ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(context));
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                downX=event.getX();
                downY=event.getY();
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
                    Log.e(TAG,"==> l="+l+" r="+r+" t="+top+" b="+bottom);
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
                if (event.getRawX()>=screenWidth/2){
                    changeImageRes(rightImage);
                    this.layout(screenWidth-width,top,screenWidth,bottom);
                }else {
                    changeImageRes(leftImage);
                    this.layout(0,top,width,bottom);
                }
                Log.e(TAG,"==> up left "+getLeft()+" width= "+width+" top="+top+" bottom="+bottom);
                break;

        }
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
