package com.kildeen.ref.module.authorization;

import com.kildeen.ref.module.user.UserService;
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

    private List<UserDTO> users;

    @PostConstruct
    private void init() {
        fetchUsers();
    }

    private void fetchUsers() {
        users = userService.fetchUsers();
    }

    public List<UserDTO> getUsers() {
        return users;
    }

    public void update() {
        fetchUsers();
    }

    public String getOutcome() {
        return UserSetup.class.toString();
    }


}
