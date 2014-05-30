package com.kildeen.ref.domain;

import com.google.common.base.Objects;
import org.apache.commons.lang3.RandomStringUtils;

import javax.persistence.*;
import java.util.List;

/**
 * <p>File created: 2014-04-30 20:26</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */

@Entity
@Table(name = "ref_permission")
public class Permission extends BaseEntity {

    @Column
    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    List<Group> groups;

    public Permission(final Class<?> definition) {
        this.name = definition.getCanonicalName();
    }

    public Permission() {
    }

    public String getName() {
        return name;
    }

    public List<Group> getGroups() {
        return groups;
    }

    @Override
    public boolean equals(Object permission) {
        Permission permission1 = (Permission) permission;
        long id1 = permission1.getId();
        long id = this.getId();

        if (id == id1 && id != 0) {
            return true;
        }

        return this.name.equals(permission1.getName());
    }

    @Override
    public int hashCode() {

        if (getId() ==0 && name == null) {
            // Can't hashcode yet
            return  super.hashCode();
        }

        return Objects.hashCode(name, getId());

    }

}
