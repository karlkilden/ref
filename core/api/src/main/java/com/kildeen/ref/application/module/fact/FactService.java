package com.kildeen.ref.application.module.fact;

import org.apache.deltaspike.data.api.QueryResult;
import java.util.List;

/**
 * <p>File created: 2014-04-26 23:08</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
public interface FactService {
    void save(FactDTO fact);

    void remove(FactDTO fact);

    FactDTO fetchById(long id);

    FactDTO getById(long id);

    FactDTO fetchByName(String name);

    QueryResult<FactDTO> fetchAllResult();

    List<FactDTO> getAll();
}
