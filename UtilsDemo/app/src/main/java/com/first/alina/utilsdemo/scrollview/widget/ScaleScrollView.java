package com.first.alina.utilsdemo.scrollview.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

/**
 * Created by alina on 2018/7/12.
 */

public class ScaleScrollView extends ScrollView implements View.OnTouchListener{
    private final String TAG="ScaleScrollView";
    private View dropZoomView;
    private int dropViewWidth;
    private int dropViewHeght;
    private boolean isScaling;
    private float firstPosition;
    public ScaleScrollView(Context context) {
        super(context);
    }

    public ScaleScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ScaleScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        initView();
    }

    private void initView(){
        setOverScrollMode(OVER_SCROLL_NEVER);
        if (getChildAt(0)!=null){
            ViewGroup viewGroup= (ViewGroup) getChildAt(0);
            if (viewGroup.getChildAt(0)!=null){
                dropZoomView=viewGroup.getChildAt(0);
                Log.e(TAG,"==> first View !=null");
                setOnTouchListener(this);
            }
        }
    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (dropViewWidth<=0||dropViewHeght<=0){
            dropViewWidth=dropZoomView.getMeasuredWidth();
            dropViewHeght=dropZoomView.getMeasuredHeight();
        }
        switch (event.getAction()){
            case MotionEvent.ACTION_UP:
                isScaling=false;
                break;
            case MotionEvent.ACTION_MOVE:
                if (!isScaling){
                    if (getScaleY()==0){
                        firstPosition=event.getY();
                    }else {
                        break;
                    }
                }
                int distance= (int) ((event.getY()-firstPosition)*0.6);
                if (distance<0){
                    break;
                }
                isScaling=true;
                setZoom(1+distance);
                break;
        }
        return false;
    }

    private void setZoom(float distance){
        if (dropViewHeght<=0||dropViewWidth<=0){
            return;
        }
        ViewGroup.LayoutParams lp=dropZoomView.getLayoutParams();
        lp.width= (int) (dropViewWidth+distance);
        lp.height= (int) ((dropViewWidth+distance) * 9 / 16);
    }
}
