package com.kildeen.ref;

import javax.enterprise.context.ApplicationScoped;

/**
 * <p>File created: 2014-04-12 10:05</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
@ApplicationScoped
public class CoreHelloWorldImpl implements CoreHelloWorld {
    @Override
    public String getHelloWorld() {
        return "Hello, World!";
    }
}
