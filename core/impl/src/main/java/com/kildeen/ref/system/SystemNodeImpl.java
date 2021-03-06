package com.kildeen.ref.system;

import com.kildeen.ref.domain.Permission;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.deltaspike.core.api.config.view.ViewConfig;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.apache.commons.collections4.CollectionUtils.isNotEmpty;

/**
 * <p>File created: 2014-04-30 21:53</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
public class SystemNodeImpl implements SystemNode {

    private String nodeName;
    private List<SystemNode> children;
    private Class<?> definition;
    private boolean root;
    private SystemNode parent;
    private NodeType type;
    private Permission permission;
    private String path;
    private String page;
    private PageInfo pageInfo;

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
        this.nodeName = getNodeName(definition);

        if (parent == null) {
            root = true;
        }
        for (Class<?> childDefinition : definition.getDeclaredClasses()) {
            children.add(new SystemNodeImpl(childDefinition, this));
        }

        if ((type == NodeType.BRANCH) && isNotEmpty(children)) {
            pageInfo = new PageInfoImpl(children);
        }
    }

    @Override
    public String getNodeName(final Class<?> definition) {
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
    public String getNodeName() {
        return nodeName;
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


    @Override
    public String getPath() {

        return path;
    }

    @Override
    public String getPage() {
        return page;
    }

    @Override
    public SystemNode getParent() {
        return parent;
    }

    public void setupPath(String path) {
        this.path = path;

        if (isBranch()) {
            this.page = path.substring(path.lastIndexOf("/") + 1);
        }
    }

    @Override
    public String toString() {
        return nodeName + " " + type.toString();
    }

    @Override
    public boolean equals(Object other) {
        SystemNodeImpl otherSystemNode = (SystemNodeImpl) other;
        return this.definition == otherSystemNode.getDefinition();
    }

    @Override
    public PageInfo getPageInfo() {
        return pageInfo;
    }
}
