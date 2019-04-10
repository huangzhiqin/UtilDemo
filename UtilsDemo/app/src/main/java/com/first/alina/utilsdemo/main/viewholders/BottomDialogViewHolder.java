package com.first.alina.utilsdemo.main.viewholders;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.first.alina.utilsdemo.R;
import com.first.alina.utilsdemo.common.recyclerviews.BindLayout;
import com.first.alina.utilsdemo.common.recyclerviews.ViewHolder;
import com.first.alina.utilsdemo.dialogs.BottomDialogActivity;
import com.first.alina.utilsdemo.main.bean.BottomDialogBean;

/**
 * Created by alina on 2019/4/10.
 */
@BindLayout(R.layout.viewholder_bottom_dialog)
public class BottomDialogViewHolder extends ViewHolder<BottomDialogBean>{
    private Context context;
    public BottomDialogViewHolder(View itemView) {
        super(itemView);
        context=itemView.getContext();
        itemView.findViewById(R.id.dialog3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, BottomDialogActivity.class));
            }
        });
    }

    @Override
    public void setContent(BottomDialogBean item, int position) {

    }
}
