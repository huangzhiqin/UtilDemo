package com.first.alina.utilsdemo.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.first.alina.utilsdemo.R;
import com.first.alina.utilsdemo.widget.AdVideoViewPlayer;

import java.util.ArrayList;
import java.util.List;

import cn.jzvd.JZVideoPlayer;

/**
 * Created by alina on 2018/4/4.
 */

public class VideoAdapter extends BaseAdapter {
    private final String TAG="VideoAdapter";
    private Context mContext;
    private List<String> list;
    String picUrl="http://img.ivsky.com/img/bizhi/t/201801/31/weimei_de_shuben-002.jpg";

    public VideoAdapter(Context context) {
        list=new ArrayList<>();
        this.mContext = context;
    }

    public void setData(List<String> list){

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
        ViewHolder holder;
        if (null==convertView){
            convertView= LayoutInflater.from(mContext).inflate(R.layout.item_layout,null);
            holder=new ViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder=(ViewHolder)convertView.getTag();
        }
        Log.e(TAG,"==> url "+list.get(position));
        holder.adVideoViewPlayer.setUp(list.get(position), JZVideoPlayer.SCREEN_WINDOW_LIST,"视频");
        //holder.adVideoViewPlayer.setTag("video");
        if (holder.adVideoViewPlayer.positionInList==-1){
            holder.adVideoViewPlayer.startVideo();
        }
        Glide.with(mContext).load(picUrl).into(holder.adVideoViewPlayer.thumbImageView);

       // holder.adVideoViewPlayer.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ScreenUtils.getScreenWidth(mContext) * 7 / 16));

        return convertView;
    }

   private class ViewHolder{
        TextView videoTitle;
        AdVideoViewPlayer adVideoViewPlayer;

        public ViewHolder(View convertView) {
            adVideoViewPlayer=convertView.findViewById(R.id.video_player);
        }
    }
}
