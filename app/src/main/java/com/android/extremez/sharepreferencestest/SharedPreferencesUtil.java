//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.android.extremez.sharepreferencestest;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;

public class SharedPreferencesUtil {
    static final String SHARED_PREFERENCE = "seeyou_pref";
    private static SharedPreferences sSharedPreferences;
    private static Editor sEditor;

    public SharedPreferencesUtil() {
    }

    public static SharedPreferences getSharedPreference(Context context) {
        try {
            Class var1 = SharedPreferences.class;
            synchronized(SharedPreferences.class) {
                if(sSharedPreferences == null) {
                    sSharedPreferences = context.getSharedPreferences("seeyou_pref", 0);
                }
            }
        } catch (Exception var4) {
            var4.printStackTrace();
        }

        return sSharedPreferences;
    }

    private static Editor getEditor(Context context) {
        if(sEditor == null) {
            sEditor = getSharedPreference(context).edit();
        }

        return sEditor;
    }

    public static void saveString(String key, String content, Context context) {
        getEditor(context).putString(key, content);
        getEditor(context).apply();
    }

    public static void saveString(int key_resID, String content, Context context) {
        String name = context.getResources().getString(key_resID);
        saveString(name, content, context);
    }

    public static String getString(int resId, Context context) {
        return getSharedPreference(context).getString(context.getString(resId), (String)null);
    }

    public static String getString(String key, Context context) {
        return context == null?"":getSharedPreference(context).getString(key, "");
    }

    public static void saveInt(int key_resID, int content, Context context) {
        String name = context.getResources().getString(key_resID);
        saveInt(name, content, context);
    }

    public static void saveInt(String name, int content, Context context) {
        getEditor(context).putInt(name, content);
        getEditor(context).apply();
    }

    public static int getInt(String name, Context context, int def) {
        return getSharedPreference(context).getInt(name, def);
    }

    public static long getLong(String name, Context context, long def) {
        return getSharedPreference(context).getLong(name, def);
    }

    public static void saveLong(String name, Context context, long value) {
        getEditor(context).putLong(name, value);
        getEditor(context).apply();
    }

    public static void saveBoolean(Context context, String name, boolean vaule) {
        getEditor(context).putBoolean(name, vaule);
        getEditor(context).apply();
    }

    public static void saveBoolean(Context context, int resId, boolean vaule) {
        saveBoolean(context, context.getString(resId), vaule);
    }

    public static boolean getBoolean(Context context, String key, boolean def) {
        return getSharedPreference(context).getBoolean(key, def);
    }

    public static boolean getBoolean(Context context, int resId, boolean def) {
        return getBoolean(context, context.getString(resId), def);
    }

    public static boolean containKey(Context context, String key) {
        return getSharedPreference(context).contains(key);
    }

    public static void registerOnSharedPreferenceChangeListener(Context context, OnSharedPreferenceChangeListener listener) {
        getSharedPreference(context).registerOnSharedPreferenceChangeListener(listener);
    }

    public static void unregisterOnSharedPreferenceChangeListener(Context context, OnSharedPreferenceChangeListener listener) {
        getSharedPreference(context).unregisterOnSharedPreferenceChangeListener(listener);
    }
}
