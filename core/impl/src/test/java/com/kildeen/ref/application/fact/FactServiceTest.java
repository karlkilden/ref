package com.kildeen.ref.application.fact;

import com.kildeen.ref.domain.Word;
import com.kildeen.ref.domain.WordOccurrence;
import com.kildeen.ref.testutil.EJBRunner;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.deltaspike.data.api.QueryResult;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

import static org.junit.Assert.*;

/**
 * <p>File created: 2014-04-23 07:20</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
@RunWith(EJBRunner.class)
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
        List<FactDTO> facts = factService.fetchAll();
        assertNotNull(factService.fetchByName("Highlander2"));

        assertNotNull(factService.findByNameEquals("Highlander2").getContent());

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
    public void bulk_save_should_be_readable_as_pages() {
        for (int i = 0; i < 100; i++) {
            FactDTO fact = new FactDTO();
            fact.setName(RandomStringUtils.random(5));
            factService.save(fact);
        }
        QueryResult<FactDTO> result = factService.fetchAllResult().withPageSize(100);
        int totalPages = result.countPages();
        result.count();
        result.getResultList();
        result.nextPage().getResultList();
        result.nextPage().getResultList();

    }
}
