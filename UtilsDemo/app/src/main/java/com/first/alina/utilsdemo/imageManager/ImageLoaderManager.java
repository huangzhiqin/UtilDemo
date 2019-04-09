package com.first.alina.utilsdemo.imageManager;

import android.view.View;

/**
 * Created by alina on 2019/4/9.
 */

public class ImageLoaderManager implements ImageLoaderStrategy{
    private ImageLoaderManager imageLoaderManager;
    private ImageLoaderStrategy glideImageLoader;

    private ImageLoaderManager() {
        glideImageLoader=new GlideImageLoaderStrategy();
    }
    public ImageLoaderManager getInstance(){
        if (imageLoaderManager==null){
            synchronized (ImageLoaderManager.class){
                if (imageLoaderManager==null){
                    imageLoaderManager=new ImageLoaderManager();
                }
            }
        }
        return imageLoaderManager;
    }

    //替换图片加载框架
    public void setImageLoader(ImageLoaderStrategy imageLoader){
        if (imageLoader!=null){
            glideImageLoader=imageLoader;
        }
    }

    @Override
    public void showImage(View view, String url, ImageLoaderOptions options) {
        glideImageLoader.showImage(view,url,options);
    }
}
