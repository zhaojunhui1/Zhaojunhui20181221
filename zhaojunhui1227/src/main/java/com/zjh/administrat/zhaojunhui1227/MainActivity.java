package com.zjh.administrat.zhaojunhui1227;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Person person = new Person();
        try {
            Class<?> clazz = Class.forName("com.zjh.administrat.zhaojunhui1227.Person");
            Method[] methods = clazz.getDeclaredMethods();
            for(Method method : methods){
                System.out.println("Person类中所有的方法["+method+"]");
            }
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields){
                System.out.println("Person类中所有的成员变量["+field+"]");
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
