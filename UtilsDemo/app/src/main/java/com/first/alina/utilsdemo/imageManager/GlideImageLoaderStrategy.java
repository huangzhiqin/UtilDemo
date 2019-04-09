package com.first.alina.utilsdemo.imageManager;

import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

/**
 * Created by alina on 2019/4/9.
 */

public class GlideImageLoaderStrategy implements ImageLoaderStrategy{
    @Override
    public void showImage(View view, String url, ImageLoaderOptions options) {
        if (view instanceof ImageView){
            Glide.with(view.getContext()).load(url).apply(setRequestOptions(new RequestOptions(),options));
        }
    }

    private RequestOptions setRequestOptions(RequestOptions requestOptions, ImageLoaderOptions options){
        if (options==null){
            return requestOptions;
        }
        if (options.errorRes!=0){
            requestOptions.error(options.errorRes);
        }
        if (options.placeRes!=0){
            requestOptions.placeholder(options.placeRes);
        }


        return requestOptions;
    }
}
