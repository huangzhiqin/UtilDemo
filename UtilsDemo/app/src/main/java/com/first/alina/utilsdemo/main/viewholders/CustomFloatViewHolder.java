package com.first.alina.utilsdemo.main.viewholders;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.first.alina.utilsdemo.R;
import com.first.alina.utilsdemo.common.recyclerviews.BindLayout;
import com.first.alina.utilsdemo.common.recyclerviews.ViewHolder;
import com.first.alina.utilsdemo.floatview.CutomFloatActivity;
import com.first.alina.utilsdemo.main.bean.CustomFloatBean;

/**
 * Created by alina on 2019/4/10.
 */
@BindLayout(R.layout.viewholder_custom_float_)
public class CustomFloatViewHolder extends ViewHolder<CustomFloatBean>{
    private Context context;
    public CustomFloatViewHolder(View itemView) {
        super(itemView);
        context=itemView.getContext();
        itemView.findViewById(R.id.custom_float_tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, CutomFloatActivity.class));
            }
        });
    }

    @Override
    public void setContent(CustomFloatBean item, int position) {

    }
}
