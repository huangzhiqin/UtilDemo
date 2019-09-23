package com.first.alina.utilsdemo.imageLoader;

import android.widget.ImageView;

/**
 * Created by alina on 2018/6/3.
 */

public class ImageConfig {
    protected String url;
    protected ImageView imageView;
    protected int placeHolder;//占位符
    protected int errorHolder;//加载错误图片
    protected boolean skipMemoryCache;//跳过内存缓存

    public String getUrl(){
        return url;
    }

    public ImageView getImageView(){
        return imageView;
    }

    public int getPlaceHolder(){
        return placeHolder;
    }

    public int getErrorHolder(){
       return errorHolder;
    }
}
