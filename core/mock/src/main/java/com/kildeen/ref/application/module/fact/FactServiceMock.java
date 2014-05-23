package com.kildeen.ref.application.module.fact;

import com.kildeen.ref.application.Database;
import org.apache.deltaspike.data.api.QueryResult;

import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import java.util.List;

/**
 * <p>File created: 2014-04-22 22:24</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
@ApplicationScoped
@Alternative
public class FactServiceMock implements FactService {


    @Inject
    private Database database;

    @Override
    public void save(FactDTO fact) {

    }


    @Override
    public void remove(FactDTO fact) {
    }


    @Override
    public FactDTO fetchById(long id) {

        for (FactDTO factDTO : database.getAllFacts()) {
            if (factDTO.getId() == id) {
                return factDTO;
            }
        }
        return null;
    }


    public FactDTO getById(long id) {
        return null;
    }

    @Override
    public FactDTO fetchByName(String name) {


        for (FactDTO factDTO : database.getAllFacts()) {
            if (factDTO.getName().equals(name)) {
                return factDTO;
            }
        }
        return null;
    }


    @Override
    public QueryResult<FactDTO> fetchAllResult() {
        // to much work to mock
        return null;


    }


    @Override
    public List<FactDTO> getAll() {

        return database.getAllFacts();
    }


}
