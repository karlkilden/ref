package com.kildeen.ref.application.fact;

import com.kildeen.ref.domain.Fact;
import com.kildeen.ref.testutil.CDIRunner;
import junit.framework.TestCase;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.deltaspike.data.api.QueryResult;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import static org.junit.Assert.assertNotNull;

/**
 * <p>File created: 2014-04-23 07:20</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
@RunWith(CDIRunner.class)
public class FactServiceTest {

    @Inject
    FactService factService;

    @Test
    public void testSave() throws Exception {
        Fact fact = new Fact();
        fact.setName("Highlander");
          factService.save(fact);
        assertNotNull(factService.fetchByName("Highlander"));
        assertNotNull(factService.findByNameEquals("Highlander"));

    }

    @Test
    public void bulkTest() {
        for (int i =0; i< 100; i++) {
            Fact fact = new Fact();
            fact.setName(RandomStringUtils.random(5));
            factService.save(fact);
        }
        QueryResult<Fact> result = factService.fetchAllResult().withPageSize(100);
        int totalPages = result.countPages();
        System.out.print("PAGES   "+totalPages);
        result.count();
        result.getResultList();
        result.nextPage().getResultList();
        result.nextPage().getResultList();

    }

    public void testRemove() throws Exception {

    }

    public void testGetAll() throws Exception {

    }

    public void testFetchById() throws Exception {

    }

    public void testGetById() throws Exception {

    }
}
