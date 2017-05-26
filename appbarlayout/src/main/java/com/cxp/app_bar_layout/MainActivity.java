package com.cxp.app_bar_layout;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton mFloatingActionButton;
    private Toolbar mToolbar;
    private RecyclerView mRecyclerView;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    private List<String> mData;
    private Context mContext;

    private MyAdapter adapter;

    private View view1, view2, view3, view4, view5;//页卡视图
    private LayoutInflater mInflater;
    private List<String> mTitleList = new ArrayList<>();//页卡标题集合
    private List<View> mViewList = new ArrayList<>();//页卡视图集合

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = MainActivity.this;

        mData = new ArrayList<>();

        mFloatingActionButton = (FloatingActionButton) findViewById(R.id.main_fab);
        mToolbar = (Toolbar) findViewById(R.id.main_toolbar);
        mTabLayout = (TabLayout) findViewById(R.id.main_tl);
        mViewPager = (ViewPager) findViewById(R.id.main_viewpager);

        mToolbar.setNavigationIcon(R.mipmap.cxp_white_19);
        mToolbar.setTitle("程小鹏。");
        setSupportActionBar(mToolbar);

        mInflater = LayoutInflater.from(this);

        //初始化Fragment
        initFragment();

        //添加页卡视图
        mViewList.add(view1);
        mViewList.add(view2);
        mViewList.add(view3);
        mViewList.add(view4);
        mViewList.add(view5);

        //添加页卡标题
        mTitleList.add("TabOne");
        mTitleList.add("TabTwo");
        mTitleList.add("TabThree");
        mTitleList.add("TabFour");
        mTitleList.add("TabFive");

        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);//设置tab模式，当前为系统默认模式
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(0)));
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(1)));
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(2)));
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(3)));
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(4)));

        //初始化数据
        initData();

        adapter = new MyAdapter(mContext, mData);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(mContext, DividerItemDecoration.VERTICAL_LIST));
        mRecyclerView.setAdapter(adapter);

        MyPagerAdapter mAdapter = new MyPagerAdapter(mViewList);
        mViewPager.setAdapter(mAdapter);//给ViewPager设置适配器
        mTabLayout.setupWithViewPager(mViewPager);//将TabLayout和ViewPager关联起来。

    }

    //初始化Fragment
    private void initFragment() {
        view1 = mInflater.inflate(R.layout.layout_fragment, null, false);
        mRecyclerView = (RecyclerView) view1.findViewById(R.id.main_recyclerview);

        view2 = mInflater.inflate(R.layout.layout_fragment1, null, false);
        view3 = mInflater.inflate(R.layout.layout_fragment1, null, false);
        view4 = mInflater.inflate(R.layout.layout_fragment1, null, false);
        view5 = mInflater.inflate(R.layout.layout_fragment1, null, false);



    }

    //初始化数据
    private void initData() {
        for (int i = 0; i < 15; i++) {
            mData.add("" + (char) (65 + i));
        }
    }

    class MyPagerAdapter extends PagerAdapter {
        private List<View> mViewList;

        public MyPagerAdapter(List<View> mViewList) {
            this.mViewList = mViewList;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(mViewList.get(position));//删除页卡
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(mViewList.get(position));//添加页卡
            return mViewList.get(position);
        }

        @Override
        public int getCount() {
            return mViewList != null ? mViewList.size() : 0;//页卡数
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;//官方推荐写法
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitleList.get(position);//页卡标题
        }
    }
}
