package com.jocata.ecomm.serviceImpl;

import com.jocata.ecomm.dao.UserDao;
import com.jocata.ecomm.entity.User;
import com.jocata.ecomm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public User createUser(User user) {
        userDao.save(user);
        return user;
    }



    public User getUserById(long id) {
        return userDao.findUserById(id);
    }
}
