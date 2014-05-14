package com.kildeen.ref.application.module.user;

import com.kildeen.ref.domain.User;

import java.util.List;

/**
 *
 */
public interface UserService {

    public User fetchByName(String name);

    public List<User> fetchUsers();

    public User fetchUser(long id);

}