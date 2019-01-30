package com.first.alina.utilsdemo.fragmentAndActivity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.first.alina.utilsdemo.R;
import com.first.alina.utilsdemo.fragments.Fragment1;
import com.first.alina.utilsdemo.fragments.Fragment2;
import com.first.alina.utilsdemo.fragments.Fragment3;
import com.first.alina.utilsdemo.fragments.Fragment4;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alina on 2019/1/15.
 */

public class FragmentActivity extends android.support.v4.app.FragmentActivity implements Fragment1.FragmentInterListener, View.OnClickListener {
    private String TAG = "FragmentActivity";
    private Button button1, button2, button3, button4;
    private LinearLayout bottomLayout;
    private FragmentManager fragmentManager;
    private Fragment1 fragment1;
    private Fragment2 fragment2;
    private Fragment3 fragment3;
    private Fragment4 fragment4;
    private List<Fragment> fragments = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        bottomLayout = findViewById(R.id.ll_btn);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        fragment1 = Fragment1.newInstance("我是第一个fragment，哈哈");
        fragment2 = Fragment2.newInstance("我是第二个fragment，哈哈");
        fragment3 = Fragment3.newInstance("我是第三个fragment，哈哈");
        fragment4 = Fragment4.newInstance("我是第四个fragment，哈哈");

        fragmentManager = getSupportFragmentManager();
        fragments.add(fragment1);
        fragments.add(fragment2);
        fragments.add(fragment3);
        fragments.add(fragment4);
        addFragment(0, fragment1, fragment2, fragment3, fragment4);

    }

    private void addFragment(int showPos, Fragment... fragments) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        for (int i = 0; i < fragments.length; i++) {
            Fragment fragment = fragments[i];
            transaction.add(R.id.container, fragment, "f" + i);
            transaction.addToBackStack("f" + i);
            if (i != showPos) {
                transaction.hide(fragment);
            }
        }
        transaction.commit();

    }

    private void showFragment(int showPos) {
        for (int i = 0; i < fragments.size(); i++) {
            if (i == showPos) {
                fragmentManager.beginTransaction().show(fragments.get(i)).commit();
            } else {
                fragmentManager.beginTransaction().hide(fragments.get(i)).commit();
            }
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Log.e(TAG, "keyDown count=" + getSupportFragmentManager().getBackStackEntryCount());

        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onItemClick(String str) {
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                showFragment(0);
                break;
            case R.id.button2:
                showFragment(1);
                break;
            case R.id.button3:
                showFragment(2);
                break;
            case R.id.button4:
                showFragment(3);
                break;
        }
    }
}
