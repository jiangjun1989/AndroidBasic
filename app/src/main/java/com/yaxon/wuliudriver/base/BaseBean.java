package com.yaxon.wuliudriver.base;

/**
 * Description:请求数据包装类
 * Created by kimiffy on 2019/3/12.
 */

public class BaseBean<T>{

    // TODO: 2019/3/12 需根据服务器返回数据封装这个包装类
    /**
     * 自定义错误码
     */
    public int rc;
    /**
     * 消息提示
     */
    public String errMsg;

    /**
     * 泛型实体类
     */
    public T data;
}
