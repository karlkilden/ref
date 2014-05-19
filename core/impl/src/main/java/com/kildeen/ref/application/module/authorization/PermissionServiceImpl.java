package com.kildeen.ref.application.module.authorization;

import com.kildeen.ref.domain.Permission;
import com.kildeen.ref.system.SystemNodeResolver;

import javax.cache.annotation.CacheDefaults;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.Singleton;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.transaction.UserTransaction;
import java.util.List;

import static javax.ejb.ConcurrencyManagementType.BEAN;

/**
 * <p>File created: 2014-04-30 22:38</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
@CacheDefaults(cacheName = "permissionCache")
@Singleton
@ConcurrencyManagement(BEAN)
public class PermissionServiceImpl implements PermissionService {

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