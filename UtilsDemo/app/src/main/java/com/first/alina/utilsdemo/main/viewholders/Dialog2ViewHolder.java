package com.first.alina.utilsdemo.main.viewholders;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;

import com.first.alina.utilsdemo.R;
import com.first.alina.utilsdemo.common.recyclerviews.BindLayout;
import com.first.alina.utilsdemo.common.recyclerviews.ViewHolder;
import com.first.alina.utilsdemo.main.bean.Dialog2Bean;
import com.first.alina.utilsdemo.widget.WealDialog;

/**
 * Created by alina on 2019/4/10.
 */
@BindLayout(R.layout.viewholder_dialog2)
public class Dialog2ViewHolder extends ViewHolder<Dialog2Bean>{
    private Context context;
    public Dialog2ViewHolder(View itemView) {
        super(itemView);
        context=itemView.getContext();
        itemView.      findViewById(R.id.dialog_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final WealDialog dialog = new WealDialog.Builder(context)
                        .setTitle("重阳节到啦")
                        .setMessage1("重阳节，重阳节，重阳节，重阳节，重阳节，重阳节")
                        .setBottomOnClickListener(new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                dialog.dismiss();
                            }
                        })
                        .setRightOnClickListener(new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).create();
                dialog.show();
            }
        });
    }

    @Override
    public void setContent(Dialog2Bean item, int position) {

    }
}
