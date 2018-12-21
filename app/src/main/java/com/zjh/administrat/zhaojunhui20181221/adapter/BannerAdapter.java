package com.zjh.administrat.zhaojunhui20181221.adapter;

import android.content.Context;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.zjh.administrat.zhaojunhui20181221.bean.BannerBean;

import java.util.ArrayList;
import java.util.List;

public class BannerAdapter extends PagerAdapter {
    private List<BannerBean.DataBean> mData;
    private Context mContext;

    public BannerAdapter(Context mContext) {
        this.mContext = mContext;
        mData = new ArrayList<>();
    }
    public void setDatas(List<BannerBean.DataBean> data) {
        if (data != null){
            mData = data;
        }
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        position = position % mData.size();
        ImageView imageView = new ImageView(mContext);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        Glide.with(mContext).load(mData.get(position).getIcon()).into(imageView);
        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
