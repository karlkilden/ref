package com.kildeen.ref.system;

import org.apache.deltaspike.core.api.exception.control.ExceptionHandler;
import org.apache.deltaspike.core.api.exception.control.Handles;
import org.apache.deltaspike.core.api.exception.control.event.ExceptionEvent;
import org.slf4j.Logger;

import javax.enterprise.context.ApplicationScoped;

/**
 * <p>File created: 2014-05-28 23:16</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
@ExceptionHandler
@ApplicationScoped
public class ApplicationExceptionHandler {
    private static final Logger log = LogManager.getLogger();
    public void handleException(@Handles(ordinal = 100) ExceptionEvent<Exception> event) {
        log.error("JSF caught Exception: ", event.getException());
    }
}
