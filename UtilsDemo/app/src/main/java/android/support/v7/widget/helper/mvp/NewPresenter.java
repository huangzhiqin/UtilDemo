package android.support.v7.widget.helper.mvp;

import android.support.v7.widget.helper.mvp.base.BasePresenter;
import android.support.v7.widget.helper.mvp.views.NewView;
import android.util.Log;

/**
 * Created by alina on 2019/3/18.
 */

public class NewPresenter implements BasePresenter {
    private String TAG="NewPresenter";
    private NewView newsView;

    public NewPresenter() {
        if (newsView==null){
            Log.e(TAG,"taskDetailView cannot be null!");
        }
        newsView.setPresenter(this);
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unSubscribe() {

    }

    @Override
    public void netWorkData() {

    }

    @Override
    public void netWorkLoadMoreData() {

    }
}
