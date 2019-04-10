package com.first.alina.utilsdemo.main.viewholders;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.first.alina.utilsdemo.R;
import com.first.alina.utilsdemo.common.recyclerviews.BindLayout;
import com.first.alina.utilsdemo.common.recyclerviews.ViewHolder;
import com.first.alina.utilsdemo.kline.BrokenLine1Activity;
import com.first.alina.utilsdemo.main.bean.BrokenBean;

/**
 * Created by alina on 2019/4/10.
 */
@BindLayout(R.layout.viewholder_broken)
public class BrokenViewHolder extends ViewHolder<BrokenBean>{
    private Context context;
    public BrokenViewHolder(View itemView) {
        super(itemView);
        context=itemView.getContext();
        itemView.findViewById(R.id.broken1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, BrokenLine1Activity.class));
            }
        });
    }

    @Override
    public void setContent(BrokenBean item, int position) {

    }
}
