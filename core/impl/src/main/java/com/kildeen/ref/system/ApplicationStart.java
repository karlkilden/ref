package com.kildeen.ref.system;

import com.kildeen.ref.security.PermissionResolver;
import org.slf4j.Logger;


import javax.annotation.PostConstruct;
import javax.ejb.*;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.logging.Level;

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
@TransactionManagement(TransactionManagementType.BEAN)
@Startup
public class ApplicationStart implements Serializable {

    private static final Logger log = LogManager.getLogger();
    @Inject
    private PermissionResolver permissionResolver;

    @Inject
    private BasicSetupHandler basicSetupHandler;

    @PostConstruct
    private void boot() {
        bootInitiator(permissionResolver, basicSetupHandler);

        java.util.logging.Logger logger = java.util.logging.Logger.getLogger("org.apache.geronimo.connector.work.WorkerContext") ;
        logger.setLevel(Level.WARNING);
    }

    private void bootInitiator(final Initiator... initiators) {
        for (Initiator initiator : initiators) {
            log.info("{} is initiating", Util.getClassNameFromProxy(initiator.getClass(), true));
            initiator.boot();

        }
    }
}
