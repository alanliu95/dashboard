package com.alan.dashboard;

import com.alan.dashboard.DAO.Mybatis.DeviceMapper;
import com.alan.dashboard.model.Device;
import com.alan.dashboard.model.SiteDevMap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DeviceDaoTest {

    @Autowired
    private DeviceMapper deviceMapper;

    @Test
    public void select() {
        //List<Device> list=deviceMapper.getAll();
        Device device = deviceMapper.getOneByName("name1");
        System.out.println(device);
    }

    //一对多
    @Test
    public void deviceMap() {
        List<SiteDevMap> map = deviceMapper.getMap();
        System.out.println(map);
    }
}
