package com.kildeen.ref.system;

import com.kildeen.ref.application.module.authorization.PermissionResolverImpl;
import com.kildeen.ref.security.PermissionResolver;
import org.slf4j.Logger;


import javax.annotation.PostConstruct;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import java.io.Serializable;

import static javax.ejb.ConcurrencyManagementType.BEAN;

/**
 * <p>File created: 2014-05-16 23:55</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
@Singleton
@ConcurrencyManagement(BEAN)
@Startup
public class ApplicationStart implements Serializable {

    private static final Logger log = LogManager.getLogger();
    @Inject
    private PermissionResolver permissionResolver;


    @PostConstruct
    private void boot() {
        bootInitiator(permissionResolver);
    }

    private void bootInitiator(final Initiator... initiators) {
        for (Initiator initiator : initiators) {
            log.info("{} is initiating");
            initiator.boot();

        }
    }
}
