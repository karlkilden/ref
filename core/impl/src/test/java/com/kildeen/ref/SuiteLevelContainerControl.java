package com.kildeen.ref;

import com.kildeen.ref.application.module.authorization.PermissionResolverImpl;
import com.kildeen.ref.application.module.fact.EagerManagerTest;
import com.kildeen.ref.application.module.fact.FactServiceMockTest;
import com.kildeen.ref.application.module.fact.FactServiceTest;
import com.kildeen.ref.security.PermissionResolver;
import com.kildeen.ref.security.PermissionResolverImplTest;
import com.kildeen.ref.system.SystemNodeTest;
import org.apache.deltaspike.testcontrol.api.junit.CdiTestSuiteRunner;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(CdiTestSuiteRunner.class)
@Suite.SuiteClasses({
        FactServiceTest.class,
        EagerManagerTest.class,
        FactServiceMockTest.class,
        SystemNodeTest.class,
        PermissionResolverImplTest.class


})
public class SuiteLevelContainerControl {
}