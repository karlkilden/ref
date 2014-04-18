package com.kildeen.ref.login;

/**
 * <p>File created: 2014-04-18 14:32</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */

import com.kildeen.ref.CoreTest;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

@Model
public class LoginBean {

    @Inject
    private CoreTest coreTest;
    private String hello;

    @PostConstruct
    private void loadMessage() {
        this.hello = coreTest.getHelloWorld();
    }

    public String getHello() {
        return hello;
    }
}
