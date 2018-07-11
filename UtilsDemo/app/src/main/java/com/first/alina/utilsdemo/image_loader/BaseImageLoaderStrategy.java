package com.first.alina.utilsdemo.image_loader;

import android.content.Context;
import android.widget.TextView;

/**
 * Created by alina on 2018/6/3.
 */

public interface BaseImageLoaderStrategy <T extends ImageConfig>{
    void displayImage(Context context, T t);
}
