package com.first.alina.utilsdemo.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.first.alina.utilsdemo.R;

/**
 * Created by alina on 2019/1/15.
 */

public class Fragment2 extends Fragment {

    private String TAG="Fragment2";
    private String paramValue;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        paramValue=getArguments().getString("paramKey");
        Log.e(TAG,"==> onAttach ");
        Log.e(TAG,"==> onAttach  getUserVisibleHint="+getUserVisibleHint());
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG,"==> onCreate ");

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.e(TAG,"==> onCreateView ");
        View view= inflater.inflate(R.layout.fragment2,container,false);
        TextView textView=view.findViewById(R.id.tv2);
        textView.setText(paramValue);

        Log.e(TAG,"==> hashCode="+getFragmentManager().hashCode());
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager()
                        .beginTransaction()
                        .add(R.id.container2,Fragment3.newInstance("我是第三个fragment"),"f2")
                        .addToBackStack("f3")
                        .commit();
            }
        });
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e(TAG,"==> onResume  getUserVisibleHint="+getUserVisibleHint());
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.e(TAG,"==> onStart ");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.e(TAG,"==> onStop ");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.e(TAG,"==> onPause ");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.e(TAG,"==> onDestroyView ");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG,"==> onDestroy ");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.e(TAG,"==> onDetach ");
    }

    public static Fragment2 newInstance(String param) {

        Bundle args = new Bundle();
        args.putString("paramKey",param);
        Fragment2 fragment = new Fragment2();
        fragment.setArguments(args);
        return fragment;
    }


}
