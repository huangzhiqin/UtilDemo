package com.first.alina.utilsdemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.util.Log;
import android.view.ViewTreeObserver;
import android.widget.TextView;

import com.first.alina.utilsdemo.scrollview.Text;
import com.first.alina.utilsdemo.widget.CenterImageSpan;


/**
 * Created by alina on 2018/2/22.
 */

public class TextViewActivity extends Activity {
    private final String TAG = "TextViewActivity";
    private TextView mTv1;
    private TextView mTextView2;
    private String str1 = "黑龙江省积分第四季柏林久很久大南北戴河舒服个IE阿会变诶哦即使是加班后脚就离开局is经办人机加工怕热接驳我人机诶交杯酒噢文件管理第三方目标可能改变和速腾让闺女比基尼结婚不好我如股票热接驳加工棚就胡同活泼健康";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textview);
        mTv1 = findViewById(R.id.tv1);
        mTextView2 = findViewById(R.id.textView2);
        Spannable content = new SpannableStringBuilder("   " + str1);
        CenterImageSpan span = new CenterImageSpan(this, R.drawable.interactive_problem, ImageSpan.ALIGN_BASELINE);
// 用ImageSpan替换文本
        content.setSpan(span, 0, 2, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
        mTv1.setText(content);

        mTextView2.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {

                int count = mTextView2.getLayout().getLineCount();
                float lineWidth0=mTextView2.getLayout().getLineWidth(0);
                float lineWidth1 = mTextView2.getLayout().getLineWidth(1);
                float lineWidth2=mTextView2.getLayout().getLineWidth(2);
                Log.e(TAG, "==> count=" + count+"  lineWidth0="+lineWidth0+"  lineWidth1="+lineWidth1+"  lineWidth2="+lineWidth2);
               mTextView2.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
