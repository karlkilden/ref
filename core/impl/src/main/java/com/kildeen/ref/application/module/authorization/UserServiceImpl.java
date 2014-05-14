package com.kildeen.ref.application.module.authorization;

import com.kildeen.ref.application.module.user.UserService;
import com.kildeen.ref.domain.User;

import javax.ejb.ConcurrencyManagement;
import javax.ejb.Singleton;
import javax.inject.Inject;
import java.util.List;

import static javax.ejb.ConcurrencyManagementType.BEAN;

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
    public User fetchByName(String name) {
        return userRepository.findOptionalByNameEqual(name);
    }

    @Override
    public List<User> fetchUsers() {
        return userRepository.findAll();
    }

    @Override
    public User fetchUser(final long id) {
        return userRepository.findBy(id);
    }
}
