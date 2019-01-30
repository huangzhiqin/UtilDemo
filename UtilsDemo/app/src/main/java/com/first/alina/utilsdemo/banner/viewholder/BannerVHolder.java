package com.first.alina.utilsdemo.banner.viewholder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by alina on 2018/10/10.
 */

public interface BannerVHolder<T> {
    View createView(Context context,ViewGroup container);

    void bindData(Context context,List<T> data,int position);
}
