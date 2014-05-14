package com.kildeen.ref.application.module.fact;

import org.apache.deltaspike.data.api.QueryResult;

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

public class FactServiceImpl implements FactService {

    @Inject
    private FactRepository factRepository;

    @Inject
    private Cache<Long, FactDTO> cache;

    
    @Override
    public void save(FactDTO fact) {
    factRepository.saveAndFlush(fact);

    }

    
    @Override
    @CacheRemove
    public void remove(FactDTO fact) {
        factRepository.remove(fact);
    }

    
    @Override
    @CacheResult
    public FactDTO fetchById(long id) {
        return factRepository.findBy(id);
    }

    
    @Override
    public FactDTO getById(long id) {
        return cache.get(id);
    }

    @Override
    public FactDTO fetchByName(String name) {
        return factRepository.findOptionalByNameEqual(name);
    }

    
    @Override
    public QueryResult<FactDTO> fetchAllResult() {
       return factRepository.fetchAll();
    }

    
    @Override
    @CacheResult
    public List<FactDTO> getAll() {
        return factRepository.findAll();
    }


}
