package android.support.v7.widget.helper.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.helper.mvp.test.MVPActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.first.alina.utilsdemo.R;

/**
 * Created by alina on 2019/8/16.
 */

public class TestFragment4 extends Fragment{
    private TextView titleView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_test1,null);
        titleView=view.findViewById(R.id.tv);
        titleView.setText("我是第四个fragment");
        titleView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), MVPActivity.class));
            }
        });
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e("TAG","=============> TestFragment4 onResume "+getUserVisibleHint());
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser){
            Log.e("TAG","=============> TestFragment4 isVisibleToUser== true");
        }
    }
}
