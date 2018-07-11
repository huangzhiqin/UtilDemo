package com.first.alina.utilsdemo.common.recyclerviews;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;

/**
 * Created by alina on 2018/7/11.
 */

public abstract class ViewHolder<T> extends RecyclerView.ViewHolder {
    private SparseArray<View> viewArray;
    protected Context mContext;
    private View itemView;
    private T item;

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public ViewHolder(View itemView) {
        super(itemView);
        viewArray=new SparseArray<>();
        mContext=itemView.getContext();
        this.itemView=itemView;
    }

    public abstract void setContent(T item,int position);

    public <V extends View> V getView(@IdRes int resId){
       V view= (V)viewArray.get(resId);
        if (view==null){
            view=itemView.findViewById(resId);
            viewArray.append(resId,view);
        }
        return view;
    }

}
