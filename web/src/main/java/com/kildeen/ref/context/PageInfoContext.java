package com.kildeen.ref.context;

import com.kildeen.ref.domain.Permission;
import com.kildeen.ref.system.PageInfo;

import java.util.Set;

/**
 * <p>File created: 2014-06-07 13:06</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
public class PageInfoContext {

    private boolean create;
    private boolean trusted;
    private boolean delete;
    private boolean read;
    private boolean update;

    private Set<Permission> permissions;
    private PageInfo pageInfo;

    public PageInfoContext(final Set<Permission> permissions, final PageInfo pageInfo) {
        this.permissions = permissions;
        this.pageInfo = pageInfo;

        this.trusted = map("Trusted");
        this.create = map("Create");
        this.read = map("Read");
        this.update = map("Update");
        this.delete = map("Delete");
        this.permissions = null;
        this.pageInfo = null;
    }


    private boolean map(String pagePermission) {
        String requiredNode = pageInfo.getNodeNameByPagePermission(pagePermission);
        if (requiredNode != null) {
            for (Permission permission : permissions) {
                if (permission.getName().equals(requiredNode)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isCreate() {
        return create;
    }

    public boolean isTrusted() {
        return trusted;
    }

    public boolean isDelete() {
        return delete;
    }

    public boolean isRead() {
        return read;
    }

    public boolean isUpdate() {
        return update;
    }
}
