package android.support.v7.widget.helper.mvp.base;

/**
 * Created by alina on 2019/3/18.
 */

public interface BasePresenter {
    void subscribe();
    void unSubscribe();
    void netWorkData();
    void netWorkLoadMoreData();
}
