package com.first.alina.utilsdemo.customview;

import com.first.alina.utilsdemo.R;
import com.first.alina.utilsdemo.base.BaseRecyclerViewActivity;
import com.first.alina.utilsdemo.common.recyclerviews.ViewHolder;
import com.first.alina.utilsdemo.main.bean.NoPaddingBean;
import com.first.alina.utilsdemo.main.viewholders.NoPaddingTextViewViewHolder;

import java.util.ArrayList;
import java.util.List;

public class NoPaddingActivity extends BaseRecyclerViewActivity {
    private List<Object> list=new ArrayList<>();
    @Override
    public void initData() {
        list.clear();
        list.add(new NoPaddingBean());
        addAdapterData(list);
    }

    @Override
    protected Class<? extends ViewHolder> getViewHolderClass(Object object, int position) {
        if (object instanceof NoPaddingBean){
            return NoPaddingTextViewViewHolder.class;
        }
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_no_padding;
    }

    @Override
    protected int getRecyclerViewId() {
        return R.id.recyclerView;
    }
}
