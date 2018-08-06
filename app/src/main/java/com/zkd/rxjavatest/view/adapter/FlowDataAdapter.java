package com.zkd.rxjavatest.view.adapter;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.zkd.rxjavatest.R;
import com.zkd.rxjavatest.model.entity.FlowDataBean;

import java.util.List;

public class FlowDataAdapter extends RecyclerArrayAdapter<FlowDataBean> {
    /**
     * Constructor
     *
     * @param context The current context.
     * @param objects The objects to represent in the ListView.
     */
    public FlowDataAdapter(Context context, List<FlowDataBean> objects) {
        super(context, objects);
    }


    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyFlowDataViewHolder(parent, R.layout.item_flow_data);
    }

    private class MyFlowDataViewHolder extends BaseViewHolder<FlowDataBean> {
        private TextView tvCreateDate;
        private TextView tvName;
        private TextView tvCreateUser;
        MyFlowDataViewHolder(ViewGroup parent, int res) {
            super(parent, res);
            tvCreateDate = $(R.id.tv_item_flow_data_create_date);
            tvName = $(R.id.tv_item_flow_data_name);
            tvCreateUser = $(R.id.tv_item_flow_data_create_user);
        }

        @Override
        public void setData(FlowDataBean data) {
            super.setData(data);
            if (data!=null) {
                String date = data.getCreateDate();
                String name = data.getFlowName();
                String user = data.getCreateUser();
                tvCreateDate.setText(date);
                tvName.setText(name);
                tvCreateUser.setText(user);
            }
        }
    }
}
