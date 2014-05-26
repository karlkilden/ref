package com.kildeen.ref.system;

import com.kildeen.ref.domain.Permission;

import java.io.Serializable;
import java.util.List;

/**
 * <p>File created: 2014-05-09 17:25</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
public interface SystemNode extends Serializable {

    String getPermissionName(Class<?> definition);

    boolean isRoot();

    boolean isBranch();

    boolean isLeaf();

    boolean isStem();

    List<SystemNode> children();

    String getPermissionName();

    Class<?> getDefinition();

    Permission getPermission();
    
    String getPath();
    
    String getPage();

    SystemNode getParent();
}
