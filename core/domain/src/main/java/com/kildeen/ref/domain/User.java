package com.kildeen.ref.domain;

import javax.persistence.*;

/**
 * <p>File created: 2014-04-21 17:27</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
@Entity
@Table(name = "ref_user")
public class User extends BaseAuditEntity {

    @Column
    private String name;

    @Column
    @ManyToOne
    @JoinColumn(name="group_id")
    private Group group;

    @Column
    private String locale;

    @Column
    private String email;

    public User() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(final Group group) {
        this.group = group;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(final String locale) {
        this.locale = locale;
    }
}
