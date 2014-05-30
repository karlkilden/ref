package com.kildeen.ref.module.fact;

import com.kildeen.ref.domain.Fact;
import org.apache.deltaspike.data.api.*;
import org.apache.deltaspike.data.api.mapping.MappingConfig;

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

    public FactDTO findOptionalByNameEqual(String name);

    @Query("select fact from Fact fact")
    QueryResult<FactDTO> fetchAll();

}
