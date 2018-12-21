package com.zjh.administrat.zhaojunhui20181221.presenter;

import java.util.Map;

public interface IPresenter {
    void pRequestData(String urlStr, Map<String, String> params, Class clazz);
}
