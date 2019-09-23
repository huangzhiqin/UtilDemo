package com.first.alina.utilsdemo.imageLoader;

import android.os.Build;
import android.widget.ImageView;

/**
 * Created by alina on 2018/6/3.
 */

public class ImageConfigImpl extends ImageConfig{
    public int blurValue;//图片模糊度
    public int imageRadius;//图片圆角
    public boolean circleCrop;//圆形

    private ImageConfigImpl(Builder builder){
        this.url=builder.url;
        this.imageView=builder.imageView;
        this.blurValue=builder.blurValue;
        this.imageRadius=builder.imageRadius;
        this.errorHolder=builder.errorHolder;
        this.placeHolder=builder.placeHolder;
        this.skipMemoryCache=builder.skipMemoryCache;
        this.circleCrop=builder.circleCrop;
    }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder{
        private String url;
        private int placeHolder;
        private int errorHolder;
        private ImageView imageView;
        private int imageRadius;
        private int blurValue;
        private boolean skipMemoryCache;
        public boolean circleCrop;//圆形
        public Builder url(String url){
            this.url=url;
            return this;
        }

        public Builder placeHolder(int placeHolder){
            this.placeHolder=placeHolder;
            return this;
        }

        public Builder errorHolder(int errorHolder){
            this.errorHolder=errorHolder;
            return this;
        }

        public Builder imageView(ImageView imageView){
            this.imageView=imageView;
            return this;
        }

        public Builder imageRadius(int imageRadius){
            this.imageRadius=imageRadius;
            return this;
        }

        public Builder skipMemoryCache(boolean skip){
            this.skipMemoryCache=skip;
            return this;
        }

        public Builder blurValue(int blurValue){
            this.blurValue=blurValue;
            return this;
        }

        public Builder circleCrop(boolean circleCrop){
            this.circleCrop=circleCrop;
            return this;
        }
        public ImageConfigImpl build(){
            return new ImageConfigImpl(this);
        }
    }
}
