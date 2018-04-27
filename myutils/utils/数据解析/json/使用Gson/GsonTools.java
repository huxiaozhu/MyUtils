package com.longcheng.volleydemo.utils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by LongWH on 2016/9/26.
 * All Rights Reserved by ZhiYou @2016 - 2017
 */
public class GsonTools {
    private static Gson gson = new Gson();
    public static <T> T parse(JsonObject jsonObject, Class<T> type) {
        return gson.fromJson(jsonObject, type);
    }

    public static <T> T parse(String jsonString, Class<T> type) {
        JsonObject jsonObject = new JsonParser().parse(jsonString).getAsJsonObject();
        return parse(jsonObject, type);
    }

    public static String toJsonString(Object object) {
        return gson.toJson(object);
    }

    public static <T> List<T> parse(JsonArray jsonArray) {
        Gson gson = new Gson();
        return gson.fromJson(jsonArray, new TypeToken<List<T>>() {
        }.getType());
    }

    public static <K, V> Map<K, V> parse(JsonObject jsonObject) {
        return gson.fromJson(jsonObject, new TypeToken<Map<K, V>>() {
               }.getType());
    }

    public static JsonObject toJsonObject(String jsonString) {
        return new JsonParser().parse(jsonString).getAsJsonObject();
    }
}
