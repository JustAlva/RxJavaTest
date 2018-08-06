package com.zkd.rxjavatest.dagger.modules;

import com.zkd.rxjavatest.presenter.callback.IFlowDataCallBack;

import dagger.Module;
import dagger.Provides;

@Module
public class FlowDataModule {
    private IFlowDataCallBack callBack;

    public FlowDataModule(IFlowDataCallBack callBack) {
        this.callBack = callBack;
    }
    @Provides
    public IFlowDataCallBack provideFlowDataCallBack(){
        return callBack;
    }
}
