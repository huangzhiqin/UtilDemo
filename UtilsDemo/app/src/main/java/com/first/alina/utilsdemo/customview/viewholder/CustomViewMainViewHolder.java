package com.first.alina.utilsdemo.customview.viewholder;

import android.content.Intent;
import android.view.View;

import com.first.alina.utilsdemo.R;
import com.first.alina.utilsdemo.common.recyclerviews.BindLayout;
import com.first.alina.utilsdemo.common.recyclerviews.ViewHolder;
import com.first.alina.utilsdemo.customview.NoPaddingActivity;
import com.first.alina.utilsdemo.customview.bean.CustomViewMainBean;
@BindLayout(R.layout.viewholder_no_padding_tv)
public class CustomViewMainViewHolder extends ViewHolder<CustomViewMainBean> {
    public CustomViewMainViewHolder(final View itemView) {
        super(itemView);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemView.getContext().startActivity(new Intent(itemView.getContext(), NoPaddingActivity.class));
            }
        });
    }

    @Override
    public void setContent(CustomViewMainBean item, int position) {

    }
}
