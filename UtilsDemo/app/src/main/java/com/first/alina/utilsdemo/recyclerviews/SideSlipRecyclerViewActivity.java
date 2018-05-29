package com.first.alina.utilsdemo.recyclerviews;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.first.alina.utilsdemo.R;
import com.first.alina.utilsdemo.recyclerviews.adapters.SideSlipRecyclerViewAdapter;
import com.first.alina.utilsdemo.recyclerviews.sideSlips.SideSlipTouchHelperCallback;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alina on 2018/5/23.
 */

public class SideSlipRecyclerViewActivity extends Activity {
    private RecyclerView recyclerView;
    private List<String> list;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sideslipe);
        recyclerView = findViewById(R.id.side_slip_recyclerView);
        list=new ArrayList<>();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        for (int i=0;i<100;i++){
            list.add("我是第 "+i+" 条数据,lalalalala。");
        }
        SideSlipRecyclerViewAdapter sideSlipRecyclerViewAdapter=new SideSlipRecyclerViewAdapter();
        sideSlipRecyclerViewAdapter.setDataList(list);
        recyclerView.setAdapter(sideSlipRecyclerViewAdapter);
        //条目触摸类
        ItemTouchHelper.Callback callback=new SideSlipTouchHelperCallback(sideSlipRecyclerViewAdapter);
        ItemTouchHelper itemTouchHelper=new ItemTouchHelper(callback);
        itemTouchHelper.attachToRecyclerView(recyclerView);

    }
}
