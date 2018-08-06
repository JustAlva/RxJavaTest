package com.zkd.rxjavatest.presenter.callback;

import com.zkd.rxjavatest.model.entity.FlowDataBean;

import java.util.List;
/**
 * describe: 回调接口
 * creator: keding.zhou
 * date: 2018/8/6 16:19
 */
public interface IFlowDataCallBack {
    void onError();
    void onSuccess(List<FlowDataBean> list);
    void onFail();
}
