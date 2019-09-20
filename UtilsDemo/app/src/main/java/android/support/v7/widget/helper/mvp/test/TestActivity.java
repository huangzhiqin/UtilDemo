package android.support.v7.widget.helper.mvp.test;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.helper.fragments.TestFragment1;
import android.support.v7.widget.helper.fragments.TestFragment2;
import android.view.View;
import android.widget.TextView;

import com.first.alina.utilsdemo.R;

/**
 * Created by alina on 2019/3/26.
 */

public class TestActivity extends FragmentActivity{
    private int type=1;
    private TextView tv;
    public static TestData testData;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2);
        tv=findViewById(R.id.tv);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (testData!=null){
                    type++;
                    testData.setData(type+"");
                }

            }
        });
    }

    public static void setTestData(TestData testData){
        TestActivity.testData=testData;
    }

    public  interface TestData{
        void setData(String type);
    }
}
