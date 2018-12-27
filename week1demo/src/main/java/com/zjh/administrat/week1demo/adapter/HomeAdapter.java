package com.zjh.administrat.week1demo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.zjh.administrat.week1demo.R;
import com.zjh.administrat.week1demo.bean.HomeBean;

import java.util.ArrayList;
import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<HomeBean.DataBean.TuijianBean.ListBeanX> mData;
    private Context mContext;

    public HomeAdapter(Context context) {
        this.mContext = context;
        mData = new ArrayList<>();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.home_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ViewHolder mHolder = (ViewHolder) viewHolder;
            mHolder.title.setText(mData.get(i).getTitle());
            mHolder.price.setText("￥"+mData.get(i).getPrice()+"");

            //截取图片集
            String str = "";
            int length = mData.get(i).getImages().length();
            for (int k = 0; k < length; k++) {
                if (mData.get(i).getImages().substring(k, k+1).equals("|")){
                    str = mData.get(i).getImages().substring(k+1, length).trim();
                }
            }
            mHolder.simpleDraweeView.setImageURI(str);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void setDatas(List<HomeBean.DataBean.TuijianBean.ListBeanX> list) {
        if (list != null){
            mData.addAll(list);
        }
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public SimpleDraweeView simpleDraweeView;
        public TextView title, price;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            simpleDraweeView = itemView.findViewById(R.id.fresco);
            title = itemView.findViewById(R.id.title);
            price = itemView.findViewById(R.id.price);

        }
    }


}
