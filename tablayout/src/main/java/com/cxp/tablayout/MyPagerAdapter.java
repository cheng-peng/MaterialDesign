package com.cxp.tablayout;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by CXP on 2016/12/15
 * desc :
 * q978515743@163.com
 */

public class MyPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> mFragmentList;
    private List<String> mTitleList;

    public MyPagerAdapter(FragmentManager fm, List<Fragment> mFragmentList, List<String> mTitleList) {
        super(fm);
        this.mFragmentList = mFragmentList;
        this.mTitleList = mTitleList;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }


    @Override
    public int getCount() {
        return mFragmentList.size()!=0?mFragmentList.size():0;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitleList.get(position);//页卡标题
    }
}
