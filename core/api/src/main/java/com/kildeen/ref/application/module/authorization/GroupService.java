package com.kildeen.ref.application.module.authorization;

import com.kildeen.ref.domain.Permission;

import java.util.List;

/**
 *
 */
public interface GroupService {
    public List<GroupDTO> fetchGroups();
    public GroupDTO fetchGroup(long id);

    GroupDTO createGroup(GroupDTO groupDTO);
}
