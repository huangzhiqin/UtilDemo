package com.first.alina.utilsdemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.first.alina.utilsdemo.imageLoader.GlideLoaderStrategy;
import com.first.alina.utilsdemo.imageLoader.ImageConfigImpl;

/**
 * Created by alina on 2018/6/3.
 */

public class ImageLoaderActivity extends Activity {
    private String url = "https://image.cc0.cn/201906/20190529015745183.jpg?x-oss-process=style/www.cc0.cn-1200px";
    public String url2="https://image.cc0.cn/201906/20190529015745183.jpg?x-oss-process=style/www.cc0.";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_loader);
        ImageView imageView = findViewById(R.id.image);
        ImageConfigImpl imageConfig = ImageConfigImpl.builder()
                .circleCrop(true)
                .url(url2)
                .imageView(imageView)
                .placeHolder(R.drawable.laoding)
                .errorHolder(R.drawable.meinv)
                .build();
        GlideLoaderStrategy.getInstance().displayImage(this, imageConfig);
    }
}
