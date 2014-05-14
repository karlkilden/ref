package com.kildeen.ref.application.module.authorization;

import com.kildeen.ref.application.Database;
import com.kildeen.ref.system.SystemNodeResolver;

import javax.annotation.PostConstruct;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.Singleton;
import javax.inject.Inject;
import java.util.List;

import static javax.ejb.ConcurrencyManagementType.BEAN;

/**
 * <p>File created: 2014-04-30 22:38</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
@Singleton
@ConcurrencyManagement(BEAN)
public class GroupServiceMock implements GroupService {

    @Inject
    Database database;

    @Inject
    private SystemNodeResolver systemNodeResolver;

    @Override
    public List<GroupDTO> fetchGroups() {
        return database.getAllGroups();
    }

    @Override
    public GroupDTO fetchGroup(final long id) {

        for (GroupDTO dto: database.getAllGroups()) {
            if (dto.getId() == id) {
                return dto;
            }
        }
              return null;
    }

    @Override
    public GroupDTO createGroup(GroupDTO groupDTO) {
        database.createGroup(groupDTO);
        return groupDTO;
    }

    @PostConstruct
    private void setupMock() {


    }
}