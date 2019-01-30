package com.first.alina.utilsdemo.dialogs;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialog;
import android.view.View;

import com.first.alina.utilsdemo.R;
import com.first.alina.utilsdemo.dialogs.widget.CutomBottomSheetDialog;

/**
 * Created by alina on 2018/8/20.
 */

public class BottomDialogActivity extends Activity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_dialog);
        findViewById(R.id.bottom_dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CutomBottomSheetDialog bottomSheetDialog=new CutomBottomSheetDialog(BottomDialogActivity.this,R.style.bottom_dialog_style);
                bottomSheetDialog.setContentView(R.layout.dialog_layout);
                bottomSheetDialog.show();
            }
        });
        findViewById(R.id.tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialog bottomSheetDialog=new BottomSheetDialog(BottomDialogActivity.this);
                bottomSheetDialog.setContentView(R.layout.dialog_layout);
                bottomSheetDialog.show();
            }
        });
    }
}
