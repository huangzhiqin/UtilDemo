package com.first.alina.utilsdemo.main.viewholders;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.first.alina.utilsdemo.R;
import com.first.alina.utilsdemo.banner.BannerActivity;
import com.first.alina.utilsdemo.main.bean.BannerBean;
import com.first.alina.utilsdemo.common.recyclerviews.BindLayout;
import com.first.alina.utilsdemo.common.recyclerviews.ViewHolder;

/**
 * Created by alina on 2019/4/10.
 */
@BindLayout(R.layout.viewholder_banner)
public class BannerViewHolder extends ViewHolder<BannerBean>{
    private Context context;
    public BannerViewHolder(View itemView) {
        super(itemView);
        context=itemView.getContext();
        itemView.findViewById(R.id.banner).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, BannerActivity.class));
            }
        });

    }

    @Override
    public void setContent(BannerBean item, int position) {

    }
}
