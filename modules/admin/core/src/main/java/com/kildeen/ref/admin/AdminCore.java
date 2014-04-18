package com.kildeen.ref.admin;

import org.apache.deltaspike.core.api.config.view.navigation.event.PreViewConfigNavigateEvent;

import javax.ejb.Stateless;
import javax.enterprise.event.Observes;

/**
 * <p>File created: 2014-04-13 00:35</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
@Stateless
public class AdminCore {



    private String helloWorld ="Hello, World!!!";

    public String getHelloWorld() {
        return helloWorld;
    }


    private void listen(@Observes PreViewConfigNavigateEvent event) {
        event.getFromView();
            System.out.print("aaaa");
    }

}
