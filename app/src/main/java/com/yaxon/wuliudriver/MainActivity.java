package com.yaxon.wuliudriver;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;


import com.yaxon.wuliudriver.base.BaseActivity;
import com.yaxon.wuliudriver.constant.Key;
import com.yaxon.wuliudriver.ui.fragment.DeliveryFragment;
import com.yaxon.wuliudriver.ui.fragment.HomeFragment;
import com.yaxon.wuliudriver.ui.fragment.MessageFragment;
import com.yaxon.wuliudriver.ui.fragment.MineFragment;
import com.yaxon.wuliudriver.ui.fragment.OrderFragment;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * Description: 主页面
 * Created by kimiffy on 2019/8/16.
 */

public class MainActivity extends BaseActivity {

    @BindView(R.id.btn_main_menu_tab1)
    Button mBtnMainMenuTab1;
    @BindView(R.id.btn_main_menu_tab2)
    Button mBtnMainMenuTab2;
    @BindView(R.id.btn_main_menu_tab3)
    Button mBtnMainMenuTab3;
    @BindView(R.id.btn_main_menu_tab4)
    Button mBtnMainMenuTab4;
    @BindView(R.id.btn_main_menu_tab5)
    Button mBtnMainMenuTab5;
    private final int TAB_SIZE = 5;
    private Fragment[] mFragments = new Fragment[TAB_SIZE];
    private Button[] mTabs = new Button[TAB_SIZE];
    private String[] mFragmentTags = {"MainTag0", "MainTag1", "MainTag2", "MainTag3", "MainTag4"};
    private int lastIndex;//记录上一次选中的下标

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        //通过tag恢复保存的fragment  防止fragment重影
        if (savedInstanceState != null) {
            for (int i = 0; i < TAB_SIZE; i++) {
                Fragment fragment = getSupportFragmentManager().getFragment(savedInstanceState, mFragmentTags[i]);
                if (null != fragment) {
                    mFragments[i] = fragment;
                }
            }
            lastIndex = savedInstanceState.getInt(Key.BUNDLE_STATE_LAST_INDEX, 0);
        }
        mTabs[0] = mBtnMainMenuTab1;
        mTabs[1] = mBtnMainMenuTab2;
        mTabs[2] = mBtnMainMenuTab3;
        mTabs[3] = mBtnMainMenuTab4;
        mTabs[4] = mBtnMainMenuTab5;

    }

    @Override
    protected void initUI() {
        setSelectedTab(lastIndex);
    }

    @OnClick({R.id.btn_main_menu_tab1, R.id.btn_main_menu_tab2, R.id.btn_main_menu_tab3, R.id.btn_main_menu_tab4, R.id.btn_main_menu_tab5})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_main_menu_tab1:
                setSelectedTab(0);
                break;
            case R.id.btn_main_menu_tab2:
                setSelectedTab(1);
                break;
            case R.id.btn_main_menu_tab3:
                setSelectedTab(2);
                break;
            case R.id.btn_main_menu_tab4:
                setSelectedTab(3);
                break;
            case R.id.btn_main_menu_tab5:
                setSelectedTab(4);
                break;
        }
    }

    /**
     * 选择显示Fragment
     *
     * @param position 下标
     */
    private void setSelectedTab(int position) {
        mTabs[lastIndex].setSelected(false);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        for (Fragment fragment : mFragments) {
            if (null != fragment) {
                ft.hide(fragment);
            }
        }
        Fragment fragment = mFragments[position];
        if (null == fragment) {
            mFragments[position] = createFragment(position);
            ft.add(R.id.fl_content, mFragments[position]);
        } else {
            ft.show(fragment);
        }
        lastIndex = position;
        mTabs[lastIndex].setSelected(true);
        ft.commit();
    }

    /**
     * 实例化Fragment
     *
     * @param position 下标
     * @return fragment
     */
    private Fragment createFragment(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = HomeFragment.newInstance();
                break;
            case 1:
                fragment = DeliveryFragment.newInstance();
                break;
            case 2:
                fragment = OrderFragment.newInstance();
                break;
            case 3:
                fragment = MessageFragment.newInstance();
                break;
            case 4:
                fragment = MineFragment.newInstance();
                break;
        }
        return fragment;
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        //保存已经添加到FragmentManager的fragment
        for (int i = 0; i < TAB_SIZE; i++) {
            if (null != mFragments[i] && mFragments[i].isAdded()) {
                getSupportFragmentManager().putFragment(outState, mFragmentTags[i], mFragments[i]);
            }
        }
        outState.putInt(Key.BUNDLE_STATE_LAST_INDEX, lastIndex);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mFragments = null;
    }
}
