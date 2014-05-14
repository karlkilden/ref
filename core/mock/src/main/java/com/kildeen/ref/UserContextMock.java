package com.kildeen.ref;

import com.kildeen.ref.domain.User;
import com.kildeen.ref.system.Current;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
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
public class UserContextMock implements Serializable {

    private User user;

    public User getUser() {
        return user;
    }

    @Produces
    @Current
    public Locale getLocale() {
        return Locale.ENGLISH;
    }

}
