package com.first.alina.utilsdemo.main.viewholders;

import android.view.View;

import com.first.alina.utilsdemo.R;
import com.first.alina.utilsdemo.common.recyclerviews.BindLayout;
import com.first.alina.utilsdemo.common.recyclerviews.ViewHolder;
import com.first.alina.utilsdemo.main.bean.ThreadBean;

/**
 * Created by alina on 2019/4/16.
 */
@BindLayout(R.layout.viewholder_thread)
public class ThreadViewHolder extends ViewHolder<ThreadBean>{
    public ThreadViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setContent(ThreadBean item, int position) {


    }
}
