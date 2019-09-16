package com.yaxon.wuliudriver.ui.fragment;

import android.os.Bundle;

import com.yaxon.wuliudriver.R;
import com.yaxon.wuliudriver.base.BaseMVPFragment;
import com.yaxon.wuliudriver.base.BasePresenter;

public class OrderFragment extends BaseMVPFragment {

    public static OrderFragment newInstance() {

        Bundle args = new Bundle();

        OrderFragment fragment = new OrderFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_order;
    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }

    @Override
    protected void initUI() {

    }
}
