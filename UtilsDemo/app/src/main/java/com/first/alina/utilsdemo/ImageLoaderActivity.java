package com.first.alina.utilsdemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.first.alina.utilsdemo.imageLoader.GlideLoaderStrategy;
import com.first.alina.utilsdemo.imageLoader.ImageConfigImpl;

import java.io.File;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by alina on 2018/6/3.
 */

public class ImageLoaderActivity extends Activity {
    private String url = "http://img0.imgtn.bdimg.com/it/u=2450420640,2967151336&fm=26&gp=0.jpg";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_loader);
        CircleImageView imageView = findViewById(R.id.image);
        ImageConfigImpl imageConfig = ImageConfigImpl.builder()
                .circleCrop(true)
                .url(url)
                .imageView(imageView)
                .placeHolder(R.drawable.laoding)
                .errorHolder(R.drawable.meinv)
                .build();
        GlideLoaderStrategy.getInstance().displayImage(this, imageConfig);




    }
}
