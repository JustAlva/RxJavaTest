package com.zkd.rxjavatest.dagger.components;

import com.zkd.rxjavatest.dagger.modules.FlowDataModule;
import com.zkd.rxjavatest.dagger.scopes.UserScope;
import com.zkd.rxjavatest.view.activity.FlowDataActivity;

import dagger.Component;
@UserScope
@Component(modules = FlowDataModule.class,dependencies = ApiServiceComponent.class)
public interface FlowDataComponent {
    void inject(FlowDataActivity flowDataActivity);
}
