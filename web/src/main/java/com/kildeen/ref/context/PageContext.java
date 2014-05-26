package com.kildeen.ref.context;

import com.kildeen.ref.BundleBean;
import com.kildeen.ref.system.SystemNode;
import com.kildeen.ref.system.SystemNodeResolver;
import org.apache.deltaspike.core.api.config.view.navigation.event.PreViewConfigNavigateEvent;

import javax.annotation.PostConstruct;
import javax.enterprise.event.Observes;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * <p>File created: 2013-12-16 19:34</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */

@ViewScoped
@Named
public class PageContext implements Serializable {


    @Inject
    private SystemNodeResolver systemNodeResolver;

    @Inject
    private BundleBean bundleBean;


    private SystemNode systemNode;

    private void registerPageChange(@Observes PreViewConfigNavigateEvent preViewConfigNavigateEvent) {
        systemNode = systemNodeResolver.byDefinition(preViewConfigNavigateEvent.getToView());

        if (systemNode == null) {
            throw new RuntimeException(preViewConfigNavigateEvent.getToView().getName() + " Not found as node");
        }
    }

    public SystemNode getSystemNode() {

        return systemNode;
    }

    @PostConstruct
    private void refreshSystemNode() {
        FacesContext fc = FacesContext.getCurrentInstance();
        if (fc != null) {
            systemNode = systemNodeResolver.byPath(fc.getViewRoot().getViewId());
            if (systemNode == null) {
                throw new RuntimeException(fc.getViewRoot().getViewId() + " Not found as node");
            }
        }
    }

    public String getPageHeader() {
        return bundleBean.getText(systemNode);
    }

    public List<SystemNode> getNodes() {
        if (systemNode.getParent() != null)
            return systemNode.getParent().children();
        return Collections.EMPTY_LIST;
    }


}
