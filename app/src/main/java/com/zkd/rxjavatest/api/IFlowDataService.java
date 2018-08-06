package com.zkd.rxjavatest.api;

import com.zkd.rxjavatest.model.entity.BaseDataBean;
import com.zkd.rxjavatest.model.entity.FlowDataBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;

public interface IFlowDataService {

    @GET("flow/all")
    Call<BaseDataBean> getAllFlow();

    @GET("flow/all")
    Observable<BaseDataBean<List<FlowDataBean>>> getFlowData();
}
