package com.first.alina.utilsdemo.floatview;

import com.first.alina.utilsdemo.R;
import com.first.alina.utilsdemo.base.BaseRecyclerViewActivity;
import com.first.alina.utilsdemo.common.recyclerviews.ViewHolder;
import com.first.alina.utilsdemo.main.bean.CustomFloatBean;
import com.first.alina.utilsdemo.main.bean.FloatViewBean;
import com.first.alina.utilsdemo.main.viewholders.CustomFloatViewHolder;
import com.first.alina.utilsdemo.main.viewholders.FloatViewHolder;

import java.util.ArrayList;
import java.util.List;

public class FloatMainActivity extends BaseRecyclerViewActivity {
    private List<Object> objectList=new ArrayList<>();
    @Override
    protected Class<? extends ViewHolder> getViewHolderClass(Object object, int position) {
         if (object instanceof CustomFloatBean) {
            return CustomFloatViewHolder.class;
        } else if (object instanceof FloatViewBean) {
             return FloatViewHolder.class;
         }
        return null;
    }

    @Override
    public void initData() {
        objectList.clear();
        objectList.add(new FloatViewBean());
        objectList.add(new CustomFloatBean());
        addAdapterData(objectList);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_float_main;
    }

    @Override
    protected int getRecyclerViewId() {
        return R.id.recyclerView;
    }
}
