package com.kildeen.ref.system;


import org.apache.deltaspike.core.api.config.view.metadata.ConfigDescriptor;
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
    private Map<String, Class<?>> nodeClassMap = new HashMap<>();

    private List<SystemNode> nodes = new ArrayList<>();

    private HashMap<String, SystemNode> nodeMap = new HashMap<>();


    @Inject
    private ViewConfigResolver viewConfigResolver;

    @Inject
    @Current
    private List<Class<?>> rootClasses;

    @Inject
    private SystemNodeResolver systemNodeResolver;
    private Set<Class<?>> navigationalNodes = new HashSet<>();


    @PostConstruct
    private void init() {
        rootNodes = new ArrayList<>();

        for (Class<?> clazz : rootClasses) {
            rootNodes.add(new SystemNodeImpl(clazz, null));
        }

        for (SystemNode node : rootNodes) {
            mapNodes((SystemNodeImpl) node);
        }


    }

    private void mapNodes(final SystemNodeImpl node) {
        ConfigDescriptor<?> descriptor = viewConfigResolver.getConfigDescriptor(node.getDefinition());
        if (descriptor != null) {
            navigationalNodes.add(node.getDefinition());
        }
        nodeClassMap.put(node.getPermissionName(), node.getDefinition());
        nodeMap.put(descriptor.getPath(), node);
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
        return nodeClassMap.get(permission);
    }

    @Override
    public Collection<SystemNode> nodes() {
        return nodes;
    }

    @Override
    public Set<Class<?>> getNavigationalNodes() {
        return navigationalNodes;
    }

    @Override
    public SystemNode byPath(final String path) {
        return nodeMap.get(path);
    }


}
