package com.yaxon.wuliudriver.ui.fragment;

import android.os.Bundle;

import com.yaxon.wuliudriver.R;
import com.yaxon.wuliudriver.base.BaseMVPFragment;
import com.yaxon.wuliudriver.base.BasePresenter;

public class DeliveryFragment extends BaseMVPFragment {

    public static DeliveryFragment newInstance() {

        Bundle args = new Bundle();

        DeliveryFragment fragment = new DeliveryFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_delivery;
    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }

    @Override
    protected void initUI() {

    }
}
