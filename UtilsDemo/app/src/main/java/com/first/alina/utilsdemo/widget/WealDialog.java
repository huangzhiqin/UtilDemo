package com.first.alina.utilsdemo.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.first.alina.utilsdemo.R;


/**
 * Created by alina on 2018/4/18.
 * 福利Dialog
 */

public class WealDialog extends Dialog {
    private static final String TAG="WealDialog";
    public WealDialog(@NonNull Context context) {
        super(context);
    }

    public WealDialog(@NonNull Context context, @StyleRes int themeResId) {
        super(context, themeResId);
    }

    protected WealDialog(@NonNull Context context, boolean cancelable, @Nullable DialogInterface.OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    public static class Builder{
        private Context context;
        private TextView bottomCloseTv;
        private ImageView closeImg;
        private TextView messageTv;
        private TextView titleTv;
        private String title;
        private String message;
        private OnClickListener onClickListener;
        private OnClickListener rightOnClickListener;

        public Builder (Context context){
            this.context=context;
        }

        public Builder setTitle(String title){
            this.title=title;
            return this;
        }

        public Builder setMessage(String message){
            this.message=message;
            return this;
        }

        public Builder setBottomOnClickListener(OnClickListener OnClickListener){
            this.onClickListener=OnClickListener;
            return this;
        }

        public Builder setRightOnClickListener(OnClickListener rightOnClickListener){
            this.rightOnClickListener=rightOnClickListener;
            return this;
        }

        public WealDialog create(){

            final WealDialog wealDialog=new WealDialog(context, R.style.weal_dialog);
            View view= LayoutInflater.from(context).inflate(R.layout.dialog_weal,null);
            wealDialog.setContentView(view);
            bottomCloseTv=view.findViewById(R.id.dialog_bottom_close);
            messageTv=view.findViewById(R.id.dialog_weal_hint);
            titleTv=view.findViewById(R.id.festival);
            closeImg=view.findViewById(R.id.dialog_close);
            bottomCloseTv.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);//添加下划线
            wealDialog.setCanceledOnTouchOutside(true);
            titleTv.setText(title);
            messageTv.setText(message);
            bottomCloseTv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.e(TAG,"==> onClick ");
                        onClickListener.onClick(wealDialog, DialogInterface.BUTTON_POSITIVE);
                    }
                });
            closeImg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickListener.onClick(wealDialog, DialogInterface.BUTTON_NEGATIVE);
                }
            });
            return wealDialog;
        }
    }

}
