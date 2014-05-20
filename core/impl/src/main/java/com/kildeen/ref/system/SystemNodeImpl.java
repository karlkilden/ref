package com.kildeen.ref.system;

import com.kildeen.ref.domain.Permission;
import org.apache.deltaspike.core.api.config.view.ViewConfig;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>File created: 2014-04-30 21:53</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
public class SystemNodeImpl implements SystemNode {

    private String permissionName;
    private List<SystemNode> children;
    private Class<?> definition;
    private boolean root;
    private SystemNode parent;
    private NodeType type;
    private Permission permission;

    public SystemNodeImpl(final Class<?> definition, SystemNodeImpl parent) {
        this.definition = definition;
        children = new ArrayList<>(this.definition.getDeclaredClasses().length);
        Class<?>[] childDefinitions = definition.getDeclaredClasses();
        this.parent = parent;
        if (definition.isInterface()) {

            if (childDefinitions.length == 0) {
                throw new RuntimeException("A Leaf or Branch cannot be defined as interface");
            }
            type = NodeType.STEM;
        } else {

            if (ViewConfig.class.isAssignableFrom(definition)) {
                type = NodeType.BRANCH;
            } else {
                if (this.parent != null && parent.type != NodeType.BRANCH) {
                    throw new RuntimeException("A leaf must have branch parent");
                }
                type = NodeType.LEAF;
            }
        }
        this.permissionName = getPermissionName(definition);

        if (parent == null) {
            root = true;
        }
        for (Class<?> childDefinition : definition.getDeclaredClasses()) {
            children.add(new SystemNodeImpl(childDefinition, this));
        }

    }

    @Override
    public String getPermissionName(final Class<?> definition) {
        String permission;
        if (definition.isAnnotationPresent(Named.class)) {
            permission = definition.getAnnotation(Named.class).value();
        } else {
            permission = definition.getCanonicalName();
        }
        return permission;
    }

    @Override
    public boolean isRoot() {
        return root;
    }

    @Override
    public boolean isBranch() {
        return type == NodeType.BRANCH;
    }

    @Override
    public boolean isLeaf() {
        return type == NodeType.LEAF;
    }

    @Override
    public boolean isStem() {
        return type == NodeType.STEM;
    }

    @Override
    public List<SystemNode> children() {
        return children;
    }

    @Override
    public String getPermissionName() {
        return permissionName;
    }

    @Override
    public Class<?> getDefinition() {
        return definition;
    }

    @Override
    public Permission getPermission() {
        return permission;
    }

    public void setPermission(final Permission permissionName) {
        this.permission = permissionName;
    }


    private enum NodeType {
        STEM, BRANCH, LEAF
    }
}
