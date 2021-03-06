package com.first.alina.utilsdemo.main.viewholders;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.first.alina.utilsdemo.R;
import com.first.alina.utilsdemo.common.recyclerviews.BindLayout;
import com.first.alina.utilsdemo.common.recyclerviews.ViewHolder;
import com.first.alina.utilsdemo.floatview.FloatActivity;
import com.first.alina.utilsdemo.main.bean.FloatViewBean;

/**
 * Created by alina on 2019/4/10.
 */
@BindLayout(R.layout.viewholder_float_view)
public class FloatViewHolder extends ViewHolder<FloatViewBean>{
    private Context context;
    public FloatViewHolder(View itemView) {
        super(itemView);
        context=itemView.getContext();
        itemView.findViewById(R.id.float_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, FloatActivity.class));
            }
        });
    }

    @Override
    public void setContent(FloatViewBean item, int position) {

    }
}
