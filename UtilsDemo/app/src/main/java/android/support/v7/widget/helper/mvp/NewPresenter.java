package android.support.v7.widget.helper.mvp;

import android.support.v7.widget.helper.mvp.base.BasePresenter;
import android.support.v7.widget.helper.mvp.bean.MVP1Bean;
import android.support.v7.widget.helper.mvp.views.NewView;
import android.util.Log;
import android.util.TimeUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by alina on 2019/3/18.
 */

public class NewPresenter implements BasePresenter {
    private String TAG = "NewPresenter";
    private NewView newsView;

    public NewPresenter(NewView newsView) {
        if (newsView == null) {
            Log.e(TAG, "taskDetailView cannot be null!");
        } else {
            this.newsView = newsView;
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
        List<Object> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            MVP1Bean mvpBean = new MVP1Bean();
            mvpBean.name = "MVP " + i + "哈哈";
            list.add(mvpBean);
        }
        newsView.netWorkSuccess(list);
        //rxJavaConcat();
        //rxJavaMap();
        //flatMap();
        //distinct();
        //filter();
        //timer();
        //interval();
        //doOnNext();
        //skip();
        //take();
        just();
    }

    @Override
    public void netWorkLoadMoreData() {

    }

    @SuppressWarnings("unchecked")//去掉泛型检查  合并
    private void rxJavaConcat() {
        Observable.concat(Observable.just(1, 2, 3), Observable.just(4, 5, 6))
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.e(TAG, "=========>" + integer);
                    }
                });
        List<MVP1Bean> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            MVP1Bean mvp = new MVP1Bean();
            mvp.name = "我是第 " + i + " 条数据";
            list.add(mvp);
        }
        Observable.concatArray(Observable.just(list), Observable.just(list), Observable.just(list), Observable.just(list), Observable.just(list))
                .subscribe(new Consumer<List<MVP1Bean>>() {
                    @Override
                    public void accept(List<MVP1Bean> stringObjectMap) throws Exception {
                        for (int i = 0; i < stringObjectMap.size(); i++) {
                            Log.e(TAG, "===>name=" + stringObjectMap.get(i).name);
                        }

                    }
                });
    }

    private void rxJavaMap() {
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
                return "this is result " + integer;
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                Log.e(TAG, "accept=======> " + s);

            }
        });

    }

    //concatMap和FlatMap大致一样，唯一的区别是，concatMap有执行顺序
    private void flatMap() {
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> emitter) throws Exception {
                emitter.onNext("1");
                emitter.onNext("2");
                emitter.onNext("3");

            }
        }).flatMap(new Function<String, ObservableSource<String>>() {
            @Override
            public ObservableSource<String> apply(@NonNull String s) throws Exception {
                List<String> list = new ArrayList<>();
                for (int i = 0; i < 5; i++) {
                    list.add("我是第 " + i + "条数据");
                }
                return Observable.fromIterable(list);
            }
        }).subscribeOn(Schedulers.newThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        Log.e(TAG, "======>accept s=" + s);

                    }
                });
    }

    //去重复
    private void distinct() {
        Observable.just(1, 2, 1, 4, 2)
                .distinct()
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.e(TAG, "======> integer=" + integer);

                    }
                });

    }

    private void filter() {
        Observable.just(1, 20, 30, 22, -80)
                .filter(new Predicate<Integer>() {
                    @Override
                    public boolean test(@NonNull Integer integer) throws Exception {
                        if (integer > 20) {
                            return true;
                        }
                        return false;
                    }
                }).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                Log.e(TAG, "======> integer=" + integer);
            }
        });
    }

    //可以做延迟操作
    private void timer() {
        Log.e(TAG, "========>  start time=" + System.currentTimeMillis());
        Observable.timer(2, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        Log.e(TAG, "=========>  aLong=" + aLong + " " + System.currentTimeMillis());
                    }
                });
    }


    //interval 操作符用于间隔时间执行某个操作，其接受三个参数，分别是第一次发送延迟，间隔时间，时间单位。注意：页面不可见的时候，此方法还是会执行
    //查看源码发现，我们subscribe(Cousumer<? super T> onNext)返回的是Disposable，我们可以在这上面做文章
    private void interval() {
        Disposable disposable = Observable.interval(3, 2, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {

                    }
                });

        //页面不可见的时候,此方法可以在onDestory中调用
        if (!disposable.isDisposed()) {
            disposable.dispose();
        }
    }

    //可以在接受之前保存数据
    private void doOnNext(){
        Observable.just("1","2","3")
                .doOnNext(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        Log.e(TAG,"=======> doOnNext accept="+s);

                    }
                }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                Log.e(TAG,"=======> accept= "+s);
            }
        });
    }

    /**
     * 跳过count个数据进行接收
     */
    private void skip(){
        Observable.just(1,3,6,8,9,10)
                .skip(2)
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.e(TAG,"=======> accept= "+integer);
                    }
                });
    }

    /**
     * 最多接收count个数据
     */
    private void take(){
        Observable.just(1,3,6,8,9,10)
                .take(3)
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.e(TAG,"=======> accept= "+integer);
                    }
                });
    }

    /**
     * 一个简单的发射器，调用onNext()方法
     */
    private void just(){
        Observable.just(1,3,6,8,9,10)
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.e(TAG,"=======> accept= "+integer);
                    }
                });
    }
}
