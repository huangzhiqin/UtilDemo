package com.first.alina.utilsdemo.kline;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.first.alina.utilsdemo.R;
import com.first.alina.utilsdemo.common.recyclerviews.ViewHolder;
import com.first.alina.utilsdemo.kline.viewholer.BrokenLine1ViewHolder;
import com.first.alina.utilsdemo.scrollview.adapters.Adapter1;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alina on 2018/8/28.
 */

public class BrokenLine1Activity extends Activity{
    private RecyclerView recyclerView;
    private Adapter1<Object> adapter1;
    private List<Object> lists=new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brokenline1);
        initRecyclerView();
        initAdapter();
        initData();

    }

    private void initRecyclerView(){
        recyclerView=findViewById(R.id.broken_line1_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initAdapter(){
        adapter1=new Adapter1<Object>(this) {
            @Override
            public Class<? extends ViewHolder> getHolderClass(Object object, int position) {
                if (object instanceof LineData){
                    return BrokenLine1ViewHolder.class;
                }
                return BrokenLine1ViewHolder.class;
            }
        };
        recyclerView.setAdapter(adapter1);
    }

    private void initData(){
        ArrayList<Entry> entries=new ArrayList<>();
        for (int i=0;i<5;i++){
            entries.add(new Entry(i,(int) (Math.random() * 65) + 40));
        }
        LineDataSet lineDataSet=new LineDataSet(entries,"折线图");
        lineDataSet.setLineWidth(2.5f);
        lineDataSet.setCircleRadius(0);
        lineDataSet.setHighLightColor(R.color.visible_color1);

        ArrayList<ILineDataSet> sets=new ArrayList<>();
        sets.add(lineDataSet);
        LineData lineData=new LineData(sets);
        lists.add(lineData);
        adapter1.addData(lists);
        adapter1.notifyDataSetChanged();
    }
}
