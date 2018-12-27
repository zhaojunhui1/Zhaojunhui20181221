package com.zjh.administrat.week1demo.view;

import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;

import com.zjh.administrat.week1demo.adapter.MainPageAdapter;
import com.zjh.administrat.week1demo.R;

public class MainActivity extends FragmentActivity {
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private MainPageAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tablayout);
        mAdapter = new MainPageAdapter(getSupportFragmentManager());
        viewPager.setAdapter(mAdapter);
        tabLayout.setupWithViewPager(viewPager);

    }

}
