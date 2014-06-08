package com.kildeen.ref.system;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class PageInfoImpl implements PageInfo {

    private Collection<SystemNode> children;
    private Map<String, String> permissionToSystemNode = new HashMap<>();

    private String[] permissions = new String[]{
            "Trusted",
            "Create",
            "Read",
            "Update",
            "Delete"
    };


    public PageInfoImpl(Collection<SystemNode> children) {

        this.children = children;

        for (String pagePermission : permissions) {
            for (SystemNode systemNode : this.children) {
                if (systemNode.getNodeName().endsWith(pagePermission)) {
                    permissionToSystemNode.put(pagePermission, systemNode.getNodeName());
                }
            }
        }
    }

    @Override
    public boolean isTrusted() {
        return permissionToSystemNode.containsKey("Trusted");
    }

    @Override
    public boolean isCreate() {
        return permissionToSystemNode.containsKey("Create");
    }

    @Override
    public boolean isRead() {
        return permissionToSystemNode.containsKey("Read");
    }

    @Override
    public boolean isUpdate() {
        return permissionToSystemNode.containsKey("Update");
    }

    @Override
    public boolean isDelete() {
        return permissionToSystemNode.containsKey("Delete");
    }

    @Override
    public String getNodeNameByPagePermission(final String node) {
        return permissionToSystemNode.get(node);
    }

}