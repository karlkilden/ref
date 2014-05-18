package com.kildeen.ref.security;

import com.kildeen.ref.system.Initiator;

import java.util.Set;

/**
 * <p>File created: 2014-05-07 20:30</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
public interface PermissionResolver extends Initiator {

    Set<Class<?>> getPermissions(long groupId);
}
