package com.zkd.rxjavatest.model.entity;

import android.text.TextUtils;

import java.util.List;
/**
 * describe: 网络请求返回 数据结构
 * creator: keding.zhou
 * date: 2018/8/6 16:17
 */
public class   BaseDataBean <T>{
    private String status;
    private T data;
    private String msg;

    public BaseDataBean(String status,T data, String msg) {
        this.status = status;
        this.data = data;
        this.msg = msg;
    }
    //是否成功
    public boolean isSuccess() {
        if (TextUtils.equals(this.status, "200")) {
            return true;
        }else{
            return false;
        }
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
