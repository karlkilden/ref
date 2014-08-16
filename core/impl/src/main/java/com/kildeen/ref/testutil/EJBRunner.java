package com.kildeen.ref.testutil;

import org.apache.deltaspike.core.api.projectstage.ProjectStage;
import org.apache.deltaspike.core.util.ProjectStageProducer;
import org.apache.openejb.junit.jee.EJBContainerRunner;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;

import java.util.logging.Logger;

/**
 * <p>File created: 2014-04-20 15:10</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
public class EJBRunner extends EJBContainerRunner {


    public EJBRunner(final Class<?> klass) throws InitializationError {
        super(klass);
    }
}