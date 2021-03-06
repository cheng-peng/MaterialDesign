package com.cxp.tablayout.demo;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by CXP on 2016/12/16
 * desc :
 * q978515743@163.com
 */

public class TabLayoutDemo2PagerAdapter extends PagerAdapter {

    private List<View> mViewList;

    public TabLayoutDemo2PagerAdapter(@NonNull List<View> viewList) {
        this.mViewList = viewList;
    }

    @Override
    public int getCount() {
        return mViewList.size();
    }

    // 滑动切换的时候销毁当前的组件
    @Override
    public void destroyItem(ViewGroup container, int position,
                            Object object) {
        ((ViewPager) container).removeView(mViewList.get(position));
    }

    // 每次滑动的时候生成的组件
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ((ViewPager) container).addView(mViewList.get(position));
        return mViewList.get(position);
    }
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
