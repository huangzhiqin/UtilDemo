package com.first.alina.utilsdemo.utils;

/**
 * Created by alina on 2019/4/16.
 * 据说是最好的单例模式，即保证的线程安全，也避免了同步带来的性能影响
 *
 */

public class SingleInstance2 {

    private SingleInstance2() {
    }

    public static class SingleHolder{
        private static final SingleInstance2 instance2=new SingleInstance2();
    }

    public static SingleInstance2 getInstance(){
        return SingleHolder.instance2;
    }
}
