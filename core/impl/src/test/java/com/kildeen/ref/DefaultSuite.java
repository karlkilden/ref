package com.kildeen.ref;

import com.kildeen.ref.domain.BaseEntityTest;
import com.kildeen.ref.module.fact.FactServiceMockTest;
import com.kildeen.ref.system.SystemNodeTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created with IntelliJ IDEA.
 * User: Karl Kildén
 * Date: 2014-05-20
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        FactServiceMockTest.class,
        SystemNodeTest.class,
        BaseEntityTest.class
})

/**
 *
 * All tests that uses standard junit only with fast additions such as Mockito should be added to this suit if possible.
 */

public class DefaultSuite {
}
