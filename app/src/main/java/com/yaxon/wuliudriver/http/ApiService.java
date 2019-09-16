package com.yaxon.wuliudriver.http;

import com.yaxon.wuliudriver.base.BaseBean;
import com.yaxon.wuliudriver.bean.LoginBean;
import com.yaxon.wuliudriver.utils.AppUtils;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Description: api 接口
 * Created by kimiffy on 2019/2/25.
 */

public interface ApiService {

    /**
     * 正式服务器地址
     */
    String SERVER_ADDRESS_RELEASE = "http://10.0.2.2:8082/";

    /**
     * 测试服务器地址
     */
    String SERVER_ADDRESS_DEBUG = "http://10.0.2.2:8082/";

    /**
     * 服务器地址
     */
    String SERVER_ADDRESS = AppUtils.isDebug() ? SERVER_ADDRESS_DEBUG : SERVER_ADDRESS_RELEASE;


    /**
     * 获取验证码
     */
    @POST("sendSMSCheckCode.do")
    Observable<BaseBean> getSms(@Body Map<String, String> map);

    /**
     * 登录
     */
    @POST("login.do")
    Observable<BaseBean<LoginBean>> login(@Body Map<String, String> map);

}
