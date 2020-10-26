package com.alick.languagedemo;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;

import androidx.annotation.ArrayRes;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.FontRes;
import androidx.annotation.StringRes;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;


/**
 * 功能: 资源工具类
 * 作者: 崔兴旺
 * 日期: 2020/3/6 0006
 */
public class ResourceUtils {
    /**
     * 获取应用内字符串资源
     *
     * @param id int @StringRes
     * @return 字符串资源，找不到则返回空字符串
     */
    public static String getString(@StringRes int id) {
        try {
            return AppHolder.getApp().getString(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 获取尺寸
     * @param id
     * @return
     */
    public static int getDimension(@DimenRes int id) {
        try {
            return AppHolder.getApp().getResources().getDimensionPixelOffset(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 获取应用内字符串资源，并用指定的格式化参数替代占位符
     *
     * @param id         int @StringRes
     * @param formatArgs 用于替代的格式参数
     * @return 格式化之后的字符串资源，或者空字符串
     */
    public static String getString(@StringRes int id, Object... formatArgs) {
        try {
            if (formatArgs == null) {
                return AppHolder.getApp().getString(id);
            } else {
                return AppHolder.getApp().getString(id, formatArgs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 获取应用内字符串数组资源
     *
     * @param id
     * @return 应用内字符串数组资源或空字符串数组
     */
    public static String[] getStringArray(@ArrayRes int id) {
        try {
            return AppHolder.getApp().getResources().getStringArray(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new String[]{};

    }

    /**
     * 获取应用内颜色资源
     *
     * @param id
     * @return 颜色资源或全透明颜色
     */
    public static int getColor(@ColorRes int id) {
        try {
            return ContextCompat.getColor(AppHolder.getApp(), id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Color.TRANSPARENT
        return Color.TRANSPARENT;
    }

    /**
     * 获取应用内的颜色状态列表
     *
     * @param id
     * @return 应用内的颜色状态列表或只包含单个全透明颜色的颜色状态列表
     */
    public static ColorStateList getColorStateList(@ColorRes int id) {
        try {
            return ContextCompat.getColorStateList(AppHolder.getApp(), id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //A ColorStateList containing a single Color.TRANSPARENT
        return ColorStateList.valueOf(Color.TRANSPARENT);
    }

    /**
     * 获取应用内的Drawable资源
     *
     * @param id
     * @return 应用内的Drawable资源或者应用图标
     */
    public static Drawable getDrawable(@DrawableRes int id) {
        try {
            return ContextCompat.getDrawable(AppHolder.getApp(), id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //if not find drawable resource,then return drawable of R.drawable.bhc_cm_icon_doctor_launcher respect
        return ContextCompat.getDrawable(AppHolder.getApp(), 0);
    }


    public static Typeface getFont(@FontRes int id) {
        try {
            return ResourcesCompat.getFont(AppHolder.getApp(), id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResourcesCompat.getFont(AppHolder.getApp(),0);
    }




}
