package com.yaxon.wuliudriver.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.yaxon.wuliudriver.constant.Config;
import com.yaxon.wuliudriver.constant.Key;

import java.io.File;
/**
 * Description: 本地缓存工具类
 * Created by jiangj on 2019/9/8.
 */
public class PrefsUtil {
    private static final String TAG = PrefsUtil.class.getSimpleName();
    private static SharedPreferences mPrefsSys = null;
    private static SharedPreferences.Editor mEditorSys = null;

    /**
     * 获取系统参数Preferences,
     *
     * @param context
     * @param prefersname
     */
    public static void init(Context context, String prefersname) {
        mPrefsSys = context.getSharedPreferences(prefersname, Context.MODE_PRIVATE);
        mEditorSys = mPrefsSys.edit();
    }
    /**
     * 删除文件
     */
    public static void delPrefsSysFile() {
        String mPath = File.separator + "data" + File.separator + "data"
                + File.separator + "com.yaxon.wuliudriver" + File.separator
                + "shared_prefs" + File.separator + Config.SP_NAME + ".xml";
        File file = new File(mPath);
        if (file.exists()) {
            file.delete();
        }
    }
    /**
     * 清除所有数据
     */
    public static void clearPrefsSysData() {
        if (mEditorSys != null) {
            mEditorSys.clear().commit();
        }
    }
    /**
     * 提交保存字符串
     *
     * @param value
     */
    private static void editCommit(String value) {
        if (!mEditorSys.commit()) {
            if (AppUtils.isDebug()) {
                LogUtil.w(TAG, "fail to save" + value);
            }
        }
    }
    /**
     * 提交保存整数值
     *
     * @param value
     */
    private static void editCommit(int value) {
        if (!mEditorSys.commit()) {
            if (AppUtils.isDebug()) {
                LogUtil.w(TAG, "fail to save" + value);
            }
        }
    }
    /**
     * 提交保存整数值
     *
     * @param value
     */
    private static void editCommit(long value) {
        if (!mEditorSys.commit()) {
            if (AppUtils.isDebug()) {
                LogUtil.w(TAG, "fail to save" + value);
            }
        }
    }
    /**
     * 提交保存布尔值
     *
     * @param value
     */
    private static void editCommit(boolean value) {
        if (!mEditorSys.commit()) {
            if (AppUtils.isDebug()) {
                LogUtil.w(TAG, "fail to save" + value);
            }
        }
    }

    /**
     * 会话ID
     *
     * @return
     */
    public static String getSessionId() {
        return mPrefsSys.getString(Key.PREFERENCES_SESSION_ID, "");
    }

    public static void setSessionId(String sessionId) {
        mEditorSys.putString(Key.PREFERENCES_SESSION_ID, sessionId);
        editCommit(sessionId);
    }

    /**
     * 设置用户ID
     *
     */
    public static int getUserId() {
        return mPrefsSys.getInt(Key.PREFERENCES_USER_ID, 0);
    }

    public static void setUserId(int value) {
        mEditorSys.putInt(Key.PREFERENCES_USER_ID, value);
        editCommit(value);
    }

    /**
     * 登录用户名  （用户名或手机号）
     *
     * @param value
     */
    public static void setUserName(String value) {
        mEditorSys.putString(Key.PREFERENCES_USER_NAME, value);
        editCommit(value);
    }

    public static String getUserName() {
        return mPrefsSys.getString(Key.PREFERENCES_USER_NAME, "");
    }
}
