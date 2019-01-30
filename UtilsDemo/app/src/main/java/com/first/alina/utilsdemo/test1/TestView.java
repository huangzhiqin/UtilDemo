package com.first.alina.utilsdemo.test1;

/**
 * Created by alina on 2018/11/23.
 */

public class TestView {

    public String content;

    public TestView() {
    }

    public void test1(String str, CallBack callBack){
        StringBuffer buffer=new StringBuffer(str);
        buffer.append("哈哈");
        if (callBack!=null){
            callBack.handle(new Object[]{this.content});
        }
    }
}
