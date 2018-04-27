package com.lee.jq.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lee.jq.R;
import com.lee.jq.utils.PreManger;
import com.lee.jq.widget.MyViewPager;
import com.lee.jq.widget.MyViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WellComeActivity extends BaseActivity {

    @BindView(R.id.viewpager)
    MyViewPager viewpager;
    // 引导页图片资源
    private static final int[] pics = {R.layout.guid_view1, R.layout.guid_view2, R.layout.guid_view3};
    //存放View的列表
    private List<View> views;
    private boolean isChecked = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_well_come);
        ButterKnife.bind(this);

    }

    @Override
    protected void setData() {
        // 判断是否是第一次开启应用
            PreManger.instance().saveStart(false);
            views = new ArrayList<View>();
            // 初始化引导页视图列表
            for (int i = 0; i < pics.length; i++) {
                View view = LayoutInflater.from(this).inflate(pics[i], null);
                views.add(view);
            }
            viewpager.setNoScroll(false);
            viewpager.setAdapter(new MyViewPagerAdapter(views));
            RelativeLayout view = (RelativeLayout) views.get(2);
            TextView button = (TextView) view.findViewById(R.id.button);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isChecked) {
                        isChecked = false;
                        startActivity(new Intent(WellComeActivity.this, MainActivity.class));
                        finish();
                    }
                }
            });

    }

    @Override
    protected void setLisnter() {

    }
}
