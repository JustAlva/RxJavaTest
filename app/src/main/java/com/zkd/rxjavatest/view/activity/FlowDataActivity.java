package com.zkd.rxjavatest.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.zkd.rxjavatest.R;
import com.zkd.rxjavatest.dagger.components.DaggerFlowDataComponent;
import com.zkd.rxjavatest.dagger.modules.FlowDataModule;
import com.zkd.rxjavatest.model.entity.FlowDataBean;
import com.zkd.rxjavatest.presenter.callback.IFlowDataCallBack;
import com.zkd.rxjavatest.presenter.impl.FlowDataPresenter;
import com.zkd.rxjavatest.utils.base.BaseActivity;
import com.zkd.rxjavatest.view.adapter.FlowDataAdapter;
import com.zkd.rxjavatest.view.application.MyApplication;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FlowDataActivity extends BaseActivity implements IFlowDataCallBack {


    @BindView(R.id.rv_flow_data)
    RecyclerView rvFlowData;

    @Inject
    FlowDataPresenter flowDataPresenter;
    FlowDataAdapter mAdapter;
    private List<FlowDataBean> mList = new ArrayList<>();
    /**
     * 设置主布局文件
     */
    @Override

    protected void setContentView(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_flow_data);
        ButterKnife.bind(this);
    }

    /**
     * 初始化数据
     */
    @Override
    protected void initData() {
        DaggerFlowDataComponent.builder().
                flowDataModule(new FlowDataModule(this))
                .apiServiceComponent(MyApplication.get(this).getApiComponent())
                .build()
                .inject(this);
        mAdapter = new FlowDataAdapter(FlowDataActivity.this, mList);
        rvFlowData.setLayoutManager(new LinearLayoutManager(this));
        rvFlowData.setAdapter(mAdapter);
        flowDataPresenter.getFlowAllData();
    }

    /**
     * 初始化布局
     */
    @Override
    protected void initView() {

    }

    @Override
    public void onError() {
        showToast("报错");
    }

    @Override
    public void onSuccess(List<FlowDataBean> list) {
        mAdapter.addAll(list);
    }

    @Override
    public void onFail() {
        showToast("获取失败");
    }
}
