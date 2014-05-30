
package com.kildeen.ref.module.authorization;


import com.kildeen.ref.module.user.UserService;
import com.kildeen.ref.domain.User;
import com.kildeen.ref.system.Current;
import com.kildeen.ref.system.SystemNodeResolver;
import org.apache.deltaspike.core.api.scope.ViewAccessScoped;
import org.apache.deltaspike.jsf.api.message.JsfMessage;

import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Locale;

/**
 * <p>File created: 2014-04-26 20:32</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
@ViewAccessScoped
@Named
public class UserSetupBean implements Serializable {

    @Inject
    private SystemNodeResolver systemNodeResolver;

    @Inject
    private UserService userService;

    @Inject
    private GroupService groupService;

    @Inject
    private JsfMessage<Messages> msg;

    @Inject
    @Current
    private Locale locale;

    private UserDTO user = new UserDTO();
    private long userId;

    public void init() {
        user = userService.fetchById(userId);
        if (user == null) {
            user = new UserDTO();
        }
    }

    public void saveUser() {

        userService.save(user);
        msg.addInfo().entityCreated(User.class.getSimpleName(), user.getName());
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(final UserDTO user) {
        this.user = user;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(final long userId) {
        this.userId = userId;
    }

}
