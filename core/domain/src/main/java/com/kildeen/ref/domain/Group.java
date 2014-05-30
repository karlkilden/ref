package com.kildeen.ref.domain;

import javax.persistence.*;
import java.util.List;

/**
 * <p>File created: 2014-04-21 17:27</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
@Entity
@Table(name = "ref_group")
public class Group extends BaseAuditEntity {

    @Column
    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "group")
    private List<User> users;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Permission> permissions;

    @OneToOne
    private User latestAddedUser;

    public String getName() {
        return name;
    }

    public List<User> getUsers() {
        return users;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setUsers(final List<User> users) {
        this.users = users;
    }

    public void setPermissions(final List<Permission> permissions) {
        this.permissions = permissions;
    }

    public User getLatestAddedUser() {
        return latestAddedUser;
    }

    public void setLatestAddedUser(User user) {
        this.latestAddedUser = user;
    }
}
