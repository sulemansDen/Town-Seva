package com.example.suleman.townseva;

/**
 * Created by suleman on 1/7/16.
 */
public class BookingHistoryItem
{

    private  String orderId;
    private String serviceName;
    private String subCategoryName;
    private String subChildCategoryName;
    private String status;


    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getSubCategoryName() {
        return subCategoryName;
    }

    public void setSubCategoryName(String subCategoryName) {
        this.subCategoryName = subCategoryName;
    }

    public String getSubChildCategoryName() {
        return subChildCategoryName;
    }

    public void setSubChildCategoryName(String subChildCategoryName) {
        this.subChildCategoryName = subChildCategoryName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
