package com.first.alina.utilsdemo.recyclerviews.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.first.alina.utilsdemo.R;
import com.first.alina.utilsdemo.recyclerviews.sideSlips.SideSlipItemTouchMoveListener;

import java.util.Collections;
import java.util.List;

/**
 * Created by alina on 2018/5/23.
 */

public class SideSlipRecyclerViewAdapter extends RecyclerView.Adapter<SideSlipRecyclerViewAdapter.SideSlipViewHolder> implements SideSlipItemTouchMoveListener{
    private List<String> dataList;

    public void setDataList(List<String> dataList){
        this.dataList=dataList;
    }

    @Override
    public SideSlipViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sideslipe_recyclerview,parent,false);
        return new SideSlipViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final SideSlipViewHolder holder, int position) {
        holder.title.setText(dataList.get(position));
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(holder.title.getContext(),"delete is start",Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    @Override
    public boolean onItemMove(int fromPos, int toPos) {
        Collections.swap(dataList,fromPos,toPos);
        notifyItemMoved(fromPos, toPos);
        return true;
    }

    @Override
    public boolean onItemRemove(int position) {
        dataList.remove(position);
        notifyItemRemoved(position);
        return true;
    }

    @Override
    public boolean swipeItem(int position) {

        return true;
    }


    public  class SideSlipViewHolder extends RecyclerView.ViewHolder{
        private TextView title;
        ImageView delete;

        public SideSlipViewHolder(View view) {
            super(view);
            title=view.findViewById(R.id.side_slip_item);
            delete=view.findViewById(R.id.side_slip_delete);

        }
    }
}
