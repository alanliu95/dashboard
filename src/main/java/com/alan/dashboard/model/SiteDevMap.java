package com.alan.dashboard.model;

import java.util.List;

public class SiteDevMap {
    private int siteId;
    private String siteName;
    List<Device> deviceList;

    public void setSiteId(int siteId) {
        this.siteId = siteId;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public void setDeviceList(List<Device> deviceList) {
        this.deviceList = deviceList;
    }

    @Override
    public String toString() {
        return "SiteDevMap{" +
                "siteId=" + siteId +
                ", siteName='" + siteName + '\'' +
                ", deviceList=" + deviceList +
                '}';
    }
}
