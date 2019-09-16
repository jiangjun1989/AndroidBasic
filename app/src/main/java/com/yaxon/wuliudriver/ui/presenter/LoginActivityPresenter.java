package com.yaxon.wuliudriver.ui.presenter;

import android.os.Bundle;

import com.yaxon.wuliudriver.R;
import com.yaxon.wuliudriver.app.MyApplication;
import com.yaxon.wuliudriver.base.BaseBean;
import com.yaxon.wuliudriver.base.BasePresenter;
import com.yaxon.wuliudriver.http.callback.BaseObserver;
import com.yaxon.wuliudriver.http.exception.ErrorType;
import com.yaxon.wuliudriver.ui.activity.LoginActivity;
import com.yaxon.wuliudriver.ui.activity.VerificationCodeActivity;
import com.yaxon.wuliudriver.ui.contarct.LoginActivityContract;
import com.yaxon.wuliudriver.utils.MatcherUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:登录注册控制层
 * Created by jiangj on 2019/9/13.
 */
public class LoginActivityPresenter extends BasePresenter<LoginActivityContract.View> implements LoginActivityContract.Presenter {

    public LoginActivityPresenter(LoginActivityContract.View view) {
        mView = view;
    }

    @Override
    public void getSms(final String name) {
        if (!MatcherUtils.isMobileNO(name)) {
            mView.getSmsFail(MyApplication.getInstance().getApplicationContext().getResources().getString(R.string.input_phone));
            return;
        }
        // 请求
        Map<String, String> map = new HashMap<>();
        map.put("sim", name);
        map.put("opType", "2");
        addDisposable(mApiService.getSms(map), new BaseObserver<BaseBean>() {
            @Override
            public void onSuccess(BaseBean bean) {
                if (bean.rc == 1) {
                    mView.getSmsSuccess(bean.errMsg);
                } else {
                    mView.getSmsFail(bean.errMsg);
                }
            }

            @Override
            public void onFailure(String msg, ErrorType errorType) {
                mView.getSmsFail(msg);
            }
        });
    }
}
