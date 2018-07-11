package com.first.alina.utilsdemo.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.first.alina.utilsdemo.R;


/**
 * Created by alina on 2018/5/22.
 */

public class RatingBarView extends LinearLayout{
    private final String TAG="RatingBarView";
    private float ratingBarImageSize;
    private int ratingBarCount;
    private float ratingBarPadding;
    private float ratingImageWidth;
    private float ratingImageHeight;
    private Drawable fullResouce;
    private Drawable halfResouce;
    private Drawable emptyResouce;
    private Drawable dividerDrawable;
    private boolean isHalf;

    public RatingBarView(Context context) {
        super(context,null);
    }

    public RatingBarView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs);
    }

    public RatingBarView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setOrientation(LinearLayout.HORIZONTAL);
        TypedArray typedArray=context.obtainStyledAttributes(attrs, R.styleable.RatingBarStyle,0,0);
        ratingBarImageSize=typedArray.getDimension(R.styleable.RatingBarStyle_ratingImageSize,60);
        ratingBarCount=typedArray.getInteger(R.styleable.RatingBarStyle_ratingCount,5);
        ratingBarPadding=typedArray.getDimension(R.styleable.RatingBarStyle_ratingImagePadding,30);
        ratingImageWidth=typedArray.getDimension(R.styleable.RatingBarStyle_ratingWidth,60);
        ratingImageHeight=typedArray.getDimension(R.styleable.RatingBarStyle_ratingHeight,60);
        fullResouce=typedArray.getDrawable(R.styleable.RatingBarStyle_ratingImageFull);
        halfResouce=typedArray.getDrawable(R.styleable.RatingBarStyle_ratingStartHalf);
        emptyResouce=typedArray.getDrawable(R.styleable.RatingBarStyle_ratingImageEmpty);
        isHalf=typedArray.getBoolean(R.styleable.RatingBarStyle_half,false);
        dividerDrawable=typedArray.getDrawable(R.styleable.RatingBarStyle_dividerDrawable);
        typedArray.recycle();

    }


    private ImageView getRatingView(Context context){
        ImageView ratingView=new ImageView(context);
        return ratingView;
    }
    public void setBarCount(int count,int selectorCount){
        for (int i=0;i<count;i++){
            if (getChildCount()==0){
                ImageView ratingView=getRatingView(this.getContext());
                if (i<selectorCount){
                    ratingView.setImageDrawable(fullResouce);
                }else {
                    ratingView.setImageDrawable(emptyResouce);
                }
                addView(ratingView);
            }else {
                ImageView lastChildView= (ImageView) getChildAt(i-1);
                LinearLayout.LayoutParams layoutParams= (LayoutParams) lastChildView.getLayoutParams();
                layoutParams.rightMargin=20;
                ImageView ratingView=getRatingView(this.getContext());
                addView(ratingView,layoutParams);
            }

        }
    }
}
