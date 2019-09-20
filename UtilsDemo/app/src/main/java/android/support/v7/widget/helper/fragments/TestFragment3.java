package android.support.v7.widget.helper.fragments;

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
 * Created by alina on 2019/8/16.
 */

public class TestFragment3 extends Fragment{
    private TextView titleView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_test1,null);
        titleView=view.findViewById(R.id.tv);
        titleView.setText("我是第三个fragment");
        return view;
    }


    @Override
    public void onResume() {
        super.onResume();
        Log.e("TAG","=============> TestFragment3 onResume "+getUserVisibleHint());
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser){
            Log.e("TAG","=============> TestFragment3 isVisibleToUser= true");
        }

    }
}
