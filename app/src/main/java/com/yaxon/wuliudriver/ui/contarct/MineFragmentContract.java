package com.yaxon.wuliudriver.ui.contarct;

import com.yaxon.wuliudriver.base.contract.IBaseView;
import com.yaxon.wuliudriver.base.contract.IPresenter;
import com.yaxon.wuliudriver.ui.fragment.MineFragment;

/**
 * Description:我的消息契约类
 * Created by jiangj on 2019/9/13.
 */
public class MineFragmentContract {

    public interface Presenter extends IPresenter<View> {
    }

    public interface View extends IBaseView {
    }

}
