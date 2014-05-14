package com.kildeen.ref.testutil;

import org.apache.deltaspike.core.api.projectstage.ProjectStage;
import org.apache.deltaspike.core.util.ProjectStageProducer;
import org.apache.deltaspike.testcontrol.api.TestControl;
import org.apache.deltaspike.testcontrol.api.junit.CdiTestRunner;
import org.apache.openejb.junit.jee.EJBContainerRunner;
import org.apache.openejb.junit.jee.config.Properties;
import org.apache.openejb.junit.jee.config.Property;
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
public class CDIRunner extends CdiTestRunner {
    private static final Logger LOGGER = Logger.getLogger(CDIRunner.class.getName());

    private ProjectStage projectStage;
    private ProjectStage previousProjectStage;
    TestControl testControl;

    public CDIRunner(final Class<?> testClass) throws InitializationError {
        super(testClass);
        final Properties annotationConfig = testClass.getAnnotation(Properties.class);
        if (annotationConfig != null) {
            for (Property property : annotationConfig.value()) {
                System.setProperty(property.key(), property.value());
            }
        }
    }



}