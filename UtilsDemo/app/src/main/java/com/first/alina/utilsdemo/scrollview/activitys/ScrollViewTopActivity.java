package com.first.alina.utilsdemo.scrollview.activitys;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.first.alina.utilsdemo.R;
import com.first.alina.utilsdemo.common.recyclerviews.ViewHolder;
import com.first.alina.utilsdemo.scrollview.adapters.Adapter1;
import com.first.alina.utilsdemo.scrollview.beans.TextBean;
import com.first.alina.utilsdemo.scrollview.viewholders.TextViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alina on 2018/7/11.
 */

public class ScrollViewTopActivity extends Activity{
    private RecyclerView recyclerView;
    private List<Object> textBeenList=new ArrayList<>();
    private Adapter1<Object> adapter1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrollview);
        initView();
        initData();

    }

    private void initView(){
        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    private void initData(){
        for (int i=0;i<80;i++){
            TextBean textBean=new TextBean();
            textBean.title="第 "+i+" 条数据";
            textBeenList.add(textBean);
        }
        adapter1=new Adapter1<Object>(this) {
            @Override
            public Class<? extends ViewHolder> getHolderClass(Object object, int position) {
                if (object instanceof TextBean){
                    return TextViewHolder.class;
                }
                return TextViewHolder.class;
            }
        };
        adapter1.addData(textBeenList);
        recyclerView.setAdapter(adapter1);
    }
}
