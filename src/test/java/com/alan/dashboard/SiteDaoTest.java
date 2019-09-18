package com.alan.dashboard;

import com.alan.dashboard.DAO.Mybatis.SiteMapper;
import com.alan.dashboard.model.Site;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SiteDaoTest {
    @Test
    public void Hello() {
        System.out.println("Hello,world!");
    }

    @Autowired
    private SiteMapper siteMapper;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void MapTypeTest() throws Exception {
        List<Map<String, Object>> list = siteMapper.getAllWithMap();
        //Map<String, Object> list = siteMapper.getAllWithMap();
        System.out.println(objectMapper.writeValueAsString(list));
    }

    @Test
    //resultType属性同样支持将查询结果映射到集合
    public void resultTypeTest() {
        List<Site> list = siteMapper.getAllWithResultType();
        System.out.println(list);
    }

    @Test
    public void SiteTest() {
//        List<Site> list = siteMapper.getAll();
//        System.out.println(list);
        Site site = new Site(4, "寝室");
        System.out.println(site);
        siteMapper.updateSite(site);
        System.out.println(site);
        //siteMapper.deleteSiteById(site.getId());
    }
}
