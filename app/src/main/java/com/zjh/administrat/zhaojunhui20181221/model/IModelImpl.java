package com.zjh.administrat.zhaojunhui20181221.model;

import com.zjh.administrat.zhaojunhui20181221.callback.ICallBack;
import com.zjh.administrat.zhaojunhui20181221.callback.MyCallBack;
import com.zjh.administrat.zhaojunhui20181221.utils.OkHttps;

import java.util.Map;

public class IModelImpl implements IModel {


    @Override
    public void mRequestData(String urlStr, Map<String, String> params, Class clazz, final MyCallBack myCallBack) {
        OkHttps.getInstance().postRequest(urlStr, params, clazz, new ICallBack() {
            @Override
            public void onsuccess(Object object) {
                myCallBack.OnSuccess(object);
            }

            @Override
            public void fails(Exception e) {

            }
        });
    }


}
