package com.first.alina.utilsdemo.main.viewholders;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.first.alina.utilsdemo.R;
import com.first.alina.utilsdemo.RatingBarActivity;
import com.first.alina.utilsdemo.common.recyclerviews.BindLayout;
import com.first.alina.utilsdemo.common.recyclerviews.ViewHolder;
import com.first.alina.utilsdemo.main.bean.RatingBarBean;

/**
 * Created by alina on 2019/4/10.
 */
@BindLayout(R.layout.viewholder_ratingbar)
public class RatingBarViewHolder extends ViewHolder<RatingBarBean>{
    private Context context;
    public RatingBarViewHolder(View itemView) {
        super(itemView);
        context=itemView.getContext();
        itemView.findViewById(R.id.ratingBar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, RatingBarActivity.class));
            }
        });
    }

    @Override
    public void setContent(RatingBarBean item, int position) {

    }
}
