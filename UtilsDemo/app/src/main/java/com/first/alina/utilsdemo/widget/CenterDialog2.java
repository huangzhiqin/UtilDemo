package com.first.alina.utilsdemo.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.first.alina.utilsdemo.R;

/**
 * Created by alina on 2018/2/28.
 */

public class CenterDialog2 extends Dialog {
    private Context mContext;
    private String mTitle;
    private String mBrif;

    private TextView tvContent;
    private TextView tvTitle;
    private ImageView ivClose;

    public CenterDialog2(@NonNull Context context) {
        super(context);
        this.mContext=context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_center2);

        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        Window window = this.getWindow();
        lp.copyFrom(window.getAttributes());
        lp.width = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        window.setAttributes(lp);
        window.setBackgroundDrawableResource(android.R.color.transparent);

        tvContent = (TextView) findViewById(R.id.tv_content);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        ivClose = (ImageView) findViewById(R.id.iv_close);
        if (!TextUtils.isEmpty(mTitle)){
            tvTitle.setText(mTitle);
        }

        if (!TextUtils.isEmpty(mBrif)){
            tvContent.setText(mBrif);
        }
        ivClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }

    public void setBrif(String brif){
        this.mBrif=brif;

    }

    public void setTitle(String title){
        this.mTitle=title;
    }
}
