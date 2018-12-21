package com.zjh.administrat.zhaojunhui20181221.presenter;

import com.zjh.administrat.zhaojunhui20181221.callback.MyCallBack;
import com.zjh.administrat.zhaojunhui20181221.model.IModelImpl;
import com.zjh.administrat.zhaojunhui20181221.view.IView;

import java.util.Map;

public class IPresenterImpl implements IPresenter {
    private IView iView;
    private IModelImpl iModel;

    public IPresenterImpl(IView iView) {
        this.iView = iView;
        iModel = new IModelImpl();
    }

    @Override
    public void pRequestData(String urlStr, Map<String, String> params, Class clazz) {
        iModel.mRequestData(urlStr, params, clazz, new MyCallBack() {
            @Override
            public void OnSuccess(Object object) {
                iView.viewData(object);
            }
        });
    }

    //内存处理
    public void onDetch(){
        if (iView != null){
            iView = null;
        }
        if (iModel != null){
            iModel = null;
        }
    }

}
