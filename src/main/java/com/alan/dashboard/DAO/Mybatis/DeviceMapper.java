package com.alan.dashboard.DAO.Mybatis;

import com.alan.dashboard.model.Device;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface DeviceMapper {
    List<Device> getRowsBySite(int siteId);
}
