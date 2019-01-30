package com.first.alina.utilsdemo.fragments;

import android.app.Activity;
import android.content.Context;
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
 * Created by alina on 2019/1/15.
 */

public class Fragment3 extends Fragment {
    private String TAG="Fragment3";

    private String paramValue;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        paramValue=getArguments().getString("paramKey");

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment3,container,false);

        TextView textView=view.findViewById(R.id.tv3);
        textView.setText(paramValue);
        Log.e(TAG,"==> paramValue="+paramValue);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        return view;
    }

    public static Fragment3 newInstance(String param) {

        Bundle args = new Bundle();
        args.putString("paramKey",param);
        Fragment3 fragment = new Fragment3();
        fragment.setArguments(args);
        return fragment;
    }


}

