package android.support.v7.widget.helper.mvp.test;

import android.app.Activity;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.mvp.NewPresenter;
import android.support.v7.widget.helper.mvp.base.BasePresenter;
import android.support.v7.widget.helper.mvp.bean.MVP1Bean;
import android.support.v7.widget.helper.mvp.viewholder.MVP1ViewHolder;
import android.support.v7.widget.helper.mvp.views.NewView;
import android.util.Log;
import android.widget.Toast;

import com.first.alina.utilsdemo.R;
import com.first.alina.utilsdemo.common.recyclerviews.ViewHolder;
import com.first.alina.utilsdemo.scrollview.adapters.Adapter1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alina on 2019/3/26.
 */

public class MVPActivity extends Activity implements NewView{
    private final String TAG="NewPresenter";
    private List<Object> objectList;
    private Adapter1<Object> adapter1;
    private NewPresenter newPresenter;
    private Handler childHandler;
    private MyThread myThread;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp);
        RecyclerView recyclerView=findViewById(R.id.recyclerView);
        objectList=new ArrayList<>();
        new NewPresenter(this);
        adapter1=new Adapter1<Object>(this) {
            @Override
            public Class<? extends ViewHolder> getHolderClass(Object object, int position) {
                if (object instanceof MVP1Bean){
                    return MVP1ViewHolder.class;
                }
                return MVP1ViewHolder.class;
            }
        };
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter1);
        newPresenter.netWorkData();
        String [] names={"1","2","3"};
        myThread = new MyThread();
        myThread.start();



    }

    class MyThread extends Thread{
        Looper childLooper;
        @Override
        public void run() {
            super.run();
            Looper.prepare();//创建与当前线程相关的Looper
            childLooper=Looper.myLooper();//获取Looper对象
            Looper.loop();////调用此方法，消息才会循环处理
            Log.e(TAG,"====> run");


        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        newPresenter.subscribe();
        childHandler = new Handler(myThread.childLooper){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                Log.e(TAG,"=========> "+Thread.currentThread().getName());
                myThread.childLooper.quit();
            }
        };
        childHandler.sendEmptyMessage(1);
    }

    @Override
    protected void onPause() {
        super.onPause();
        newPresenter.unSubscribe();
    }

    @Override
    public void setPresenter(BasePresenter presenter) {
        newPresenter= (NewPresenter) presenter;
    }

    @Override
    public void netWorkSuccess(List<Object> list) {
        objectList=list;
        adapter1.addData(objectList);
        Log.e(TAG,"====>"+list.size());
       new Handler().postDelayed(new Runnable() {
           @Override
           public void run() {
               Toast.makeText(MVPActivity.this,"添加数组",Toast.LENGTH_SHORT).show();
           }
       },3000);
    }



    @Override
    public void netWorkError(Object object) {
        Log.e(TAG,"====>"+object.toString());
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        Log.e(TAG,"==========> finalize");
    }
}
