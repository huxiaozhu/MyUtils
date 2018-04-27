package com.example.fishbone.datebase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by liuxiaozhu on 2016/9/2.
 * 2016-2017
 * 数据库帮助类
 */
public class DbOpenHelper extends SQLiteOpenHelper {
    /**
     * @param context ： 上下文
     * @param name ： 数据库的名字
     * @param factory ： 游标工厂类
     * @param version ：数据库的版本号
     */
    public DbOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);

    }

    /**
     *当数据库被创建时调用
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createSql = "CREATE TABLE Person(\n" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, \n" +
                "name NVARCHAR(20),\n" +
                "message NVARCHAR(500),\n" +
                "head NVARCHAR(20),\n" +
                "audit NVARCHAR(20),\n" +
                "Cc NVARCHAR(20),\n" +
                "startday NVARCHAR(10),\n" +
                "starttime NVARCHAR(5),\n" +
                "stopday NVARCHAR(10),\n" +
                "stoptime NVARCHAR(5));";
        db.execSQL(createSql);
    }

    /**
     *用来更新数据库的表结构
     * @param db
     * @param oldVersion  数据库旧的版本号
     * @param newVersion  数据库新的版本号
     *
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //执行更新数据库的代码（新的数据库版本必须大于旧的版本）
//        onUpgrade();
    }
}
