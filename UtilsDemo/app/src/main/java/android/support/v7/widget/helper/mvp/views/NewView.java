package android.support.v7.widget.helper.mvp.views;

import android.support.v7.widget.helper.mvp.base.BasePresenter;
import android.support.v7.widget.helper.mvp.base.BaseView;

/**
 * Created by alina on 2019/3/22.
 */

public interface NewView extends BaseView<BasePresenter> {

    void netWorkSuccess();

    void netWorkError(Object object);
}
