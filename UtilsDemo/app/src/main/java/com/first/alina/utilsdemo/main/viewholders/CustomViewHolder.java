package com.first.alina.utilsdemo.main.viewholders;

import android.content.Intent;
import android.view.View;

import com.first.alina.utilsdemo.R;
import com.first.alina.utilsdemo.common.recyclerviews.BindLayout;
import com.first.alina.utilsdemo.common.recyclerviews.ViewHolder;
import com.first.alina.utilsdemo.customview.CustomViewMainActivity;
import com.first.alina.utilsdemo.main.bean.CustomViewBean;
@BindLayout(R.layout.viewholder_custom_view)
public class CustomViewHolder extends ViewHolder<CustomViewBean> {
    public CustomViewHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.getContext().startActivity(new Intent(v.getContext(), CustomViewMainActivity.class));
            }
        });

    }

    @Override
    public void setContent(CustomViewBean item, int position) {

    }
}
