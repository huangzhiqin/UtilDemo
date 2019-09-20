package com.first.alina.utilsdemo.main.viewholders;

import android.content.Intent;
import android.view.View;

import com.first.alina.utilsdemo.R;
import com.first.alina.utilsdemo.common.recyclerviews.BindLayout;
import com.first.alina.utilsdemo.common.recyclerviews.ViewHolder;
import com.first.alina.utilsdemo.main.bean.ReflectionBean;
import com.first.alina.utilsdemo.reflection.ReflectionActivity;
import com.first.alina.utilsdemo.view.TextActivity;

/**
 * Created by alina on 2019/4/28.
 */
@BindLayout(R.layout.viewholder_reflection)
public class ReflectionViewHolder extends ViewHolder<ReflectionBean>{
    public ReflectionViewHolder(final View itemView) {
        super(itemView);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemView.getContext().startActivity(new Intent(itemView.getContext(), TextActivity.class));
            }
        });
    }

    @Override
    public void setContent(ReflectionBean item, int position) {
    }
}
