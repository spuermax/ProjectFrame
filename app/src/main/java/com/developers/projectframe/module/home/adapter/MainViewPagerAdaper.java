package com.developers.projectframe.module.home.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * @Author yinzh
 * @Date 2020/3/21 15:40
 * @Description
 */
public class MainViewPagerAdaper extends FragmentPagerAdapter {

    private List<Fragment> fragmentList ;


    public MainViewPagerAdaper(FragmentManager fm , List<Fragment> fragmentList) {
        super(fm);
        this.fragmentList = fragmentList;
    }


    @Override
    public int getCount() {
        return fragmentList == null ? 0 : fragmentList.size();
    }


    @Override
    public Fragment getItem(int i) {
        return fragmentList.get(i);
    }

}
