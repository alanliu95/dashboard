package com.alan.dashboard.service;

import com.alan.dashboard.DAO.Mybatis.DeviceMapper;
import com.alan.dashboard.DAO.Mybatis.RecordMapper;
import com.alan.dashboard.DAO.Mybatis.SiteMapper;
import com.alan.dashboard.model.Device;
import com.alan.dashboard.model.Record;
import com.alan.dashboard.model.Site;
import com.alan.dashboard.utils.model.RecJson;
import com.alibaba.fastjson.JSONObject;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class RecordService {
    private SiteMapper siteMapper;
    private DeviceMapper deviceMapper;
    private RecordMapper recordMapper;
    @Autowired
    private ObjectMapper jsonMapper;
    private int currSite;
    private int currDev;
    @Autowired
    public RecordService(SiteMapper siteMapper, DeviceMapper deviceMapper, RecordMapper recordMapper) {
        this.siteMapper = siteMapper;
        this.deviceMapper = deviceMapper;
        this.recordMapper = recordMapper;
    }
    public String getSiteAndDev()throws Exception{
        Map<String,List<String>> map=new HashMap<>();
        for(Site site : siteMapper.getAll()){
            List<String> devs=new ArrayList<>();
            for(Device dev : deviceMapper.getRowsBySite(site.getId()))
                devs.add(dev.getName());
            map.put(site.getName(),devs);
        }
        String json=jsonMapper.writeValueAsString(map);
        System.out.println(json);
        return json;
    }

    public void setCurr(String devName){
        Device d=deviceMapper.getOneByName(devName);
        this.currDev=d.getId();
    }
    public String getRecords() throws Exception{
        List<Record> recList=recordMapper.getRowsByDevice(this.currDev);
        RecJson recJson=new RecJson();
        recJson.ts = recList.stream().map(Record::getTs).collect(Collectors.toList());
        recJson.cpu = recList.stream().map(Record::getCpu).collect(Collectors.toList());
        recJson.mem = recList.stream().map(Record::getMem).collect(Collectors.toList());
        return jsonMapper.writeValueAsString(recJson);
    }

    public String getRecords2() throws Exception{
        List<JSONObject> recList=recordMapper.getTs(this.currDev);
        //RecJson recJson=
        for(JSONObject j : recList){
            System.out.println(j);

        }
        return jsonMapper.writeValueAsString(recList);
    }

}
