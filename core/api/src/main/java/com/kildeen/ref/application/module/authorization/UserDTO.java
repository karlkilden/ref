package com.kildeen.ref.application.module.authorization;

import com.kildeen.ref.domain.BaseEntity;
import com.kildeen.ref.domain.Group;

import javax.persistence.*;

/**
 * <p>File created: 2014-04-21 17:27</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */

public class UserDTO extends BaseEntity {

    private String name;

    private GroupDTO group;

    private String locale;

    private String email;

    public UserDTO() {
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

    public GroupDTO getGroup() {
        return group;
    }

    public void setGroup(final GroupDTO group) {
        this.group = group;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(final String locale) {
        this.locale = locale;
    }
}
