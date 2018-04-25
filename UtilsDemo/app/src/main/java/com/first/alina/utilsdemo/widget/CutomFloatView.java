package com.first.alina.utilsdemo.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.support.annotation.Px;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.animation.DecelerateInterpolator;

import com.first.alina.utilsdemo.common.ScreenUtils;


/**
 * Created by alina on 2018/4/18.
 */

public class CutomFloatView extends android.support.v7.widget.AppCompatImageView {
    private final String TAG = "CutomFloatView";
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
    private int top, bottom;
    private float rawX;
    private float rawY;
    private int statusBarHeight;//状态栏高度
    private ValueAnimator animator;
    private DecelerateInterpolator decelerateInterpolator;
    private ObjectAnimator rotationAnimator;
    private boolean actionDown=true;//只有首次绘制View和触摸时，才会调用layout方法，这方法可以避免，在滑动ListView或者更新页面时，CutomFloatView会复位的问题

    public CutomFloatView(Context context) {
        super(context);
        this.context = context;
        initView();
    }

    public CutomFloatView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initView();
    }

    public CutomFloatView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        initView();
    }

    private void initView() {

        statusBarHeight = ScreenUtils.getStatusHeight(context);
        screenHeight = ScreenUtils.getScreenHeight(context);
        screenWidth = ScreenUtils.getScreenWidth(context);
        minScroll = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public int getStatusBarHeight(){
        if (statusBarHeight==-1){
            statusBarHeight=0;
        }
        return statusBarHeight;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width = getMeasuredWidth();
        height = getMeasuredHeight();
        setLeftImageRes(leftImage);
        Log.e(TAG,"==> onMeasure");
    }

    @Override
    public void layout(@Px int l, @Px int t, @Px int r, @Px int b) {
        if (actionDown){
            super.layout(l, t, r, b);
        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:

                cancleAnimator();
                downX = event.getX();
                downY = event.getY();
                rawX = event.getRawX();
                rawY = event.getRawY();
                break;
            case MotionEvent.ACTION_MOVE:
                final float xDistance = event.getX() - downX;
                final float yDistance = event.getY() - downY;
                int l, r;
                if (Math.abs(xDistance) > 10 || Math.abs(yDistance) > 10) {

                    l = (int) (getLeft() + xDistance);
                    r = l + width;
                    top = (int) (getTop() + yDistance);
                    bottom = top + height;
                    if (l < 0) {
                        l = 0;
                        r = l + width;
                    } else if (r > screenWidth) {
                        r = screenWidth;
                        l = r - width;
                    }
                    if (top <=0) {
                        top = 0;
                        bottom = top + height;
                    } else if (top >= screenHeight-height-getStatusBarHeight()) {
                        bottom = getBottom();
                        top = getTop();
                    }
                    actionDown=true;
                    this.layout(l, top, r, bottom);
                    actionDown=false;
                }
                break;
            case MotionEvent.ACTION_UP:
                if (Math.abs(event.getRawX() - rawX) <= minScroll && Math.abs(event.getRawY() - rawY) <= minScroll) {
                    setEnabled(true);
                } else {
                    setEnabled(false);//在拖动的过程中，禁止View点击事件
                    if (event.getRawX() >= screenWidth / 2) {
                        startRotationAnimator(-18, 9, -18, -9);
                        startTranslationAnimator((int)getX(),screenWidth-width);
                        changeImageRes(rightImage);
                    } else {
                        startRotationAnimator(18, -9, 18, 9);
                        startTranslationAnimator((int) getX(),0);
                        changeImageRes(leftImage);
                    }
                }


                break;
            case MotionEvent.ACTION_CANCEL:
                Log.e(TAG, "==> action_cancel");
                break;

        }
        setEnabled(true);
        return true;
    }


    public void setLeftImageRes(int res) {
        this.setImageResource(res);
        leftImage = res;
    }

    public int getLeftImageRes() {
        return leftImage;
    }


    public void setRightImageRes(int res) {
        this.setImageResource(res);
        rightImage = res;
    }

    public int getRightImageRes() {
        return rightImage;
    }

    private void changeImageRes(int res) {
        this.setImageResource(res);
    }


    /**
     * 在X方向上弹性移动
     * @param startX
     * @param endX
     */
    private void startTranslationAnimator(int startX,int endX){
        if (decelerateInterpolator==null){
            decelerateInterpolator=new DecelerateInterpolator();
        }
        animator=ObjectAnimator.ofInt(startX,endX);
        animator.setInterpolator(decelerateInterpolator);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int upX=(int)animation.getAnimatedValue();
                actionDown=true;
                layout(upX,top,upX+width,bottom);
                actionDown=false;
            }

        });
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                animation.removeAllListeners();
                animation.removeAllListeners();
            }
        });
        animator.setDuration(500).start();

    }

    /**
     * 旋转动画
     * @param values1
     * @param values2
     * @param values3
     * @param values4
     */
    private void startRotationAnimator(int values1,int values2,int values3,int values4){
        if (decelerateInterpolator==null){
            decelerateInterpolator=new DecelerateInterpolator();
        }
        rotationAnimator = ObjectAnimator.ofFloat(this, "rotation",values1, values2, values3, values4);
        rotationAnimator.setDuration(1500);
        rotationAnimator.setInterpolator(decelerateInterpolator);
        rotationAnimator.start();
    }

    private void cancleAnimator(){
        if (animator!=null&&animator.isRunning()){
            animator.cancel();
        }
        if (rotationAnimator!=null&&rotationAnimator.isRunning()){
            rotationAnimator.cancel();
        }

    }

}
