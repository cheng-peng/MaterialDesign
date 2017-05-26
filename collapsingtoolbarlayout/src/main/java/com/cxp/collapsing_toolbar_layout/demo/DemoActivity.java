package com.cxp.collapsing_toolbar_layout.demo;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.cxp.collapsing_toolbar_layout.DividerItemDecoration;
import com.cxp.collapsing_toolbar_layout.MyAdapter;
import com.cxp.collapsing_toolbar_layout.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CXP on 2016/12/16
 * desc :
 * q978515743@163.com
 */

public class DemoActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private FloatingActionButton mFloatingActionButton;

    private List<String> mData;
    private Context mContext;
    private MyAdapter adapter;

    private Toolbar mToolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_demo);

        mContext = DemoActivity.this;
        mData = new ArrayList<>();

        mToolbar= (Toolbar) findViewById(R.id.demo_toolbar);
        mRecyclerView = (RecyclerView) findViewById(R.id.demo_recyclerview);
        mFloatingActionButton = (FloatingActionButton) findViewById(R.id.demo_fbl);

        mToolbar.setNavigationIcon(R.mipmap.cxp_white_19);

        //初始化数据
        initData();

        adapter = new MyAdapter(mContext, mData);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(mContext, DividerItemDecoration.VERTICAL_LIST));
        mRecyclerView.setAdapter(adapter);


    }

    //初始化数据
    private void initData() {
        for (int i = 0; i < 15; i++) {
            mData.add("" + (char) (65 + i));
        }
    }
}
