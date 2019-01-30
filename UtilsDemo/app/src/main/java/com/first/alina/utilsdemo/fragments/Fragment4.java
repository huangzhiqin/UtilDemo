package com.first.alina.utilsdemo.fragments;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.first.alina.utilsdemo.R;

/**
 * Created by alina on 2019/1/29.
 */

public class Fragment4 extends Fragment {
    private String TAG = "Fragment3";

    private String paramValue;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        paramValue = getArguments().getString("paramKey");

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment4, container, false);

        TextView textView = view.findViewById(R.id.tv4);
        textView.setText(paramValue);
        textView.setTextColor(Color.RED);
        Log.e(TAG, "==> paramValue=" + paramValue);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        return view;
    }

    public static Fragment4 newInstance(String param) {

        Bundle args = new Bundle();
        args.putString("paramKey", param);
        Fragment4 fragment = new Fragment4();
        fragment.setArguments(args);
        return fragment;
    }
}