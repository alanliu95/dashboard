package com.alan.dashboard.service;

import com.alan.dashboard.DAO.Mybatis.DeviceMapper;
import com.alan.dashboard.DAO.Mybatis.SiteMapper;
import com.alan.dashboard.model.SiteDevMap;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SiteService {
    private SiteMapper siteMapper;
    private DeviceMapper deviceMapper;
    private ObjectMapper objectMapper;

    @Autowired
    public SiteService(SiteMapper siteMapper, DeviceMapper deviceMapper, ObjectMapper objectMapper) {
        this.siteMapper = siteMapper;
        this.deviceMapper = deviceMapper;
        this.objectMapper = objectMapper;
    }

    /**
     * 返回json字符串，描述场地和设备从属关系，键是site_name,值是 dev_name数组
     *
     * @return
     */
    public List<SiteDevMap> getSiteDevMap() {
        return this.deviceMapper.getMap();
    }
}
