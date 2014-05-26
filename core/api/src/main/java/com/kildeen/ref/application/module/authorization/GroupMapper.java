package com.kildeen.ref.application.module.authorization;

import com.kildeen.ref.application.MapperUtil;
import com.kildeen.ref.domain.Group;
import org.apache.deltaspike.data.api.mapping.SimpleQueryInOutMapperBase;

import javax.inject.Inject;

/**
 * <p>File created: 2014-04-30 22:40</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
public class GroupMapper extends SimpleQueryInOutMapperBase<Group, GroupDTO> {

    @Inject
    private GroupService groupService;

    @Override
    protected GroupDTO toDto(final Group group) {

        GroupDTO dto = new GroupDTO(group.getName(), group.getPermissions());
        MapperUtil.toAuditDTO(dto, group);
            dto.setUsers(group.getUsers());

        dto.setLatestAddedUser(group.getLatestAddedUser());
        return dto;
    }

    @Override
    protected Group toEntity(final GroupDTO groupDTO) {
        Group group = new Group();
        MapperUtil.toAuditEntity(group, groupDTO);
        group.setName(groupDTO.getName());
        group.setPermissions(groupDTO.getPermissions());
        group.setUsers(groupDTO.getUsers());

        return group;
    }
}
