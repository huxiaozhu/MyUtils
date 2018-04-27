package com.terang.everyonetoshow.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by chenhui on 2017/6/29.
 * All Rights Reserved by YiZu
 * 线程池
 */

public class TheardUtils {
    private static ExecutorService mService;
    private TheardUtils() {
        mService = Executors.newCachedThreadPool();
    }

    private static class SingletonHolder{
        private static TheardUtils mInstance = new TheardUtils();
    }

    public static TheardUtils instance() {
        return SingletonHolder.mInstance;
    }

    public ExecutorService service() {
        return mService;
    }
}
