package com.kildeen.ref.module.authorization;

import com.kildeen.ref.module.user.UserService;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.Singleton;
import javax.ejb.TransactionAttribute;
import javax.inject.Inject;
import java.util.List;

import static javax.ejb.ConcurrencyManagementType.BEAN;
import static javax.ejb.TransactionAttributeType.REQUIRES_NEW;

/**
 * <p>File created: 2014-05-04 18:22</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
@Singleton
@ConcurrencyManagement(BEAN)
public class UserServiceImpl implements UserService {

    @Inject
    private UserRepository userRepository;

    @Override
    public UserDTO fetchByName(String name) {
        return userRepository.findOptionalByNameEqual(name);
    }

    @Override
    public List<UserDTO> fetchUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserDTO fetchById(final long id) {
        return userRepository.findBy(id);
    }

    @Override
    @TransactionAttribute(REQUIRES_NEW)
    public void save(final UserDTO user) {
        userRepository.save(user);
    }
}
