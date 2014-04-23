package com.kildeen.ref.testutil;

import org.apache.deltaspike.core.api.projectstage.ProjectStage;
import org.apache.deltaspike.core.util.ProjectStageProducer;
import org.apache.deltaspike.testcontrol.api.TestControl;
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
    private static final Logger LOGGER = Logger.getLogger(EJBRunner.class.getName());

    private ProjectStage projectStage;
    private ProjectStage previousProjectStage;
    TestControl testControl;

    public EJBRunner(final Class<?> testClass) throws InitializationError {
        super(testClass);

        testControl = testClass.getAnnotation(TestControl.class);

        if (testControl != null) {
        }
    }

    @Override
    protected void runChild(final FrameworkMethod method, RunNotifier notifier) {
        testControl = method.getAnnotation(TestControl.class);
        if (testControl != null) {
            previousProjectStage = projectStage;
            projectStage = ProjectStage.valueOf(testControl.projectStage().getSimpleName());
            ProjectStageProducer.setProjectStage(projectStage);
        }
        super.runChild(method, notifier);
        try
        {
            super.runChild(method, notifier);
        }
        finally
        {
            ProjectStageProducer.setProjectStage(previousProjectStage);
        }
    }

}