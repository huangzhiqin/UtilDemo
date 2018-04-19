package com.first.alina.utilsdemo.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.first.alina.utilsdemo.R;
import com.first.alina.utilsdemo.common.ScreenUtils;


/**
 * Created by alina on 2018/2/27.
 */

public class Bottom1Dialog extends Dialog {

    private Context mContext;
    private String mContent;

    public Bottom1Dialog(@NonNull Context context) {
        super(context);
        this.mContext=context;
    }

    public Bottom1Dialog(@NonNull Context context, @StyleRes int themeResId) {
        super(context, themeResId);
        this.mContext=context;
    }

    protected Bottom1Dialog(@NonNull Context context, boolean cancelable, @Nullable DialogInterface.OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        this.mContext=context;
    }

    public void setContent(String content){
        this.mContent=content;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_bottom1);
        initView();
        Window window = getWindow();
        if(window!=null){
            WindowManager.LayoutParams layoutParams = window.getAttributes();
            layoutParams.width = ScreenUtils.getScreenWidth(mContext);
            layoutParams.height = ScreenUtils.getScreenHeight(mContext) - ScreenUtils.dip2px(mContext,260);
            window.setGravity(Gravity.BOTTOM);  //此处可以设置dialog显示的位置
            //window.setWindowAnimations(R.style.translateDialogStyle);  //添加动画
            window.setAttributes(layoutParams);
        }
    }

    private void initView() {

        findViewById(R.id.column_head_arrow_icon).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

       TextView content=findViewById(R.id.column_head_desc);
        content.setText(mContent);


    }
}
