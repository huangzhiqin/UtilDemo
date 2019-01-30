package com.first.alina.utilsdemo.test1;

import android.util.Log;

/**
 * Created by alina on 2018/11/23.
 */

public class MainTest {
    private String TAG="MainTest";

    public void main(){
        TestView testView=new TestView();
        testView.test1("嘻嘻", new CallBack() {
            @Override
            public void handle(Object... object) {
                if (object[0].equals("年四季度和")){
                    Log.e(TAG,"==> 年四季度和");
                }
            }
        });
    }
}
