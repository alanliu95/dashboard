package com.alan.dashboard;

import com.alan.dashboard.DAO.Mybatis.DeviceMapper;
import com.alan.dashboard.DAO.Mybatis.RecordMapper;
import com.alan.dashboard.DAO.Mybatis.SiteMapper;
import com.alan.dashboard.service.RecordService;
import com.alibaba.fastjson.JSONObject;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DashboardApplicationTests {
    @Autowired
    SiteMapper siteMapper;
    @Autowired
    DeviceMapper deviceMapper;
    @Autowired
    RecordMapper recordMapper;
    @Autowired
    ApplicationContext ioc;
    @Autowired
    RecordService recordService;
    @Autowired
    ObjectMapper objectMapper;
    //@Test
    public void contextLoads() {
//        SysStatus sys=mapper.getOne(3);
//        System.out.println(sys);
        boolean bool=ioc.containsBean("objectMapper");
        System.out.println(bool);
    }

    //@Test
    public void recordTest() {

        boolean bool=ioc.containsBean("recordMapper");
        System.out.println(bool);
    }
    @Test
    public void service() throws Exception {

        //recordService.getSiteAndDev();
        //recordService.setCurr("ubuntu_14th");
        System.out.println(recordService.getRecords("ubuntu_14th"));
        //recordService.getRecords2();
    }
    //@Test
    public void testJson(){
//        List<Integer> l=new ArrayList<>();
//        l.add(1);l.add(2);
//        try {
//            System.out.println(objectMapper.writeValueAsString(l));
//        }catch (Exception e){
//
//        }
        List<JSONObject> list = recordMapper.getTs(1);

//        List<String> ts_list = list.stream().map()

        System.out.println(list);


    }

}
