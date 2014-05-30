package com.kildeen.ref.module.authorization;

import com.kildeen.ref.EndSessionEvent;
import com.kildeen.ref.UserContext;
import com.kildeen.ref.module.user.UserService;
import com.kildeen.ref.system.Index;
import com.kildeen.ref.system.Pages;
import org.apache.deltaspike.core.api.config.view.ViewConfig;
import org.apache.deltaspike.jsf.api.message.JsfMessage;
import org.omnifaces.util.Faces;

import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import static com.kildeen.ref.system.Pages.Admin.Group.GroupOverview;
import static com.kildeen.ref.system.Pages.Content.FactOverview;

/**
 * <p>File created: 2014-05-30 14:10</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
@Model
public class LoginBean {


    private String name;

    @Inject
    private JsfMessage<Messages> msg;

    @Inject
    private UserContext userContext;

    @Inject
    private UserService userService;

    @Inject
    private Event<EndSessionEvent> event;


    public Class<? extends ViewConfig> login() {

        UserDTO user = userService.fetchByName(name);

        if (user != null) {
            userContext.setUser(user);
            return FactOverview.class;
        }
        msg.addError().userNotFound(name);
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Class<? extends ViewConfig> logout() {
        Faces.getSession().invalidate();
        event.fire(new EndSessionEvent(userContext));
        return Index.class;
    }
}
