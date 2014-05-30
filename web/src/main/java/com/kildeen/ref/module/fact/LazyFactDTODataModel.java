package com.kildeen.ref.module.fact;
 
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.kildeen.ref.domain.Fact;
import org.apache.deltaspike.data.api.QueryResult;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

/**
 * Dummy implementation of LazyDataModel that uses a list to mimic a real datasource like a database.
 */
public class LazyFactDTODataModel extends LazyDataModel<FactDTO> {

    private final QueryResult<FactDTO> result;
    private FactService factService;
    private FactMapper factMapper;

    public LazyFactDTODataModel(FactService factService, FactMapper factMapper) {
        this.factService = factService;
        this.factMapper = factMapper;
        result = factService.fetchAllResult().withPageSize(5);
        this.setRowCount((int) result.count());
    }
     
    @Override
    public FactDTO getRowData(String rowKey) {
        return factService.fetchById(Long.parseLong(rowKey));
    }
 
    @Override
    public Object getRowKey(FactDTO fact) {
        return fact.getId();
    }
 
    @Override
    public List<FactDTO> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,Object> filters) {
        List<FactDTO> data = new ArrayList<>();
        result.toPage(first/5);

        //filter
        for(Object fact : result.getResultList()) {
            data.add(factMapper.toDto((Fact) fact));
        }
        //sort
//        if(sortField != null) {
//            Collections.sort(data, new LazySorter(sortField, sortOrder));
//        }
 
        //rowCount
        int dataSize = data.size();
 
        //paginate

        return data;
    }
}