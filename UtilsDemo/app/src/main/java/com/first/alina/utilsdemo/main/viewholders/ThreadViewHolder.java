package com.first.alina.utilsdemo.main.viewholders;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.first.alina.utilsdemo.R;
import com.first.alina.utilsdemo.common.recyclerviews.BindLayout;
import com.first.alina.utilsdemo.common.recyclerviews.ViewHolder;
import com.first.alina.utilsdemo.main.bean.ThreadBean;
import com.first.alina.utilsdemo.thread_demo.ThreadDemoActivity;

/**
 * Created by alina on 2019/4/16.
 */
@BindLayout(R.layout.viewholder_thread)
public class ThreadViewHolder extends ViewHolder<ThreadBean>{
    private Context context;
    public ThreadViewHolder(View itemView) {
        super(itemView);
        context=itemView.getContext();
        itemView.findViewById(R.id.text).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, ThreadDemoActivity.class));
            }
        });
    }

    @Override
    public void setContent(ThreadBean item, int position) {
    }

}
