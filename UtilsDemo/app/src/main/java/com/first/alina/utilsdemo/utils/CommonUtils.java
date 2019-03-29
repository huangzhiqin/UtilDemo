package com.first.alina.utilsdemo.utils;

/**
 * Created by alina on 2019/3/29.
 */

public class CommonUtils {

    public static boolean isEmpty(Object object) {
        if (object == null) {
            throw new NullPointerException("object isEmpty");
        }
        return false;
    }
}
