package com.kildeen.ref.application.fact;

import com.kildeen.ref.domain.Fact;

import javax.cache.Cache;
import javax.cache.annotation.CacheDefaults;
import javax.cache.annotation.CacheRemove;
import javax.cache.annotation.CacheResult;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

/**
 * <p>File created: 2014-04-22 22:24</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
@Stateless
@CacheDefaults(cacheName = FactCache.FACT_CACHE)
public class FactService {

    @Inject
    private FactRepository factRepository;

    @Inject
    private Cache<Long, Fact> cache;

    public void save(Fact fact) {
        factRepository.saveAndFlush(fact);
    }

    @CacheRemove
    public void remove(Fact fact) {
        factRepository.remove(fact);
    }

    @CacheResult
    public List<Fact> getAll() {
        return factRepository.findAll();
    }

    @CacheResult
    public Fact fetchById(long id) {
        return factRepository.findBy(id);
    }

    public Fact getById(long id) {
        return cache.get(id);
    }

}
