package com.first.alina.utilsdemo.scrollview.viewholders;

import android.view.View;

import com.first.alina.utilsdemo.R;
import com.first.alina.utilsdemo.common.recyclerviews.BindLayout;
import com.first.alina.utilsdemo.common.recyclerviews.ViewHolder;
import com.first.alina.utilsdemo.recyclerviews.bean.SwipeMenuBean;
import com.first.alina.utilsdemo.recyclerviews.widget.SwipeMenu;
import com.first.alina.utilsdemo.recyclerviews.widget.SwipeMenuLayout;
import com.first.alina.utilsdemo.recyclerviews.widget.SwipeMenuRecyclerView;
import com.first.alina.utilsdemo.recyclerviews.widget.SwipeMenuView;

/**
 * Created by alina on 2018/7/20.
 */
@BindLayout(R.layout.recycler_swipe_view_item)
public class SwipeMenuViewHolder extends ViewHolder<SwipeMenuBean>{
    public SwipeMenuViewHolder(View itemView) {
        super(itemView);
        SwipeMenuLayout swipeMenuLayout = (SwipeMenuLayout) itemView;
        int childCount = swipeMenuLayout.getChildCount();

        for (int i = 0; i < childCount; i++) {
            View childView = swipeMenuLayout.getChildAt(2);
            if (childView instanceof SwipeMenuView) {
                ((SwipeMenuView) childView).bindViewHolder(this);
            }
        }
    }

    @Override
    public void setContent(SwipeMenuBean item, int position) {
        SwipeMenuLayout swipeMenuLayout = getView(R.id.swipe_menu_layout);
        SwipeMenu swipeLeftMenu = new SwipeMenu(swipeMenuLayout, getAdapter().getItemViewType(position));
        SwipeMenu swipeRightMenu = new SwipeMenu(swipeMenuLayout, getAdapter().getItemViewType(position));
        getAdapter().getSwipeMenuCreator().onCreateMenu(swipeLeftMenu, swipeRightMenu, getAdapter().getItemViewType(position), position);
        int leftMenuCount = swipeLeftMenu.getMenuItems().size();
        if (leftMenuCount > 0) {
            SwipeMenuView swipeLeftMenuView =getView(R.id.swipe_left);
            // noinspection WrongConstant
            swipeLeftMenuView.setOrientation(swipeLeftMenu.getOrientation());
            swipeLeftMenuView.createMenu(swipeLeftMenu, swipeMenuLayout, getAdapter().getSwipeMenuItemClickListener(), SwipeMenuRecyclerView.LEFT_DIRECTION);
        }

        int rightMenuCount = swipeRightMenu.getMenuItems().size();
        if (rightMenuCount > 0) {
            SwipeMenuView swipeRightMenuView = swipeMenuLayout.findViewById(R.id.swipe_right);
            // noinspection WrongConstant
            swipeRightMenuView.setOrientation(swipeRightMenu.getOrientation());
            swipeRightMenuView.createMenu(swipeRightMenu, swipeMenuLayout, getAdapter().getSwipeMenuItemClickListener(), SwipeMenuRecyclerView.RIGHT_DIRECTION);
            //setSwipeMenu(swipeRightMenu.getMenuItems());
        }

    }
}
