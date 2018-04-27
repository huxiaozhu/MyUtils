package com.example.jsontaskwork;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

/**
 * Created by Administrator on 2016/9/26.
 */
public class JsonUtils {
    private static Gson mGson = new Gson();

    /**
     * 把一个object对象转换成json字符串
     * @param object
     * @return
     */
    public static String toJsonString(Object object) {
        return mGson.toJson(object);
    }

    /**把字符串解析成objet对象
     * @param jsonString json字符串
     * @param c          Class；类型
     * @param <T>        泛型
     * @return T所代表的对象
     */
    public static <T> T parse(String jsonString, Class<T> c) {
        return mGson.fromJson(jsonString, c);
    }

    /**
     * 解析json字符串成为一个集合
     * @param jsonArrayString
     * @param <T>             泛型，集合中的元素类型
     * @return list
     */
    public static <T> List<T> parseArray(String jsonArrayString, TypeToken<List<T>> type) {
        return mGson.fromJson(jsonArrayString, type.getType());
    }
}
