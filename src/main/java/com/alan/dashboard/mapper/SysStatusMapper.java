package com.alan.dashboard.mapper;

import com.alan.dashboard.model.SysStatus;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface SysStatusMapper {
	
	List<SysStatus> getAll();

	SysStatus getOne(Integer id);

	void insert(SysStatus user);

	void update(SysStatus user);

	void delete(Integer id);

}