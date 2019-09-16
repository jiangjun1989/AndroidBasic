package com.yaxon.wuliudriver.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.yaxon.wuliudriver.base.contract.IBaseActivity;

/**
 * Description: mvp Activity 基类
 * Created by kimiffy on 2019/3/11.
 */

public abstract class BaseMVPActivity<P extends BasePresenter> extends BaseActivity implements IBaseActivity {

    /**
     * 具体的presenter由子类确定
     */
    protected P mPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        mPresenter = createPresenter();
        if (null != mPresenter) {
            mPresenter.attach(this);
        }
        super.onCreate(savedInstanceState);
    }

    /**
     * 创建Presenter
     *
     * @return 子类实现具体的Presenter
     */
    protected abstract P createPresenter();



    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (null != mPresenter) {
            mPresenter.detach();
        }

    }



}
