package android.support.v7.widget.helper.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.helper.mvp.test.TestActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.first.alina.utilsdemo.R;

/**
 * Created by alina on 2019/8/16.
 */

public class TestFragment1 extends Fragment implements TestActivity.TestData {
    private TextView titleView1;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_test1, null);
        titleView1 = view.findViewById(R.id.tv);
        TestActivity.setTestData(this);
        return view;
    }

    @Override
    public void setData(String type) {
        titleView1.setText(type);
    }

}
