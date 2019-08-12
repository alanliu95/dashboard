package com.alan.dashboard.model;

import java.util.List;

public class DeviceMap {
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
}
