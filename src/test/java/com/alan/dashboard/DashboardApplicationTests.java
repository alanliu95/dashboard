package com.alan.dashboard;

import com.alan.dashboard.DAO.Mybatis.DeviceMapper;
import com.alan.dashboard.DAO.Mybatis.RecordMapper;
import com.alan.dashboard.DAO.Mybatis.SiteMapper;
import com.alan.dashboard.service.RecordService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

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
    //@Test
    public void contextLoads() {
//        SysStatus sys=mapper.getOne(3);
//        System.out.println(sys);
        boolean bool=ioc.containsBean("objectMapper");
        System.out.println(bool);
    }

    @Test
    public void recordTest() {

        boolean bool=ioc.containsBean("recordMapper");
        System.out.println(bool);
    }
    @Test
    public void service() throws Exception {

        //recordService.getSiteAndDev();
        recordService.setCurr(1);
        System.out.println(recordService.getRecords());
    }

}
