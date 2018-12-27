package com.zjh.administrat.fanse_demo02;

import android.app.Activity;
import android.view.View;

import java.lang.reflect.Field;

public class InJectViewParser {
    public static void bind(Object object){
        try {
            parser(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void parser(Object object) throws Exception {
        Class<?> clazz = object.getClass();
        View view = null;
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields){
            if (field.isAnnotationPresent(InJectView.class)){
                InJectView inJectView = field.getAnnotation(InJectView.class);
                int value = inJectView.value();
                if (value < 0){
                    throw new Exception("error");
                }else {
                    field.setAccessible(true);
                    if (object instanceof View){
                        view = ((View) object).findViewById(value);
                    }else if(object instanceof Activity){
                        view = ((Activity) object).findViewById(value);
                    }
                    field.set(object, view);
                }
            }
        }


    }


}
