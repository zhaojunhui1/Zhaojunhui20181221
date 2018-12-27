package com.zjh.administrat.zhaojunhui1226.model;

import com.zjh.administrat.zhaojunhui1226.callback.MyCallBack;

import java.util.Map;

public interface IModel {
    void mRequestData(String urlStr, Map<String, String> params, Class clazz, MyCallBack myCallBack);
}
