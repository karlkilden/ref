package com.kildeen.ref.application.fact;

import com.kildeen.ref.domain.Fact;

import javax.annotation.PostConstruct;
import javax.cache.Cache;
import javax.cache.CacheManager;
import javax.cache.Caching;
import javax.cache.configuration.MutableConfiguration;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

/**
 * <p>File created: 2014-04-21 17:26</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
@ApplicationScoped
public class WordCache {
    @Produces
    Cache<String, Fact> cache;
    @PostConstruct
    private void setup() {
        CacheManager cacheManager = Caching.getCachingProvider().getCacheManager();
        cache = cacheManager.createCache(this.getClass().getName(), new MutableConfiguration<String, Fact>());
    }


}
