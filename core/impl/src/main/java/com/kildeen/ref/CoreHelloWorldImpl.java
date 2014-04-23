package com.kildeen.ref;

import org.apache.deltaspike.data.api.audit.CurrentUser;

import javax.ejb.Stateless;
import javax.enterprise.inject.Produces;

/**
 * <p>File created: 2014-04-12 10:05</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */

public class CoreHelloWorldImpl implements CoreHelloWorld {
    @Override
    public String getHelloWorld() {
        return "hello";
    }

    @Produces
    @CurrentUser
    public String getString() {
        return "apa";
    }
}
