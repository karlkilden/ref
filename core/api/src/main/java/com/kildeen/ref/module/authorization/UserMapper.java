package com.kildeen.ref.module.authorization;

import com.kildeen.ref.application.MapperUtil;
import com.kildeen.ref.module.user.UserService;
import com.kildeen.ref.domain.User;
import org.apache.deltaspike.data.api.mapping.SimpleQueryInOutMapperBase;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 * <p>File created: 2014-04-30 22:40</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
@ApplicationScoped
public class UserMapper extends SimpleQueryInOutMapperBase<User, UserDTO> {

    @Inject
    private UserService userService;

    @Inject
    GroupMapper groupMapper;

    @Inject
    private EntityManager em;


    @Override
    protected UserDTO toDto(final User user) {

        UserDTO dto = new UserDTO(user.getName());
        MapperUtil.toAuditDTO(dto, user);
        dto.setEmail(user.getEmail());
        dto.setLocale(user.getLocale());
        if (user.getGroup() != null)
        dto.setGroup(groupMapper.toDto(user.getGroup()));
        return dto;
    }

    @Override
    protected User toEntity(final UserDTO userDTO) {
        User user;
        if (userDTO.getId() != 0) {
            user = em.find(User.class, userDTO.getId());
        }
        else {
            user = new User();
        }
        MapperUtil.toAuditEntity(user, userDTO);
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setLocale(userDTO.getLocale());
        user.setGroup(groupMapper.toEntity(userDTO.getGroup()));
        return user;
    }
}
