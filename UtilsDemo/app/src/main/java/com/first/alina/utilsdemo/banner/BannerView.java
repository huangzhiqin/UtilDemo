package com.first.alina.utilsdemo.banner;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.first.alina.utilsdemo.R;
import com.first.alina.utilsdemo.banner.viewholder.BannerVHolder;
import com.first.alina.utilsdemo.banner.viewholder.BannerVHolderCreator;
import com.first.alina.utilsdemo.common.ScreenUtils;

import java.util.List;

/**
 * Created by alina on 2018/10/10.
 */

public class BannerView<T> extends RelativeLayout {
    private boolean isClipChildren;
    private int itemcount;
    private BannerVHolderCreator bannerVHolderCreator;
    private BannerAdapter bannerAdapter;
    private List<T> mDatas;
    private ViewPager viewPager;

    public BannerView(Context context) {
        this(context, null);
    }

    public BannerView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BannerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        View view;
        if (isClipChildren) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.normal_banner, this, true);
        } else {
            view = LayoutInflater.from(getContext()).inflate(R.layout.clipchildren_banner, this, true);
        }
        viewPager = view.findViewById(R.id.banner);
        viewPager.setOffscreenPageLimit(3);
    }

    public void setClipChildren(boolean clipChildren) {
        this.isClipChildren = clipChildren;
    }

    public void setPageListener(List<T> datas, BannerVHolderCreator bannerVHolderCreator) {
        mDatas = datas;
        this.bannerVHolderCreator = bannerVHolderCreator;
        bannerAdapter = new BannerAdapter(datas);
        viewPager.setAdapter(bannerAdapter);
        //viewPager.setCurrentItem(0);
        //viewPager.clearOnPageChangeListeners();
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
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

        if (isClipChildren){
            viewPager.setPageTransformer(true,new CoverModeTransformer(viewPager));
        }else {
            viewPager.setPageTransformer(false,new ScaleTransformer());
        }
    }

    public class BannerAdapter extends PagerAdapter {

        private List<T> data;

        public BannerAdapter(List<T> data) {
            this.data = data;
        }

        @Override
        public int getCount() {
            Log.e("BannerAdapter ", "==> getCount=" + data.size());
            return data == null ? 0 : data.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            Log.e("BannerAdapter ", "==> isViewFromObject=" + (object == view));
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = getView(position, container);
            container.addView(view);
            Log.e("BannerAdapter ", "==> instantiateItem=");
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }

    private View getView(int position, final ViewGroup container) {
        BannerVHolder bannerVHolder = bannerVHolderCreator.createHolder();
        View view = null;
        if (bannerVHolder == null) {
            throw new RuntimeException("can not a holder");
        } else {
            view = bannerVHolder.createView(container.getContext(), container);
        }
        view.setLayoutParams(new LayoutParams(ScreenUtils.dip2px(container.getContext(),100), ViewGroup.LayoutParams.MATCH_PARENT));

        if (mDatas != null && mDatas.size() > 0) {
            bannerVHolder.bindData(container.getContext(), mDatas, position);
        }
        view.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(container.getContext(), "点击", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

}
