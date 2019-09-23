package com.first.alina.utilsdemo.imageLoader;

import android.content.Context;
import android.widget.ImageView;

/**
 * Created by alina on 2018/6/3.
 */

public interface BaseImageLoaderStrategy <T extends ImageConfig>{
    void displayImage(Context context, String url, ImageView imgView);
    void displayImage(Context context, T t);
}
