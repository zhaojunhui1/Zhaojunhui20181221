package com.zjh.administrat.zhaojunhui20181221.model;

import com.zjh.administrat.zhaojunhui20181221.callback.MyCallBack;

import java.util.Map;

public interface IModel {
    void mRequestData(String urlStr, Map<String, String> params, Class clazz, MyCallBack myCallBack);
}
