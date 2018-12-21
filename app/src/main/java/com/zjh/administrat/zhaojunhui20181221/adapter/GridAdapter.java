package com.zjh.administrat.zhaojunhui20181221.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zjh.administrat.zhaojunhui20181221.R;
import com.zjh.administrat.zhaojunhui20181221.bean.DetailBean;

import java.util.ArrayList;
import java.util.List;

public class GridAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<DetailBean.DataBean> mData;
    private Context mContext;

    public GridAdapter(Context mContext) {
        this.mContext = mContext;
        mData =  new ArrayList<>();
    }

    public void setDatas(List<DetailBean.DataBean> data) {
        if (data != null){
            mData.addAll(data);
        }
        notifyDataSetChanged();

    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.grid_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ViewHolder mHolder = (ViewHolder) viewHolder;
        mHolder.name.setText(mData.get(i).getName());
        Glide.with(mContext).load(mData.get(i).getIcon()).into(mHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            name = itemView.findViewById(R.id.name);
        }
    }

}
