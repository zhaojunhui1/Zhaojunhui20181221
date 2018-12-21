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
import com.zjh.administrat.zhaojunhui20181221.bean.GoodsBean;
import com.zjh.administrat.zhaojunhui20181221.view.DetailsActivity;

import java.util.ArrayList;
import java.util.List;

import okhttp3.logging.HttpLoggingInterceptor;

public class GoodsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<GoodsBean.DataBean> mData;
    private Context mContext;
    private boolean mflag;
    private String str;

    public GoodsAdapter(Context mContext, boolean flag) {
        this.mContext = mContext;
        this.mflag = flag;
        mData = new ArrayList<>();
    }

    public void setDatas(List<GoodsBean.DataBean> data) {
        if (mData != null){
            mData.addAll(data);
        }
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        RecyclerView.ViewHolder holder = null;
        if (mflag = true){
            View view = LayoutInflater.from(mContext).inflate(R.layout.linear_item, viewGroup, false);
            holder = new ViewHolder(view);
        }else {
            View view = LayoutInflater.from(mContext).inflate(R.layout.linear2_item, viewGroup, false);
            holder = new ViewHolder(view);
        }
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        //线性
        ViewHolder holder = (ViewHolder) viewHolder;
        for (int j = 0; j < mData.get(i).getList().size() ; j++) {
            holder.name.setText(mData.get(i).getList().get(j).getTitle());
            holder.price.setText("￥"+mData.get(i).getList().get(j).getPrice()+"");

            str = "";
            int length = mData.get(i).getList().get(j).getImages().length();
            for (int k = 0; k < length ; k++) {
                if (mData.get(i).getList().get(j).getImages().substring(k, k+1).equals("|")){
                    str = mData.get(i).getList().get(j).getImages().substring(k+1, length).trim();
                }
            }
            Glide.with(mContext).load(str).into(holder.imageView);

        }
        //网格
       /* GridHolder holder1 = (GridHolder) viewHolder;
        for (int j = 0; j < mData.get(i).getList().size() ; j++) {
            holder1.name.setText(mData.get(i).getList().get(j).getTitle());
            holder1.price.setText("￥"+mData.get(i).getList().get(j).getPrice()+"");

            String str = "";
            int length = mData.get(i).getList().get(j).getImages().length();
            for (int k = 0; k < length ; k++) {
                if (mData.get(i).getList().get(j).getImages().substring(k, k+1).equals("|")){
                    str = mData.get(i).getList().get(j).getImages().substring(k+1, length).trim();
                }
            }
            Glide.with(mContext).load(str).into(holder1.imageView);
        }*/

        //长按事件
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (mOnClickListener != null){
                    mOnClickListener.OnLongClick(i, str);
                }
                return true;
            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView name, price;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.name);
            price = itemView.findViewById(R.id.price);
        }
    }
    /*public class GridHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView name, price;
        public GridHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_grid);
            name = itemView.findViewById(R.id.name_grid);
            price = itemView.findViewById(R.id.price_grid);
        }
    }*/

    //成员变量
    OnClickListener mOnClickListener;
    //set方法
    public void setOnClickListener(OnClickListener onClickListener){
        mOnClickListener = onClickListener;
    }
    //定义接口
    public interface OnClickListener{
        void OnLongClick(int i, String url);
    }


}
