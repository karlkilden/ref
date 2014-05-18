package com.kildeen.ref.security;


import com.kildeen.ref.application.Database;
import com.kildeen.ref.application.module.authorization.GroupDTO;
import com.kildeen.ref.application.module.authorization.GroupService;
import com.kildeen.ref.domain.Permission;
import com.kildeen.ref.system.SystemNode;
import com.kildeen.ref.system.SystemNodeImpl;
import com.kildeen.ref.system.SystemNodeResolver;

import javax.annotation.PostConstruct;
import javax.ejb.*;
import javax.inject.Inject;
import java.util.HashSet;
import java.util.Set;

import static javax.ejb.ConcurrencyManagementType.BEAN;

/**
 * <p>File created: 2014-05-03 23:54</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
@Singleton
@ConcurrencyManagement(BEAN)
@Startup
@Lock(LockType.READ)
public class PermissionResolverMock implements PermissionResolver {

    private static final String PERMISSION_RESOLVER_CACHE = "permissionResolverCache";

    @Inject
    Database database;

    @Inject
    private SystemNodeResolver systemNodeResolver;

    @Override
    public Set<Class<?>> getPermissions(long groupId) {

        GroupDTO group = null;

        for (GroupDTO dto : database.getAllGroups()) {
            if (dto.getId() == groupId) {
                group = dto;
            }
        }
        Set<Class<?>> allowedNodes = new HashSet<>(group.getPermissions().size());
        for (Permission permission : group.getPermissions()) {
            allowedNodes.add(systemNodeResolver.byId(permission.getName()));
        }
        return allowedNodes;
    }


    @Override
    public void boot() {

    }
}
