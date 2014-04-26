package com.kildeen.ref.application.fact;

import com.kildeen.ref.domain.Book;
import com.kildeen.ref.domain.Fact;
import org.apache.deltaspike.data.api.*;
import org.apache.deltaspike.data.api.mapping.MappingConfig;

import java.util.List;

/**
 * <p>File created: 2014-04-22 22:22</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
@Repository (forEntity = Fact.class)
@MappingConfig(FactMapper.class)
public interface FactRepository extends EntityRepository<FactDTO, Long> {

    @Query(named = Fact.BY_NAME)
    public FactDTO fetchByName(@QueryParam("name") String name);

    @Query("select fact from Fact fact")
    QueryResult<FactDTO> fetchAll();

    public FactDTO findByNameEqual(String name);
}
