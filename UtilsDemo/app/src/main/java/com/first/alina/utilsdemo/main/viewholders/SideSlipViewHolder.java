package com.first.alina.utilsdemo.main.viewholders;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.first.alina.utilsdemo.R;
import com.first.alina.utilsdemo.common.recyclerviews.BindLayout;
import com.first.alina.utilsdemo.common.recyclerviews.ViewHolder;
import com.first.alina.utilsdemo.main.bean.SideSlipBean;
import com.first.alina.utilsdemo.recyclerviews.SideSlipRecyclerViewActivity;

/**
 * Created by alina on 2019/4/10.
 */
@BindLayout(R.layout.viewholder_side_slip)
public class SideSlipViewHolder extends ViewHolder<SideSlipBean>{
    private Context context;
    public SideSlipViewHolder(View itemView) {
        super(itemView);
        context=itemView.getContext();
        itemView.findViewById(R.id.side_slip).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, SideSlipRecyclerViewActivity.class));
            }
        });
    }

    @Override
    public void setContent(SideSlipBean item, int position) {

    }
}
