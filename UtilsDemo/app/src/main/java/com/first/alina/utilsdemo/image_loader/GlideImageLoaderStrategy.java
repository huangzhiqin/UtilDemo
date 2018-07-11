package com.first.alina.utilsdemo.image_loader;

import android.content.Context;

import com.bumptech.glide.Glide;

/**
 * Created by alina on 2018/6/3.
 */

public class GlideImageLoaderStrategy implements BaseImageLoaderStrategy<ImageConfigImpl>{

    @Override
    public void displayImage(Context context, ImageConfigImpl imageConfig) {
        Glide.with(context).load(imageConfig.getUrl()).into(imageConfig.getImageView());

    }
}
