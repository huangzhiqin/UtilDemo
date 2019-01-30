package com.first.alina.utilsdemo.fragments;

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
 *
 * 注意：getFragmentManager add时，FrameLayout的id必须唯一，不能重复
 */

public class Fragment1 extends Fragment {
    private String TAG="Fragment1";

    private String paramValue;
    private FragmentInterListener fragmentInterListener;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        paramValue=getArguments().getString("paramKey");
        Log.e(TAG,"==> onAttach ");
        if (context instanceof FragmentInterListener){
            fragmentInterListener= (FragmentInterListener) context;
        }
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
       View view= inflater.inflate(R.layout.fragment1,container,false);

        TextView textView=view.findViewById(R.id.tv1);
        textView.setText(paramValue);
        Log.e(TAG,"==> hashCode="+getFragmentManager().hashCode());

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fragmentInterListener!=null){
                    fragmentInterListener.onItemClick("我是从fragment中传来的数据");
                }
                getFragmentManager()
                        .beginTransaction()
                        .add(R.id.container1,Fragment2.newInstance("我是第二个fragment"),"f2")
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

    public static Fragment1 newInstance(String param) {

        Bundle args = new Bundle();
        args.putString("paramKey",param);
        Fragment1 fragment = new Fragment1();
        fragment.setArguments(args);
        return fragment;
    }

    public interface FragmentInterListener{
        void onItemClick(String str);
    }




}
