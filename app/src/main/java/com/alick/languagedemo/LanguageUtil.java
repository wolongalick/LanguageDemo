package com.alick.languagedemo;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.LocaleList;
import android.util.DisplayMetrics;

import java.util.Locale;

public class LanguageUtil {

    public static Context appContext = AppHolder.getApp();

    /**
     * 更改应用语言
     *
     * @param locale      语言地区
     * @param persistence 是否持久化
     */

    public static void changeAppLanguage(Locale locale, boolean persistence) {
        //获取应用程序的所有资源对象
        Resources resources = AppHolder.getApp().getResources();
        //获取屏幕参数
        DisplayMetrics metrics = resources.getDisplayMetrics();
        //获取设置对象
        Configuration configuration = resources.getConfiguration();
        //如果API < 17
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR1) {
            configuration.locale = locale;
            appContext = AppHolder.getApp();
        } else //如果 17 < = API < 25 Android 7.7.1
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N_MR1) {
                configuration.setLocale(locale);
                appContext = AppHolder.getApp();
            } else {//API 25  Android 7.7.1
                configuration.setLocale(locale);
                configuration.setLocales(new LocaleList(locale));
                appContext = AppHolder.getApp().createConfigurationContext(configuration);
            }
        //更新配置信息
        resources.updateConfiguration(configuration, metrics);
        //持久化
        if (persistence) {
            //存起来
//            SharePreferencesTools.saveObjectToSharePreferences(AppHolder.getApp(), LanguageSwitchConstant.LANGUA_SWITCH_FILE_NAME, LanguageSwitchConstant.LANGUA_SWITCH_SELECTED_KEY,locale);
        }
    }

    /**
     * 获取App当前语言
     * 如果存过信息那么以存的信息为准否则取系统的配置信息为准
     *
     * @Return Locale
     **/
    public static Locale getAppLocale() {
        //读取本地配置文件信息
        Locale currentAppLocale = null;
//        currentAppLocale=(Locale) SharePreferencesTools.readObjectFromSharePreferences(AppHolder.getApp(),LanguageSwitchConstant.LANGUA_SWITCH_FILE_NAME,LanguageSwitchConstant.LANGUA_SWITCH_SELECTED_KEY);
        if (currentAppLocale == null) {
            currentAppLocale = getSystemLocale();
        }
        return currentAppLocale;
    }

    /******
     * 获取当前系统语言
     */
    public static Locale getSystemLocale() {
        Locale currentSystemLocale;
        //API >= 24
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            currentSystemLocale = Resources.getSystem().getConfiguration().getLocales().get(0);
        } else {
            currentSystemLocale = Resources.getSystem().getConfiguration().locale;
        }
        return currentSystemLocale;
    }
}
