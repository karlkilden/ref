package com.kildeen.ref.module.fact;

import com.kildeen.ref.testutil.CDIRunner;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.deltaspike.data.api.QueryResult;
import org.apache.openejb.junit.jee.config.Properties;
import org.apache.openejb.junit.jee.config.Property;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 * Created with IntelliJ IDEA.
 * User: Karl Kildén
 * Date: 2014-05-20
 */

@RunWith(CDIRunner.class)
@Properties({@Property(key="openejb.jpa.init-entitymanager", value = "true")})

public class SlowFactServiceTest {

        @Inject
        FactService factService;

        @Inject
        WordRepository wordRepository;

        @Inject
        EntityManager em;


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
