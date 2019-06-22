package com.alan.dashboard.DAO.Mybatis;

import com.alan.dashboard.model.Site;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface SiteMapper {
    List<Site> getAll();
}
