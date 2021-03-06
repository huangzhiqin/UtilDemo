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
import android.widget.ListView;
import android.widget.TextView;

import com.first.alina.utilsdemo.R;
import com.first.alina.utilsdemo.adapters.DialogWealAdapter;

import java.util.List;


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
        private TextView messageTv1;
        private ImageView closeImg;
        private TextView titleTv;
        private ListView listView;
        private String title;
        private String message1;
        private List<String> list;
        private OnClickListener onClickListener;
        private OnClickListener rightOnClickListener;
        private DialogWealAdapter dialogWealAdapter;

        public Builder (Context context){
            this.context=context;
        }

        public Builder setTitle(String title){
            this.title=title;
            return this;
        }

        public Builder setMessage1(String message){
            this.message1=message;
            return this;
        }
        public Builder setDataList(List<String> list){
            this.list=list;
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
            titleTv=view.findViewById(R.id.festival);
            closeImg=view.findViewById(R.id.dialog_close);
            messageTv1=view.findViewById(R.id.dialog_message1);
            bottomCloseTv.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);//添加下划线
            //bottomCloseTv.getPaint().setFlags(Paint.LINEAR_TEXT_FLAG);//去掉下划线
            listView=view.findViewById(R.id.dialog_coupon_listview);
            listView.setDividerHeight(0);
            wealDialog.setCanceledOnTouchOutside(true);
            titleTv.setText(title);
            messageTv1.setText(message1);
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
            if (list!=null){
                dialogWealAdapter=new DialogWealAdapter(context);
                dialogWealAdapter.setData(list);
                listView.setAdapter(dialogWealAdapter);
            }

            return wealDialog;
        }
    }

}
