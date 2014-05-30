package com.kildeen.ref.module.authorization;

import com.kildeen.ref.domain.User;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;
import org.apache.deltaspike.data.api.mapping.MappingConfig;

/**
 * <p>File created: 2014-04-22 22:22</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
@Repository(forEntity = User.class)
@MappingConfig(UserMapper.class)
public interface UserRepository extends EntityRepository<UserDTO, Long> {

    public UserDTO findOptionalByNameEqual(String name);

}
