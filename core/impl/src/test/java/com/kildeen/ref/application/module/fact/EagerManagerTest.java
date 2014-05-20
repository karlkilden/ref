package com.kildeen.ref.application.module.fact;

import com.kildeen.ref.domain.Word;
import com.kildeen.ref.domain.WordOccurrence;
import com.kildeen.ref.testutil.CDIRunner;
import com.kildeen.ref.testutil.EJBRunner;
import org.apache.bval.constraints.NotEmpty;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.deltaspike.data.api.QueryResult;
import org.apache.openejb.junit.jee.EJBContainerRunner;
import org.apache.openejb.junit.jee.config.Properties;
import org.apache.openejb.junit.jee.config.Property;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * <p>File created: 2014-04-23 07:20</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
@RunWith(CDIRunner.class)
@Properties({@Property(key="openejb.jpa.init-entitymanager", value = "true")})
public class EagerManagerTest {



    @Test
    public void content_should_not_be_null_nor_empty () {
        assertEquals("","");
    }
}
