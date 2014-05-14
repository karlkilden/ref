package com.kildeen.ref.application.module.authorization;


import com.kildeen.ref.application.module.authorization.GroupDTO;
import com.kildeen.ref.application.module.authorization.GroupService;
import com.kildeen.ref.application.module.authorization.PermissionRepository;
import com.kildeen.ref.domain.Permission;
import com.kildeen.ref.security.PermissionResolver;
import com.kildeen.ref.system.SystemNode;
import com.kildeen.ref.system.SystemNodeImpl;
import com.kildeen.ref.system.SystemNodeResolver;

import javax.annotation.PostConstruct;
import javax.cache.annotation.CacheResult;
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
public class PermissionResolverImpl implements PermissionResolver {

    private static final String PERMISSION_RESOLVER_CACHE = "permissionResolverCache";

    @Inject
    private GroupService groupService;

    @Inject
    private PermissionRepository permissionRepository;

    @Inject
    private SystemNodeResolver systemNodeResolver;

    @CacheResult(cacheName = PERMISSION_RESOLVER_CACHE)
    @Override
    public Set<Class<?>> getPermissions(long groupId) {
        GroupDTO group = groupService.fetchGroup(groupId);
        Set<Class<?>> allowedNodes = new HashSet<>(group.getPermissions().size());

        for (Permission permission : group.getPermissions()) {
            allowedNodes.add(systemNodeResolver.byId(permission.getName()));
        }
        return allowedNodes;
    }

    @PostConstruct
    private void createPermissions() {
        for (SystemNode node : systemNodeResolver.nodes()) {
            Permission permission = permissionRepository.findOptionalByNameEqual(node.getPermissionName());
            if (permission == null) {
                permission = new Permission(node.getPermissionName());
                permission = permissionRepository.saveAndFlush(permission);
            }
            SystemNodeImpl impl = (SystemNodeImpl) node;
            impl.setPermission(permission);
        }

    }
}
