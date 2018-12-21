package com.zjh.administrat.zhaojunhui20181221.view;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.zjh.administrat.zhaojunhui20181221.R;
import com.zjh.administrat.zhaojunhui20181221.adapter.BannerAdapter;
import com.zjh.administrat.zhaojunhui20181221.bean.BannerBean;
import com.zjh.administrat.zhaojunhui20181221.presenter.IPresenterImpl;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements IView{

    private String urlStr = "http://www.zhaoapi.cn/ad/getAd";
    private IPresenterImpl iPresenter;
    private ViewPager viewPager;
    private BannerAdapter mAdapter;
    private Button button;
    private BannerBean bannerBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
     //初始化View
    private void initView() {
        iPresenter = new IPresenterImpl(this);
        viewPager = findViewById(R.id.viewPager);
        button = findViewById(R.id.button);
        mAdapter = new BannerAdapter(this);
        viewPager.setAdapter(mAdapter);

        Map<String, String> map = new HashMap<>();
        iPresenter.pRequestData(urlStr, map, BannerBean.class);

    }

    //请求回来数据
    @Override
    public void viewData(Object object) {
        bannerBean = (BannerBean) object;
        mAdapter.setDatas(bannerBean.getData());

        //最后一页显示跳转
         viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
             @Override
             public void onPageScrolled(int i, float v, int i1) {

             }

             @Override
             public void onPageSelected(int i) {
                 //最后一页显示跳转
                 if (bannerBean.getData().size()-1 == i){
                     button.setVisibility(View.VISIBLE);
                 }else {
                     button.setVisibility(View.GONE);
                 }
             }

             @Override
             public void onPageScrollStateChanged(int i) {

             }
         });


        //跳转购物
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, DetailsActivity.class));
            }
        });

    }

    //内存处理
    @Override
    protected void onDestroy() {
        super.onDestroy();
        iPresenter.onDetch();
    }
}
