package com.kildeen.ref;

import com.kildeen.ref.application.module.fact.FactServiceMockTest;
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
        //No classes
})

/**
 *
 * All tests that does not require a booted container yet are slow should run in this suit if possible
 */

public class SlowSuite {
}
