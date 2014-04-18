package com.kildeen.ref.admin;

import org.apache.deltaspike.testcontrol.api.junit.CdiTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * <p>File created: 2014-04-17 17:39</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
@RunWith(CdiTestRunner.class)
public class AdminCoreTest {


    @Inject
    Teest bookService;

    @Test
    public void test() {
        assertNotNull(bookService.hello());
        assertEquals(bookService.hello(), "hello");
    }

}
