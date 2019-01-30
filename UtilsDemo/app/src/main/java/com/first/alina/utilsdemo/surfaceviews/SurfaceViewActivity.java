package com.first.alina.utilsdemo.surfaceviews;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.first.alina.utilsdemo.R;
import com.first.alina.utilsdemo.common.ScreenUtils;
import com.first.alina.utilsdemo.markets.Utils;

/**
 * Created by alina on 2018/12/14.
 */

public class SurfaceViewActivity extends Activity{
    private  String imageUrl="http://imgsrc.baidu.com/forum/w=580/sign=eb1509cbf1d3572c66e29cd4ba126352/5f0f9890f603738d48b35200b01bb051f819ec23.jpg";
    private  String pikaxiuUrl="http://b-ssl.duitang.com/uploads/blog/201308/24/20130824172634_iLEzt.gif";
    private  String maoUrl="http://img1.imgtn.bdimg.com/it/u=370547691,2471399517&fm=214&gp=0.jpg";
    private String gaoxiaoUrl="http://2e.zol-img.com.cn/product/88/684/ceWSzj3KqStS.gif";
    private String url2="http://2b.zol-img.com.cn/product/87/763/cev9Mx0KTQhRo.gif";
    private String url3="http://upfile.asqql.com/2009pasdfasdfic2009s305985-ts/2016-4/201641621544952927.gif";
    private String [] urls={imageUrl,pikaxiuUrl,maoUrl,url3,url2,gaoxiaoUrl};
    private LinearLayout surfaceLayout;
    private Button changeBtn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surceface);
        surfaceLayout=findViewById(R.id.surface_layout);
        changeBtn=findViewById(R.id.change_btn);
        surfaceLayout.setWeightSum(10);
        for (int i=0;i<6;i++){
            ImageView imageView=new ImageView(this);
            LinearLayout.LayoutParams layoutParams= new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            if (i==3){
                layoutParams.weight=5;
            }else {
                layoutParams.weight=1;
            }
            Glide.with(this).load(R.drawable.baoman).into(imageView);
            surfaceLayout.addView(imageView);
        }
        ScreenUtils.getScreenHeight(this);
        changeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
