package com.first.alina.utilsdemo.okhttpUtils;

/**
 * Created by alina on 2018/12/19.
 */

public abstract class ErrorResult implements IResult{
    private boolean isShowToast;

    public void setShowToast(boolean isShowToast){
        this.isShowToast=isShowToast;
    }
}
