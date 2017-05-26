package com.cxp.tablayout;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.cxp.tablayout.demo.TabLayoutDemo2PagerAdapter;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * setTabGravity()  用来设置 TabLayout 的布局方式，只有两个可选值fill 和 center，默认值是 fill
 * setSelectedTabIndicatorColor()    用来设置底部指示器的颜色
 * setSelectedTabIndicatorHeight()   用来设置底部指示器的高度
 * setTabMode():MODE_FIXED 固定不可滚动 或 MODE_SCROLLABLE 可滚动的
 */
public class MainActivity extends AppCompatActivity {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    private TabLayout mTitleTL;
    private ViewPager mContentVP;

    private List<String> mTitleList = new ArrayList<>();//页卡标题集合
    private List<Fragment> mFragmentList = new ArrayList<>();//页卡视图集合

    private String[] mTitleArr = {"Android", "Java", "iOS", "C", "C++", "Swift", "Python"};
    private List<View> mViewList;
    private TabLayoutDemo2PagerAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTitleTL= (TabLayout) findViewById(R.id.main_tab_layout);
        mContentVP= (ViewPager) findViewById(R.id.viewpager);

        //初始化数据
//        initData();

        initData1();


    }

    private void initData1() {
        int size = mTitleArr.length;
        mViewList = new ArrayList<>(size);
        // 添加 Tab，初始化 View 列表
        for (int i = 0; i < size; i++) {
            mTitleTL.addTab(mTitleTL.newTab().setText(mTitleArr[i]));
            View view = LayoutInflater.from(this).inflate(R.layout.item_tablayoutdemo2_vp, null);
            TextView tv = (TextView) view.findViewById(R.id.tv_text);
            tv.setText(mTitleArr[i]);
            mViewList.add(view);
        }
        mAdapter = new TabLayoutDemo2PagerAdapter(mViewList);
        // 填充 ViewPager
        mContentVP.setAdapter(mAdapter);
        // 给ViewPager添加监听
        mContentVP.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTitleTL));
        // 设置setOnTabSelectedListener
        mTitleTL.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                // 切换到指定的 item
                mContentVP.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    //初始化数据
    private void initData() {

        FirstFragment fragment1=new FirstFragment();
        TwoFragment fragment2=new TwoFragment();
        ThreeFragment fragment3=new ThreeFragment();



        //添加页卡视图
        mFragmentList.add(fragment1);
        mFragmentList.add(fragment2);
        mFragmentList.add(fragment3);

        //添加页卡标题
        mTitleList.add("TabOne");
        mTitleList.add("TabTwo");
        mTitleList.add("TabThree");

        //设置未选中和选中时字体的颜色
        mTabLayout.setTabTextColors(Color.BLACK,Color.RED);

        mTabLayout.setTabMode(TabLayout.MODE_FIXED);//设置tab模式，当前为系统默认模式
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(0)));//添加tab选项卡
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(1)));
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(2)));

        MyPagerAdapter mAdapter = new MyPagerAdapter(getSupportFragmentManager(),mFragmentList,mTitleList);
        mViewPager.setAdapter(mAdapter);//给ViewPager设置适配器

        //设置TabLayout 的点击监听
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
//        //设定默认选中
//        for (int i = 0; i < mTabLayout.getTabCount(); i++) {
//            TabLayout.Tab tab = mTabLayout.getTabAt(i);
//            if (tab != null) {
//                tab.setText(mTitleList.get(i));
//            }
//        }
//        mViewPager.setCurrentItem(1);
    }

}
