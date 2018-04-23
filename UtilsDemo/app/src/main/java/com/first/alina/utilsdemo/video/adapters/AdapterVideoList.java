package com.first.alina.utilsdemo.video.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.bumptech.glide.Glide;
import com.first.alina.utilsdemo.R;

import cn.jzvd.JZVideoPlayer;
import cn.jzvd.JZVideoPlayerStandard;

/**
 * Created by Nathen
 * On 2016/02/07 01:20
 */
public class AdapterVideoList extends BaseAdapter {

    public static final String TAG = "JiaoZiVideoPlayer";

    Context context;

    String[] videoUrls;
    String[] videoTitles;
    String[] videoThumbs;

    public AdapterVideoList(Context context, String[] videoUrls, String[] videoTitles, String[] videoThumbs) {
        this.context = context;
        this.videoUrls = videoUrls;
        this.videoTitles = videoTitles;
        this.videoThumbs = videoThumbs;
    }

    @Override
    public int getCount() {
        return videoUrls.length;
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
   /*     viewHolder.jzVideoPlayer = convertView.findViewById(R.id.videoplayer);
        viewHolder.jzVideoPlayer.setUp(
                videoUrls[position], JZVideoPlayer.SCREEN_WINDOW_LIST,
                videoTitles[position]);
        Glide.with(convertView.getContext())
                .load(videoThumbs[position])
                .into(viewHolder.jzVideoPlayer.thumbImageView);
        viewHolder.jzVideoPlayer.positionInList = position;*/
        viewHolder.jzVideoPlayer = convertView.findViewById(R.id.videoplayer);
        viewHolder.jzVideoPlayer.setUp(
                videoUrls[position], JZVideoPlayer.SCREEN_WINDOW_LIST,
                "我是视频");
        Glide.with(convertView.getContext())
                .load(videoThumbs[position])
                .into(viewHolder.jzVideoPlayer.thumbImageView);
        int positionInList=viewHolder.jzVideoPlayer.positionInList;
        if (positionInList==-1){
            viewHolder.jzVideoPlayer.startVideo();
        }
        viewHolder.jzVideoPlayer.positionInList = position;
        return convertView;
    }

    class ViewHolder {
        JZVideoPlayerStandard jzVideoPlayer;
    }
}