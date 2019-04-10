package com.first.alina.utilsdemo.main.viewholders;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.first.alina.utilsdemo.ImageLoaderActivity;
import com.first.alina.utilsdemo.R;
import com.first.alina.utilsdemo.common.recyclerviews.BindLayout;
import com.first.alina.utilsdemo.common.recyclerviews.ViewHolder;
import com.first.alina.utilsdemo.main.bean.ImageBean;

/**
 * Created by alina on 2019/4/10.
 */
@BindLayout(R.layout.viewholder_image)
public class ImageViewHolder extends ViewHolder<ImageBean>{
    private Context context;
    public ImageViewHolder(View itemView) {
        super(itemView);
        context=itemView.getContext();
        itemView.findViewById(R.id.image).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, ImageLoaderActivity.class));

            }
        });

    }

    @Override
    public void setContent(ImageBean item, int position) {

    }
}
