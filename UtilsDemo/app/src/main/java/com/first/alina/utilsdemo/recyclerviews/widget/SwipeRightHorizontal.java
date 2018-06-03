package com.first.alina.utilsdemo.recyclerviews.widget;

import android.view.View;
import android.widget.OverScroller;

/**
 * Created by alina on 2018/5/25.
 */

public class SwipeRightHorizontal extends SwipeHorizontal{
    public SwipeRightHorizontal( View menuView) {
        super(SwipeRecyclerView.RIGHT_DIRECTION, menuView);
    }

    @Override
    public boolean isMenuOpen(int scrollX) {
        int i=-getMenuWidth()*getDirection();
        return scrollX>=i&&i!=0;
    }

    @Override
    public void autoMenuOpen(OverScroller scroller, int scrollX, int duration) {
        scroller.startScroll(Math.abs(scrollX),0,getMenuWidth()-Math.abs(scrollX),0,duration);

    }

    @Override
    public void autoMenuClose(OverScroller scroller, int scrollX, int duration) {
        scroller.startScroll(-Math.abs(scrollX),0,Math.abs(scrollX),0,duration);
    }

    @Override
    public Checker checkXY(int x, int y) {
        mChecker.x=x;
        mChecker.y=y;
        mChecker.shouldResetSwipe=false;
        if (mChecker.x==0){
            mChecker.shouldResetSwipe=true;
        }
        if (mChecker.x<0){
            mChecker.x=0;
        }
        if (mChecker.x>getMenuWidth()){
            mChecker.x=getMenuWidth();
        }
        return mChecker;
    }

    @Override
    public boolean isClickOnContentView(int contentViewWidth, float x) {
        return x<contentViewWidth-getMenuWidth();
    }
}
