package com.first.alina.utilsdemo.main.viewholders;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.first.alina.utilsdemo.R;
import com.first.alina.utilsdemo.common.recyclerviews.BindLayout;
import com.first.alina.utilsdemo.common.recyclerviews.ViewHolder;
import com.first.alina.utilsdemo.main.bean.SoftKeyBean;
import com.first.alina.utilsdemo.test.activity.ChatMainActivity;

/**
 * Created by alina on 2019/4/10.
 */
@BindLayout(R.layout.viewholder_soft_key)
public class SoftKeyViewHolder extends ViewHolder<SoftKeyBean>{
    private Context context;
    public SoftKeyViewHolder(View itemView) {
        super(itemView);
        context=itemView.getContext();
        itemView.findViewById(R.id.soft_key).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, ChatMainActivity.class));
            }
        });
    }

    @Override
    public void setContent(SoftKeyBean item, int position) {

    }
}
