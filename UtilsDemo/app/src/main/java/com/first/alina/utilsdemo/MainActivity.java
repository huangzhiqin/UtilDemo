package com.first.alina.utilsdemo;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;

import com.first.alina.utilsdemo.common.recyclerviews.ViewHolder;
import com.first.alina.utilsdemo.main.bean.CustomViewBean;
import com.first.alina.utilsdemo.main.bean.DialogBean;
import com.first.alina.utilsdemo.main.bean.FloatMainBean;
import com.first.alina.utilsdemo.main.bean.FloatScrollViewBean;
import com.first.alina.utilsdemo.main.bean.ImageBean;
import com.first.alina.utilsdemo.main.bean.MVPBean;
import com.first.alina.utilsdemo.main.bean.MultipleBean;
import com.first.alina.utilsdemo.main.bean.PicAndTextBean;
import com.first.alina.utilsdemo.main.bean.ReflectionBean;
import com.first.alina.utilsdemo.main.bean.ScaleImageBean;
import com.first.alina.utilsdemo.main.bean.SideSlipBean;
import com.first.alina.utilsdemo.main.bean.SoftKeyBean;
import com.first.alina.utilsdemo.main.viewholders.CustomViewHolder;
import com.first.alina.utilsdemo.main.viewholders.DialogViewHolder;
import com.first.alina.utilsdemo.main.viewholders.FloatMainViewHolder;
import com.first.alina.utilsdemo.main.viewholders.FloatScrollViewHolder;
import com.first.alina.utilsdemo.main.viewholders.ImageViewHolder;
import com.first.alina.utilsdemo.main.viewholders.MVPViewHolder;
import com.first.alina.utilsdemo.main.viewholders.MultipleViewHolder;
import com.first.alina.utilsdemo.main.viewholders.PicAndTextViewHolder;
import com.first.alina.utilsdemo.main.viewholders.ReflectionViewHolder;
import com.first.alina.utilsdemo.main.viewholders.ScaleImageViewHolder;
import com.first.alina.utilsdemo.main.viewholders.SideSlipViewHolder;
import com.first.alina.utilsdemo.main.viewholders.SoftKeyViewHolder;
import com.first.alina.utilsdemo.scrollview.adapters.Adapter1;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "MainActivity";
    private List<Object> list = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        Adapter1<Object> adapter1 = new Adapter1<Object>(this) {
            @Override
            public Class<? extends ViewHolder> getHolderClass(Object object, int position) {
               if (object instanceof PicAndTextBean) {
                    return PicAndTextViewHolder.class;
                } else if (object instanceof MultipleBean) {
                    return MultipleViewHolder.class;
                } else if (object instanceof MVPBean) {
                    return MVPViewHolder.class;
                } else if (object instanceof ScaleImageBean) {
                    return ScaleImageViewHolder.class;
                } else if (object instanceof FloatScrollViewBean) {
                    return FloatScrollViewHolder.class;
                } else if (object instanceof ImageBean) {
                    return ImageViewHolder.class;
                }  else if (object instanceof SoftKeyBean) {
                    return SoftKeyViewHolder.class;
                } else if (object instanceof SideSlipBean) {
                    return SideSlipViewHolder.class;
                } else if (object instanceof ReflectionBean){
                  return ReflectionViewHolder.class;
              }else if (object instanceof DialogBean) {
                    return DialogViewHolder.class;
                }else if (object instanceof FloatMainBean){
                   return FloatMainViewHolder.class;
               }else if (object instanceof CustomViewBean){
                   return CustomViewHolder.class;
               }
                    return null;
            }
        };
        list.add(new DialogBean());
        list.add(new PicAndTextBean());
        list.add(new SoftKeyBean());
        list.add(new MultipleBean());
        list.add(new MVPBean());
        list.add(new ScaleImageBean());
        list.add(new FloatScrollViewBean());
        list.add(new ImageBean());
        list.add(new SideSlipBean());
        list.add(new ReflectionBean());
        list.add(new FloatMainBean());
        list.add(new CustomViewBean());

        adapter1.addData(list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter1);
        //WindowsManager.getInstance().showFloatView(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "==> onResume");
       // Toast.makeText(this, Thread.currentThread().getName(), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "==> onStart");
       /* IntentFilter intentFilter=new IntentFilter();
        MyBroadcastReceiver myBroadcast=new MyBroadcastReceiver();
        registerReceiver(myBroadcast,intentFilter);*/

    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode==KeyEvent.KEYCODE_BACK){
            try {
                this.finish();
                ActivityManager manager = (ActivityManager) this
                        .getSystemService(Context.ACTIVITY_SERVICE);
                if (manager != null) {
                    manager.killBackgroundProcesses(this.getPackageName());
                }
                System.exit(0);
            } catch (Exception e) {
                e.printStackTrace();
            }

            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}

