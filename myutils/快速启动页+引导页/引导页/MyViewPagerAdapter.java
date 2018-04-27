package com.lee.jq.widget;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuxiaozhu on 2017/9/2.
 * All Rights Reserved by YiZu
 */

public class MyViewPagerAdapter extends PagerAdapter {
    List<View> list;

    public MyViewPagerAdapter(List<View> list) {
        if (this.list == null) {
            this.list = new ArrayList<>();
        } else {
            this.list.clear();
        }
        if (list == null) {
            return;
        }
        this.list.addAll(list);
    }

    @Override
    public int getCount() {
        return list.size();

    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(list.get(position));
        return list.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(list.get(position));
    }

}
