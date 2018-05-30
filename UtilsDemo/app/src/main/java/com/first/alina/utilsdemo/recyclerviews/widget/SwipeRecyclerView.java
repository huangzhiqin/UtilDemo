package com.first.alina.utilsdemo.recyclerviews.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

/**
 * Created by alina on 2018/5/25.
 */

public class SwipeRecyclerView extends RecyclerView{
    private int scaleTouchSlop;
    private boolean allowSwipeDelete;
    private static final int INVALID_POSITION = -1;
    protected int oldTouchedPosition = INVALID_POSITION;

    /**
     * Left menu.
     */
    public static final int LEFT_DIRECTION = 1;
    /**
     * Right menu.
     */
    public static final int RIGHT_DIRECTION = -1;

    private int mDownX;
    private int mDownY;
    public SwipeRecyclerView(Context context) {
        super(context,null);
    }

    public SwipeRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs,0);
    }

    public SwipeRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        scaleTouchSlop= ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent e) {
        boolean isIntercepted=super.onInterceptTouchEvent(e);
        if (allowSwipeDelete){
            return isIntercepted;
        }else {
            if (e.getPointerCount()>1)return true;//多指触屏不触发侧滑删除功能
            int action=e.getAction();
            int x=(int)e.getX();
            int y=(int)e.getY();
            switch (action){
                case MotionEvent.ACTION_DOWN:
                    mDownX=x;
                    mDownY=y;
                    isIntercepted=false;
                    int touchingPosition=getChildAdapterPosition(findChildViewUnder(x,y));
                   // if (touchingPosition!=oldTouchedPosition&&)
                    break;
                case MotionEvent.ACTION_MOVE:

                    break;
                case MotionEvent.ACTION_UP:
                case MotionEvent.ACTION_CANCEL:

                    break;
            }

        }
        return super.onInterceptTouchEvent(e);
    }
}
