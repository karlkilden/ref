package com.kildeen.ref.system;

import org.apache.deltaspike.core.api.config.view.metadata.ViewConfigResolver;
import org.apache.deltaspike.testcontrol.api.junit.CdiTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import static org.junit.Assert.assertNull;

/**
 * <p>File created: 2014-05-03 00:21</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
@RunWith(CdiTestRunner.class)
public class LeafTest {

    @Inject
    private SystemNodeResolver systemNodeResolver;

    @Inject
    private ViewConfigResolver viewConfigResolver;

    @Test
    public void viewConfigShouldIgnoreLeaf() {
//        assertNull(viewConfigResolver.getConfigDescriptor(Pages.Admin.Group.GroupSetup.Delete.class));
    }

}
