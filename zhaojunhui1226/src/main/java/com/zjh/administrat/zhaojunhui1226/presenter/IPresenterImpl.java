package com.zjh.administrat.zhaojunhui1226.presenter;

import android.app.admin.DeviceAdminInfo;

import com.zjh.administrat.zhaojunhui1226.callback.MyCallBack;
import com.zjh.administrat.zhaojunhui1226.model.IModel;
import com.zjh.administrat.zhaojunhui1226.model.IModelImpl;
import com.zjh.administrat.zhaojunhui1226.view.IView;

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
            public void OnSuccess(Object data) {
                iView.viewDatas(data);
            }
        });
    }

    public void onDetch(){
        if (iView != null){
            iView = null;
        }
        if (iModel != null){
            iModel = null;
        }
    }
}
