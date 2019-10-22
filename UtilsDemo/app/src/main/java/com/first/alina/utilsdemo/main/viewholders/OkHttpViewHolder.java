package com.first.alina.utilsdemo.main.viewholders;

import android.content.Intent;
import android.util.Log;
import android.view.View;

import com.first.alina.utilsdemo.R;
import com.first.alina.utilsdemo.common.recyclerviews.BindLayout;
import com.first.alina.utilsdemo.common.recyclerviews.ViewHolder;
import com.first.alina.utilsdemo.main.bean.OkHttpBean;
import com.first.alina.utilsdemo.okhttp.OkhttpActivity;

@BindLayout(R.layout.viewholder_okhttp)
public class OkHttpViewHolder extends ViewHolder<OkHttpBean> {
    public OkHttpViewHolder(final View itemView) {
        super(itemView);
        itemView.findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemView.getContext().startActivity(new Intent(itemView.getContext(), OkhttpActivity.class));
            }
        });
    }

    @Override
    public void setContent(OkHttpBean item, int position) {


    }
}
