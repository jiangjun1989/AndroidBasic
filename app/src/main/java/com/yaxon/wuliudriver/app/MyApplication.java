package com.yaxon.wuliudriver.app;

import android.app.Application;
import android.content.Context;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.yaxon.wuliudriver.constant.Config;
import com.yaxon.wuliudriver.utils.AppUtils;
import com.yaxon.wuliudriver.utils.PrefsUtil;

/**
 * Description:
 * Created by kimiffy on 2019/2/25.
 */

public class MyApplication extends Application {

    private static MyApplication myApplication;
    private static Context mAppContext;

    @Override
    public void onCreate() {
        super.onCreate();
        myApplication = this;
        mAppContext = getApplicationContext();
        init();
    }

    /**
     * 初始化
     */
    private void init() {
        initDBFlow();
        Logger.addLogAdapter(new AndroidLogAdapter());
        AppUtils.syncIsDebug(getApplicationContext());
        // 初始化本地缓存
        PrefsUtil.init(mAppContext, Config.SP_NAME);
    }


    /**
     * 数据库初始化
     */
    private void initDBFlow() {
    }

    public static MyApplication getInstance() {
        return myApplication;
    }


}
