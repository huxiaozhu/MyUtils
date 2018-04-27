package com.longcheng.mvpseconddemo.utils;

import android.text.TextUtils;
import android.util.Log;

import java.io.File;

/**
 * Created by LongWH on 2016/9/27.
 * All Rights Reserved by ZhiYou @2016 - 2017
 * 用来处理一些零碎的操作
 */
public class CommonUtils {
    private static String mTag = "CommonUtils";

    public static boolean isPic(File file) {
        if (isFileWrong(file)) {
            return false;
        }

        String fileName = file.getName();
        return isPic(fileName);
    }

    public static boolean isPic(String fileName) {
        if (TextUtils.isEmpty(fileName)) {
            Log.w(mTag, "Warning, isPic fileName is empty");
            return false;
        }

        if (fileName.endsWith(".jpg")
                || fileName.endsWith(".png")
                || fileName.endsWith(".jpeg")
                || fileName.endsWith(".gif")) {
            return true;
        }

        return false;
    }

    /**判断文件是否是txt文件
     * @param file ：
     * @return ：true则是，否则false
     */
    public static boolean isTxt(File file) {
        if (isFileWrong(file)) {
            return false;
        }

        String fileName = file.getName();

        return fileName.endsWith(".txt");
    }



    private static boolean isFileWrong(File file) {
        if (file == null) {
            Log.w(mTag, "Warning,isPic file is null !!!");
            return true;
        }

        if (file.isDirectory()) {
            Log.w(mTag, "Warning, isPic file is Directory !!!");
            return true;
        }

        return false;
    }
}
