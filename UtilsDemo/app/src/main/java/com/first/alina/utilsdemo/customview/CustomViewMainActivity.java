package com.first.alina.utilsdemo.customview;

import com.first.alina.utilsdemo.R;
import com.first.alina.utilsdemo.base.BaseRecyclerViewActivity;
import com.first.alina.utilsdemo.common.recyclerviews.ViewHolder;
import com.first.alina.utilsdemo.customview.bean.CustomViewMainBean;
import com.first.alina.utilsdemo.customview.bean.UpdateViewBean;
import com.first.alina.utilsdemo.customview.viewholder.CustomViewMainViewHolder;
import com.first.alina.utilsdemo.customview.viewholder.UpdateViewHolder;
import com.first.alina.utilsdemo.main.bean.BannerBean;
import com.first.alina.utilsdemo.main.bean.CanvasBean;
import com.first.alina.utilsdemo.main.bean.MoveCommentBean;
import com.first.alina.utilsdemo.main.bean.RatingBarBean;
import com.first.alina.utilsdemo.main.bean.ScrollUpDownBean;
import com.first.alina.utilsdemo.main.viewholders.BannerViewHolder;
import com.first.alina.utilsdemo.main.viewholders.CanvasViewHolder;
import com.first.alina.utilsdemo.main.viewholders.MoveCommentViewHolder;
import com.first.alina.utilsdemo.main.viewholders.RatingBarViewHolder;
import com.first.alina.utilsdemo.main.viewholders.ScrollUpDownViewHolder;

import java.util.ArrayList;
import java.util.List;

public class CustomViewMainActivity extends BaseRecyclerViewActivity {
    private List<Object> list=new ArrayList<>();
    @Override
    public void initData() {
        list.clear();
        list.add(new CustomViewMainBean());
        list.add(new RatingBarBean());
        list.add(new MoveCommentBean());
        list.add(new CanvasBean());
        list.add(new BannerBean());
        list.add(new UpdateViewBean());
        addAdapterData(list);

    }

    @Override
    protected Class<? extends ViewHolder> getViewHolderClass(Object object, int position) {
        if (object instanceof CustomViewMainBean){
            return CustomViewMainViewHolder.class;
        } else if (object instanceof RatingBarBean) {
            return RatingBarViewHolder.class;
        }else if (object instanceof MoveCommentBean) {
            return MoveCommentViewHolder.class;
        }else if (object instanceof ScrollUpDownBean) {
            return ScrollUpDownViewHolder.class;
        } else if (object instanceof CanvasBean) {
            return CanvasViewHolder.class;
        }else if (object instanceof BannerBean) {
            return BannerViewHolder.class;
        }else if (object instanceof UpdateViewBean){
            return UpdateViewHolder.class;
        }
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_custom_main;
    }

    @Override
    protected int getRecyclerViewId() {
        return R.id.recyclerView;
    }
}
