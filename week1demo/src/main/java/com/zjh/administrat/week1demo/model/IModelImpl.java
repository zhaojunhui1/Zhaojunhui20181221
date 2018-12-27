package com.zjh.administrat.week1demo.model;

import com.zjh.administrat.week1demo.callback.ICallBack;
import com.zjh.administrat.week1demo.callback.MyCallBack;
import com.zjh.administrat.week1demo.utils.OkHttps;

import java.util.Map;

public class IModelImpl implements IModel {
    @Override
    public void mRequestData(String urlStr, Map<String, String> params, Class clazz, final MyCallBack myCallBack) {
        OkHttps.getInstance().postRequest(urlStr, params, clazz, new ICallBack() {
            @Override
            public void success(Object object) {
                myCallBack.OnSuccess(object);
            }

            @Override
            public void fails(Exception e) {

            }
        });
    }
}
