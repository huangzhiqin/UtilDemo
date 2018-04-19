package com.first.alina.utilsdemo.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.bumptech.glide.Glide;
import com.first.alina.utilsdemo.R;
import com.first.alina.utilsdemo.widget.AdVideoViewPlayer;

import java.util.List;

import cn.jzvd.JZVideoPlayer;

/**
 * Created by alina on 2018/4/4.
 */

public class AdapterVideoList extends BaseAdapter {

    public static final String TAG = "JiaoZiVideoPlayer";
    String picUrl="http://img.ivsky.com/img/bizhi/t/201801/31/weimei_de_shuben-002.jpg";

    Context context;

    List<String> videoUrls;

    public AdapterVideoList(Context context, List<String> videoUrls) {
        this.context = context;
        this.videoUrls = videoUrls;
    }

    @Override
    public int getCount() {
        return videoUrls.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;
        if (null == convertView) {
            viewHolder = new ViewHolder();
            LayoutInflater mInflater = LayoutInflater.from(context);
            convertView = mInflater.inflate(R.layout.item_videoview, null);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.adVideoViewPlayer = convertView.findViewById(R.id.videoplayer);
        viewHolder.adVideoViewPlayer.setUp(
                videoUrls.get(position), JZVideoPlayer.SCREEN_WINDOW_LIST,
                "我是视频");
        Glide.with(convertView.getContext())
                .load(picUrl)
                .into(viewHolder.adVideoViewPlayer.thumbImageView);
        int positionInList=viewHolder.adVideoViewPlayer.positionInList;
        if (positionInList==-1){
            viewHolder.adVideoViewPlayer.startVideo();
        }
        Log.e(TAG,"==>positionInList "+positionInList);
        viewHolder.adVideoViewPlayer.positionInList = position;


        return convertView;
    }

    class ViewHolder {
        //JZVideoPlayerStandard jzVideoPlayer;
        AdVideoViewPlayer adVideoViewPlayer;
    }
}
