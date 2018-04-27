package com.example.administrator.lock.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.administrator.lock.ui.fragment.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ChenHui on 2016/9/18.
 * 2016-2017
 */
public class VPagerAdapter extends FragmentPagerAdapter {
    private List<BaseFragment> mFragments = new ArrayList<>();

    public VPagerAdapter(FragmentManager fm, List<BaseFragment> list) {
        super(fm);
        if (list != null) {
            mFragments.addAll(list);
        }
    }


    @Override
    public Fragment getItem(int position) {
        if (position>=0&&position<getCount()){
        return mFragments.get(position);
        }
        return null;
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

}
