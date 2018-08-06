package com.zkd.rxjavatest.view.application;

import android.app.Application;
import android.content.Context;

import com.zkd.rxjavatest.dagger.components.ApiServiceComponent;
import com.zkd.rxjavatest.dagger.components.DaggerApiServiceComponent;
import com.zkd.rxjavatest.dagger.modules.ApiServiceModule;

public class MyApplication extends Application {

    private ApiServiceComponent apiComponent;

    public static MyApplication get(Context context){
        return (MyApplication)context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initApi();

    }

    private void initApi() {
        apiComponent = DaggerApiServiceComponent.builder()
                .apiServiceModule(new ApiServiceModule())
                .build();
    }

    public ApiServiceComponent getApiComponent() {
        return apiComponent;
    }
}
