package com.first.alina.utilsdemo.imageManager;

import android.view.View;

/**
 * Created by alina on 2019/4/9.
 */

public interface ImageLoaderStrategy {
    void showImage(View view,String url,ImageLoaderOptions options);
}
