package com.lee.jq.utils;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.lee.jq.R;
import com.lee.jq.constens.IRecycerView;


/**
 * Created by liuxiaozhu on 2017/7/29.
 * All Rights Reserved by YiZu
 * popwindow弹出窗
 */

public class PopWindowsUtils {
    private PopupWindow popupWindow;

    public PopWindowsUtils() {
    }

    /**
     * 显示PopWindows
     * @param context
     * @param recycler
     * @param views
     */
    public void ShowPopWindow(Context context,View views,int gravity,IRecycerView recycler) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_popwindow, (ViewGroup) views,false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.pop_recyclerView);
        recycler.CallBack(recyclerView);
        popupWindow = new PopupWindow(context);
        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setContentView(view);
        //去除黑框
        popupWindow.setBackgroundDrawable(null);
        popupWindow.showAtLocation(views, gravity,0,0);
    }

    /**
     * 消失
     */
    public void dissmiss() {
        if (popupWindow.isShowing()) {
            popupWindow.dismiss();
        }
    }
}
