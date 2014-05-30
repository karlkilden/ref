package com.kildeen.ref;

import com.kildeen.ref.module.authorization.GroupDTO;
import com.kildeen.ref.module.authorization.UserDTO;
import com.kildeen.ref.system.Current;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Locale;

/**
 * <p>File created: 2014-05-03 23:37</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
@SessionScoped
@Named
public class UserContext implements Serializable {


    private UserDTO user;
    private String logout;

    public UserDTO getUser() {
        return user;
    }

    @Produces
    @Current
    public Locale getLocale() {
        return Locale.ENGLISH;
    }

    @Produces
    @Current
    public GroupDTO getGroup() {
        return user.getGroup();
    }

    public void setUser(final UserDTO user) {
        this.user = user;
    }

    public boolean initialized() {
        return user != null;
    }

}
