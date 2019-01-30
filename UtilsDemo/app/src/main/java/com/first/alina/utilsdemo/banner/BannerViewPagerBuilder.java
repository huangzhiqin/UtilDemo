package com.first.alina.utilsdemo.banner;

import android.view.View;

import java.util.List;

/**
 * Created by alina on 2017/11/24.
 */

public class BannerViewPagerBuilder {
    public View indicatorView;
    public List<Object> list;
    public View view;

    public BannerViewPagerBuilder(Builder builder) {
        this.view = builder.view;
        this.list = builder.list;
        this.indicatorView=builder.indicatorView;

    }
    public static class Builder<T> {
        private List<T> list;
        private View view;
        private View indicatorView;

        public Builder setIndicator(View indicatorView){
            this.indicatorView=indicatorView;
            return this;
        }
        public Builder setData(List<T> list){
            if (this.list!=null){
                this.list.clear();
            }
            this.list=list;
            return this;
        }
        public Builder setView(View view){
            this.view=view;
            return this;
        }
        public BannerViewPagerBuilder builder(){
            return new BannerViewPagerBuilder(this);
        }

    }
}
