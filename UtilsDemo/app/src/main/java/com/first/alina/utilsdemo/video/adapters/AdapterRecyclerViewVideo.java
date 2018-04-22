package com.first.alina.utilsdemo.video.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.AudioManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.first.alina.utilsdemo.R;
import com.first.alina.utilsdemo.VideoConstant;
import com.first.alina.utilsdemo.widget.AdVideoViewPlayer;

import cn.jzvd.JZVideoPlayer;

public class AdapterRecyclerViewVideo extends RecyclerView.Adapter<AdapterRecyclerViewVideo.MyViewHolder> {

    public static final String TAG = "RecyclerViewVideo";
    int[] videoIndexs = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    private Context context;
    private AudioManager mAudioManager;

    public AdapterRecyclerViewVideo(Context context) {
        this.context = context;
        mAudioManager = (AudioManager)context.getSystemService(Context.AUDIO_SERVICE);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
                context).inflate(R.layout.item_recyclerview, parent,
                false));
        return holder;
    }

    @SuppressLint("LongLogTag")
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.jzVideoPlayer.setUp(
                VideoConstant.videoUrls[0][position], JZVideoPlayer.SCREEN_WINDOW_LIST,
                VideoConstant.videoTitles[0][position]);
        int positionList=holder.jzVideoPlayer.positionInList;
        mAudioManager.setStreamMute(AudioManager.STREAM_MUSIC,true);
       // holder.jzVideoPlayer.startVideo();
        holder.jzVideoPlayer.positionInList=position;
        Log.i(TAG, "onBindViewHolder "+" position=" + position+" positionInList "+positionList+" "+(positionList==-1)+" "+holder.jzVideoPlayer.positionInList);
        mAudioManager.requestAudioFocus(onAudioFocusChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);//短暂的获取焦点,会暂停后台的媒体播放器

        holder.itemView.setTag(position);

        holder.videoCloseImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e(TAG,"==> "+mAudioManager.getStreamVolume(AudioManager.STREAM_MUSIC)+" "+(mAudioManager.getStreamVolume(AudioManager.STREAM_MUSIC)==0));
                if ((mAudioManager.getStreamVolume(AudioManager.STREAM_MUSIC))==0){
                    mAudioManager.setStreamMute(AudioManager.STREAM_MUSIC,false);
                }else {
                    mAudioManager.setStreamMute(AudioManager.STREAM_MUSIC,true);
                }
            }
        });

        Glide.with(holder.jzVideoPlayer.getContext()).load(VideoConstant.videoThumbs[0][position]).into(holder.jzVideoPlayer.thumbImageView);

    }

    @Override
    public int getItemCount() {
        return videoIndexs.length;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        AdVideoViewPlayer jzVideoPlayer;
        ImageView videoCloseImg;

        public MyViewHolder(View itemView) {
            super(itemView);
            jzVideoPlayer = itemView.findViewById(R.id.videoplayer);
            videoCloseImg=itemView.findViewById(R.id.video_close_icon);
        }
    }

    AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener=new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int i) {
            switch (i){
                case AudioManager.AUDIOFOCUS_GAIN://获取焦点

                    break;

                case AudioManager.AUDIOFOCUS_LOSS://失去焦点

                    break;
                case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT://短暂的失去焦点

                    break;
                case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK://

                    break;
            }

        }
    };

}
