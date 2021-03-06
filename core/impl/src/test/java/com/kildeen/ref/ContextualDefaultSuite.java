package com.kildeen.ref;

import com.kildeen.ref.module.fact.EagerManagerTest;
import com.kildeen.ref.module.fact.FactServiceTest;
import com.kildeen.ref.security.PermissionResolverImplTest;
import com.kildeen.ref.system.LeafTest;
import org.apache.deltaspike.testcontrol.api.junit.CdiTestSuiteRunner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(CdiTestSuiteRunner.class)
@Suite.SuiteClasses({
        FactServiceTest.class,
        EagerManagerTest.class,
        LeafTest.class,
        PermissionResolverImplTest.class
})

/**
 * All tests that needs a booted container and can run in this suit should.
 *
 */
public class ContextualDefaultSuite {
    @AfterClass
    public static void tearDown() {
    }
}