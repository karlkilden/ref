package com.kildeen.ref.module.authorization;

import com.kildeen.ref.application.Database;
import com.kildeen.ref.system.SystemNodeResolver;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import java.util.List;

/**
 * <p>File created: 2014-04-30 22:38</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
@ApplicationScoped
@Alternative
public class GroupServiceMock implements GroupService {

    @Inject
    Database database;

    @Inject
    private SystemNodeResolver systemNodeResolver;

    @Override
    public List<GroupDTO> fetchAll() {
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
    public GroupDTO save(GroupDTO groupDTO) {
        database.createGroup(groupDTO);
        return groupDTO;
    }

    @Override
    public GroupDTO fetchByName(final String root) {
        for (GroupDTO dto: database.getAllGroups()) {
            if (dto.getName().equals(root)) {
                return dto;
            }
        }
        return null;    }

    @PostConstruct
    private void setupMock() {


    }
}