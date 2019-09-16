package com.yaxon.wuliudriver.ui.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.yaxon.wuliudriver.R;
import com.yaxon.wuliudriver.base.BaseMVPFragment;
import com.yaxon.wuliudriver.ui.activity.LoginActivity;
import com.yaxon.wuliudriver.ui.contarct.MineFragmentContract;
import com.yaxon.wuliudriver.ui.presenter.MineFragmentPresenter;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Description:我的消息
 * Created by jiangj on 2019/9/13.
 */
public class MineFragment extends BaseMVPFragment<MineFragmentPresenter> implements MineFragmentContract.View {

    @BindView(R.id.btn_mine_login)
    Button btnMineLogin;

    public static MineFragment newInstance() {

        Bundle args = new Bundle();

        MineFragment fragment = new MineFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }

    @Override
    protected void initUI() {

    }

    @Override
    protected MineFragmentPresenter createPresenter() {
        return new MineFragmentPresenter(this);
    }

    @OnClick({R.id.btn_mine_login})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_mine_login:
                startActivity(LoginActivity.class);
                break;
        }
    }
}
