package com.kildeen.ref.application.module.authorization;

import com.kildeen.ref.domain.Permission;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Karl Kildén
 * Date: 2014-05-15
 */
public interface PermissionService {
    List<Permission> fetchPermissions();

    Permission fetchPermission(long id);

    Permission createPermission(Permission permission);

    void removePermission(Permission permission);

    Permission fetchByName(String permissionName);
}
