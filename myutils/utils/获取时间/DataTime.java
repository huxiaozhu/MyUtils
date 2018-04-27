package com.example.fishbone.utils;

import java.util.Calendar;

/**
 * Created by liuxiaozhu on 2016/8/31.
 * 2016-2017
 */
public  class DataTime {
    Calendar calendar = Calendar.getInstance();
    int yeas = calendar.get(Calendar.YEAR);
    int month = calendar.get(Calendar.MONTH)+1;
    int day = calendar.get(Calendar.DAY_OF_MONTH);
    int hours = calendar.get(Calendar.HOUR_OF_DAY);
    int minute = calendar.get(Calendar.MINUTE);

    public int getYeas() {
        return yeas;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getHours() {
        return hours;
    }

    public int getMinute() {
        return minute;
    }
}
