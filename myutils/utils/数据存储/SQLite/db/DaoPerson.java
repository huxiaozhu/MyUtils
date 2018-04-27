package com.example.fishbone.datebase;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.example.fishbone.bean.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuxiaozhu on 2016/9/2.
 * 2016-2017
 */
public class DaoPerson {
    private final String mTag = this.getClass().getName();
    private static DaoPerson mtask;
    private SQLiteDatabase mDb;

    private DaoPerson() {

    }

    public static DaoPerson instance() {
        if (mtask == null) {
            mtask = new DaoPerson();
        }
        return mtask;
    }

    /**
     * 初始化数据库
     *
     * @param context
     */
    public void init(Context context) {
//        获取用户名
//        String username = Task.instance().getUserName();
        String username = "liuxiaozhu";
        if (!TextUtils.isEmpty(username)) {
            DbOpenHelper helper = new DbOpenHelper(context, username, null, 1);
//            SQLiteDatabase.openOrCreateDatabase()//打开数据库
            mDb = helper.getReadableDatabase();//创建数据库
        } else {
            Log.e(mTag, "数据库创建失败");
//            Toast.makeText(context, "创建数据库失败", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 插入一列数据
     *
     * @param who
     * @return
     */
    public boolean insert(Person who) {
        if (mDb == null) {
            Log.e(mTag, "insertOne error !!! DB is null");
            return false;
        }
//        要执行的sql语句
        String insterSql = "INSERT OR REPLACE INTO Person (id,name,message,head,audit,Cc,startday,starttime,stopday,stoptime)\n" +
                "  VALUES(?,?,?,?,?,?,?,?,?,?)";
        Object[] values = {who.getmId(), who.getmId(), who.getmMessage(), who.getmHead(),
                who.getmAudit(), who.getmCc(), who.getmStartday(), who.getmStarttime(), who.getmStopday(), who.getmStoptime()};
        boolean result;
        try {
            if (mDb != null) {
                mDb.execSQL(insterSql, values);
            }
            result = true;
        } catch (SQLException e) {
            e.printStackTrace();
            Log.e(mTag, "insert error !!!" + e.getMessage());
            result = false;
        }
        return result;
    }

    /**
     * 添加多条数据
     * @param persons
     * @return
     */
    public boolean insert(List<Person> persons) {
        if (mDb == null) {
            Log.e(mTag, "insertOne error !!! DB is null");
            return false;
        }
        mDb.beginTransaction();//开启事务
        boolean isSuccess = false;

        try {
            for (Person p :
                    persons) {
                insert(p);
            }
            mDb.setTransactionSuccessful();//设置失误
            isSuccess = true;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            mDb.endTransaction();//结束事务
        }
        return isSuccess;
    }

    /**
     *删除数据
     */
    public boolean delet(int id) {
        String deleteSql="DELETE FROM Person WHERE id = ?";
        if (mDb == null) {
            Log.e(mTag, "mDb is null !!!");
            return false;
        }
        boolean result;

        try {
            mDb.execSQL(deleteSql,new Object[]{id});
            result = true;
        } catch (SQLException e) {
            e.printStackTrace();
            result=false;
        }
        return result;
    }
    /**
     * 更新数据
     *
     * @param who ：被更新的人
     * @return ：true 更新成功，false 失败
     */
    public boolean updata(Person who) {
        if (mDb == null) {
            return false;
        }
        String updateSql = "UPDATE TABLE Person SET id= ? WHERE name = ?";
        boolean result;
        try {
            mDb.execSQL(updateSql, new Object[]{who.getmId(), who.getmName()});
            result = true;
        } catch (SQLException e) {
            Log.e(mTag, "update Error !!!" + e.getMessage());
            result = false;
        }
        return result;
    }

    //查询一条数据
    public Person select(int id) {
        if (mDb == null) {
            return null;
        }
        String select = "SELECT * FROM Person WHERE id = ?";
        Cursor cursor = null;   //光标
        Person person = null;

        try {
//            找到指定id
            cursor=mDb.rawQuery(select,new String[]{String.valueOf(id)});
            int index = 0;
            //判断cursor不是null，并且可以移动到第一条数据
            if (cursor != null && cursor.moveToFirst()) {
                //把cursor移动到第一条数据
                person = new Person();
                int realId = cursor.getInt(index);
                person.setmId(realId);
                person.setmName(cursor.getString(index + 1));
                person.setmMessage(cursor.getString(index + 2));
                person.setmHead(cursor.getString(index + 3));
                person.setmAudit(cursor.getString(index+4));
                person.setmCc(cursor.getString(index+5));
                person.setmStartday(cursor.getString(index+6));
                person.setmStarttime(cursor.getString(index+7));
                person.setmStopday(cursor.getString(index+8));
                person.setmStoptime(cursor.getString(index+9));
        }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(mTag, e.getMessage());
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return person;
        }

    /**
     * 查询整个表
     * @return
     */
    public List<Person> selectAll() {
        if (mDb == null) {
            Log.e(mTag, "queryAll mDb is null !!!");
            return null;
        }
        Cursor cursor = null;
        List<Person> per = null;
        try {
            cursor = mDb.rawQuery("SELECT * FROM Person", new String[]{});
            if (cursor != null) { //非null判断
                per = new ArrayList<>();
                int index = 0;
                //如果cursor可以移动到下一条数据
                while (cursor.moveToNext()) {
                    Person person = new Person();
                    person.setmId(cursor.getInt(index));
                    person.setmName(cursor.getString(index + 1));
                    person.setmMessage(cursor.getString(index + 2));
                    person.setmHead(cursor.getString(index + 3));
                    person.setmAudit(cursor.getString(index+4));
                    person.setmCc(cursor.getString(index+5));
                    person.setmStartday(cursor.getString(index+6));
                    person.setmStarttime(cursor.getString(index+7));
                    person.setmStopday(cursor.getString(index+8));
                    person.setmStoptime(cursor.getString(index+9));
                    per.add(person);
                }
            }
        } catch (Exception e) {
            Log.e(mTag, "queryAll Error !!! " + e.getMessage());
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }

        return per;
    }




}
