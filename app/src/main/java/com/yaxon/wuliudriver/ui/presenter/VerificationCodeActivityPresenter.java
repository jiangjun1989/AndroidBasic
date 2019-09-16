package com.yaxon.wuliudriver.ui.presenter;

import com.yaxon.wuliudriver.MainActivity;
import com.yaxon.wuliudriver.base.BaseBean;
import com.yaxon.wuliudriver.base.BasePresenter;
import com.yaxon.wuliudriver.bean.LoginBean;
import com.yaxon.wuliudriver.http.callback.BaseObserver;
import com.yaxon.wuliudriver.http.exception.ErrorType;
import com.yaxon.wuliudriver.ui.activity.VerificationCodeActivity;
import com.yaxon.wuliudriver.ui.contarct.VerificationCodeActivityContract;
import com.yaxon.wuliudriver.utils.PrefsUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:验证登录注册控制层
 * Created by jiangj on 2019/9/13.
 */
public class VerificationCodeActivityPresenter extends BasePresenter<VerificationCodeActivityContract.View> implements VerificationCodeActivityContract.Presenter {

    public VerificationCodeActivityPresenter(VerificationCodeActivityContract.View view) {
        mView = view;
    }

    @Override
    public void login(final String loginName, int mode, String checkCode) {
        // 请求
        Map<String, String> map = new HashMap<>();
        map.put("loginName", loginName);
        map.put("mode", mode + "");
        map.put("checkCode", checkCode);
        addDisposable(mApiService.login(map), new BaseObserver<BaseBean<LoginBean>>() {
            @Override
            public void onSuccess(BaseBean<LoginBean> bean) {
                if (bean.rc == 1) {
                    // 提示信息
                    mView.loginSuccess(bean.errMsg);
                    LoginBean loginBean = bean.data;
                    if (loginBean != null) {
                        // 保存登录返回信息
                        PrefsUtil.setSessionId(loginBean.getSessionId());
                        PrefsUtil.setUserId(loginBean.getUid());
                        PrefsUtil.setUserName(loginName);
                    }
                } else {
                    mView.loginFail(bean.errMsg);
                }
            }

            @Override
            public void onFailure(String msg, ErrorType errorType) {
                mView.loginFail(msg);
            }
        });
    }
}
