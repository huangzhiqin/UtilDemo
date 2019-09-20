package com.first.alina.utilsdemo.windowsmanager;

import android.app.Activity;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.Toast;

import com.first.alina.utilsdemo.common.ScreenUtils;
import com.first.alina.utilsdemo.common.widget.LeftToRightScaleView;

/**
 * Created by alina on 2019/5/16.
 */

public class WindowsManager {
    private final String TAG="WindowsManager";
    private static volatile WindowsManager windowsManager;
    private WindowManager windowManager;
    private WindowManager.LayoutParams layoutParams;
    private LeftToRightScaleView leftToRightScaleView;

    public WindowsManager() {
    }

    public static WindowsManager getInstance() {
        if (windowsManager == null) {
            synchronized (WindowsManager.class) {
                if (windowsManager == null) {
                    windowsManager = new WindowsManager();
                }
            }
        }
        return windowsManager;
    }

    public void showFloatView(final Activity context) {
        leftToRightScaleView = new LeftToRightScaleView(context);
        layoutParams = new WindowManager.LayoutParams();
        layoutParams.height = ScreenUtils.dip2px(context,44);
        layoutParams.width = ScreenUtils.dip2px(context,152);
        layoutParams.type = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY;
        layoutParams.gravity = Gravity.LEFT | Gravity.TOP;  //窗口位置
        windowManager = context.getWindowManager();
        windowManager.addView(leftToRightScaleView, layoutParams);
        leftToRightScaleView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                leftToRightScaleView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });
        final int touchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        leftToRightScaleView.setOnTouchListener(new View.OnTouchListener() {
            float lastX;
            float lastY;
            boolean isPerformClick;
            float screenWidth = ScreenUtils.getScreenWidth(context);

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        isPerformClick = true;
                        lastX = event.getX();
                        lastY = event.getY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        if (Math.abs(lastX - event.getX()) >= touchSlop || Math.abs(lastY - event.getY()) >= touchSlop) {
                            isPerformClick = false;

                        }
                        float getRawX = event.getRawX();
                        float getRawY = event.getRawY();
                        int distanceX = (int) (getRawX - lastX);
                        int distanceY = (int) (getRawY - lastY);
                        layoutParams.x = distanceX;
                        layoutParams.y = distanceY;
                        upWindowPosition();
                        break;

                    case MotionEvent.ACTION_UP:
                        if (event.getRawX() > screenWidth / 2) {
                            layoutParams.x = (int) screenWidth - 10;
                        } else {
                            layoutParams.x = 10;
                        }
                        layoutParams.y = (int) event.getRawY();
                        upWindowPosition();
                        break;
                }
                return true;
            }
        });
        leftToRightScaleView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "点击事件", Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void upWindowPosition() {
        layoutParams.width=leftToRightScaleView.getWidth();
        Log.e(TAG,"=========>upWindowPosition width="+leftToRightScaleView.getWidth());
        windowManager.updateViewLayout(leftToRightScaleView, layoutParams);

    }

}
