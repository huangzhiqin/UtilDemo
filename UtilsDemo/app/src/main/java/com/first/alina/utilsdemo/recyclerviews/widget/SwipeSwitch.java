package com.first.alina.utilsdemo.recyclerviews.widget;

/**
 * Created by alina on 2018/5/25.
 */

public interface SwipeSwitch {
    /**
     * the menu is open?
     * @return
     */
    boolean isMenuOpen();

    boolean isMenuClose();

    /**
     * the menu is open on the left?
     * @return
     */
    boolean isLeftMenuOpen();

    /**
     * the menu is open on the right?
     * @return
     */
    boolean isRightMenuOpen();


    boolean isCompleteOpen();

    boolean isCompleteClose();

    boolean isLeftCompleteOpen();

    boolean isLeftCompleteClose();

    boolean isRightCompleteOpen();

    boolean isRightCompleteClose();

    void smoothRightOpenMenu();

    void smoothRightCloseMenu();

    void smoothLeftOpenMenu();

    void smoothLeftCloseMenu();

    /**
     * 滑动时间
     * @param duration
     */
    void smoothRigthOpenMenu(int duration);

    void smoothRightCloseMenu(int duration);


    /**
     * 滑动的时间
     * @param duration
     */
    void smoothLeftOpenMenu(int duration);

    void smoothLeftCloseMenu(int duration);


    void smoothOpenMenu();

    void smoothCloseMenu();

    void smoothCloseMenu(int duration);


}
