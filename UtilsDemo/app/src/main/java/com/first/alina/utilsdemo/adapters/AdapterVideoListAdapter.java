package com.first.alina.utilsdemo.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.bumptech.glide.Glide;
import com.first.alina.utilsdemo.R;


import java.util.List;

import cn.jzvd.JZVideoPlayer;
import cn.jzvd.JZVideoPlayerStandard;

/**
 * Created by alina on 2018/4/4.
 */

public class AdapterVideoListAdapter extends BaseAdapter {
    public static final String TAG = "JiaoZiVideoPlayer";
    String picUrl="http://img.ivsky.com/img/bizhi/t/201801/31/weimei_de_shuben-002.jpg";

    Context context;

    List<String> videoUrls;

    public AdapterVideoListAdapter(Context context, List<String> videoUrls) {
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
        viewHolder.jzVideoPlayer = convertView.findViewById(R.id.videoplayer);
        viewHolder.jzVideoPlayer.setUp(
                videoUrls.get(position), JZVideoPlayer.SCREEN_WINDOW_LIST,
                "我是视频");
        Glide.with(convertView.getContext())
                .load(picUrl)
                .into(viewHolder.jzVideoPlayer.thumbImageView);
        viewHolder.jzVideoPlayer.positionInList = position;
        viewHolder.jzVideoPlayer.startVideo();
        return convertView;
    }

    class ViewHolder {
        JZVideoPlayerStandard jzVideoPlayer;
    }
}
