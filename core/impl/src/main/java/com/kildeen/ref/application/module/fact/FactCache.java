package com.kildeen.ref.application.module.fact;

import javax.annotation.PostConstruct;
import javax.cache.Cache;
import javax.cache.CacheManager;
import javax.cache.Caching;
import javax.cache.configuration.MutableConfiguration;
import javax.cache.expiry.AccessedExpiryPolicy;
import javax.cache.expiry.Duration;
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
public class FactCache {

    public static final String FACT_CACHE = "factCache";
    @Produces
    private Cache<Long, FactDTO> cache;

    @PostConstruct
    private void setup() {
        CacheManager cacheManager = Caching.getCachingProvider().getCacheManager();
        MutableConfiguration conf = new MutableConfiguration<Long, FactDTO>();
        conf.setExpiryPolicyFactory(AccessedExpiryPolicy.factoryOf(Duration.ONE_HOUR))
                .setStatisticsEnabled(true);
        cache = cacheManager.createCache(FACT_CACHE, conf);

    }

}
