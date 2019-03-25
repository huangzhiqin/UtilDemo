package com.first.alina.utilsdemo.test1;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.widget.ImageView;

import com.first.alina.utilsdemo.R;
import com.first.alina.utilsdemo.common.recyclerviews.ViewHolder;
import com.first.alina.utilsdemo.scrollview.adapters.Adapter1;
import com.first.alina.utilsdemo.scrollview.beans.TestWebBean;
import com.first.alina.utilsdemo.scrollview.beans.TextBean;
import com.first.alina.utilsdemo.scrollview.viewholders.TextViewHolder;
import com.first.alina.utilsdemo.scrollview.viewholders.WebViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alina on 2018/7/11.
 */

public class RecyclerViewWebActivity extends Activity {
    private final String TAG="ScrollViewTopActivity";
    private RecyclerView recyclerView;
    private List<Object> textBeenList = new ArrayList<>();
    private Adapter1<Object> adapter1;
    private LinearLayoutManager linearLayoutManager;
    private WebView webView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_web);
        initView();
        initData();

    }

    private void initView() {
        recyclerView = findViewById(R.id.recyclerView);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    private void initData() {
        textBeenList.add(new TestWebBean());
        for (int i = 0; i < 80; i++) {
            TextBean textBean = new TextBean();
            textBean.title = "第 " + i + " 条数据";
            textBeenList.add(textBean);
        }
        adapter1 = new Adapter1<Object>(this) {
            @Override
            public Class<? extends ViewHolder> getHolderClass(Object object, int position) {
                if (object instanceof TextBean) {
                    return TextViewHolder.class;
                }else if (object instanceof TestWebBean){

                    return WebViewHolder.class;
                }
                return TextViewHolder.class;
            }
        };
        adapter1.addData(textBeenList);
        recyclerView.setAdapter(adapter1);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return super.onKeyDown(keyCode, event);
    }
}
