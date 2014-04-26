package com.kildeen.ref.application.fact;

import com.kildeen.ref.domain.Fact;
import org.apache.deltaspike.data.api.QueryResult;

import javax.cache.Cache;
import javax.cache.annotation.CacheDefaults;
import javax.cache.annotation.CacheRemove;
import javax.cache.annotation.CacheResult;
import javax.ejb.Stateless;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.*;
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
    private Cache<Long, FactDTO> cache;

    @PersistenceContext(unitName = "ref")
    private EntityManager entityManager;

    public void save(FactDTO fact) {
    factRepository.saveAndFlush(fact);

    }

    @CacheRemove
    public void remove(FactDTO fact) {
        factRepository.remove(fact);
    }

    @CacheResult
    public List<FactDTO> getAll() {
        return factRepository.findAll();
    }

    @CacheResult
    public FactDTO fetchById(long id) {
        return factRepository.findBy(id);
    }

    public FactDTO getById(long id) {
        return cache.get(id);
    }

    public FactDTO fetchByName(String name) {
        return factRepository.fetchByName(name);
    }

    public QueryResult<FactDTO> fetchAllResult() {
       return factRepository.fetchAll();
    }

    public FactDTO findByNameEquals(String equals) {
        return factRepository.fetchByName(equals);
    }

    public List<FactDTO> fetchAll() {
        return factRepository.findAll();
    }


}
