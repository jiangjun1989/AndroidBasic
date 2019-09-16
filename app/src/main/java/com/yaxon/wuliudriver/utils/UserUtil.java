package com.yaxon.wuliudriver.utils;

/**
 * Description:用户相关工具类
 * Created by kimiffy on 2019/3/6.
 */

public class UserUtil {

    private UserUtil() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /**
     * 用户是否登录了
     *
     * @return 登录状态
     */
    public static boolean isUserLogin() {
//        List<LoginInfo> users = SQLite.select().
//                from(LoginInfo.class).
//                queryList();
        return true;
    }

}
