package com.first.alina.utilsdemo.banner;

import android.view.View;

/**
 * Created by alina on 2017/11/24.
 */

public interface FocusViewListener<T>{
    void getItemView(View view, T data);
}
