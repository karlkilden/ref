package com.kildeen.ref.system;


import org.apache.deltaspike.core.api.config.view.metadata.ViewConfigResolver;

import javax.annotation.PostConstruct;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import java.util.*;

import static javax.ejb.ConcurrencyManagementType.BEAN;

/**
 * <p>File created: 2014-04-30 19:13</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
@Singleton
@ConcurrencyManagement(BEAN)
@Startup
public class SystemNodeResolverImpl implements SystemNodeResolver {

    private List<SystemNode> rootNodes;
    private Map<String, Class<?>> nodeMap = new HashMap<>();

    private List<SystemNode> nodes = new ArrayList<>();

    @Inject
    private ViewConfigResolver viewConfigResolver;

    @Inject
    private SystemNodeResolver systemNodeResolver;
    private Set<Class<?>> navigationalNodes = new HashSet<>();


    @PostConstruct
    private void init() {
        rootNodes = new ArrayList<>();

        rootNodes.add(new SystemNodeImpl(Index.class, null));
        rootNodes.add(new SystemNodeImpl(Pages.class, null));

        for (SystemNode node : rootNodes) {
            mapNodes((SystemNodeImpl) node);
        }


    }

    private void mapNodes(final SystemNodeImpl node) {
        if (viewConfigResolver.getConfigDescriptor(node.getDefinition()) != null) {
            navigationalNodes.add(node.getDefinition());
        }
        nodeMap.put(node.getPermissionName(), node.getDefinition());
        nodes.add(node);
        for (SystemNode child : node.children()) {
            mapNodes((SystemNodeImpl) child);
        }
    }

    @Override
    public List<SystemNode> root() {
        return rootNodes;
    }

    @Override
    public Class<?> byId(final String permission) {
        return nodeMap.get(permission);
    }

    @Override
    public Collection<SystemNode> nodes() {
        return nodes;
    }

    @Override
    public Set<Class<?>> getNavigationalNodes() {
        return navigationalNodes;
    }


}
