package com.kildeen.ref.application.module.authorization;

import com.kildeen.ref.application.module.fact.BaseAuditDTO;
import com.kildeen.ref.domain.Permission;
import com.kildeen.ref.domain.User;
import org.apache.bval.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * <p>File created: 2014-04-30 22:40</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
public class GroupDTO extends BaseAuditDTO {

    @NotEmpty
    @NotNull
    private List<Permission> permissions;

    @NotEmpty
    @NotNull
    private String name;

    private List<User> users;

    private User latestAddedUser;

    public GroupDTO(final String name, final List<Permission> permissions, User latestAddedUser) {
        this.permissions = permissions;
        this.name = name;
        this.latestAddedUser = latestAddedUser;
    }

    public GroupDTO() {

    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setUsers(final List<User> users) {
        this.users = users;

    }

    public List<User> getUsers() {
        return users;
    }

    public void setPermissions(final List<Permission> permissions) {
        this.permissions = permissions;
    }

    public User getLatestAddedUser() {
        return latestAddedUser;
    }

    public void setLatestAddedUser(User latestAddedUser) {
        this.latestAddedUser = latestAddedUser;
    }
}
