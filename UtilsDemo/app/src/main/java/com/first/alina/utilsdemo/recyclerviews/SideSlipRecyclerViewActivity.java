package com.first.alina.utilsdemo.recyclerviews;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.ViewGroup;

import com.first.alina.utilsdemo.R;
import com.first.alina.utilsdemo.common.recyclerviews.ViewHolder;
import com.first.alina.utilsdemo.recyclerviews.adapters.SideSlipRecyclerViewAdapter;
import com.first.alina.utilsdemo.recyclerviews.bean.SwipeMenuBean;
import com.first.alina.utilsdemo.recyclerviews.sideSlips.SideSlipTouchHelperCallback;
import com.first.alina.utilsdemo.recyclerviews.widget.SwipeMenu;
import com.first.alina.utilsdemo.recyclerviews.widget.SwipeMenuBridge;
import com.first.alina.utilsdemo.recyclerviews.widget.SwipeMenuCreator;
import com.first.alina.utilsdemo.recyclerviews.widget.SwipeMenuItem;
import com.first.alina.utilsdemo.recyclerviews.widget.SwipeMenuRecyclerView;
import com.first.alina.utilsdemo.scrollview.adapters.Adapter1;
import com.first.alina.utilsdemo.scrollview.viewholders.SwipeMenuViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alina on 2018/5/23.
 */

public class SideSlipRecyclerViewActivity extends Activity {
    private SwipeMenuRecyclerView recyclerView;
    private List<Object> list;
    private Adapter1<Object> adapter1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sideslipe);
        recyclerView = findViewById(R.id.side_slip_recyclerView);
        list = new ArrayList<>();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        for (int i = 0; i < 100; i++) {
            SwipeMenuBean swipeMenuBean = new SwipeMenuBean();
            swipeMenuBean.title = "我是第 " + i + " 条数据,lalalalala。";
            list.add(swipeMenuBean);
        }
        adapter1 = new Adapter1<Object>(this) {
            @Override
            public Class<? extends ViewHolder> getHolderClass(Object object, int position) {
                if (object instanceof SwipeMenuBean) {
                    return SwipeMenuViewHolder.class;
                }
                return SwipeMenuViewHolder.class;
            }
        };
        adapter1.addData(list);

        recyclerView.setAdapter(adapter1);
        adapter1.setSwipeMenuCreator(swipeMenuCreator);
        adapter1.setSwipeMenuItemClickListener(new SwipeMenuItemClickListener() {
            @Override
            public void onItemClick(SwipeMenuBridge menuBridge) {
                menuBridge.closeMenu();
                int direction = menuBridge.getDirection();
                //recyclerView的item中侧滑按钮位置
                int recyclerViewItemPos = menuBridge.getPosition();
                //recyclerView中item位置
                int recyclerViewPos = menuBridge.getAdapterPosition();
                if (direction == SwipeMenuRecyclerView.RIGHT_DIRECTION) {
                    int itemPosition1 = 1;
                    int itemPosition2 = 2;
                    if (recyclerViewItemPos == itemPosition1) {

                    } else if (recyclerViewItemPos == itemPosition2) {

                    }
                }
            }
        });

    }


    private SwipeMenuCreator swipeMenuCreator = new SwipeMenuCreator() {
        @Override
        public void onCreateMenu(SwipeMenu swipeLeftMenu, SwipeMenu swipeRightMenu, int viewType, int position) {

            SwipeMenuBean subjectFreeTalkBean = (SwipeMenuBean) list.get(position);
            int width = getResources().getDimensionPixelSize(R.dimen.subject_of_all_talk_item_width);
            int height = ViewGroup.LayoutParams.MATCH_PARENT;
            {
                SwipeMenuItem placeholderItem = new SwipeMenuItem(SideSlipRecyclerViewActivity.this)
                        .setBackground(R.drawable.ic_empty)
                        .setWidth(getResources().getDimensionPixelSize(R.dimen.subject_free_talk_menu_placeholder))
                        .setTextSize(18)
                        .setHeight(height);
                //加入一个空的item，为空出与左边的位置
                swipeRightMenu.addMenuItem(placeholderItem);
                SwipeMenuItem deleteItem = new SwipeMenuItem(SideSlipRecyclerViewActivity.this)
                        .setBackgroundColor(getResources().getColor(R.color.color_grey_999999))
                        .setText("取消\n关注")
                        .setTextColor(getResources().getColor(R.color.white))
                        .setTextSize(18)
                        .setWidth(width)
                        .setHeight(height);
                // 添加菜单到右侧。
                swipeRightMenu.addMenuItem(deleteItem);

                SwipeMenuItem addItem = new SwipeMenuItem(SideSlipRecyclerViewActivity.this)
                        .setText(!subjectFreeTalkBean.isPush ? "开启\n推送" : "关闭\n推送")
                        .setBackgroundColor(getResources().getColor(R.color.color_grey_999999))
                        .setTextColor(getResources().getColor(R.color.bg_pink))
                        .setWidth(width)
                        .setTextSize(18)
                        .setHeight(height);
                // 添加菜单到右侧。
                swipeRightMenu.addMenuItem(addItem);
            }
        }
    };
}
