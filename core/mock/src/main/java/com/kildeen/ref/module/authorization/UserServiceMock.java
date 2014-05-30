package com.kildeen.ref.module.authorization;

import com.kildeen.ref.application.Database;
import com.kildeen.ref.module.user.UserService;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import java.util.List;

/**
 * <p>File created: 2014-05-04 18:22</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */

@ApplicationScoped
@Alternative
public class UserServiceMock implements UserService {
    @Inject
    Database database;

    @Override
    public UserDTO fetchByName(String name) {
        for (UserDTO user : database.getAllUsers()) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public List<UserDTO> fetchUsers() {
        return database.getAllUsers();
    }

    @Override
    public UserDTO fetchById(final long id) {
        for (UserDTO user : database.getAllUsers()) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    @Override
    public void save(final UserDTO user) {
        database.getAllUsers().add(user);
    }
}
