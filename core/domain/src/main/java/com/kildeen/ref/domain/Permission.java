package com.kildeen.ref.domain;

import org.apache.deltaspike.core.api.provider.BeanProvider;
import org.apache.deltaspike.core.util.metadata.AnnotationInstanceProvider;
import org.apache.deltaspike.data.api.audit.CurrentUser;

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

    @OneToMany(fetch = FetchType.LAZY)
    @Column
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


}
