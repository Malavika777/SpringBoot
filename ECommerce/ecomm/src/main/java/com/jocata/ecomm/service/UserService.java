package com.jocata.ecomm.service;

import com.jocata.ecomm.entity.User;

import java.util.List;

public interface UserService {

    User createUser(User user);
    User updateUser(User user);
    User getUserById(long id);
    void deleteUser(User user);
    List<User> getAllUsers();
}
