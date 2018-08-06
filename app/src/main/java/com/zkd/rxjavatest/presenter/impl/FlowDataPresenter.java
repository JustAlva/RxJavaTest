package com.zkd.rxjavatest.presenter.impl;

import com.zkd.rxjavatest.api.IFlowDataService;
import com.zkd.rxjavatest.model.entity.BaseDataBean;
import com.zkd.rxjavatest.model.entity.FlowDataBean;
import com.zkd.rxjavatest.presenter.IFlowDataPresenter;
import com.zkd.rxjavatest.presenter.callback.IFlowDataCallBack;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
/**
 * describe: 业务逻辑层 
 * creator: keding.zhou
 * date: 2018/8/6 16:05
 */
public class FlowDataPresenter implements IFlowDataPresenter {

    private IFlowDataCallBack callback;
    private IFlowDataService api;

    @Inject
    public FlowDataPresenter(IFlowDataCallBack callback, IFlowDataService api) {
        this.callback = callback;
        this.api = api;
    }

    @Override
    public void getFlowAllData() {
        api.getFlowData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseDataBean<List<FlowDataBean>>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BaseDataBean<List<FlowDataBean>> baseDataBean) {
                        if (baseDataBean.isSuccess()) {
                            //成功
                            callback.onSuccess(baseDataBean.getData());
                        }else{
                            callback.onFail();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onError();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
