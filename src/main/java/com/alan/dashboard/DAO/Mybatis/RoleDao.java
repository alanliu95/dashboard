package com.alan.dashboard.DAO.Mybatis;


import com.alan.dashboard.model.security.Role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface RoleDao {

    public Role createRole(Role role);

    public void deleteRole(Long roleId);

    public void correlationPermissions(Long roleId, Long... permissionIds);

    public void uncorrelationPermissions(Long roleId, Long... permissionIds);

}
