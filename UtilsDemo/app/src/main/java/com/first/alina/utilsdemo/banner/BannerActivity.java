package com.first.alina.utilsdemo.banner;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.first.alina.utilsdemo.R;
import com.first.alina.utilsdemo.banner.bean.BannerBean;
import com.first.alina.utilsdemo.banner.viewholder.BannerVHolder;
import com.first.alina.utilsdemo.common.ScreenUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alina on 2018/10/10.
 */

public class BannerActivity extends Activity {
    private String TAG="BannerActivity";
    //private BannerView<BannerBean> bannerView;
    private List<BannerBean> bannerBeens;
    private String [] image=new String[]{"http://img0.imgtn.bdimg.com/it/u=4210784274,1296893488&fm=26&gp=0.jpg",
            "http://img4.imgtn.bdimg.com/it/u=2729636427,3678492377&fm=26&gp=0.jpg",
    "http://img2.imgtn.bdimg.com/it/u=3439449676,1924592330&fm=26&gp=0.jpg",
    "http://img2.imgtn.bdimg.com/it/u=923534578,3489180452&fm=26&gp=0.jpg",
    "http://img1.imgtn.bdimg.com/it/u=2918210382,2004110159&fm=26&gp=0.jpg",
            "http://img1.imgtn.bdimg.com/it/u=173260917,2098051876&fm=200&gp=0.jpg"};
    private TransIndicator mTransIndicator;
    private FocusViewPager focusViewPager;
    private ImageView mImage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner);
        focusViewPager=findViewById(R.id.banner_viewpager);
       // bannerView = findViewById(R.id.banner_view);
        mTransIndicator =findViewById(R.id.banner_indicator);
        focusViewPager.setPageTransformer(false, new ScaleTransformer());
       // bannerView.setClipChildren(false);
        bannerBeens = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            BannerBean bannerBean = new BannerBean();
            bannerBean.iamge=image[i];
            bannerBeens.add(bannerBean);
        }
        test();
      /*  bannerView.setPageListener(bannerBeens, new BannerVHolderCreator<BannerViewHolder>() {
            @Override
            public BannerViewHolder createHolder() {
                Log.e(TAG,"==> createHolder");
                return new BannerViewHolder();
            }
        });*/

    }

    private class BannerViewHolder implements BannerVHolder<BannerBean>{
        private ImageView imageView;
        @Override
        public View createView(Context context,ViewGroup container) {
            View view= LayoutInflater.from(context).inflate(R.layout.item_banner,container,false);
            imageView=view.findViewById(R.id.image);
            return view;
        }

        @Override
        public void bindData(Context context, List<BannerBean> data, int position) {
            Glide.with(context).load(data.get(position).iamge).into(imageView);
        }
    }

    private void test(){
        BannerViewPagerBuilder builder = new BannerViewPagerBuilder.Builder<BannerBean>()
                .setData(bannerBeens)
                .setIndicator(mTransIndicator)
                .builder();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) focusViewPager.getLayoutParams();
        layoutParams.leftMargin = ScreenUtils.dip2px(BannerActivity.this, 20);
        layoutParams.rightMargin = ScreenUtils.dip2px(BannerActivity.this, 20);
        focusViewPager.setLayoutParams(layoutParams);
        focusViewPager.isScroll(true);
        focusViewPager.startPlay();
        focusViewPager.setViewPagerListener(R.layout.fragment_featured_banner, builder, new FocusViewListener() {
            @Override
            public void getItemView(View view, Object data) {
                Log.e(TAG,"==> getItemView");
                mImage = view.findViewById(R.id.imageview);
                final BannerBean bannerBean = (BannerBean) data;
                Glide.with(BannerActivity.this).load(bannerBean.iamge).into(mImage);

            }
        });
    }
}
