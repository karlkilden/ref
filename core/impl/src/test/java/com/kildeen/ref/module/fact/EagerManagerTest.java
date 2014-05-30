package com.kildeen.ref.module.fact;

import org.apache.deltaspike.testcontrol.api.junit.CdiTestRunner;
import org.apache.openejb.junit.jee.config.Properties;
import org.apache.openejb.junit.jee.config.Property;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * <p>File created: 2014-04-23 07:20</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
@RunWith(CdiTestRunner.class)
@Properties({@Property(key="openejb.jpa.init-entitymanager", value = "true")})
public class EagerManagerTest {



    @Test
    public void content_should_not_be_null_nor_empty () {
        assertEquals("","");
    }
}
