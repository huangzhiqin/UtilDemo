package android.support.v7.widget.helper.mvp;

import android.support.v7.widget.helper.mvp.base.BasePresenter;
import android.support.v7.widget.helper.mvp.bean.MVP1Bean;
import android.support.v7.widget.helper.mvp.views.NewView;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/**
 * Created by alina on 2019/3/18.
 */

public class NewPresenter implements BasePresenter {
    private String TAG="NewPresenter";
    private NewView newsView;

    public NewPresenter(NewView newsView) {
        if (newsView==null){
            Log.e(TAG,"taskDetailView cannot be null!");
        }else {
            this.newsView=newsView;
            newsView.setPresenter(this);
        }
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unSubscribe() {

    }

    @Override
    public void netWorkData() {
        List<Object> list=new ArrayList<>();
        for (int i=0;i<10000;i++){
            MVP1Bean mvpBean=new MVP1Bean();
            mvpBean.name="MVP "+i+"哈哈";
            list.add(mvpBean);
        }
        newsView.netWorkSuccess(list);
        rxJavaConcat();
        //rxJavaMap();
    }

    @Override
    public void netWorkLoadMoreData() {

    }

    @SuppressWarnings("unchecked")//去掉泛型检查
    private void rxJavaConcat(){
        Observable.concat(Observable.just(1,2,3),Observable.just(4,5,6))
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.e(TAG,"=========>"+integer);
                    }
                });
        List<MVP1Bean> list=new ArrayList<>();
        for (int i=0;i<10;i++){
            MVP1Bean mvp=new MVP1Bean();
            mvp.name="我是第 "+i+" 条数据";
            list.add(mvp);
        }
        Observable.concatArray(Observable.just(list),Observable.just(list),Observable.just(list),Observable.just(list),Observable.just(list))
        .subscribe(new Consumer<List< MVP1Bean>>() {
            @Override
            public void accept(List<MVP1Bean> stringObjectMap) throws Exception {
                for (int i=0;i<stringObjectMap.size();i++){
                    Log.e(TAG,"===>name="+stringObjectMap.get(i).name);
                }

            }
        });
    }

    private void rxJavaMap(){
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);

            }
        }).map(new Function<Integer, String>() {//对数据类型进行转换Integer转成String
            @Override
            public String apply(@NonNull Integer integer) throws Exception {
                return "this is result "+integer;
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                Log.e(TAG,"accept=======> "+s);

            }
        });

    }
}
