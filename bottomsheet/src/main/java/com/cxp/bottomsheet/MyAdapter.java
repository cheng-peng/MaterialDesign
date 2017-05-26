package com.cxp.bottomsheet;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by CXP on 2016/12/15
 * desc :
 * q978515743@163.com
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {


    private List<String> mData;
    private Context mContext;
    private OnItemClickListener mOnItemClickListener;

    public MyAdapter(Context context, List<String> mData,OnItemClickListener mOnItemClickListener) {
        this.mContext = context;
        this.mData = mData;
        this.mOnItemClickListener = mOnItemClickListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_item, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.tv.setText(mData.get(position));
        holder.cardView.setTag(mData.get(position));
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOnItemClickListener.OnItemClickListener(view,position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size() != 0 ? mData.size() : 0;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv;
        CardView cardView;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.ite_tv);
            cardView= (CardView) itemView.findViewById(R.id.item_card);
        }
    }

}