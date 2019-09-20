package com.first.alina.utilsdemo.reflection;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.first.alina.utilsdemo.R;
import com.first.alina.utilsdemo.main.bean.ReflectionBean;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by alina on 2019/4/28.
 */

public class ReflectionActivity extends Activity {
    private TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refletion);
        textView = findViewById(R.id.tv);
        //方法一:获取对象
/*        Boolean boo = true;
        // textView.setText(boo.getClass().toString());*/
        //方法二：获取对象
        /*Class<?> classType = Boolean.class;
        textView.setText(classType.toString());*/
        //方法三：
        try {
            Class classTypes = Class.forName("com.first.alina.utilsdemo.main.bean.ReflectionBean");
            Object object = classTypes.newInstance();
            Method setMethod = classTypes.getMethod("setStr", String.class);
            setMethod.invoke(object, "哈哈");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    
}
