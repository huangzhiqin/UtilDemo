package com.first.alina.utilsdemo.recyclerviews.sideSlips;

import android.graphics.Canvas;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.ViewGroup;

import com.first.alina.utilsdemo.recyclerviews.adapters.SideSlipRecyclerViewAdapter;

/**
 * Created by alina on 2018/5/23.
 */

public class SideSlipTouchHelperCallback extends ItemTouchHelper.Callback {
    private final String TAG = "SideSlipTouchCallback";

    private SideSlipItemTouchMoveListener sideSlipItemTouchMoveListener;

    public SideSlipTouchHelperCallback(SideSlipItemTouchMoveListener sideSlipItemTouchMoveListener) {
        this.sideSlipItemTouchMoveListener = sideSlipItemTouchMoveListener;
    }

    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
        int swipeFlags = ItemTouchHelper.LEFT;
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
     *
     * @param recyclerView
     * @param viewHolder
     * @param target
     * @return
     */
    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        //TODO 如何让不同的ViewType之间可以拖拽，就是去掉这个判断。
        if (viewHolder.getItemViewType() != target.getItemViewType()) {
            return false;
        }
        boolean result = sideSlipItemTouchMoveListener.onItemMove(viewHolder.getAdapterPosition(), target.getAdapterPosition());
        return result;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        if (viewHolder instanceof SideSlipRecyclerViewAdapter.SideSlipViewHolder) {
            ViewGroup viewGroup = (ViewGroup) viewHolder.itemView;
            int width = viewGroup.getChildAt(1).getLayoutParams().width;//获取需要被侧滑出来的
            Log.e(TAG,"==>width= "+width+" scrollX="+viewHolder.itemView.getScrollX());
            if (direction==ItemTouchHelper.LEFT){
                sideSlipItemTouchMoveListener.swipeItem(viewHolder.getAdapterPosition());
            }
        }
    }

    @Override
    public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        viewHolder.itemView.setScrollX(0);
        super.clearView(recyclerView, viewHolder);
    }

    @Override
    public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        if (actionState == ItemTouchHelper.ACTION_STATE_SWIPE) {
            if (viewHolder instanceof SideSlipRecyclerViewAdapter.SideSlipViewHolder) {
                Log.e(TAG, "==> computeSwipeDistance=" + computeSwipeDistance(viewHolder)+" dX="+dX);
                if (Math.abs(dX) <= computeSwipeDistance(viewHolder)) {
                    viewHolder.itemView.scrollTo(-(int) dX, 0);
                    Log.e(TAG, "==>onChildDraw computeSwipeDistance=" + computeSwipeDistance(viewHolder));
                }
            } else {
                super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
            }
        } else {
            super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
        }
    }


    /**
     * 计算Item在侧滑时，需要侧滑的宽度 getChildAt(1)是获取item跟布局的第二个Child View，所以在跟布局中被侧滑出的Child View必须放在第二位,且需要设置指定宽度
     *
     * @param viewHolder
     * @return
     */
    public int computeSwipeDistance(RecyclerView.ViewHolder viewHolder) {
        ViewGroup viewGroup = (ViewGroup) viewHolder.itemView;
        int width = viewGroup.getChildAt(1).getLayoutParams().width;
        return width;
    }
}
