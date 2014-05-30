package com.kildeen.ref.module.authorization;

import java.util.List;

/**
 *
 */
public interface GroupService {
    public List<GroupDTO> fetchAll();
    public GroupDTO fetchGroup(long id);

    GroupDTO save(GroupDTO groupDTO);

    GroupDTO fetchByName(String root);
}
