package com.kildeen.ref.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * <p>File created: 2014-04-21 17:27</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
@Entity
@Table(name = "ref_user")
public class User extends BaseEntity {

    @Column
    private String name;

    @Column
    private long groupId;

    @Column
    private String locale;

    public User() {
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setGroupId(final long groupId) {
        this.groupId = groupId;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(final String locale) {
        this.locale = locale;
    }
}
