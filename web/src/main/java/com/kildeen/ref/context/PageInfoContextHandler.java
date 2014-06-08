package com.kildeen.ref.context;

import com.kildeen.ref.UserContext;
import com.kildeen.ref.system.SystemNode;
import org.apache.commons.collections4.Factory;
import org.apache.commons.collections4.map.LazyMap;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>File created: 2014-06-07 13:06</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
@SessionScoped
public class PageInfoContextHandler implements Serializable {

    @Inject
    private UserContext userContext;

    private PageInfoContext pageInfoContext;
    private SystemNode systemNode;
    Map<SystemNode, PageInfoContext> PageInfoContextCache;

    public PageInfoContext getPageInfoContext(SystemNode systemNode) {
        this.systemNode = systemNode;
        pageInfoContext = PageInfoContextCache.get(systemNode);
        return pageInfoContext;
    }

    @PostConstruct
    public void init() {

        Factory<PageInfoContext> factory = new Factory<PageInfoContext>() {

            public PageInfoContext create() {
                return new PageInfoContext(userContext.getGroup().getPermissionSet(), systemNode.getPageInfo());
            }
        };
        PageInfoContextCache = LazyMap.lazyMap(new HashMap<SystemNode, PageInfoContext>(), factory);
    }


}
