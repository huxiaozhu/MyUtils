package com.lee.jq.utils.alpay;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.widget.Toast;

import com.alipay.sdk.app.PayTask;
import com.lee.jq.utils.MyToast;

import java.util.Map;

/**
 * Created by liuxiaozhu on 2017/8/17.
 * All Rights Reserved by YiZu
 * 阿里支付
 */

public class MyAliPay {

    private static final int SDK_PAY_FLAG = 1;
    /**
     *  阿里支付
     * @param orderInfo
     */
    public MyAliPay(final String orderInfo, final Activity activity) {
        Runnable payRunnable = new Runnable() {
            @Override
            public void run() {
                PayTask alipay = new PayTask(activity);
                Map<String,String> result = alipay.payV2(orderInfo,true);
                Message msg = new Message();
                msg.what = SDK_PAY_FLAG;
                msg.obj = result;
                mHandler.sendMessage(msg);
            }
        };
        // 必须异步调用
        Thread payThread = new Thread(payRunnable);
        payThread.start();
    }

    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            if (msg.what == SDK_PAY_FLAG) {
                PayResult payResult = new PayResult((Map<String, String>) msg.obj);
                /**
                 对于支付结果，请商户依赖服务端的异步通知结果。同步通知结果，仅作为支付结束的通知。
                 */
                String resultInfo = payResult.getResult();// 同步返回需要验证的信息
                String resultStatus = payResult.getResultStatus();
                // 判断resultStatus 为9000则代表支付成功
                if (TextUtils.equals(resultStatus, "9000")) {
                    // 该笔订单是否真实支付成功，需要依赖服务端的异步通知。
                    MyToast.ShowLong("支付成功");
                } else {
                    // 该笔订单真实的支付结果，需要依赖服务端的异步通知。
                    MyToast.ShowLong("支付失败");
                }
            }
        }
    };
}
