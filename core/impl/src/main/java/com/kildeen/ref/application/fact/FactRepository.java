package com.kildeen.ref.application.fact;

import com.kildeen.ref.domain.Book;
import com.kildeen.ref.domain.Fact;
import org.apache.deltaspike.data.api.*;

import java.util.List;

/**
 * <p>File created: 2014-04-22 22:22</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
@Repository
public interface FactRepository extends EntityRepository<Fact, Long> {

    @Query(named = Fact.BY_NAME)
    public Fact fetchByName(@QueryParam("name") String name);

    @Query("select fact from Fact fact")
    QueryResult<Fact> fetchAll();

    public Fact findByNameEqual(String name);
}
