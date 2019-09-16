package com.yaxon.wuliudriver.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.yaxon.wuliudriver.R;
import com.yaxon.wuliudriver.utils.event.BindEventBus;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * Description:基类
 * Created by kimiffy on 2019/2/13.
 */

public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {


    private Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());
        unbinder = ButterKnife.bind(this);
        initData(savedInstanceState);
        initStateView();
        initUI();
        initHeaderTitle();
        initEventBus();
        setListener();
    }

    /**
     * 获取界面布局id
     *
     * @return 该页面的layout
     */
    @LayoutRes
    protected abstract int getLayoutResId();

    /**
     * 数据初始化
     *
     * @param savedInstanceState 保存的状态
     */
    protected abstract void initData(Bundle savedInstanceState);

    /**
     * 视图初始化
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

    @Override
    public void onClick(View v) {

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
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
        if (this.getClass().isAnnotationPresent(BindEventBus.class)) {
            EventBus.getDefault().unregister(this);
        }
    }

    //---------------------------------------公共方法-----------------------------------------------

    /**
     * 页面跳转
     *
     * @param clz 要跳转的Activity
     */
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(this, clz));
    }

    /**
     * 页面跳转
     *
     * @param clz    要跳转的Activity
     * @param intent intent
     */
    public void startActivity(Class<?> clz, Intent intent) {
        intent.setClass(this, clz);
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
        intent.setClass(this, clz);
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
        intent.setClass(this, clz);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, requestCode);
    }

    /**
     * 初始化通用的头部标题(如果使用的是自己写的头部布局请忽略)
     * 头部右侧按钮不够通用,这里不做统一处理 ,子类需要操作右侧按钮重写 getHeaderRightButton即可
     */
    private void initHeaderTitle() {
        String title = getHeaderTitle();
        if ("no_title".equals(title)) {
            return;
        }
        TextView titleTv = findViewById(R.id.title_content_text);
        Button leftIcon = findViewById(R.id.button_left);
        Button rightButton = findViewById(R.id.button_right);
        leftIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        titleTv.setText(title);
        if (hideHeaderBack()) {
            leftIcon.setVisibility(View.GONE);
        }
        getHeaderRightButton(rightButton);
    }

    /**
     * 获取页面通用头部标题,不是采用通用头部的 不用重写
     * 不强制重写 如有需要复写即可
     * 默认返回"no_title",如果是"no_title" 需要具体实现类自己去处理 返回 标题等操作
     *
     * @return 该页面的头部标题
     */
    protected String getHeaderTitle() {
        return "no_title";
    }


    /**
     * 通用头部右侧按钮 子类可重写 对rightbutton 操作
     * 默认是 不可见的 需 rightButton.setVisibility(View.VISIBLE);
     * @param rightButton
     */
    protected void getHeaderRightButton(Button rightButton) {}

    /**
     * 是否隐藏通用头部左侧返回按钮
     *
     * @return
     */
    protected boolean hideHeaderBack() {
        return false;
    }
}
