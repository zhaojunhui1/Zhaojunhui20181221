package com.zjh.administrat.week1demo.presenter;

import java.util.Map;

public interface IPresenter {
    void pRequestData(String urlStr, Map<String, String> params, Class clazz);
}
