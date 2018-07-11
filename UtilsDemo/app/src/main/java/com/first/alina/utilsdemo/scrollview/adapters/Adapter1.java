package com.first.alina.utilsdemo.scrollview.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.first.alina.utilsdemo.common.recyclerviews.BindLayout;
import com.first.alina.utilsdemo.common.recyclerviews.ViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alina on 2018/7/11.
 */

public abstract class Adapter1<T> extends RecyclerView.Adapter<ViewHolder> {

    private List<T> dataList = new ArrayList<>();
    private Context mContext;
    private SparseArray<Class<? extends ViewHolder>> viewHolderArray;

    public Adapter1(Context context) {
        this.mContext = context;
        viewHolderArray = new SparseArray<>();
    }

    public void addData(List<T> list) {
        this.dataList=list;
    }

    public void clearAll() {
        dataList.clear();
    }

    public void remove(int position) {
        dataList.remove(position);
    }

    public T getItem(int position){
        return dataList.get(position);
    }

    @Override
    public int getItemViewType(int position) {
        Class<? extends ViewHolder> cls = getHolderClass(dataList.get(position), position);
        int type = cls.hashCode();
        viewHolderArray.append(type, cls);
        return type;
    }

    public abstract Class<? extends ViewHolder> getHolderClass(Object object, int position);

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Class<? extends ViewHolder> viewHolderCls = viewHolderArray.get(viewType);
        ViewHolder viewHolder = null;
        BindLayout bindLayout = viewHolderCls.getAnnotation(BindLayout.class);
        int viewLayout = bindLayout.value();
        View view = LayoutInflater.from(mContext).inflate(viewLayout, parent, false);
        try {
            viewHolder=viewHolderCls.getConstructor(View.class).newInstance(view);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.setItem(getItem(position));
        holder.setContent(dataList.get(position),position);
    }

    @Override
    public int getItemCount() {
        return dataList.size()>0?dataList.size():0;
    }

}
