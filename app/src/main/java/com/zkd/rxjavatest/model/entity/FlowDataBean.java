package com.zkd.rxjavatest.model.entity;

public class FlowDataBean {
    private String id ;
    private String status;
    private String flowId;
    private String flowName;
    private String flowJson;
    private String createUser;
    private String createDate;

    public FlowDataBean(String id, String status, String flowId, String flowName, String flowJson, String createUser, String createDate) {
        this.id = id;
        this.status = status;
        this.flowId = flowId;
        this.flowName = flowName;
        this.flowJson = flowJson;
        this.createUser = createUser;
        this.createDate = createDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFlowId() {
        return flowId;
    }

    public void setFlowId(String flowId) {
        this.flowId = flowId;
    }

    public String getFlowName() {
        return flowName;
    }

    public void setFlowName(String flowName) {
        this.flowName = flowName;
    }

    public String getFlowJson() {
        return flowJson;
    }

    public void setFlowJson(String flowJson) {
        this.flowJson = flowJson;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
}
