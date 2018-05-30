package com.first.alina.utilsdemo.recyclerviews.widget;

import android.view.View;
import android.view.ViewGroup;
import android.widget.OverScroller;

/**
 * Created by alina on 2018/5/25.
 */

abstract class SwipeHorizontal {

    private int direcation;
    private View menuView;
    protected Checker mChecker;

    public SwipeHorizontal(int direcation, View menuView) {
        this.direcation = direcation;
        this.menuView = menuView;
    }
    public boolean canSwipe(){
        if (menuView instanceof ViewGroup){
            return ((ViewGroup)menuView).getChildCount()>0;
        }
        return false;
    }

    public int getDirection(){
        return direcation;
    }

    public boolean isCompleteClose(int scrollX){
        int i=-getMenuWidth()*getDirection();

        return scrollX==0&&i!=0;
    }

    public abstract boolean isMenuOpen(int scrollX);

    public abstract void autoMenuOpen(OverScroller scroller,int scrollX,int duration);

    public abstract void autoMenuClose(OverScroller scroller,int scrollX,int duration);

    public abstract Checker checkXY(int x,int y);

    public abstract boolean isClickOnContentView(int contentViewWidth,float x);

    public View getMenuView(){
       return menuView;
    }

    public int getMenuWidth(){
        return menuView.getWidth();
    }

    public static final class Checker{
        public int x;
        public int y;
        public boolean shouldResetSwipe;
    }
}
