package com.sgxxqp.test.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;

/**
 * Created by liuxiaozhu on 2017/8/24.
 * All Rights Reserved by YiZu
 * 手机屏幕管理的工具
 */

public class ScreenManagerUtils {
    //像素/mScale==dp
    private static float mScale = 0.0f; // 密度
    private static float mFontScale = 0.0f;
    //当前屏幕的dp值
    private static int mDpi = 0; // dpi
    //当前屏幕宽度的像素值
    private static int mWidthPixels = 0;
    //当前屏幕高度的像素值
    private static int mHeightPixels = 0;

    private ScreenManagerUtils() {
    }

    /**
     * @param context
     */
    public static void init(Context context) {
        //该类主要是测量手机显示的信息，如他的大小、密度和字体的缩放
        DisplayMetrics displaysMetrics = new DisplayMetrics();// 初始化一个结构
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        wm.getDefaultDisplay().getMetrics(displaysMetrics);// 对该结构赋值，测量当前屏幕的信息
        mWidthPixels = displaysMetrics.widthPixels;
        mHeightPixels = displaysMetrics.heightPixels;
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        mScale = dm.density;
        mDpi = dm.densityDpi;
        mFontScale = dm.scaledDensity;
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(float dpValue) {
        return (int) (dpValue * mScale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dip(float pxValue) {
        return (int) (pxValue / mScale + 0.5f);
    }

    /**
     * 得到的屏幕的宽度
     */
    public static int getWidthPx() {
        // DisplayMetrics 一个描述普通显示信息的结构，例如显示大小、密度、字体尺寸
        return mWidthPixels;
    }

    /**
     * 得到的屏幕的高度
     */
    public static int getHeightPx() {
        // DisplayMetrics 一个描述普通显示信息的结构，例如显示大小、密度、字体尺寸
        return mHeightPixels;
    }

    /**
     * 得到屏幕的dpi
     */
    public static int getDensityDpi() {
        // DisplayMetrics 一个描述普通显示信息的结构，例如显示大小、密度、字体尺寸
        return mDpi;
    }
    /**
     * 返回状态栏/通知栏的高度
     */
    public static int getStatusHeight(Activity activity) {
        Rect frame = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(frame);
        return frame.top;
    }

    /**
     * 将px转换为sp
     * @param pxValue
     * @return
     */
    public static int px2sp(float pxValue) {
        return (int) (pxValue / mFontScale + 0.5f);
    }

    /**
     * 将sp值转换为px值
     * @param spValue （DisplayMetrics类中属性scaledDensity）
     */
    public static int sp2px(float spValue) {

        return (int) (spValue * mFontScale + 0.5f);
    }


    /**
     * 获取当前屏幕截图，包含状态栏
     * @param activity
     * @return
     */
    public static Bitmap getScreenPicIncloudBar(Activity activity)
    {
        View view = activity.getWindow().getDecorView();
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        Bitmap bmp = view.getDrawingCache();
        Bitmap bp = null;
        bp = Bitmap.createBitmap(bmp, 0, 0, getWidthPx(), getHeightPx());
        view.destroyDrawingCache();
        return bp;
    }

    /**
     * 获取当前屏幕截图，不包含状态栏
     * @param activity
     * @return
     */
    public static Bitmap getScreenPicNoBar(Activity activity)
    {
        View view = activity.getWindow().getDecorView();
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        Bitmap bmp = view.getDrawingCache();
        Bitmap bp = null;
        bp = Bitmap.createBitmap(bmp, 0, getStatusHeight(activity), getWidthPx(), getHeightPx()
                - getStatusHeight(activity));
        view.destroyDrawingCache();
        return bp;

    }


}
