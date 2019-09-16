package com.yaxon.wuliudriver.ui.contarct;

import com.yaxon.wuliudriver.base.contract.IBaseView;
import com.yaxon.wuliudriver.base.contract.IPresenter;
import com.yaxon.wuliudriver.ui.activity.LoginActivity;

/**
 * Description:登录注册契约类
 * Created by jiangj on 2019/9/13.
 */
public class LoginActivityContract {

    public interface Presenter extends IPresenter<View> {
        // 获取验证码
        void getSms(String name);
    }

    public interface View extends IBaseView {
        // 获取验证码成功
        void getSmsSuccess(String msg);
        // 获取验证码失败
        void getSmsFail(String errMsg);
    }

}
