package com.first.alina.utilsdemo.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.first.alina.utilsdemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alina on 2018/4/23.
 */

public class DialogWealAdapter extends BaseAdapter{

    private List<String> list;
    private Context context;

    public DialogWealAdapter(Context context) {
        this.context = context;
        list=new ArrayList<>();
    }

    public void setData(List<String> list){
        if (this.list.size()>0){
            this.list.clear();
        }
        this.list.addAll(list);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView==null){
            convertView=LayoutInflater.from(context).inflate(R.layout.item_dialog_weal,null);
            viewHolder=new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) convertView.getTag();
        }
        viewHolder.moneyTv.setText(list.get(position));
        return convertView;
    }

  private class ViewHolder{
        TextView moneyTv;
        TextView moneyCouponTv;
        TextView wealTime;
        TextView couponTitle;

      public ViewHolder(View view) {
          moneyTv=view.findViewById(R.id.dialog_money);
          moneyCouponTv=view.findViewById(R.id.dialog_money_coupon);
          wealTime=view.findViewById(R.id.dialog_weal_time);
          couponTitle=view.findViewById(R.id.dialog_coupon_title);
      }
  }
}
