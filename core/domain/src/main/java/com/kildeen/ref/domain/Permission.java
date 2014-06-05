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
    public boolean equals(Object other) {

        Permission otherPermission = (Permission) other;
        return baseEquals(otherPermission, this.name, otherPermission.getName());
    }



    @Override
    public int hashCode() {

        if (getId() ==0 && name == null) {
            // Can't hashcode yet
            return  super.hashCode();
        }

        return Objects.hashCode(name, getId());

    }

    @Override
    public String toString() {
        return name +" "+ baseToString();
    }

}
