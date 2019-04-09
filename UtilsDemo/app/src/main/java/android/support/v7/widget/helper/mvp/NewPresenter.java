package android.support.v7.widget.helper.mvp;

import android.os.Message;
import android.support.v7.widget.helper.mvp.base.BasePresenter;
import android.support.v7.widget.helper.mvp.bean.MVP1Bean;
import android.support.v7.widget.helper.mvp.views.NewView;
import android.util.Log;
import android.widget.TextView;

import com.jakewharton.rxbinding2.widget.RxTextView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
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
    private Disposable disposable;

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
        unsubscrible();
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
        //just();
        //single();
        //debounce();
        //last();
        //merge();
        //reduce();
        //scan();
        //cache();
        //mergeObservable();
        //mergeTest();
        //rxJavaConcat();
        //rxJavaMerge();
        //mergeInterval();
        zip();
    }

    @Override
    public void netWorkLoadMoreData() {

    }

    @SuppressWarnings("unchecked")//去掉泛型检查  合并拼接，有多少数据，就会返回多少
    private void rxJavaConcat() {
        Observable.concat(Observable.just(1, 2, 3), Observable.just(4, 5, 6, 7))
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.e(TAG, "=========>" + integer);
                    }
                });


    }

    private void rxJavaMerge() {
        Observable.merge(Observable.just(1, 2, 3), Observable.just(4, 5, 6, 7))
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.e(TAG, "=========>" + integer);
                    }
                });
    }

    private void rxJavaConcatArray() {
        Observable<List<MVP1Bean>> observable = Observable.create(new ObservableOnSubscribe<List<MVP1Bean>>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<List<MVP1Bean>> emitter) throws Exception {
                List<MVP1Bean> list = new ArrayList<>();
                for (int i = 0; i < 10; i++) {
                    MVP1Bean mvp = new MVP1Bean();
                    mvp.name = "我是第 " + i + " 条数据";
                    list.add(mvp);

                }
                emitter.onNext(list);
                emitter.onComplete();
            }
        });

        Observable<List<MVP1Bean>> observable2 = Observable.create(new ObservableOnSubscribe<List<MVP1Bean>>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<List<MVP1Bean>> emitter) throws Exception {
                List<MVP1Bean> list = new ArrayList<>();
                for (int i = 30; i < 40; i++) {
                    MVP1Bean mvp = new MVP1Bean();
                    mvp.name = "我是第 " + i + " 条数据";
                    list.add(mvp);
                }
                emitter.onNext(list);
                emitter.onComplete();
            }
        });
        Observable.concat(observable, observable2)
                .subscribe(new Consumer<List<MVP1Bean>>() {
                    @Override
                    public void accept(List<MVP1Bean> stringObjectMap) throws Exception {
                        for (int i = 0; i < stringObjectMap.size(); i++) {
                            Log.e(TAG, "===>name=" + stringObjectMap.get(i).name);
                        }

                    }
                });
    }

    private void zip() {
        Observable.zip(Observable.just(2,4), Observable.just(3,9,15,18), new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(@NonNull Integer s, @NonNull Integer integer) throws Exception {
                Log.e(TAG, "zip : accept : " + s +"  integer="+integer+" "+ Thread.currentThread().getName());
                return s + integer;
            }
        }).observeOn(AndroidSchedulers.mainThread()).observeOn(Schedulers.io()).subscribeOn(Schedulers.io())
                .subscribe(new Consumer<Integer>() {
            @Override
            public void accept(@NonNull Integer s) throws Exception {
                Log.e(TAG, "zip : accept : " + s +" "+ Thread.currentThread().getName());
            }
        });

    }

    /**
     * Map 基本算是 RxJava 中一个最简单的操作符了，熟悉 RxJava 1.x 的知道，它的作用是对发射时间发送的每一个事件应用一个函数，是的每一个事件都按照指定的函数去变化
     */
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

    /**
     * FlatMap 是一个很有趣的东西，我坚信你在实际开发中会经常用到。它可以把一个发射器 Observable 通过某种方法转换为多个 Observables，然后再把这些分散的 Observables装进一个单一的发射器 Observable。但有个需要注意的是，flatMap 并不能保证事件的顺序，如果需要保证，需要用到我们下面要讲的 ConcatMap
     * concatMap和FlatMap大致一样，唯一的区别是，concatMap有执行顺序
     */
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

    /**
     * 去重复
     */
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

    /**
     * 根据条件过滤数据
     */
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

    /**
     * 可以做延迟操作
     */
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


    /**
     * interval 操作符用于间隔时间执行某个操作，其接受三个参数，分别是第一次发送延迟，间隔时间，时间单位。注意：页面不可见的时候，此方法还是会执行
     * 查看源码发现，我们subscribe(Cousumer<? super T> onNext)返回的是Disposable，我们可以在这上面做文章
     * 存在内存泄漏的风险，注意dispose
     */
    private void interval() {
        disposable = Observable.interval(3, 2, TimeUnit.SECONDS)
                //.takeUntil(20)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        Log.e(TAG, "=========>interval 轮训操作 aLong=" + aLong);

                    }
                });

        //页面不可见的时候,此方法可以在onDestory中调用
       /* if (!disposable.isDisposed()) {
            disposable.dispose();
        }*/
    }

    //页面不可见的时候,此方法可以在onDestory中调用
    private void unsubscrible() {
        if (disposable != null) {
            if (!disposable.isDisposed()) {
                disposable.dispose();
            }
        }

    }

    /**
     * 可以在接受之前保存数据
     */
    private void doOnNext() {
        Observable.just("1", "2", "3")
                .doOnNext(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        Log.e(TAG, "=======> doOnNext accept=" + s);

                    }
                }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                Log.e(TAG, "=======> accept= " + s);
            }
        });
    }

    /**
     * 跳过count个数据进行接收
     */
    private void skip() {
        Observable.just(1, 3, 6, 8, 9, 10)
                .skip(2)
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.e(TAG, "=======> accept= " + integer);
                    }
                });
    }

    /**
     * 最多接收count个数据
     */
    private void take() {
        Observable.just(1, 3, 6, 8, 9, 10)
                .take(3)
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.e(TAG, "=======> accept= " + integer);
                    }
                });
    }

    /**
     * 一个简单的发射器，调用onNext()方法
     */
    private void just() {
        Observable.just(1, 3, 6, 8, 9, 10)
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.e(TAG, "=======> accept= " + integer);
                    }
                });
    }

    private void single() {
        Single.just(3)
                .subscribe(new SingleObserver<Integer>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onSuccess(@NonNull Integer integer) {
                        Log.e(TAG, "=======> onSuccess= " + integer);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.e(TAG, "=======> onError= " + e.toString());
                    }
                });
    }

    /**
     * 过去掉时间间隔小于预期的
     * 输出结果：E/NewPresenter: =======> accept= 3
     */
    private void debounce() {
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> emitter) throws Exception {
                emitter.onNext("1");
                Thread.sleep(400);
                emitter.onNext("2");
                Thread.sleep(503);
                emitter.onNext("3");
                Thread.sleep(100);
                emitter.onComplete();

            }
        }).debounce(500, TimeUnit.SECONDS)
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        Log.e(TAG, "=======> accept= " + s);
                    }
                });

    }

    /**
     * 获取最后一条数据
     */
    private void last() {
        Observable.just(1, 2, 3)
                .last(2)
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.e(TAG, "=======> accept= " + integer);
                    }
                });
    }


    /**
     * 每次使用一个方法处理一个值,相当于求和、值拼接
     */
    private void reduce() {
        Observable.just(1, 2, 5)
                .reduce(new BiFunction<Integer, Integer, Integer>() {
                    @Override
                    public Integer apply(@NonNull Integer integer, @NonNull Integer integer2) throws Exception {
                        Log.e(TAG, "====> integer=" + integer + "   integer2=" + integer2);
                        return integer + integer2;
                    }
                }).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                Log.e(TAG, "====> accept=" + integer);
            }
        });
    }

    /**
     * 和reduce一样，只不过scan会把每步结果都输出，即每次计算都会执行accept方法
     */
    private void scan() {
        Observable.just(1, 2, 3, 7)
                .scan(new BiFunction<Integer, Integer, Integer>() {
                    @Override
                    public Integer apply(@NonNull Integer integer, @NonNull Integer integer2) throws Exception {
                        return integer + integer2;
                    }
                })
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.e(TAG, "====> accept=" + integer);
                    }
                });
    }

    String cacheResult = "我是缓存数据";
    String netWorkResult = "我是网络数据";
    String result = "最终数据结果:";

    /**
     * 缓存
     */
    private void cache() {
        final Observable<String> cacheObservable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> emitter) throws Exception {
                Log.e(TAG, "====> 缓存数据 subscribe");
                if (cacheResult != null) {
                    emitter.onNext(cacheResult);
                }
                emitter.onComplete();
            }
        });
        Observable<String> netWork = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> emitter) throws Exception {
                Log.e(TAG, "====> 网络数据 subscribe");
                if (netWorkResult != null) {
                    emitter.onNext(netWorkResult);
                }
                emitter.onComplete();
            }
        });
        Observable.concat(cacheObservable, netWork)
                //.firstElement()
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String o) throws Exception {
                        Log.e(TAG, "====> accept=" + o);
                    }
                });
    }

    /**
     * 合并 感觉和concat类似，组合多个被观察者，合并后按照时间线并行执行
     */
    private void merge() {
        Observable.merge(Observable.just(1, 2), Observable.just(2, 3, 4))
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.e(TAG, "=======> accept= " + integer);
                    }
                });
    }

    private void mergeInterval() {
       /* Observable.concat(Observable.intervalRange(0, 6, 1, 1, TimeUnit.SECONDS), Observable.intervalRange(8, 5, 2, 3, TimeUnit.SECONDS))
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(Object o) throws Exception {
                        Log.e(TAG, "====> concat accept=" + o);
                    }
                });*/
        Observable.merge(Observable.intervalRange(0, 6, 1, 1, TimeUnit.SECONDS), Observable.intervalRange(8, 5, 2, 1, TimeUnit.SECONDS))
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(Object o) throws Exception {
                        Log.e(TAG, "====>merge accept=" + o);
                    }
                });
    }


    private void mergeObservable() {
        Observable<String> cacheObservable2 = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> emitter) throws Exception {
                Log.e(TAG, "====> 缓存数据 subscribe");
                if (cacheResult != null) {
                    emitter.onNext(cacheResult);
                }
                emitter.onComplete();
            }
        });
        Observable<String> netWorkObservable2 = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> emitter) throws Exception {
                Log.e(TAG, "====> 网络数据 subscribe");
                if (netWorkResult != null) {
                    emitter.onNext(netWorkResult);
                }
                emitter.onComplete();
            }
        });

        Observable.merge(cacheObservable2, netWorkObservable2)
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull String s) {
                        result += s + "+";
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        Log.e(TAG, "============>" + result);
                    }
                });
    }

    private void setTestView(TextView textView) {
        this.textView = textView;
    }

    private TextView textView;

    private void handleTest(){
        Message message=Message.obtain();
        Message message11=new Message();
    }


}
