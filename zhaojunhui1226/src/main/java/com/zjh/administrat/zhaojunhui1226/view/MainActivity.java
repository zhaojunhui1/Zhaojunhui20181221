package com.zjh.administrat.zhaojunhui1226.view;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;
import com.youth.banner.loader.ImageLoaderInterface;
import com.zjh.administrat.zhaojunhui1226.R;
import com.zjh.administrat.zhaojunhui1226.bean.DetailBean;
import com.zjh.administrat.zhaojunhui1226.presenter.IPresenterImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements IView{

    private String urlStr = "http://www.zhaoapi.cn/product/getProductDetail";
    private IPresenterImpl iPresenter;
    private Banner banner;
    private TextView name, price;
    private DetailBean detailBean;
    private DetailBean.DataBean dataBean;
    private List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initBanner();
    }


    private void initView() {
        iPresenter = new IPresenterImpl(this);
        banner = findViewById(R.id.banner);
        name = findViewById(R.id.name);
        price = findViewById(R.id.price);

        Map<String, String> map = new HashMap<>();
        map.put("pid", "1");
        iPresenter.pRequestData(urlStr, map, DetailBean.class);
    }


    private void initBanner() {
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        banner.setImageLoader(new ImageLoaderInterface<ImageView>() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                //截取图片集
                String str = "";
                int length = detailBean.getData().getImages().length();
                for (int i = 0; i < length; i++) {
                    if (detailBean.getData().getImages().substring(i, i+1).equals("|")){
                        str = detailBean.getData().getImages().substring(i+1, length).trim();
                    }
                }
                Glide.with(context).load(str).into(imageView);
            }

            @Override
            public ImageView createImageView(Context context) {
                ImageView imageView = new ImageView(context);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                return imageView;
            }
        });
    }

    //返回数据
    @Override
    public void viewDatas(final Object data) {
        detailBean = (DetailBean) data;

        Log.i("TAG", detailBean +"");

        String str = "";
        int length = detailBean.getData().getImages().length();
        for (int i = 0; i < length; i++) {
            if (detailBean.getData().getImages().substring(i, i+1).equals("|")){
                str = detailBean.getData().getImages().substring(i+1, length).trim();
            }
        }
        list = new ArrayList<>();
        list.add(str);

        name.setText(detailBean.getData().getTitle());
        price.setText("优惠价:"+ detailBean.getData().getPrice()+"");

        banner.setImages(list);
        banner.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        iPresenter.onDetch();
    }
}
