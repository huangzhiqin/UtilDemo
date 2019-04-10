package com.first.alina.utilsdemo.main.viewholders;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.first.alina.utilsdemo.R;
import com.first.alina.utilsdemo.activitys.TextViewSwitchActivity;
import com.first.alina.utilsdemo.common.recyclerviews.BindLayout;
import com.first.alina.utilsdemo.common.recyclerviews.ViewHolder;
import com.first.alina.utilsdemo.main.bean.ScrollUpDownBean;

/**
 * Created by alina on 2019/4/10.
 */
@BindLayout(R.layout.viewholder_scroll_up_down)
public class ScrollUpDownViewHolder extends ViewHolder<ScrollUpDownBean>{
    private Context context;
    public ScrollUpDownViewHolder(View itemView) {
        super(itemView);
        context=itemView.getContext();
        itemView.findViewById(R.id.switch_tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, TextViewSwitchActivity.class));
            }
        });
    }

    @Override
    public void setContent(ScrollUpDownBean item, int position) {

    }
}
