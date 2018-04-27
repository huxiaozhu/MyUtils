package com.example.administrator.my;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click(View view) {
        //设置显示内容
        //Notification提示消息给用户，
        // Notification是一种具有全局效果的通知，程序一般通过NotificationManager服务来发送Notification。

        Notification.Builder builder = new Notification.Builder(this);
        builder.setContentTitle("我是标题")
                .setContentText("我是内容")
                .setSmallIcon(R.mipmap.ic_launcher);

        //设置点击跳转
        PendingIntent intent = PendingIntent.getActivity(this, 0, new Intent(MainActivity.this, Main2Activity.class), PendingIntent.FLAG_UPDATE_CURRENT);
        //处理PendingIntent
        builder.setContentIntent(intent);
        //发出通知
        Notification notification = builder.build();
        //点击后消失
        notification.flags = Notification.FLAG_AUTO_CANCEL;
        //获取状态通知栏管理
//        NotificationManager 是一个系统Service，所以必须通过 getSystemService(NOTIFICATION_SERVICE)方法来获取。
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0, notification);
    }
}
