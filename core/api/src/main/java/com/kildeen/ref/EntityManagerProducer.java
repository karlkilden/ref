package com.kildeen.ref;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * <p>File created: 2014-04-25 23:31</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
public class EntityManagerProducer {

    @PersistenceContext(unitName = "ref")
    @Produces
    private EntityManager entityManager;
}
