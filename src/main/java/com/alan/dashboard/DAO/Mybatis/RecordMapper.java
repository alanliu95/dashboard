package com.alan.dashboard.DAO.Mybatis;

import com.alan.dashboard.model.Record;
import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface RecordMapper {
    public List<Record> getRowsByDevice(int devId);

    public List<JSONObject> getTs(int devId);
}
