package com.zkd.rxjavatest.utils.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ViewStub;
import android.widget.TextView;
import android.widget.Toast;

import com.zkd.rxjavatest.R;
import com.zkd.rxjavatest.presenter.impl.FlowDataPresenter;

import javax.inject.Inject;

import okhttp3.Call;

public abstract class BaseActivity extends AppCompatActivity {
    protected Context mContext;
    private String TAG_APP_NAME = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            setConfigs();
            setContentView(savedInstanceState);
            mContext = this;
            TAG_APP_NAME = getResources().getString(R.string.app_name);
            initData();
            initView();

        } catch (Exception e) {
            Log.e(TAG_APP_NAME, this.getLocalClassName() + ":" + e.toString());
        }
    }

    /**
     * 设置属性
     */
    protected void setConfigs() {
        //隐藏标题栏
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

    }

    /**
     * 标题栏相关设置
     *
     * @param tvTopbarTitle 标题TextView
     * @param title         标题
     * @param isCanBack     是否有返回键
     * @param vsTopbarBack  返回键 ViewStub
     */
    protected void setTopBarTitle(TextView tvTopbarTitle, String title, boolean isCanBack, ViewStub vsTopbarBack) {
        //设置标题


    }

    /**
     * 设置主布局文件
     */
    protected abstract void setContentView(@Nullable Bundle savedInstanceState);

    /**
     * 初始化数据
     */
    protected abstract void initData();

    /**
     * 初始化布局
     */
    protected abstract void initView();


    /**
     * @param text 显示内容
     * @param <T> 类型
     */
    protected <T> void showToast(T text) {
        if (null != text) {
            Toast.makeText(this, text + "", Toast.LENGTH_SHORT).show();
        } else {
            Log.e(TAG_APP_NAME,  "Toast值不能为空！");
        }
    }





}
