package com.yaxon.wuliudriver.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yaxon.wuliudriver.utils.event.BindEventBus;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Description: Fragment 基类
 * Created by kimiffy on 2019/2/13.
 */

public abstract class BaseFragment extends Fragment {
    /**
     * 当前fragment绑定的Activity
     */
    protected Activity mActivity;
    private Unbinder unbinder;
    protected View rootView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (null == rootView) {
            rootView = inflater.inflate(getLayoutResId(), container, false);
        }
        rootView.setClickable(true);//防止点击穿透
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mActivity = getActivity();
        unbinder = ButterKnife.bind(this, view);
        initData(savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initStateView();
        initUI();
        initEventBus();
        setListener();
    }


    /**
     * 获取界面布局id
     *
     * @return 该页面的layout
     */
    protected abstract int getLayoutResId();

    /**
     * 数据初始化
     *
     * @param savedInstanceState 保存的数据
     */
    protected abstract void initData(Bundle savedInstanceState);

    /**
     * 界面初始化
     */
    protected abstract void initUI();

    /**
     * 设置监听
     */
    protected void setListener() {

    }

    /**
     * 初始化状态布局
     */
    protected void initStateView() {

    }


    /**
     * 初始化EventBus
     */
    private void initEventBus() {
        if (this.getClass().isAnnotationPresent(BindEventBus.class)) {
            EventBus.getDefault().register(this);
        }
    }



    @Override
    public void onDestroy() {
        super.onDestroy();
        rootView = null;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        if (this.getClass().isAnnotationPresent(BindEventBus.class)) {
            EventBus.getDefault().unregister(this);
        }
    }


    /**
     * 页面跳转
     *
     * @param clz 要跳转的Activity
     */
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(mActivity, clz));
    }

    /**
     * 页面跳转
     *
     * @param clz    要跳转的Activity
     * @param intent intent
     */
    public void startActivity(Class<?> clz, Intent intent) {
        intent.setClass(mActivity, clz);
        startActivity(intent);
    }

    /**
     * 携带数据的页面跳转
     *
     * @param clz    要跳转的Activity
     * @param bundle 需要传递的数据
     */
    public void startActivity(Class<?> clz, Bundle bundle) {
        Intent intent = new Intent();
        intent.setClass(mActivity, clz);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    /**
     * 页面跳转并要求获取返回结果
     *
     * @param clz         要跳转的Activity
     * @param bundle      bundle数据
     * @param requestCode requestCode
     */
    public void startActivityForResult(Class<?> clz, Bundle bundle, int requestCode) {
        Intent intent = new Intent();
        intent.setClass(mActivity, clz);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, requestCode);
    }
}
