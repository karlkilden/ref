package com.kildeen.ref.module.authorization;

import java.io.Serializable;
import java.util.List;
import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;
 
public class GroupDataModel extends ListDataModel<GroupDTO> implements SelectableDataModel<GroupDTO>, Serializable {
 
    public GroupDataModel() {
    }
 
    public GroupDataModel(List<GroupDTO> data) {
        super(data);
    }
     
    @Override
    public GroupDTO getRowData(String rowKey) {
         
        List<GroupDTO> groups = (List<GroupDTO>) getWrappedData();
         
        for(GroupDTO group : groups) {
            if(group.getName().equals(rowKey))
                return group;
        }
         
        return null;
    }
 
    @Override
    public Object getRowKey(GroupDTO group) {
        return group.getName();
    }
}