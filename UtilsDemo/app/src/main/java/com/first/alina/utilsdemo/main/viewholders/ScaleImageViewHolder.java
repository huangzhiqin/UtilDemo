package com.first.alina.utilsdemo.main.viewholders;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.first.alina.utilsdemo.R;
import com.first.alina.utilsdemo.common.recyclerviews.BindLayout;
import com.first.alina.utilsdemo.common.recyclerviews.ViewHolder;
import com.first.alina.utilsdemo.main.bean.ScaleImageBean;
import com.first.alina.utilsdemo.scrollview.activitys.ScaleScrollActivity;

/**
 * Created by alina on 2019/4/10.
 */
@BindLayout(R.layout.viewholder_scale_image)
public class ScaleImageViewHolder extends ViewHolder<ScaleImageBean>{
    private Context context;
    public ScaleImageViewHolder(View itemView) {
        super(itemView);
        context=itemView.getContext();
        itemView.findViewById(R.id.scale_image).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, ScaleScrollActivity.class));
            }
        });
    }

    @Override
    public void setContent(ScaleImageBean item, int position) {

    }
}
