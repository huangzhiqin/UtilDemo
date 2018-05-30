package com.first.alina.utilsdemo.recyclerviews.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import com.first.alina.utilsdemo.R;

/**
 * Created by alina on 2018/5/25.
 */

public class SwipeMenuLayout extends FrameLayout implements SwipeSwitch{
    public SwipeMenuLayout(@NonNull Context context) {
        super(context,null);
    }

    public SwipeMenuLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs,0);
    }

    public SwipeMenuLayout(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    @Override
    public boolean isMenuOpen() {
        return false;
    }

    @Override
    public boolean isMenuClose() {
        return false;
    }

    @Override
    public boolean isLeftMenuOpen() {
        return false;
    }

    @Override
    public boolean isRightMenuOpen() {
        return false;
    }

    @Override
    public boolean isCompleteOpen() {
        return false;
    }

    @Override
    public boolean isCompleteClose() {
        return false;
    }

    @Override
    public boolean isLeftCompleteOpen() {
        return false;
    }

    @Override
    public boolean isLeftCompleteClose() {
        return false;
    }

    @Override
    public boolean isRightCompleteOpen() {
        return false;
    }

    @Override
    public boolean isRightCompleteClose() {
        return false;
    }

    @Override
    public void smoothRightOpenMenu() {

    }

    @Override
    public void smoothRightCloseMenu() {

    }

    @Override
    public void smoothLeftOpenMenu() {

    }

    @Override
    public void smoothLeftCloseMenu() {

    }

    @Override
    public void smoothRigthOpenMenu(int duration) {

    }

    @Override
    public void smoothRightCloseMenu(int duration) {

    }

    @Override
    public void smoothLeftOpenMenu(int duration) {

    }

    @Override
    public void smoothLeftCloseMenu(int duration) {

    }

    @Override
    public void smoothOpenMenu() {

    }

    @Override
    public void smoothCloseMenu() {

    }

    @Override
    public void smoothCloseMenu(int duration) {

    }
}
