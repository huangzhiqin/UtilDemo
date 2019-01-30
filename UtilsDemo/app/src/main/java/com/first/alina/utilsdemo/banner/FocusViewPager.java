package com.first.alina.utilsdemo.banner;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;


import com.first.alina.utilsdemo.R;

import java.util.List;

/**
 * Created by alina on 2017/11/21.
 */

public class FocusViewPager extends ViewPager {
    private final String TAG = "FocusViewPager";

    private ViewGroup parent;
    private boolean mIsLoop;
    private int mLoopTime;
    private int LOOP_WHAT = 1;
    private int LOOP_COUNT = 5000;
    private int mCurrentIndex;
    private LayoutInflater mLayoutInflater;
    private Handler mHanler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (LOOP_WHAT == msg.what) {
                mCurrentIndex = getCurrentItem();
                if (mCurrentIndex >= LOOP_COUNT / 2) {
                    mCurrentIndex++;
                }
                if (mCurrentIndex > LOOP_COUNT) {
                    mCurrentIndex = LOOP_COUNT / 2;
                }
                setCurrentItem(mCurrentIndex);
                mHanler.sendEmptyMessageDelayed(LOOP_WHAT, mLoopTime);
            }
        }
    };
    private boolean mIsScroll;

    public FocusViewPager(Context context) {
        super(context, null);
        parent = (ViewGroup) getParent();
    }

    public FocusViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        parent = (ViewGroup) getParent();
        mLayoutInflater = LayoutInflater.from(context);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.banner_Indicator);
        mIsLoop = typedArray.getBoolean(R.styleable.banner_Indicator_isLoop, false);
        mLoopTime = typedArray.getInt(R.styleable.banner_Indicator_loopTime, 4000);
        typedArray.recycle();
        if (mIsLoop) {
            mHanler.sendEmptyMessageDelayed(LOOP_WHAT, mLoopTime);
        }
        addOnPageChangeListener(new OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    public void startPlay(){
        if (mIsScroll){
            mHanler.removeMessages(LOOP_WHAT);
            mHanler.removeCallbacksAndMessages(null);
            mHanler.sendEmptyMessageDelayed(LOOP_WHAT, mLoopTime);
        }

    }

    public void stopPlay(){
        mHanler.removeMessages(LOOP_WHAT);
        mHanler.removeCallbacksAndMessages(null);
    }

    public void setViewPagerListener(int LayoutId, BannerViewPagerBuilder builder, FocusViewListener focusViewListener) {
        FocusViewPagerAdapter adapter = new FocusViewPagerAdapter(LayoutId, builder.list, focusViewListener);
        setAdapter(adapter);
        adapter.notifyDataSetChanged();
        setOffscreenPageLimit(3);
        setCurrentItem(builder.list.size() + LOOP_COUNT / 2);
        if (builder.indicatorView != null) {
            if (builder.indicatorView instanceof TransIndicator) {
                ((TransIndicator) builder.indicatorView).addPagerData(builder, this);
            }
        }
    }


    class FocusViewPagerAdapter<T> extends PagerAdapter {
        int LayoutId;
        List<T> list;
        FocusViewListener listener;

        public FocusViewPagerAdapter(int layoutId, List<T> list, FocusViewListener focusViewListener) {
            this.LayoutId = layoutId;
            this.list = list;
            this.listener = focusViewListener;
        }

        @Override
        public int getCount() {
            return list.size() + LOOP_COUNT;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = mLayoutInflater.inflate(LayoutId, null);
            listener.getItemView(view, list.get(position % list.size()));
            container.addView(view, 0);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        mHanler.removeMessages(LOOP_WHAT);
        mHanler.removeCallbacksAndMessages(null);
        int action = ev.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:

                if (parent != null) {
                    //禁止上一层的View不处理该事件,屏蔽父组件的事件
                    parent.requestDisallowInterceptTouchEvent(true);
                }
                break;
            case MotionEvent.ACTION_CANCEL:

                if (parent != null) {
                    //拦截
                    parent.requestDisallowInterceptTouchEvent(false);
                }
                break;
            case MotionEvent.ACTION_UP:
                if (mIsScroll){
                    mHanler.sendEmptyMessageDelayed(LOOP_WHAT, mLoopTime);
                }


                break;

            default:

                break;
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (mIsScroll) {
            try {
                return super.onInterceptTouchEvent(ev);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {

        if (mIsScroll){
            return super.onTouchEvent(ev);
        }else
            return false;


    }

    public void isScroll(boolean scroll){
        mIsScroll = scroll;

    }

}