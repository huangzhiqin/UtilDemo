package com.first.alina.utilsdemo.scrollview.widget;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.BoolRes;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;

import com.first.alina.utilsdemo.common.ScreenUtils;

import java.util.logging.Logger;

/**
 * Created by alina on 2018/7/12.
 */

public class ScaleScrollView extends NestedScrollView implements View.OnTouchListener {
    private final String TAG = "ScaleScrollView";
    private View dropZoomView;
    private View childImageView;
    private View childTextView;
    private int dropImageViewWidth;
    private int dropImageViewHeight;
    private int dropTextViewWidth;
    private int dropTextViewHeight;
    private int dropViewWidth;
    private int dropViewHeight;
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

    private void initView() {
        setOverScrollMode(OVER_SCROLL_NEVER);
        if (getChildAt(0) != null) {
            ViewGroup viewGroup = (ViewGroup) getChildAt(0);
            if (viewGroup.getChildAt(0) != null) {
                ViewGroup childViewGroup = (ViewGroup) viewGroup.getChildAt(0);
                if (childViewGroup.getChildAt(0) != null) {
                    dropZoomView = viewGroup.getChildAt(0);
                    childImageView = childViewGroup.getChildAt(0);
                    childTextView = childViewGroup.getChildAt(1);
                }

                setOnTouchListener(this);
            }
        }
    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (dropViewWidth <= 0 || dropViewHeight <= 0) {
            dropViewWidth = dropZoomView.getMeasuredWidth();
            dropViewHeight = dropZoomView.getMeasuredHeight();
        }
        if (dropImageViewHeight <= 0 || dropImageViewWidth <= 0) {
            dropImageViewHeight = childImageView.getMeasuredHeight();
            dropImageViewWidth = childImageView.getMeasuredWidth();
        }
        if (dropTextViewHeight <= 0 || dropTextViewWidth <= 0) {
            dropTextViewHeight = childTextView.getMeasuredHeight();
            dropTextViewWidth = childTextView.getMeasuredWidth();
        }
        switch (event.getAction()) {
            case MotionEvent.ACTION_UP:
                isScaling = false;
                replyImage();
                break;
            case MotionEvent.ACTION_MOVE:

                if (!isScaling) {
                    if (getScrollY() == 0) {
                        firstPosition = event.getY();
                    } else {
                        break;
                    }
                }
                int distance = (int) ((event.getY() - firstPosition) * 0.6);
                if (distance < 0) {
                    break;
                }
                isScaling = true;
                setZoom(1 + distance);
                break;
            case MotionEvent.ACTION_DOWN:
                Log.e("ScaleScrollViewTouch", "==> ACTION_DOWN ");
                break;
        }
        return false;
    }

    private void setZoom(float distance) {
        if (dropViewHeight <= 0 || dropViewWidth <= 0) {
            return;
        }
        ViewGroup.LayoutParams lp = dropZoomView.getLayoutParams();
        lp.width = (int) (dropViewWidth + distance);
        lp.height = (int) ((dropViewWidth + distance) * 9 / 16);
        dropZoomView.setLayoutParams(lp);

        ViewGroup.LayoutParams lpImage = dropZoomView.getLayoutParams();
        lpImage.width = (int) (dropImageViewWidth + distance);
        lpImage.height = (int) ((dropImageViewWidth + distance) * 9 / 16);
        childImageView.setLayoutParams(lpImage);

        ViewGroup.LayoutParams lpTv = childTextView.getLayoutParams();
        lpTv.width = (int) (dropTextViewWidth + distance);
        lpTv.height = (int) ((dropTextViewWidth + distance) * 9 / 16);
        childTextView.setLayoutParams(lpTv);

    }

    // 回弹动画 (使用了属性动画)
    @SuppressLint("NewApi")
    public void replyImage() {
        final ViewGroup.LayoutParams lp = dropZoomView.getLayoutParams();
        final float w = dropZoomView.getLayoutParams().width;// 图片当前宽度
        final float h = dropZoomView.getLayoutParams().height;// 图片当前高度
        final float newW = ScreenUtils.getScreenWidth(this.getContext());// 图片原宽度
        final float newH = ScreenUtils.getScreenWidth(this.getContext()) * 9 / 16;// 图片原高度

        // 设置动画
        ValueAnimator anim = ObjectAnimator.ofFloat(0.0F, 1.0F).setDuration(200);

        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float cVal = (Float) animation.getAnimatedValue();
                lp.width = (int) (w - (w - newW) * cVal);
                lp.height = (int) (h - (h - newH) * cVal);
                dropZoomView.setLayoutParams(lp);
            }
        });
        anim.start();

    }
}
