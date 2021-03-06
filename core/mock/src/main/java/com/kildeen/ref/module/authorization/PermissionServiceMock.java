package com.kildeen.ref.module.authorization;

import com.kildeen.ref.domain.Permission;
import com.kildeen.ref.system.SystemNodeResolver;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import java.util.List;

/**
 * <p>File created: 2014-04-30 22:38</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
@ApplicationScoped
@Alternative
public class PermissionServiceMock implements PermissionService {

    @Inject
    private PermissionRepository permissionRepository;

    @Inject
    private SystemNodeResolver systemNodeResolver;

    @Override
    public List<Permission> fetchPermissions() {
        return permissionRepository.findAll();
    }

    @Override
    public Permission fetchPermission(final long id) {
        return permissionRepository.findBy(id);
    }

    @Override
    public Permission createPermission(Permission permission) {
        return permissionRepository.saveAndFlush(permission);
    }

    @Override
    public void removePermission(Permission permission) {


        permissionRepository.remove(permissionRepository.findBy(permission.getId()));
    }

    @Override
    public Permission fetchByName(String permissionName) {
        return permissionRepository.findOptionalByNameEqual(permissionName);
    }


}