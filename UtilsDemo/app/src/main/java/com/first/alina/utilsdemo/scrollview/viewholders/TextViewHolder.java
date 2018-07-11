package com.first.alina.utilsdemo.scrollview.viewholders;

import android.view.View;
import android.widget.TextView;

import com.first.alina.utilsdemo.R;
import com.first.alina.utilsdemo.common.recyclerviews.BindLayout;
import com.first.alina.utilsdemo.common.recyclerviews.ViewHolder;
import com.first.alina.utilsdemo.scrollview.beans.TextBean;

/**
 * Created by alina on 2018/7/11.
 */
@BindLayout(R.layout.item_scroll_top_item)
public class TextViewHolder extends ViewHolder<TextBean>{
    private TextView titleTv;
    public TextViewHolder(View itemView) {
        super(itemView);
        titleTv=getView(R.id.text);
    }

    @Override
    public void setContent(TextBean item, int position) {
        titleTv.setText(item.title);
    }
}
