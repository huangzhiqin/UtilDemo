package com.first.alina.utilsdemo.main.viewholders;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.first.alina.utilsdemo.R;
import com.first.alina.utilsdemo.common.recyclerviews.BindLayout;
import com.first.alina.utilsdemo.common.recyclerviews.ViewHolder;
import com.first.alina.utilsdemo.dialogs.DialogActivity;
import com.first.alina.utilsdemo.fragmentAndActivity.FragmentActivity;
import com.first.alina.utilsdemo.main.bean.DialogBean;

/**
 * Created by alina on 2019/4/10.
 */
@BindLayout(R.layout.viewholder_dialog)
public class DialogViewHolder extends ViewHolder<DialogBean>{
    private Context context;
    public DialogViewHolder(View itemView) {
        super(itemView);
        context=itemView.getContext();
        itemView.findViewById(R.id.tv2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, DialogActivity.class));


            }
        });
    }

    @Override
    public void setContent(DialogBean item, int position) {

    }
}
