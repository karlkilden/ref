package com.kildeen.ref.security;

import com.kildeen.ref.system.PageInfoImpl;
import com.kildeen.ref.system.SystemNode;
import com.kildeen.ref.system.SystemNodeImpl;
import com.kildeen.ref.system.TestPages;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * <p>File created: 2014-06-07 12:42</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
public class PageInfoTest {

    @Test
    public void that_only_isDelete_returns_true_when_a_node_name_ends_with_delete() {


        PageInfoImpl impl = new PageInfoImpl(Arrays.<SystemNode>asList(new SystemNodeImpl(TestPages.Admin.CreateUser.Delete.class, null))) ;

        assertTrue(impl.isDelete());
        assertFalse(impl.isRead());
    }

}
