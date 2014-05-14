package com.kildeen.ref.security;

import java.util.Set;

/**
 * <p>File created: 2014-05-07 20:30</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
public interface PermissionResolver {

    Set<Class<?>> getPermissions(long groupId);
}
