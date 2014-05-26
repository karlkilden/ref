package com.kildeen.ref.context;

import com.kildeen.ref.Produced;
import com.kildeen.ref.system.SystemNodeResolver;
import org.apache.deltaspike.core.api.common.DeltaSpike;
import org.apache.deltaspike.core.api.config.view.metadata.ConfigDescriptor;
import org.apache.deltaspike.core.api.config.view.metadata.ViewConfigDescriptor;
import org.apache.deltaspike.core.api.config.view.metadata.ViewConfigResolver;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.HashMap;

/**
 * <p>File created: 2013-12-16 19:34</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
@Produced
public class RequestContext implements Serializable {

    @Inject
    private FacesContext facesContext;

    @Inject
    private ViewConfigResolver viewConfigResolver;

    @Inject
    private SystemNodeResolver systemNodeResolver;

    private String url;
    private String root;
    private HttpServletRequest  httpServletRequest;

    @PostConstruct
    private void init() {
        httpServletRequest = (HttpServletRequest) facesContext.getExternalContext().getRequest();
        root = httpServletRequest.getContextPath();
        url = httpServletRequest.getRequestURI().replace(root, "");
    }

    public String getUrl() {
        return httpServletRequest.getRequestURI();
    }

    public String getRoot() {
        return root;
    }

    public String getPage() {
        return url;
    }

    public HttpServletRequest getRequest() {
        return httpServletRequest;
    }


}
