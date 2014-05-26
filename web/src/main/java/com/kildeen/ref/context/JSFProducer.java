package com.kildeen.ref.context;

import com.kildeen.ref.application.WebStartupEvent;
import org.apache.deltaspike.core.api.provider.BeanProvider;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;
import javax.faces.event.PostConstructApplicationEvent;
import javax.inject.Inject;
import java.io.Serializable;

/**
 * <p>File created: 2014-05-07 19:36</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
@ApplicationScoped
public class JSFProducer implements Serializable {

    @Inject
    private Event<WebStartupEvent> event;

    @Produces
    @RequestScoped
    public FacesContext getFacesContext() {
        return FacesContext.getCurrentInstance();
    }


    private void postConstructApplicationEventResend(@Observes PostConstructApplicationEvent jsfPostConstructEvent) {

        event.fire(new WebStartupEvent());
    }
}
