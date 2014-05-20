package com.kildeen.ref;

import com.kildeen.ref.application.module.fact.EagerManagerTest;
import com.kildeen.ref.application.module.fact.FactServiceTest;
import com.kildeen.ref.application.module.fact.SlowFactServiceTest;
import com.kildeen.ref.system.LeafTest;
import org.apache.deltaspike.testcontrol.api.junit.CdiTestSuiteRunner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.Configurator;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(CdiTestSuiteRunner.class)
@Suite.SuiteClasses({
        SlowFactServiceTest.class
})

/**
 * All tests that needs a booted container and takes time to run should run in this suit if possible.
 *
 */
public class ContextualSlowSuite {

    @BeforeClass
    public static void tearDown() {
        Configurator.shutdown((LoggerContext) LogManager.getContext());
    }
}