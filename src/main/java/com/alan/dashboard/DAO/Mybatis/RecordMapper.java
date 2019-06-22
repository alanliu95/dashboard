package com.alan.dashboard.DAO.Mybatis;

import com.alan.dashboard.model.Record;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface RecordMapper {
    public List<Record> getRowsByDevice(int devId);
}
