package com.kildeen.ref.admin;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

/**
 * <p>File created: 2014-04-13 00:35</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
@Model
public class AdminWeb {
      @Inject
    private AdminCore adminCore;

    public AdminCore getAdminCore() {
        return adminCore;
    }
}
