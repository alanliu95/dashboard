package com.alan.dashboard.service;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SiteServiceTest {
    @Autowired
    private SiteService siteService;

    //    @Autowired
//    private ObjectMapper objectMapper;
    @Test
    public void siteDevMapTest() throws Exception {

        System.out.println(siteService.getSiteDevMap());
    }
}
