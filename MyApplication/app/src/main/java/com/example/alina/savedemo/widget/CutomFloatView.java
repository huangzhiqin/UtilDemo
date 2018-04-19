package com.example.alina.savedemo.widget;

import android.content.Context;
import android.support.v4.view.ViewConfigurationCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.ImageView;

import com.example.alina.savedemo.common.ScreenUtils;

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
    public CutomFloatView(Context context) {
        super(context);
        this.context=context;
      //  initView(context);
    }

    public CutomFloatView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context=context;
       // initView(context);
    }

    public CutomFloatView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context=context;
     //   initView(context);
    }

   /* private void initView(Context context){
        LayoutInflater.from(context).inflate(R.layout.layout_cutom_view,this);
        floatImge=findViewById(R.id.float_img);
    }*/

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
                downX=event.getRawX();
                downY=event.getRawY();
                break;
            case MotionEvent.ACTION_MOVE:
                final float xDistance=event.getRawX()-downX;
                final float yDistance=event.getRawY()-downY;
                int l,r,t,b;
                if (Math.abs(xDistance)>10||Math.abs(yDistance)>10){
                    l=(int)(getLeft()+xDistance);
                    r=l+width;
                    t=(int)(getTop()+yDistance);
                    b=t+height;
                    Log.e(TAG,"==> l="+l+" r="+r+" t="+t+" b="+b);
                    if(l<0){
                        l=0;
                        r=l+width;
                    }else if(r>screenWidth){
                        r=screenWidth;
                        l=r-width;
                    }
                    if(t<0){
                        t=0;
                        b=t+height;
                    }else if(b>screenHeight){
                        b=screenHeight;
                        t=b-height;
                    }
                    this.layout(l,t,r,b);

                }
                break;

        }
        return true;

    }
}
