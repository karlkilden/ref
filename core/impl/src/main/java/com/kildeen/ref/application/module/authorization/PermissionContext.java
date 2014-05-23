package com.kildeen.ref.application.module.authorization;

import com.kildeen.ref.user.UserContext;
import org.apache.deltaspike.core.api.config.view.metadata.ViewConfigResolver;


import javax.inject.Inject;
import java.io.Serializable;

/**
 * <p>File created: 2014-05-03 23:32</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
public class PermissionContext implements Serializable {

    @Inject
    private UserContext userContext;



    @Inject
    private ViewConfigResolver viewConfigResolver;


    public boolean isAllowed() {
        return true;
    }

}
