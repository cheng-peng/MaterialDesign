package com.cxp.coordinatorlayout;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton fab;
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

        fab= (FloatingActionButton) findViewById(R.id.main_fab);
        mRecyclerView= (RecyclerView) findViewById(R.id.main_recyclerview);
        
        
        //初始化数据
        initData();
        
        adapter=new MyAdapter(mContext,mData);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(mContext,DividerItemDecoration.VERTICAL_LIST));
        mRecyclerView.setAdapter(adapter);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(fab,"测试",Snackbar.LENGTH_SHORT).show();
            }
        });
    }

    //初始化数据
    private void initData() {
        for (int i = 0; i < 15; i++) {
            mData.add(""+(char)(65+i));
        }
    }
}
