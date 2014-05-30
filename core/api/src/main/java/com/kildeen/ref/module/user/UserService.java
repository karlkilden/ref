package com.kildeen.ref.module.user;

import com.kildeen.ref.module.authorization.UserDTO;

import java.util.List;

/**
 *
 */
public interface UserService {

    public UserDTO fetchByName(String name);

    public List<UserDTO> fetchUsers();

    public UserDTO fetchById(long id);

    void save(UserDTO user);
}