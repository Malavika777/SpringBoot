package com.jocata.ecomm.dao;

import com.jocata.ecomm.entity.User;

import java.util.List;

public interface UserDao {

    User save(User user);
    User findUserById(Long id);
    User update(User user);
    void delete(User user);
    List<User> findAllUsers();
}
