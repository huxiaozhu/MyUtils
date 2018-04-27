package com.longcheng.okhttpdemo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.asm.Type;
import com.alibaba.fastjson.serializer.StringCodec;

import java.util.List;
import java.util.Map;

/**
 * Created by LongWH on 2016/9/26.
 * All Rights Reserved by ZhiYou @2016 - 2017
 */
public class FastJsonUtils {
    public static String toJson(Object obj) {
        return JSON.toJSONString(obj);
    }

    public static <T> T parse(JSONObject jsonObject,Class<T> c) {
        return JSONObject.parseObject(jsonObject.toJSONString(), c);
    }

    public static <T> List<T> parse(JSONArray jsonArray, Class<T> c) {
        return JSONArray.parseArray(jsonArray.toJSONString(), c);
    }

    public static <V> Map<String, V> parse(JSONObject jsonObject) {
      return JSONObject.parseObject(jsonObject.toJSONString(), new TypeReference<Map<String,V>>() {
        });
    }


}
