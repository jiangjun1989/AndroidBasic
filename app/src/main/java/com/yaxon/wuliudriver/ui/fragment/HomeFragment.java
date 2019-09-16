package com.yaxon.wuliudriver.ui.fragment;

import android.os.Bundle;

import com.yaxon.wuliudriver.R;
import com.yaxon.wuliudriver.base.BaseMVPFragment;
import com.yaxon.wuliudriver.base.BasePresenter;

public class HomeFragment extends BaseMVPFragment {

    public static HomeFragment newInstance() {
        
        Bundle args = new Bundle();
        
        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }

    @Override
    protected void initUI() {

    }
}
