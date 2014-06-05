package com.kildeen.ref.context;

import com.kildeen.ref.BundleBean;
import com.kildeen.ref.domain.BaseEntity;
import com.kildeen.ref.security.PermissionResolver;
import com.kildeen.ref.system.Current;
import com.kildeen.ref.system.LogManager;
import com.kildeen.ref.system.SystemNode;
import com.kildeen.ref.system.SystemNodeResolver;
import org.apache.deltaspike.core.api.config.view.navigation.event.PreViewConfigNavigateEvent;
import org.primefaces.application.exceptionhandler.ExceptionInfo;
import org.slf4j.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;
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

    private static final Logger log = LogManager.getLogger();

    @Inject
    private SystemNodeResolver systemNodeResolver;

    @Inject
    private BundleBean bundleBean;

    @Inject
    private EntityLookup entityLookup;

    @Inject
    private PermissionResolver permissionResolver;

    private SystemNode systemNode;

    private String currentEntity;
    private PageType pageType;
    private boolean loaded;

    private ExceptionInfo exceptionInfo;

    private void registerPageChange(@Observes PreViewConfigNavigateEvent preViewConfigNavigateEvent) {
        systemNode = systemNodeResolver.getByDefinition(preViewConfigNavigateEvent.getToView());

        if (systemNode == null) {
            throw new RuntimeException(preViewConfigNavigateEvent.getToView().getName() + " Not found as node");
        }
        log.info("new page: {}", systemNode.getPage());
    }

    @Produces
    @Current
    public SystemNode getSystemNode() {

        return systemNode;
    }



    @PostConstruct
    private void refreshSystemNode() {
        FacesContext fc = FacesContext.getCurrentInstance();
        if (fc != null) {
            systemNode = systemNodeResolver.getByPath(fc.getViewRoot().getViewId());
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

    //Lazy load of information not usually needed
    private synchronized void lazyLoadAdditionalInformation() {
        if (!loaded) {
            String page = systemNode.getPage().toLowerCase();

            for (PageType pageType : PageType.values()) {
                if (page.contains(pageType.toString().toLowerCase())) {


                    this.pageType = pageType;
                }
            }

            for (Class<? extends BaseEntity> entity : entityLookup.getEntityClasses()) {
                String className = entity.getSimpleName().toLowerCase();
                if (page.contains(className)) {
                    currentEntity = entity.getSimpleName();
                }
            }
            if (currentEntity == null) {
                currentEntity = "Unknown";
            }
        }

    }

    public ExceptionInfo getExceptionInfo() {
        return exceptionInfo;
    }

    public void setExceptionInfo(final ExceptionInfo exceptionInfo) {
        this.exceptionInfo = exceptionInfo;
    }

    public String currentEntity() {
        lazyLoadAdditionalInformation();
        return currentEntity;
    }

    public PageType pageType() {
        lazyLoadAdditionalInformation();
        return pageType;
    }

}
