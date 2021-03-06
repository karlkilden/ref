package com.kildeen.ref;

import org.apache.deltaspike.data.api.audit.CurrentUser;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;

/**
 * <p>File created: 2014-04-25 23:31</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */

@ApplicationScoped
public class PersistenceProducer implements Serializable {

    @PersistenceContext(unitName = "ref")
    @Produces
    private EntityManager entityManager;
}
