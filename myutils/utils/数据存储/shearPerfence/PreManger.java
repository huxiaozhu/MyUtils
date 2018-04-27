package com.lee.jq.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Administrator on 2016/8/23.
 */
public class PreManger {
    /*PreferenceManger自己的实例*/
    private static PreManger mInstance;
    /*SharedPreferences的实例*/
    private SharedPreferences mPreferences;
    /*SharedPreferences的编辑器*/
    private SharedPreferences.Editor mEditor;

    /*私有化的构造函数，目的是不能在其他类实例化*/
    private PreManger() {

    }

    /*获取当前类的实例*/
    public static PreManger instance() {
        if (mInstance == null) {
            mInstance = new PreManger();
        }
        return mInstance;
    }

    /**
     * 初始化mPreferences  和mEditor
     *
     * @param context：上下文
     */
    public void init(Context context) {
        //
        mPreferences = context.getSharedPreferences("preferenre", Context.MODE_PRIVATE);
        if (mPreferences != null) {/*非控判断是必要的*/
            mEditor = mPreferences.edit();
            /*不要忘了提交*/
            mEditor.apply();
        }

    }

    /*================================存储数据===================================*/

    /**
     * 保存登陆信息
     * @param phone
     * @param pic
     * @param token
     */
    public void saveLogin(String phone, String pic, String token) {
        if (mEditor != null) {
            mEditor.putString(key.PHONE, phone);
            mEditor.putString(key.PIC, pic);
            mEditor.putString(key.TOKEN, token);
            mEditor.commit();
        }
    }

    /**
     * 保存图片信息
     * @param pic
     */
    public void savePic(String pic) {
        if (mEditor != null) {
            mEditor.putString(key.PIC, pic);
            mEditor.commit();
        }
    }

    /**
     * 保存图片信息
     */
    public void savePhone(String phone) {
        if (mEditor != null) {
            mEditor.putString(key.PHONE, phone);
            mEditor.commit();
        }
    }
    /**
     * 获取用户名
     *
     * @return
     */
    public String getPhoneNum() {
        if (mPreferences != null) {
            return mPreferences.getString(key.PHONE, "");
        }
        return "";
    }

    /**
     * 获取图片
     * @return
     */
    public String getPic() {
        if (mPreferences != null) {
            return mPreferences.getString(key.PIC, "");
        }
        return "";
    }

    /**
     * 获取token
     *
     * @return
     */
    public String getToken() {
        if (mPreferences != null) {
            return mPreferences.getString(key.TOKEN, "");
        }
        return "";
    }

    /**
     * SharedPreferences 文件的key的常量类
     */
    private interface key {
        String PHONE = "phone";
        String PIC = "pic";
        String TOKEN = "token";


    }
}
