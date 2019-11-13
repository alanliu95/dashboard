package com.alan.dashboard.service.security;


import com.alan.dashboard.model.security.Permission;

public interface PermissionService {
    public Permission createPermission(Permission permission);

    public void deletePermission(Long permissionId);
}
