package com.zjh.administrat.week1demo.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoaderInterface;
import com.zjh.administrat.week1demo.R;
import com.zjh.administrat.week1demo.adapter.HomeAdapter;
import com.zjh.administrat.week1demo.bean.HomeBean;
import com.zjh.administrat.week1demo.presenter.IPresenterImpl;
import com.zjh.administrat.week1demo.view.IView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OneFragment extends Fragment implements IView {
    private String urlStr = "http://www.zhaoapi.cn/home/getHome";
    private Banner banner;
    private RecyclerView recyclerView;
    private IPresenterImpl iPresenter;
    private HomeAdapter mAdapter;
    private int mSpanCount = 2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.onefragment, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        banner = view.findViewById(R.id.banner);
        recyclerView = view.findViewById(R.id.recycleView);
        iPresenter = new IPresenterImpl(this);

        mAdapter = new HomeAdapter(getActivity());
        recyclerView.setAdapter(mAdapter);
        Map<String, String> map = new HashMap<>();
        iPresenter.pRequestData(urlStr, map, HomeBean.class);

        //布局管理器
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), mSpanCount);
        gridLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        recyclerView.setLayoutManager(gridLayoutManager);
    }

    //获取数据
    @Override
    public void viewDatas(Object data) {
        HomeBean homeBean = (HomeBean) data;
        mAdapter.setDatas(homeBean.getData().getTuijian().getList());

        //轮播图
         List<HomeBean.DataBean.BannerBean> mBanner = homeBean.getData().getBanner();
         banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
         banner.setImageLoader(new ImageLoaderInterface<ImageView>() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                Glide.with(context).load(path).into(imageView);
            }

            @Override
            public ImageView createImageView(Context context) {
                ImageView imageView = new ImageView(context);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                return imageView;
            }
        });
        List list = new ArrayList();
        for (int i = 0; i < mBanner.size(); i++) {
            list.add(mBanner.get(i).getIcon());
        }
        banner.setImages(list);
        banner.start();

        //banner的点击事件
        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                 Toast.makeText(getActivity(), "您点击了第"+position+"个图片", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        iPresenter.onDetch();
    }
}
