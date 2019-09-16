package com.yaxon.wuliudriver.ui.contarct;

import com.yaxon.wuliudriver.base.contract.IBaseView;
import com.yaxon.wuliudriver.base.contract.IPresenter;
import com.yaxon.wuliudriver.ui.activity.VerificationCodeActivity;

/**
 * Description:验证登录注册契约类
 * Created by jiangj on 2019/9/13.
 */
public class VerificationCodeActivityContract {

    public interface Presenter extends IPresenter<View> {
        // 登录
        void login(String loginName, int mode, String checkCode);
    }

    public interface View extends IBaseView {
        // 登录成功
        void loginSuccess(String msg);
        // 登录失败
        void loginFail(String errMsg);
    }

}
