package com.first.alina.utilsdemo.image_loader;

import android.content.Context;

/**
 * Created by alina on 2018/6/3.
 */

public  class ImageLoader {

    private BaseImageLoaderStrategy baseImageLoaderStrategy;

    public ImageLoader() {
    }

    public <T extends ImageConfig> void loadImage(Context context, T config){
        if (this.baseImageLoaderStrategy==null){
            throw new NullPointerException("you should invoke setLoadImgStrategy first");
        }
        this.baseImageLoaderStrategy.displayImage(context,config);
    }

    public void setLoadImageStrategy(BaseImageLoaderStrategy baseImageLoaderStrategy){
        this.baseImageLoaderStrategy=baseImageLoaderStrategy;
    }

    public BaseImageLoaderStrategy getBaseImageLoaderStrategy(){
        return baseImageLoaderStrategy;
    }
}
