package com.first.alina.utilsdemo.scrollview.activitys;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;

import com.first.alina.utilsdemo.R;
import com.first.alina.utilsdemo.common.recyclerviews.ViewHolder;
import com.first.alina.utilsdemo.scrollview.adapters.Adapter1;
import com.first.alina.utilsdemo.scrollview.beans.TextBean;
import com.first.alina.utilsdemo.scrollview.viewholders.TextViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alina on 2018/7/12.
 */

public class TextScrollviewaActivity extends Activity {

    //注意ImageView 中的 android:layout_gravity="centerCrop"不可以少，不然放大时就不是已中点为中心放大了



    private ScrollView scrollView;
    private ImageView img;
    private RecyclerView recyclerView;

    // 记录首次按下位置
    private float mFirstPosition = 0;
    // 是否正在放大
    private Boolean mScaling = false;

    private DisplayMetrics metric;
    private List<Object> textBeenList = new ArrayList<>();
    private Adapter1<Object> adapter1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_scroll);



        // 获取屏幕宽高
        metric = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metric);

        //获取控件
        scrollView = (ScrollView) findViewById(R.id.scollview);
        img = (ImageView) findViewById(R.id.img);
        recyclerView=findViewById(R.id.recyclerView_scroll_text);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        initData();
        //设置图片初始大小  这里我设为满屏的16:9
        ViewGroup.LayoutParams lp = (ViewGroup.LayoutParams) img.getLayoutParams();
        lp.width = metric.widthPixels;
        lp.height = metric.widthPixels * 9 / 16;
        img.setLayoutParams(lp);

        //监听滚动事件
        scrollView.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint({ "ClickableViewAccessibility", "NewApi" })
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                ViewGroup.LayoutParams lp = (ViewGroup.LayoutParams) img.getLayoutParams();
                switch (event.getAction()) {
                    case MotionEvent.ACTION_UP:
                        //手指离开后恢复图片
                        mScaling = false;
                        replyImage();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        if (!mScaling) {
                            if (scrollView.getScrollY() == 0) {
                                mFirstPosition = event.getY();// 滚动到顶部时记录位置，否则正常返回
                            } else {
                                break;
                            }
                        }
                        int distance = (int) ((event.getY() - mFirstPosition) * 0.6); // 滚动距离乘以一个系数
                        if (distance < 0) { // 当前位置比记录位置要小，正常返回
                            break;
                        }

                        // 处理放大
                        mScaling = true;
                        lp.width = metric.widthPixels + distance;
                        lp.height = (metric.widthPixels + distance) * 9 / 16;
                        img.setLayoutParams(lp);
                        return true; // 返回true表示已经完成触摸事件，不再处理
                }
                return false;
            }
        });

    }

    // 回弹动画 (使用了属性动画)
    @SuppressLint("NewApi")
    public void replyImage() {
        final ViewGroup.LayoutParams lp = (ViewGroup.LayoutParams) img.getLayoutParams();
        final float w = img.getLayoutParams().width;// 图片当前宽度
        final float h = img.getLayoutParams().height;// 图片当前高度
        final float newW = metric.widthPixels;// 图片原宽度
        final float newH = metric.widthPixels * 9 / 16;// 图片原高度

        // 设置动画
        ValueAnimator anim = ObjectAnimator.ofFloat(0.0F, 1.0F).setDuration(200);

        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float cVal = (Float) animation.getAnimatedValue();
                lp.width = (int) (w - (w - newW) * cVal);
                lp.height = (int) (h - (h - newH) * cVal);
                img.setLayoutParams(lp);
            }
        });
        anim.start();

    }

    private void initData() {
        for (int i = 0; i < 80; i++) {
            TextBean textBean = new TextBean();
            textBean.title = "第 " + i + " 条数据";
            textBeenList.add(textBean);
        }
        adapter1 = new Adapter1<Object>(this) {
            @Override
            public Class<? extends ViewHolder> getHolderClass(Object object, int position) {
                if (object instanceof TextBean) {
                    return TextViewHolder.class;
                }
                return TextViewHolder.class;
            }
        };
        adapter1.addData(textBeenList);
        recyclerView.setAdapter(adapter1);
    }

}
