package com.alan.dashboard.DAO.Mybatis;

import com.alan.dashboard.model.Device;
import com.alan.dashboard.model.DeviceMap;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DeviceMapper {
    //查
    public List<Device> getRowsBySiteId(int siteId);
    public Device getOneByName(String name);
    public List<Device> getAll();

    public void delRowsBySiteId(int siteId);

    public void addDevice(Device device);

    public void deleteDeviceById(int id);

    public List<DeviceMap> getMap();
    //public void updateDevice(Device device);
    //public void deleteDeviceById(Device device);
}
