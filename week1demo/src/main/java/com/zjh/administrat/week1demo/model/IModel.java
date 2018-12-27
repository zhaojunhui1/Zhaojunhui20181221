package com.zjh.administrat.week1demo.model;

import com.zjh.administrat.week1demo.callback.MyCallBack;

import java.util.Map;

public interface IModel {
    void mRequestData(String urlStr, Map<String, String> params, Class clazz, MyCallBack myCallBack);
}
