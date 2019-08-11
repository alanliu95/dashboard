package com.alan.dashboard;

import com.alan.dashboard.DAO.Mybatis.SiteMapper;
import com.alan.dashboard.model.Site;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DaoTest {
    @Test
    public void Hello() {
        System.out.println("Hello,world!");
    }

    @Autowired
    private SiteMapper siteMapper;

    @Test
    public void SiteTest() {
        List<Site> list = siteMapper.getAll();
        System.out.println(list);
    }
}
