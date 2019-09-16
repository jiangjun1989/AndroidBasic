package com.yaxon.wuliudriver.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.yaxon.wuliudriver.base.contract.IBaseFragment;


/**
 * Description:
 * Created by kimiffy on 2019/3/12.
 */

public abstract class BaseMVPFragment<P extends BasePresenter> extends BaseFragment implements IBaseFragment {

    /**
     * 具体的presenter由子类确定
     */
    protected P mPresenter;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mPresenter = createPresenter();
        if (mPresenter != null) {
            mPresenter.attach(this);
        }
        super.onViewCreated(view, savedInstanceState);
    }

    /**
     * 创建Presenter
     */
    protected abstract P createPresenter();



    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detach();
        }
    }


    /**
     * 获取当前绑定的activity
     *
     * @return 当前绑定的activity
     */
    @Override
    public Activity getBindActivity() {
        return mActivity;
    }




}
