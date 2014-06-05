package com.kildeen.ref.application;


import com.kildeen.ref.domain.Permission;
import com.kildeen.ref.module.authorization.GroupDTO;
import com.kildeen.ref.security.PermissionResolver;
import com.kildeen.ref.system.BasicSetupHandler;
import com.kildeen.ref.system.SystemNodeResolver;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import java.util.HashSet;
import java.util.Set;

/**
 * <p>File created: 2014-05-03 23:54</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
@ApplicationScoped
@Alternative
public class BasicSetupHandlerMock implements BasicSetupHandler {

    @Override
    public void boot() {

    }
}
