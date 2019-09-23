package com.first.alina.utilsdemo.main.viewholders;

import android.content.Intent;
import android.view.View;

import com.first.alina.utilsdemo.R;
import com.first.alina.utilsdemo.common.recyclerviews.BindLayout;
import com.first.alina.utilsdemo.common.recyclerviews.ViewHolder;
import com.first.alina.utilsdemo.floatview.FloatMainActivity;
import com.first.alina.utilsdemo.main.bean.FloatMainBean;
@BindLayout(R.layout.viewholder_float_main)
public class FloatMainViewHolder extends ViewHolder<FloatMainBean> {
    public FloatMainViewHolder(final View itemView) {
        super(itemView);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemView.getContext().startActivity(new Intent(itemView.getContext(), FloatMainActivity.class));
            }
        });
    }

    @Override
    public void setContent(FloatMainBean item, int position) {

    }
}
