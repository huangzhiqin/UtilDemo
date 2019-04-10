package com.first.alina.utilsdemo.main.viewholders;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.first.alina.utilsdemo.R;
import com.first.alina.utilsdemo.common.recyclerviews.BindLayout;
import com.first.alina.utilsdemo.common.recyclerviews.ViewHolder;
import com.first.alina.utilsdemo.main.bean.MultipleBean;
import com.first.alina.utilsdemo.test1.RecyclerViewWebActivity;

/**
 * Created by alina on 2019/4/10.
 */
@BindLayout(R.layout.viewholder_multiple_webview)
public class MultipleViewHolder extends ViewHolder<MultipleBean>{
    private Context context;
    public MultipleViewHolder(View itemView) {
        super(itemView);
        context=itemView.getContext();
        itemView.findViewById(R.id.webview).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(MainActivity.this, WebViewActivity.class));
                context.startActivity(new Intent(context, RecyclerViewWebActivity.class));
            }
        });
    }

    @Override
    public void setContent(MultipleBean item, int position) {

    }
}
