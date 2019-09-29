package com.first.alina.utilsdemo.customview.viewholder;

import android.content.Intent;
import android.view.View;

import com.first.alina.utilsdemo.R;
import com.first.alina.utilsdemo.common.recyclerviews.BindLayout;
import com.first.alina.utilsdemo.common.recyclerviews.ViewHolder;
import com.first.alina.utilsdemo.customview.UpdateViewPosActivity;
import com.first.alina.utilsdemo.customview.bean.UpdateViewBean;
@BindLayout(R.layout.viewholder_update_view)
public class UpdateViewHolder extends ViewHolder<UpdateViewBean> {
    public UpdateViewHolder(final View itemView) {
        super(itemView);
        itemView.findViewById(R.id.tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemView.getContext().startActivity(new Intent(itemView.getContext(), UpdateViewPosActivity.class));
            }
        });
    }

    @Override
    public void setContent(UpdateViewBean item, int position) {

    }
}
