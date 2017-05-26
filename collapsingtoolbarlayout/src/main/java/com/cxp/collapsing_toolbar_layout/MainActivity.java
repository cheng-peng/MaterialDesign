package com.cxp.collapsing_toolbar_layout;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    private List<String> mData;
    private Context mContext;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext=MainActivity.this;
        mData=new ArrayList<>();

        mRecyclerView= (RecyclerView) findViewById(R.id.main_recyclerview);

        //初始化数据
        initData();

        adapter=new MyAdapter(mContext,mData);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(mContext,DividerItemDecoration.VERTICAL_LIST));
        mRecyclerView.setAdapter(adapter);

    }

    //初始化数据
    private void initData() {
        for (int i = 0; i < 15; i++) {
            mData.add(""+(char)(65+i));
        }
    }
}
