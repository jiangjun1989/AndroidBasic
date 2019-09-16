package com.yaxon.wuliudriver.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.yaxon.wuliudriver.R;
import com.yaxon.wuliudriver.base.BaseMVPActivity;
import com.yaxon.wuliudriver.ui.contarct.LoginActivityContract;
import com.yaxon.wuliudriver.ui.presenter.LoginActivityPresenter;
import com.yaxon.wuliudriver.utils.ToastUtil;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Description:登录注册
 * Created by jiangj on 2019/9/13.
 */
public class LoginActivity extends BaseMVPActivity<LoginActivityPresenter> implements LoginActivityContract.View {
    @BindView(R.id.et_phone)
    EditText etPhone;
    @BindView(R.id.btn_get_sms)
    Button btnGetSms;

    private String mPhone;

    @Override
    protected LoginActivityPresenter createPresenter() {
        return new LoginActivityPresenter(this);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }

    @Override
    protected void initUI() {

    }

    @Override
    protected String getHeaderTitle() {
        return getString(R.string.login);
    }

    @OnClick({R.id.btn_get_sms})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_get_sms:
                mPhone = etPhone.getText().toString().trim();
                mPresenter.getSms(mPhone);
                break;
        }
    }

    @Override
    public void getSmsSuccess(String msg) {
        ToastUtil.showToast(msg);
        // 跳转到验证页面
        Bundle bundle = new Bundle();
        bundle.putString("phone", mPhone);
        startActivity(VerificationCodeActivity.class);
    }

    @Override
    public void getSmsFail(String errMsg) {
        ToastUtil.showToast(errMsg);
    }
}
