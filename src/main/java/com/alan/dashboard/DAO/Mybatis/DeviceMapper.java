package com.alan.dashboard.DAO.Mybatis;

import com.alan.dashboard.model.Device;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DeviceMapper {
    public List<Device> getRowsBySite(int siteId);
    public Device getOneByName(String name);

    public List<Device> getAll();
}
