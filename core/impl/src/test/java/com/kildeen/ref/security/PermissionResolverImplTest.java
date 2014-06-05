package com.kildeen.ref.security;

import com.kildeen.ref.system.SystemNodeResolver;
import com.kildeen.ref.system.TestPages;
import com.kildeen.ref.testutil.CDIRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import static org.junit.Assert.*;

/**
 * <p>File created: 2014-05-07 20:37</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
@RunWith(CDIRunner.class)
public class PermissionResolverImplTest {
    @Inject
    private SystemNodeResolver systemNodeResolver;

    @Test
    public void test_that_permissions_can_be_found_using_node_name() throws Exception {
        assertNotNull(systemNodeResolver.getDefinitionByName(TestPages.Admin.CreateUser.class.getCanonicalName()));
        assertNotNull(systemNodeResolver.getByNodeName(TestPages.Admin.CreateUser.Delete.class.getCanonicalName()));
    }
}
