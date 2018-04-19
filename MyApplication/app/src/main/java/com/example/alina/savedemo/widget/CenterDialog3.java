package com.example.alina.savedemo.widget;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;
import android.support.v7.widget.LinearLayoutCompat;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.alina.savedemo.R;

/**
 * Created by alina on 2018/2/28.
 */

public class CenterDialog3 extends Dialog{
    public CenterDialog3(@NonNull Context context) {
        super(context);
    }

    public CenterDialog3(@NonNull Context context, @StyleRes int themeResId) {
        super(context, themeResId);
    }

    public static class Builder{
        private Context context;
        private String title;
        private String message;
        private String positiveButtonText;
        private String negativeButtonText;
        private OnClickListener positiveButtonClickListener;
        private OnClickListener negativeButtonClickListener;

        public Builder(Context context) {
            this.context = context;
        }
        public Builder setMessage(String message){
            this.message=message;
            return this;
        }
        public Builder setTitle(String title){
            this.title=title;
            return this;
        }
        public Builder setPositiveButton(String positiveText, OnClickListener listener){
            this.positiveButtonText=positiveText;
            this.positiveButtonClickListener=listener;
            return this;
        }
        public Builder setNegativeButton(String negativeText,OnClickListener listener){
            this.negativeButtonText=negativeText;
            this.negativeButtonClickListener=listener;
            return this;
        }

        public CenterDialog3 create(){
            LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            final CenterDialog3 centerDialog3=new CenterDialog3(context, R.style.loading_dialog);
            View layout=inflater.inflate(R.layout.dialog_center3,null);
            centerDialog3.addContentView(layout,new LinearLayoutCompat.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

            if (!TextUtils.isEmpty(title)){
                ((TextView)layout.findViewById(R.id.title)).setText(title);
            }
            if (!TextUtils.isEmpty(positiveButtonText)){
                ((TextView)layout.findViewById(R.id.positiveButton)).setText(positiveButtonText);
                if (positiveButtonClickListener!=null){
                    (layout.findViewById(R.id.positiveButton)).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            positiveButtonClickListener.onClick(centerDialog3, DialogInterface.BUTTON_POSITIVE);
                        }
                    });
                }
            }else {
                (layout.findViewById(R.id.positiveButton)).setVisibility(View.GONE);
            }

            if (!TextUtils.isEmpty(negativeButtonText)){
                ((TextView)layout.findViewById(R.id.negativeButton)).setText(negativeButtonText);
                if (negativeButtonClickListener!=null){
                    layout.findViewById(R.id.negativeButton).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            negativeButtonClickListener.onClick(centerDialog3,DialogInterface.BUTTON_NEGATIVE);
                        }
                    });
                }
            }else {
                (layout.findViewById(R.id.negativeButton)).setVisibility(View.GONE);
            }

            if (!TextUtils.isEmpty(message)){
                ((TextView) layout.findViewById(R.id.message)).setText(message);
            }

            return centerDialog3;
        }

    }
}
