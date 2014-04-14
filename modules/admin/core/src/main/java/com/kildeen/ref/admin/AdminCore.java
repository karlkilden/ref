package com.kildeen.ref.admin;

import org.apache.deltaspike.core.api.config.view.navigation.event.PreViewConfigNavigateEvent;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * <p>File created: 2014-04-13 00:35</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
public class AdminCore {

    @PersistenceContext(unitName = "book-pu")
    private EntityManager entityManager;


    private String helloWorld ="Hello, World!!!";

    public String getHelloWorld() {
        return helloWorld;
    }

    @Produces
    private EntityManager getEntityManager() {
        return entityManager;
    }

    private void listen(@Observes PreViewConfigNavigateEvent event) {
        event.getFromView();
            System.out.print("aaaa");
        event.navigateTo(Apa.class);
    }

}
