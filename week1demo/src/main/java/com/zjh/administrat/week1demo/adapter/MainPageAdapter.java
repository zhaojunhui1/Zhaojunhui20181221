package com.zjh.administrat.week1demo.adapter;

import android.content.Context;
import android.renderscript.Sampler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.zjh.administrat.week1demo.fragment.CenterFragment;
import com.zjh.administrat.week1demo.fragment.LeftFragment;
import com.zjh.administrat.week1demo.fragment.RightFragment;

public class MainPageAdapter extends FragmentPagerAdapter {

    private String[] menus = new String[]{"预约","扫描", "我的"};
    public MainPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return new LeftFragment();
            case 1:
                return new CenterFragment();
            case 2:
                return new RightFragment();
            default:
                return new LeftFragment();
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return menus[position];
    }

    @Override
    public int getCount() {
        return menus.length;
    }


}
