package com.zjh.administrat.week1demo.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.zjh.administrat.week1demo.fragment.OneFragment;
import com.zjh.administrat.week1demo.fragment.TwoFragment;

public class LeftAdapter extends FragmentPagerAdapter {

    private String[] menu = new String[]{"热销","招牌","主食","小吃","饮品"};
    public LeftAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        switch (i){
            case 0:
                return new OneFragment();
            case 1:
                return new TwoFragment();
            case 2:
                return new TwoFragment();
            case 3:
                return new TwoFragment();
            case 4:
                return new TwoFragment();
             default:
                 return new TwoFragment();
        }

    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return menu[position];
    }

    @Override
    public int getCount() {
        return menu.length;
    }
}
