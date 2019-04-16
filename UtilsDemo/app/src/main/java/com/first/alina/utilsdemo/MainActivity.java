package com.first.alina.utilsdemo;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.Toast;

import com.first.alina.utilsdemo.common.recyclerviews.ViewHolder;
import com.first.alina.utilsdemo.main.bean.BannerBean;
import com.first.alina.utilsdemo.main.bean.BottomDialogBean;
import com.first.alina.utilsdemo.main.bean.BrokenBean;
import com.first.alina.utilsdemo.main.bean.CanvasBean;
import com.first.alina.utilsdemo.main.bean.CustomFloatBean;
import com.first.alina.utilsdemo.main.bean.Dialog2Bean;
import com.first.alina.utilsdemo.main.bean.FloatScrollViewBean;
import com.first.alina.utilsdemo.main.bean.FloatViewBean;
import com.first.alina.utilsdemo.main.bean.ImageBean;
import com.first.alina.utilsdemo.main.bean.MVPBean;
import com.first.alina.utilsdemo.main.bean.MoveCommentBean;
import com.first.alina.utilsdemo.main.bean.MultipleBean;
import com.first.alina.utilsdemo.main.bean.NoPaddingBean;
import com.first.alina.utilsdemo.main.bean.PicAndTextBean;
import com.first.alina.utilsdemo.main.bean.RatingBarBean;
import com.first.alina.utilsdemo.main.bean.ScaleImageBean;
import com.first.alina.utilsdemo.main.bean.ScrollUpDownBean;
import com.first.alina.utilsdemo.main.bean.SideSlipBean;
import com.first.alina.utilsdemo.main.bean.SoftKeyBean;
import com.first.alina.utilsdemo.main.bean.View1Bean;
import com.first.alina.utilsdemo.main.viewholders.BannerViewHolder;
import com.first.alina.utilsdemo.main.viewholders.BottomDialogViewHolder;
import com.first.alina.utilsdemo.main.viewholders.BrokenViewHolder;
import com.first.alina.utilsdemo.main.viewholders.CanvasViewHolder;
import com.first.alina.utilsdemo.main.viewholders.CustomFloatViewHolder;
import com.first.alina.utilsdemo.main.viewholders.Dialog2ViewHolder;
import com.first.alina.utilsdemo.main.viewholders.DialogViewHolder;
import com.first.alina.utilsdemo.main.bean.DialogBean;
import com.first.alina.utilsdemo.main.viewholders.FloatScrollViewHolder;
import com.first.alina.utilsdemo.main.viewholders.FloatViewHolder;
import com.first.alina.utilsdemo.main.viewholders.ImageViewHolder;
import com.first.alina.utilsdemo.main.viewholders.MVPViewHolder;
import com.first.alina.utilsdemo.main.viewholders.MoveCommentViewHolder;
import com.first.alina.utilsdemo.main.viewholders.MultipleViewHolder;
import com.first.alina.utilsdemo.main.viewholders.NoPaddingTextViewViewHolder;
import com.first.alina.utilsdemo.main.viewholders.PicAndTextViewHolder;
import com.first.alina.utilsdemo.main.viewholders.RatingBarViewHolder;
import com.first.alina.utilsdemo.main.viewholders.ScaleImageViewHolder;
import com.first.alina.utilsdemo.main.viewholders.ScrollUpDownViewHolder;
import com.first.alina.utilsdemo.main.viewholders.SideSlipViewHolder;
import com.first.alina.utilsdemo.main.viewholders.SoftKeyViewHolder;
import com.first.alina.utilsdemo.main.viewholders.View1ViewHolder;
import com.first.alina.utilsdemo.scrollview.adapters.Adapter1;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "MainActivity";
    private RecyclerView recyclerView;
    private List<Object> list = new ArrayList<>();
    private Adapter1<Object> adapter1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        adapter1 = new Adapter1<Object>(this) {
            @Override
            public Class<? extends ViewHolder> getHolderClass(Object object, int position) {
              if (object instanceof DialogBean) {
                    return DialogViewHolder.class;
                } else if (object instanceof Dialog2Bean) {
                    return Dialog2ViewHolder.class;
                } else if (object instanceof PicAndTextBean) {
                    return PicAndTextViewHolder.class;
                } else if (object instanceof FloatViewBean) {
                    return FloatViewHolder.class;
                } else if (object instanceof CanvasBean) {
                    return CanvasViewHolder.class;
                } else if (object instanceof BannerBean) {
                    return BannerViewHolder.class;
                } else if (object instanceof View1Bean) {
                    return View1ViewHolder.class;
                } else if (object instanceof MultipleBean) {
                    return MultipleViewHolder.class;
                } else if (object instanceof BrokenBean) {
                    return BrokenViewHolder.class;
                } else if (object instanceof MVPBean) {
                    return MVPViewHolder.class;
                } else if (object instanceof ScaleImageBean) {
                    return ScaleImageViewHolder.class;
                } else if (object instanceof FloatScrollViewBean) {
                    return FloatScrollViewHolder.class;
                } else if (object instanceof ImageBean) {
                    return ImageViewHolder.class;
                } else if (object instanceof ScrollUpDownBean) {
                    return ScrollUpDownViewHolder.class;
                } else if (object instanceof MoveCommentBean) {
                    return MoveCommentViewHolder.class;
                } else if (object instanceof RatingBarBean) {
                    return RatingBarViewHolder.class;
                } else if (object instanceof SoftKeyBean) {
                    return SoftKeyViewHolder.class;
                } else if (object instanceof SideSlipBean) {
                    return SideSlipViewHolder.class;
                } else if (object instanceof CustomFloatBean) {
                    return CustomFloatViewHolder.class;
                } else if (object instanceof BottomDialogBean) {
                    return BottomDialogViewHolder.class;
                }else if (object instanceof NoPaddingBean){
                  return NoPaddingTextViewViewHolder.class;
              }
                return null;
            }
        };
        list.add(new DialogBean());
        list.add(new Dialog2Bean());
        list.add(new PicAndTextBean());
        list.add(new FloatViewBean());
        list.add(new CanvasBean());
        list.add(new BannerBean());
        list.add(new View1Bean());
        list.add(new MultipleBean());
        list.add(new BrokenBean());
        list.add(new MVPBean());
        list.add(new ScaleImageBean());
        list.add(new FloatScrollViewBean());
        list.add(new ImageBean());
        list.add(new ScrollUpDownBean());
        list.add(new MoveCommentBean());
        list.add(new RatingBarBean());
        list.add(new SoftKeyBean());
        list.add(new SideSlipBean());
        list.add(new CustomFloatBean());
        list.add(new NoPaddingBean());
        list.add(new BottomDialogBean());

        adapter1.addData(list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter1);

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "==> onResume");
        Toast.makeText(this, Thread.currentThread().getName(), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "==> onStart");

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

