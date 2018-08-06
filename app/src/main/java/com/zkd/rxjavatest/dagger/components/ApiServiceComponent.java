package com.zkd.rxjavatest.dagger.components;

import com.zkd.rxjavatest.api.IFlowDataService;
import com.zkd.rxjavatest.dagger.modules.ApiServiceModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApiServiceModule.class)
public interface ApiServiceComponent {
    IFlowDataService getFlowDataService();
}
