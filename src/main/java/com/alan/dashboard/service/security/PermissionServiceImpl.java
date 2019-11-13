package com.alan.dashboard.service.security;


import com.alan.dashboard.DAO.Mybatis.PermissionDao;
import com.alan.dashboard.model.security.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service
public class PermissionServiceImpl implements PermissionService {
    //@Autowired
    private PermissionDao permissionDao;

    public void setPermissionDao(PermissionDao permissionDao) {
        this.permissionDao = permissionDao;
    }

    public Permission createPermission(Permission permission) {
        return permissionDao.createPermission(permission);
    }

    public void deletePermission(Long permissionId) {
        permissionDao.deletePermission(permissionId);
    }
}
