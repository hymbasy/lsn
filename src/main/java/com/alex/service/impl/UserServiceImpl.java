package com.alex.service.impl;

import com.alex.dao.UserDao;
import com.alex.model.User;
import com.alex.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

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

    @Override
    public User selectUserByNameAndPassword(String username, String password) {
        User user = new User();
        Map<String,Object> map = new HashMap<>();
        map.put("userName",username);
        map.put("passWord",password);
        return userDao.selectUserByNameAndPassword(map);
    }
}
