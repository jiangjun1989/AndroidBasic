package com.yaxon.wuliudriver.ui.presenter;

import com.yaxon.wuliudriver.base.BasePresenter;
import com.yaxon.wuliudriver.ui.activity.LoginActivity;
import com.yaxon.wuliudriver.ui.contarct.MineFragmentContract;
import com.yaxon.wuliudriver.ui.fragment.MineFragment;

/**
 * Description:我的消息控制层
 * Created by jiangj on 2019/9/13.
 */
public class MineFragmentPresenter extends BasePresenter<MineFragmentContract.View> implements MineFragmentContract.Presenter {

    public MineFragmentPresenter(MineFragmentContract.View view) {
        mView = view;
    }
}
