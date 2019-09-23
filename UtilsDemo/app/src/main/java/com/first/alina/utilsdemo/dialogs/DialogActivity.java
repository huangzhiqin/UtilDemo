package com.first.alina.utilsdemo.dialogs;

import com.first.alina.utilsdemo.R;
import com.first.alina.utilsdemo.base.BaseRecyclerViewActivity;
import com.first.alina.utilsdemo.common.recyclerviews.ViewHolder;
import com.first.alina.utilsdemo.main.bean.BottomDialogBean;
import com.first.alina.utilsdemo.main.bean.Dialog2Bean;
import com.first.alina.utilsdemo.main.viewholders.BottomDialogViewHolder;
import com.first.alina.utilsdemo.main.viewholders.Dialog2ViewHolder;

import java.util.ArrayList;
import java.util.List;

public class DialogActivity extends BaseRecyclerViewActivity {
    private List<Object> list=new ArrayList<>();

    @Override
    public void initData() {
        list.clear();
        list.add(new Dialog2Bean());
        list.add(new BottomDialogBean());
        addAdapterData(list);
    }

    @Override
    protected Class<? extends ViewHolder> getViewHolderClass(Object object, int position) {
        if (object instanceof Dialog2Bean) {
            return Dialog2ViewHolder.class;
        } else if (object instanceof BottomDialogBean) {
            return BottomDialogViewHolder.class;
        }
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_dialog;
    }

    @Override
    protected int getRecyclerViewId() {
        return R.id.recyclerView;
    }

}
