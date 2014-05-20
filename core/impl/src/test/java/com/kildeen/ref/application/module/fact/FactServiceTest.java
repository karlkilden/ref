package com.kildeen.ref.application.module.fact;

import com.kildeen.ref.application.RollBackException;
import com.kildeen.ref.domain.Word;
import com.kildeen.ref.domain.WordOccurrence;
import com.kildeen.ref.testutil.CDIRunner;
import com.kildeen.ref.testutil.EJBRunner;
import org.apache.bval.constraints.NotEmpty;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.deltaspike.data.api.QueryResult;
import org.apache.deltaspike.testcontrol.api.junit.CdiTestRunner;
import org.apache.openejb.junit.jee.EJBContainerRunner;
import org.apache.openejb.junit.jee.config.Properties;
import org.apache.openejb.junit.jee.config.Property;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.OptimisticLockException;
import javax.persistence.TypedQuery;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Scanner;
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
public class FactServiceTest {

    @Inject
    FactService factService;

    @Inject
    WordRepository wordRepository;

    @Inject
    EntityManager em;

    @Test
    public void a_fact_dto_should_be_persisted_and_read_back_() throws Exception {
        FactDTO fact = new FactDTO();
        fact.setName("Highlander2");
        fact.setContent("hello 123");
        factService.save(fact);
        List<FactDTO> facts = factService.getAll();
        assertNotNull(factService.fetchByName("Highlander2"));
        assertNotNull(factService.fetchByName("Highlander2").getContent());
        FactDTO test1 = facts.get(0);
        test1.setContent(test1.getContent() + " test");
        factService.save(test1); 

        FactDTO test2 = factService.fetchById(test1.getId());
        System.out.print(test2);
    }


    @Test(expected = Exception.class)
    public void optimistic_lock_fail_when_version_is_different() throws Exception {
        FactDTO fact = new FactDTO();
        fact.setName("testabc");
        fact.setContent("testabctest");
        factService.save(fact);
        List<FactDTO> facts = factService.getAll();

        FactDTO test1 = facts.get(0);

        test1.setContent(test1.getContent() + " test");
        factService.save(test1);
        em.detach(test1);

        FactDTO test2 = factService.fetchById(test1.getId());
        test2.setContent("ggggg");
        factService.save(test2);
        test1.setContent("gg2");
        factService.save(test1);


    }


    @Test
    public void same_word_used_twice_should_only_be_one_instance() throws Exception {
        FactDTO fact = new FactDTO();
        fact.setName("test");
        fact.setContent("hello 123");
        factService.save(fact);

        FactDTO fact2 = new FactDTO();
        fact.setName("test2");
        fact.setContent("hello 123");
        factService.save(fact2);

        boolean found = false;
        for (Word word : wordRepository.findAll()) {
            if (word.getString().equals("hello")) {
                if (found) {
                    fail("found hello twice");
                }
                found = true;
            }
        }

    }

    @Test
    public void same_word_used_twice_should_be_two_occurrences() throws Exception {
        FactDTO fact = new FactDTO();
        fact.setName("test");
        fact.setContent("asdfkoasdfko");
        factService.save(fact);
        FactDTO fact2 = new FactDTO();
        fact2.setName("test2");
        fact2.setContent("asdfkoasdfko");
        factService.save(fact2);
        int expectedCount = 2;
        TypedQuery<WordOccurrence> q = em.createQuery("Select wordOccurence from WordOccurrence wordOccurence", WordOccurrence.class);
        for (WordOccurrence wo : q.getResultList()) {
            if ("asdfkoasdfko".equals(wo.getWord().getString())) {
                expectedCount--;
            }
        }
        assertEquals(0, expectedCount);

    }

    @Test
    public void content_should_not_be_null_nor_empty () {

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

        Validator validator = factory.getValidator();

        FactDTO client = new FactDTO();

        client.setName("Hello");
        client.setContent("");

        Set<ConstraintViolation<FactDTO>> constraintViolations = validator.validate(client);
        assertNotNull(constraintViolations);
        assertTrue(constraintViolations.size() > 0);
        assertTrue(constraintViolations.iterator().next().getConstraintDescriptor().getAnnotation().annotationType().equals(NotEmpty.class));

        client.setContent(null);

        constraintViolations = validator.validate(client);
        assertNotNull(constraintViolations);
        assertTrue(constraintViolations.size() > 0);
        assertTrue(constraintViolations.iterator().next().getConstraintDescriptor().getAnnotation().annotationType().equals(NotNull.class));
    }
}
