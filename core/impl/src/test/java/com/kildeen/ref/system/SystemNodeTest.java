package com.kildeen.ref.system;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * <p>File created: 2014-05-03 00:02</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
public class SystemNodeTest {

    SystemNodeImpl node = new SystemNodeImpl(TestPages.class, null);

    @Test
    public void node_with_no_parent_is_marked_as_root() {
        assertTrue(node.isRoot());
    }

    @Test
    public void node_with_stem_parent_and_defined_as_interface_is_stem (){
        assertTrue(node.children().get(0).isStem());
    }

    @Test(expected = RuntimeException.class)
    public void stem_with_no_children_is_recognized_as_invalid() {
        SystemNode node = new SystemNodeImpl(InvalidStem.class, null);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void branch_with_branch_as_child_is_recognized_as_invalid() {
        SystemNode node = new SystemNodeImpl(InvalidLeaf.class, null);
    }
}
