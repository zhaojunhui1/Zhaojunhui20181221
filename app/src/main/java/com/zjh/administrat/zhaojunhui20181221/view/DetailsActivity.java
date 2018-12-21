package com.zjh.administrat.zhaojunhui20181221.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.zjh.administrat.zhaojunhui20181221.R;
import com.zjh.administrat.zhaojunhui20181221.adapter.GridAdapter;
import com.zjh.administrat.zhaojunhui20181221.adapter.GoodsAdapter;
import com.zjh.administrat.zhaojunhui20181221.bean.DetailBean;
import com.zjh.administrat.zhaojunhui20181221.bean.GoodsBean;
import com.zjh.administrat.zhaojunhui20181221.presenter.IPresenterImpl;
import com.zjh.administrat.zhaojunhui20181221.utils.OkHttps;

import java.util.HashMap;
import java.util.Map;

public class DetailsActivity extends AppCompatActivity implements IView {
    private String path = "http://www.zhaoapi.cn/product/getCatagory";
    private String url = "http://www.zhaoapi.cn/product/getCarts";
    private IPresenterImpl iPresenter;
    private RecyclerView recyclerView_grid, recyclerView_linear;
    private GridAdapter mAdapter;
    private DetailBean detailBean;
    private GoodsAdapter nAdapter;
    private GoodsBean goodsBean;
    private boolean flag = true;
    private int mSpanCount = 5;
    private int spanCount = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        initView();
        initManage();
        initZXing();
    }
    //二维码扫描
    private void initZXing() {
        findViewById(R.id.sao).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DetailsActivity.this, ScanActivity.class));
            }
        });
    }

    //初始化view
    private void initView() {
        iPresenter = new IPresenterImpl(this);
        recyclerView_grid = findViewById(R.id.recycleView_grid);
        recyclerView_linear = findViewById(R.id.recycleView_linear);
         //九宫格
        mAdapter = new GridAdapter(this);
        Map<String, String> map = new HashMap<>();
        iPresenter.pRequestData(path, map, DetailBean.class);
        recyclerView_grid.setAdapter(mAdapter);
        //布局九宫格
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, mSpanCount);
        gridLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        recyclerView_grid.setLayoutManager(gridLayoutManager);

        //判断展示数据
        nAdapter = new GoodsAdapter(this, flag);
        Map<String, String> map1 = new HashMap<>();
        map1.put("uid", "71");
        iPresenter.pRequestData(url, map1, GoodsBean.class);
        recyclerView_linear.setAdapter(nAdapter);
        //下档数据的管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        recyclerView_linear.setLayoutManager(linearLayoutManager);

        //数据的长按事件
        nAdapter.setOnClickListener(new GoodsAdapter.OnClickListener() {
            @Override
            public void OnLongClick(int i, String url) {
                Toast.makeText(DetailsActivity.this, ""+url, Toast.LENGTH_SHORT).show();
            }
        });

    }

    //布局管理器
    private void initManage() {
        findViewById(R.id.change).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag = !flag;
                if (flag){
                    GridLayoutManager gridLayoutManager = new GridLayoutManager(DetailsActivity.this, spanCount);
                    gridLayoutManager.setOrientation(OrientationHelper.VERTICAL);
                    recyclerView_linear.setLayoutManager(gridLayoutManager);
                }else {
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(DetailsActivity.this);
                    linearLayoutManager.setOrientation(OrientationHelper.VERTICAL);
                    recyclerView_linear.setLayoutManager(linearLayoutManager);
                }
            }
        });
    }


    //获取数据
    @Override
    public void viewData(Object object) {
        if (object instanceof DetailBean){
            detailBean = (DetailBean) object;
            mAdapter.setDatas(detailBean.getData());
        }else if(object instanceof GoodsBean){
            goodsBean = (GoodsBean) object;
            nAdapter.setDatas(goodsBean.getData());
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        iPresenter.onDetch();
    }
}
