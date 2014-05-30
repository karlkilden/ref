package com.kildeen.ref.module.authorization;

import com.kildeen.ref.module.fact.BaseAuditDTO;
import com.kildeen.ref.domain.Permission;
import org.apache.bval.constraints.NotEmpty;
import org.apache.commons.collections4.set.ListOrderedSet;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

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
    private ListOrderedSet<Permission> permissions = new ListOrderedSet<>();

    @NotEmpty
    @NotNull
    private String name;

    private List<UserDTO> users;

    private List<String> userNames;

    private String denormalizedUserNames;


    private UserDTO latestAddedUser;

    public GroupDTO(final String name, final List<Permission> permissions) {
        this.permissions.addAll(permissions);
        this.name = name;
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
        return permissions.asList();
    }

    public Set<Permission>  getPermissionSet() {
        return permissions;
    }

    public void setUsers(final List<UserDTO> users) {
        this.users = users;

    }

    public List<UserDTO> getUsers() {
        return users;
    }

    public void setPermissions(final List<Permission> permissions) {
        this.permissions = new ListOrderedSet<>();
            this.permissions.addAll(permissions);
    }

    public UserDTO getLatestAddedUser() {
        return latestAddedUser;
    }

    public void setLatestAddedUser(UserDTO latestAddedUser) {
        this.latestAddedUser = latestAddedUser;
    }

}
