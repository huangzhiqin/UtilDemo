package com.first.alina.utilsdemo.recyclerviews.sideSlips;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

/**
 * Created by alina on 2018/5/23.
 */

public class SideSlipTouchHelperCallback extends ItemTouchHelper.Callback {

    private SideSlipItemTouchMoveListener sideSlipItemTouchMoveListener;

    public SideSlipTouchHelperCallback(SideSlipItemTouchMoveListener sideSlipItemTouchMoveListener) {
        this.sideSlipItemTouchMoveListener = sideSlipItemTouchMoveListener;
    }

    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
        int swipeFlags = ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
        int flag = makeMovementFlags(dragFlags, swipeFlags);
        return flag;
    }

    /**
     * 是否打开长按拖拽效果
     *
     * @return
     */
    @Override
    public boolean isLongPressDragEnabled() {
        return true;
    }

    /**
     * 上下移动时回调方法
     * @param recyclerView
     * @param viewHolder
     * @param target
     * @return
     */
    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
      if (viewHolder.getItemViewType()!=target.getItemViewType()){
          return false;
      }
      boolean result=sideSlipItemTouchMoveListener.onItemMove(viewHolder.getAdapterPosition(),target.getAdapterPosition());
        return result;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        sideSlipItemTouchMoveListener.onItemRemove(viewHolder.getAdapterPosition());

    }
}
