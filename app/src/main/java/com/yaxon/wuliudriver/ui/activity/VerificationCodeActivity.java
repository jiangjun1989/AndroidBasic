package com.yaxon.wuliudriver.ui.activity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.yaxon.wuliudriver.MainActivity;
import com.yaxon.wuliudriver.R;
import com.yaxon.wuliudriver.base.BaseMVPActivity;
import com.yaxon.wuliudriver.ui.contarct.VerificationCodeActivityContract;
import com.yaxon.wuliudriver.ui.presenter.VerificationCodeActivityPresenter;
import com.yaxon.wuliudriver.utils.ToastUtil;
import com.yaxon.wuliudriver.widget.verificationcodeview.VerificationCodeView;

import butterknife.BindView;

/**
 * Description:验证登录注册
 * Created by jiangj on 2019/9/13.
 */
public class VerificationCodeActivity extends BaseMVPActivity<VerificationCodeActivityPresenter> implements VerificationCodeActivityContract.View {

    @BindView(R.id.tv_2)
    TextView tv2;
    @BindView(R.id.verification_code_view)
    VerificationCodeView verificationCodeView;

    private String mPhone;

    @Override
    protected VerificationCodeActivityPresenter createPresenter() {
        return new VerificationCodeActivityPresenter(this);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_verification_code;
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        mPhone = getIntent().getStringExtra("phone");
    }

    @Override
    protected void initUI() {
        tv2.setText("验证码已发送到您的手机"+mPhone);
        verificationCodeView.setEtNumber(6);
        EditText editText = verificationCodeView.getEditText();
        editText.setFocusable(true);
        editText.setFocusableInTouchMode(true);
        editText.requestFocus();
    }

    @Override
    protected void setListener() {
        verificationCodeView.setInputCompleteListener(new VerificationCodeView.InputCompleteListener() {
            @Override
            public void inputComplete() {
                int etNumber = verificationCodeView.getEtNumber();
                String code = verificationCodeView.getInputContent();
                if(code.length()==etNumber){
                    mPresenter.login(mPhone,1,code);
                }
            }

            @Override
            public void deleteContent() {

            }
        });
    }

    @Override
    public void loginSuccess(String msg) {
        ToastUtil.showToast(msg);
        // 跳转主页面
        startActivity(MainActivity.class);
        finish();
    }

    @Override
    public void loginFail(String errMsg) {
        ToastUtil.showToast(errMsg);
    }
}
