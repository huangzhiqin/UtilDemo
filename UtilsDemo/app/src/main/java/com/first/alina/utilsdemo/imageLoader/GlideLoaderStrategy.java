package com.first.alina.utilsdemo.imageLoader;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.first.alina.utilsdemo.R;

/**
 * Created by alina on 2018/6/3.
 */

public class GlideLoaderStrategy implements BaseImageLoaderStrategy<ImageConfigImpl> {
    private static GlideLoaderStrategy glideImageLoaderStrategy;

    private GlideLoaderStrategy() {

    }

    public static GlideLoaderStrategy getInstance() {
        if (glideImageLoaderStrategy == null) {
            synchronized (GlideLoaderStrategy.class) {
                if (glideImageLoaderStrategy == null) {
                    glideImageLoaderStrategy = new GlideLoaderStrategy();
                }
            }
        }
        return glideImageLoaderStrategy;
    }

    @Override
    public void displayImage(Context context, String url, ImageView imgView) {
        if (TextUtils.isEmpty(url)) {
            throw new NullPointerException(" url not null");
        }
        if (imgView == null) {
            throw new NullPointerException(" imageView not null");
        }
        ImageConfigImpl imageConfig = ImageConfigImpl.builder().errorHolder(R.drawable.ic_error).placeHolder(R.drawable.ic_error).build();
        RequestOptions options = new RequestOptions()
                .apply(baseOption(imageConfig));
        Glide.with(context).load(url).apply(options).into(imgView);
    }

    @Override
    public void displayImage(Context context, ImageConfigImpl imageConfig) {
        if (imageConfig != null) {
            RequestOptions options=baseOption(imageConfig);
            if (imageConfig.circleCrop){
                options= options.apply(RequestOptions.bitmapTransform(new CircleCrop()));
            }

            Glide.with(context).load(imageConfig.getUrl()).apply(options).into(imageConfig.getImageView());
        }

    }

    private RequestOptions baseOption(ImageConfigImpl imageConfig) {
        if (imageConfig == null) {
            return new RequestOptions();
        }
        int errorId = R.drawable.ic_error;
        int placeId = R.drawable.ic_error;
        boolean skipMemoryCache;
        if (imageConfig.errorHolder != 0) {
            errorId = imageConfig.errorHolder;
        }
        if (imageConfig.placeHolder != 0) {
            placeId = imageConfig.placeHolder;
        }
        skipMemoryCache = imageConfig.skipMemoryCache;
        return new RequestOptions()
                .placeholder(placeId)
                .error(errorId)
                .skipMemoryCache(skipMemoryCache);
    }
}
