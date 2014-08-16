package com.kildeen.ref.module.authorization;

import com.kildeen.ref.application.MapperUtil;
import com.kildeen.ref.domain.Group;
import com.kildeen.ref.domain.Permission;
import com.kildeen.ref.domain.User;
import org.apache.deltaspike.data.api.mapping.SimpleQueryInOutMapperBase;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>File created: 2014-04-30 22:40</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
@ApplicationScoped
public class GroupMapper extends BaseMapper<Group, GroupDTO> {

    @Inject
    private GroupService groupService;

    @Inject
    private EntityManager em;


    @Override
    protected Object getPrimaryKey(final GroupDTO groupDTO) {
        return MapperUtil.getId(groupDTO);
    }

    @Override
    protected GroupDTO toDto(final Group group) {

        GroupDTO dto = new GroupDTO(group.getName(), group.getPermissions());
        MapperUtil.toAuditDTO(dto, group);

        List<UserDTO> users = new ArrayList<>();

        if (group.getUsers() != null) {

            for (User user : group.getUsers()) {
                users.add(createUserDTO(dto, user));
            }
            dto.setUsers(users);
        }

        if (group.getLatestAddedUser() != null)
        dto.setLatestAddedUser(createUserDTO(dto, group.getLatestAddedUser()));
        return dto;
    }



    private UserDTO createUserDTO(final GroupDTO dto, final User user) {
        UserDTO userDTO = new UserDTO();
        MapperUtil.toDTO(userDTO, user);
        userDTO.setName(user.getName());
        userDTO.setGroup(dto);
        return  userDTO;
    }

    @Override
    protected Group toEntity(Group group, final GroupDTO groupDTO) {

        if (group == null) {
            group = new Group();
        }
        MapperUtil.toAuditEntity(group, groupDTO);
        group.setName(groupDTO.getName());
        List<Permission> permissionsList = new ArrayList<>();

        for (Permission g: groupDTO.getPermissions()) {
                permissionsList.add(em.find(Permission.class, g.getId()));
        }

        group.setPermissions(permissionsList);
        return group;
    }
}
