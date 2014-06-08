package com.kildeen.ref.context;

import com.kildeen.ref.BundleBean;
import com.kildeen.ref.UserContext;
import com.kildeen.ref.domain.BaseEntity;
import com.kildeen.ref.system.*;
import org.primefaces.application.exceptionhandler.ExceptionInfo;
import org.slf4j.Logger;

import javax.annotation.PostConstruct;
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
    private UserContext userContext;

    @Inject
    private BundleBean bundleBean;

    @Inject
    private EntityLookup entityLookup;

    @Inject
    PageInfoContextHandler pageInfoContextHandler;


    private SystemNode systemNode;

    private String currentEntity;
    private PageType pageType;

    private boolean loaded;

    private PageInfoContext page;

    @Produces
    @Current
    public SystemNode getSystemNode() {

        return systemNode;
    }

    private ExceptionInfo exceptionInfo;

    @PostConstruct
    private void refreshSystemNode() {
        FacesContext fc = FacesContext.getCurrentInstance();
        if (fc != null) {
            systemNode = systemNodeResolver.getByPath(fc.getViewRoot().getViewId());
            if (systemNode == null) {
                throw new RuntimeException(fc.getViewRoot().getViewId() + " Not found as node");
            }
            if (systemNode.getPageInfo() != null)
            page = pageInfoContextHandler.getPageInfoContext(systemNode);
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
        loaded = true;
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

    public PageInfoContext getPage() {
        return page;
    }
}
