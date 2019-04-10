package com.first.alina.utilsdemo.main.viewholders;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.first.alina.utilsdemo.R;
import com.first.alina.utilsdemo.common.recyclerviews.BindLayout;
import com.first.alina.utilsdemo.common.recyclerviews.ViewHolder;
import com.first.alina.utilsdemo.main.bean.FloatScrollViewBean;
import com.first.alina.utilsdemo.scrollview.activitys.ScrollViewTopActivity;

/**
 * Created by alina on 2019/4/10.
 */
@BindLayout(R.layout.viewholder_float_scrollview)
public class FloatScrollViewHolder extends ViewHolder<FloatScrollViewBean>{
    private Context context;
    public FloatScrollViewHolder(View itemView) {
        super(itemView);
        context=itemView.getContext();
        itemView.findViewById(R.id.scrollView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, ScrollViewTopActivity.class));
            }

        });
    }

    @Override
    public void setContent(FloatScrollViewBean item, int position) {

    }
}
