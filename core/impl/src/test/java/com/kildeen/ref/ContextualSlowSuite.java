package com.kildeen.ref;

import com.kildeen.ref.module.fact.SlowFactServiceTest;
import org.apache.deltaspike.testcontrol.api.junit.CdiTestSuiteRunner;

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
    }
}