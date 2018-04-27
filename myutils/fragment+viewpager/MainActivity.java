package com.example.administrator.lock.ui.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.example.administrator.lock.R;
import com.example.administrator.lock.constans.FragmentTag;
import com.example.administrator.lock.ui.adapter.VPagerAdapter;
import com.example.administrator.lock.ui.fragment.AccountFragment;
import com.example.administrator.lock.ui.fragment.BaseFragment;
import com.example.administrator.lock.ui.fragment.HomeFragment;
import com.example.administrator.lock.ui.fragment.RecordFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {
    private ViewPager viewPager;
    private RadioGroup mGroup;
    private List<BaseFragment> fragments;
    private RadioButton btn1,btn2, btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setData();
        setLisinter();
    }

    private void setData() {
        fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new RecordFragment());
        fragments.add(new AccountFragment());
        VPagerAdapter adapter = new VPagerAdapter(getSupportFragmentManager(), fragments);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(0);
    }
    private void setLisinter() {
        mGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId) {
                    case R.id.radiobutton1:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.radiobutton2:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.radiobutton3:
                        viewPager.setCurrentItem(2);
                        break;
                }
            }
        });
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                switch (position) {
                    case 0:
                        btn1.setChecked(true);
                        break;
                    case 1:
                        btn2.setChecked(true);
                        break;
                    case 2:
                        btn3.setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initView() {
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        mGroup = (RadioGroup) findViewById(R.id.radiogroup);
        btn1 = (RadioButton) findViewById(R.id.radiobutton1);
        btn2 = (RadioButton) findViewById(R.id.radiobutton2);
        btn3 = (RadioButton) findViewById(R.id.radiobutton3);
    }
}
