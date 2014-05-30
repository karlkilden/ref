package com.kildeen.ref.application;

import com.kildeen.ref.system.Current;
import org.apache.deltaspike.core.api.exception.control.ExceptionHandler;
import org.apache.deltaspike.core.api.exception.control.Handles;
import org.apache.deltaspike.core.api.exception.control.event.ExceptionEvent;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <p>File created: 2014-05-29 13:12</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
@SessionScoped
@ExceptionHandler
public class ExceptionQueue implements Serializable {

    private Deque<ExceptionEvent> exceptionEvents = new ArrayDeque<>();

    public void handleException(@Handles ExceptionEvent<Exception> event) {
        exceptionEvents.add(event);
        event.handled();
    }

    public Deque<ExceptionEvent> getExceptionEvents() {
        return exceptionEvents;
    }
}
