package com.kildeen.ref.permission;

import com.kildeen.ref.application.module.authorization.GroupDTO;
import com.kildeen.ref.application.module.authorization.GroupService;
import com.kildeen.ref.application.module.user.UserService;
import com.kildeen.ref.domain.Permission;
import com.kildeen.ref.domain.User;
import com.kildeen.ref.system.Current;
import com.kildeen.ref.system.SystemNodeResolver;
import org.apache.deltaspike.core.api.config.view.ViewConfig;
import org.apache.deltaspike.jsf.api.message.JsfMessage;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import static com.kildeen.ref.system.Pages.Admin.User.UserSetup;

/**
 * <p>File created: 2014-04-26 20:32</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
@Model
public class UserBean {

    @Inject
    private SystemNodeResolver systemNodeResolver;

    @Inject
    private UserService userService;



    @Inject
    private JsfMessage<Messages> msg;

    @Inject
    @Current
    private Locale locale;

    private User user = new User();

    private List<User> users;

    @PostConstruct
    private void init() {
        fetchUsers();
    }

    private void fetchUsers() {
        users = userService.fetchUsers();
    }

    public User getUser() {
        return user;
    }

    public void setUser(final User userDTO) {
        this.user = userDTO;
    }

    public List<User> getUsers() {
        return users;
    }

    public void update() {
        fetchUsers();
    }

    public String getText(Permission permission) {
        ResourceBundle bundle = ResourceBundle.getBundle("messages", locale);

        return bundle.getString(permission.getName());
    }

    public Class<? extends ViewConfig> edit(User userDTO) {
        return UserSetup.class;
    }

    public String getOutcome() {
        return UserSetup.class.toString();
    }


}
