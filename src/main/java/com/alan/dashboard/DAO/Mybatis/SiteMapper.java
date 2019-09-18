package com.alan.dashboard.DAO.Mybatis;

import com.alan.dashboard.model.Site;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

//@Mapper
@Repository
public interface SiteMapper {
    List<Site> getAll();

    List<Site> getAllWithResultType();

    public List<Map<String, Object>> getAllWithMap();
    //public Map<String, Object> getAllWithMap();

    public void addSite(Site site);

    //删除site前，必须删除该site的所属device
    public void deleteSiteById(int id);

    public void updateSite(Site site);
}
