package com.first.alina.utilsdemo.main.viewholders;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.first.alina.utilsdemo.R;
import com.first.alina.utilsdemo.activitys.MoveCommentMainActivity;
import com.first.alina.utilsdemo.common.recyclerviews.BindLayout;
import com.first.alina.utilsdemo.common.recyclerviews.ViewHolder;
import com.first.alina.utilsdemo.main.bean.MoveCommentBean;

/**
 * Created by alina on 2019/4/10.
 */
@BindLayout(R.layout.viewholder_move_comment)
public class MoveCommentViewHolder extends ViewHolder<MoveCommentBean>{
    private Context context;
    public MoveCommentViewHolder(View itemView) {
        super(itemView);
        context=itemView.getContext();
        itemView.findViewById(R.id.move_comment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, MoveCommentMainActivity.class));
            }
        });
    }

    @Override
    public void setContent(MoveCommentBean item, int position) {

    }
}
