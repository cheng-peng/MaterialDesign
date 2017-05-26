package com.cxp.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.List;

/**
 * Created by CXP on 2016/12/19
 * desc :
 * q978515743@163.com
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private LayoutInflater mLayoutInflater;
    private List<String> mDatas;

    public MyAdapter(Context mContext, List<String> mDatas) {
        mLayoutInflater = LayoutInflater.from(mContext);
        this.mDatas = mDatas;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder = new MyViewHolder(mLayoutInflater.inflate(R.layout.layout_item, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mDatas != null ? mDatas.size() : 0;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        RadioButton mRadioButton;
        TextView mTextView;

        public MyViewHolder(View itemView) {
            super(itemView);
            mRadioButton = (RadioButton) itemView.findViewById(R.id.item_rb);
            mTextView = (TextView) itemView.findViewById(R.id.item_tv);
        }
    }
}
