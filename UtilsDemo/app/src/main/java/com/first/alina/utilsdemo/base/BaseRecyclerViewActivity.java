package com.first.alina.utilsdemo.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.first.alina.utilsdemo.common.recyclerviews.ViewHolder;
import com.first.alina.utilsdemo.scrollview.adapters.Adapter1;

import java.util.List;

public abstract class BaseRecyclerViewActivity extends Activity {
    private Adapter1<Object> adapter1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        initView();
        initRecyclerView();
        initData();

    }

    public abstract void initData();

    private void initRecyclerView(){
     RecyclerView recyclerView=findViewById(getRecyclerViewId());
     recyclerView.setLayoutManager(new LinearLayoutManager(this));
     adapter1=new Adapter1<Object>(this) {
         @Override
         public Class<? extends ViewHolder> getHolderClass(Object object, int position) {
             return getViewHolderClass(object,position);
         }
     };
     recyclerView.setAdapter(adapter1);
    }


    protected void initView(){}

    protected void addAdapterData(List<Object> objectList){
        adapter1.addData(objectList);
        adapter1.notifyDataSetChanged();
    }

    public void clearAll(){
      adapter1.clearAll();
    }

    public void loadMore(List<Object> objects){
        adapter1.addData(objects);
    }

    public void notifyData(){
        adapter1.notifyDataSetChanged();
    }

    protected abstract Class<? extends ViewHolder> getViewHolderClass(Object object, int position);
    protected abstract int getLayoutId();

    protected abstract int getRecyclerViewId();

}
