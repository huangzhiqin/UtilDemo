package com.first.alina.utilsdemo.main.viewholders;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.first.alina.utilsdemo.R;
import com.first.alina.utilsdemo.common.recyclerviews.BindLayout;
import com.first.alina.utilsdemo.common.recyclerviews.ViewHolder;
import com.first.alina.utilsdemo.main.bean.CanvasBean;
import com.first.alina.utilsdemo.view.CanvasActivity;

/**
 * Created by alina on 2019/4/10.
 */
@BindLayout(R.layout.viewholder_canvas)
public class CanvasViewHolder extends ViewHolder<CanvasBean>{
    private Context context;
    public CanvasViewHolder(View itemView) {
        super(itemView);
        context=itemView.getContext();
        itemView. findViewById(R.id.canvasTv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, CanvasActivity.class));
            }
        });

    }

    @Override
    public void setContent(CanvasBean item, int position) {

    }
}
