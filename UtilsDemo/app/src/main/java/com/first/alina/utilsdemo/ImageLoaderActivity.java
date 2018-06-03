package com.first.alina.utilsdemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.first.alina.utilsdemo.image_loader.GlideImageLoaderStrategy;
import com.first.alina.utilsdemo.image_loader.ImageConfigImpl;
import com.first.alina.utilsdemo.image_loader.ImageLoader;

/**
 * Created by alina on 2018/6/3.
 */

public class ImageLoaderActivity extends Activity{
    private String url="http://img5.imgtn.bdimg.com/it/u=1109917053,4211270766&fm=27&gp=0.jpg";
    private ImageView imageView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_loader);
        imageView=(ImageView)findViewById(R.id.image);
        ImageLoader imageLoader=new ImageLoader();
        ImageConfigImpl imageConfig=ImageConfigImpl.builder().url(url).imageView(imageView).build();
        GlideImageLoaderStrategy glideImageLoaderStrategy=new GlideImageLoaderStrategy();
        glideImageLoaderStrategy.displayImage(ImageLoaderActivity.this,imageConfig);
       // imageLoader.loadImage(this,ImageConfigImpl.builder().url(url).imageView(imageView).build());
        imageLoader.setLoadImageStrategy(glideImageLoaderStrategy);

    }
}
