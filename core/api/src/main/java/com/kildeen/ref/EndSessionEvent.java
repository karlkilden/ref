package com.kildeen.ref;

/**
 * <p>File created: 2014-05-30 21:35</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
public class EndSessionEvent {
    private UserContext userContext;

    public EndSessionEvent(final UserContext userContext) {

        this.userContext = userContext;
    }

    public UserContext getUserContext() {
        return userContext;
    }
}
