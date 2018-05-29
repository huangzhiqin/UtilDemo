package com.first.alina.utilsdemo.recyclerviews.sideSlips;

/**
 * Created by alina on 2018/5/23.
 * recyclerView侧滑和拖拽功能
 */

public interface SideSlipItemTouchMoveListener {

    /**
     * 当拖拽时回调
     * @param fromPos 从什么位置拖
     * @param toPos 拖到什么位置
     * @return
     */
    boolean onItemMove(int fromPos,int toPos);

    /**
     * 侧滑时回调
     * @param position
     * @return
     */
    boolean onItemRemove(int position);

    /**
     * 侧滑
     * @param position
     * @return
     */
    boolean swipeItem(int position);


}
