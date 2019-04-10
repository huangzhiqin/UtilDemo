package com.first.alina.utilsdemo.main.viewholders;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.helper.mvp.test.MVPActivity;
import android.view.View;

import com.first.alina.utilsdemo.R;
import com.first.alina.utilsdemo.common.recyclerviews.BindLayout;
import com.first.alina.utilsdemo.common.recyclerviews.ViewHolder;
import com.first.alina.utilsdemo.main.bean.MVPBean;

/**
 * Created by alina on 2019/4/10.
 */
@BindLayout(R.layout.viewholder_mvp)
public class MVPViewHolder extends ViewHolder<MVPBean>{
    private Context context;
    public MVPViewHolder(View itemView) {
        super(itemView);
        context=itemView.getContext();
       itemView.findViewById(R.id.mvp_tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, MVPActivity.class));
              /*  WindowManager manager= (WindowManager) MainActivity.this.getSystemService(Context.WINDOW_SERVICE);
                DisplayMetrics displayMetrics=new DisplayMetrics();
                manager.getDefaultDisplay().getMetrics(displayMetrics);
                Log.e(TAG,"==> width="+displayMetrics.widthPixels+"  height="+displayMetrics.heightPixels);*/
            }
        });
    }

    @Override
    public void setContent(MVPBean item, int position) {

    }
}
