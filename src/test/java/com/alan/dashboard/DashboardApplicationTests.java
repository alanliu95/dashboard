package com.alan.dashboard;

import com.alan.dashboard.DAO.Mybatis.SysStatusMapper;
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
    SysStatusMapper mapper;
    @Autowired
    ApplicationContext ioc;

    @Test
    public void contextLoads() {
//        SysStatus sys=mapper.getOne(3);
//        System.out.println(sys);
        boolean bool=ioc.containsBean("objectMapper");
        System.out.println(bool);
    }

}
