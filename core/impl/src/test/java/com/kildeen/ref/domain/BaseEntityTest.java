package com.kildeen.ref.domain;

import org.junit.Assert;
import org.junit.Test;

import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: Karl Kildén
 * Date: 2014-06-05
 */

public class BaseEntityTest {

    @Test
    public void that_equals_should_always_consider_non_zero_id_first() {
        BaseEntity e = new BaseEntity();
        BaseEntity e2 = new BaseEntity();

        e.setId(10);
        e2.setId(10);
        assertTrue(e.baseEquals(e2));
        assertTrue(e.baseEquals(e2, "left side", " "));
    }

    @Test
    public void that_other_comparables_matching_is_considered_equal_when_ids_are_zero() {
        BaseEntity e = new BaseEntity();
        BaseEntity e2 = new BaseEntity();

        assertTrue(e.baseEquals(e2, "1", "1", Boolean.TRUE, Boolean.TRUE));
    }

    @Test
    public void that_baseEquals_comparing_id_only_returns_null_when_both_entites_have_zero_ids() {
        BaseEntity e = new BaseEntity();
        BaseEntity e2 = new BaseEntity();

        assertNull(e.baseEquals(e2));
    }

}
