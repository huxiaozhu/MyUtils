package com.lee.jq.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.lee.jq.R;
import com.lee.jq.utils.PreManger;
import com.lee.jq.widget.MyViewPager;
import com.lee.jq.widget.MyViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by liuxiaozhu on 2017/7/10.
 * 启动页
 */

public class SplashActivity extends BaseActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 不显示系统的标题栏，保证windowBackground和界面activity_main的大小一样，显示在屏幕不会有错位（去掉这一行试试就知道效果了）
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
    }

    @Override
    protected void setData() {
        Message message;
        if (PreManger.instance().isFristStart()) {
            message= handler.obtainMessage(0);
        } else {
            message= handler.obtainMessage(1);
        }

        handler.sendMessageDelayed(message, 1000);
    }



    @Override
    protected void setLisnter() {

    }

    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            if (msg.what == 1) {
                startActivity(new Intent(SplashActivity.this,MainActivity.class));
                finish();
            }
            if (msg.what == 0) {
                startActivity(new Intent(SplashActivity.this,WellComeActivity.class));
                finish();
            }
            return false;
        }
    });
}
