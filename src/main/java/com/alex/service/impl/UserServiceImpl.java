package com.alex.service.impl;

import com.alex.dao.UserDao;
import com.alex.model.User;
import com.alex.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User selectUserById(Integer id) {
        return userDao.selectUserById(id);
    }

    @Override
    public User selectUserByName(String name) {
        return userDao.selectUserByName(name);
    }
}
