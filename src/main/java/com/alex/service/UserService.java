package com.alex.service;

import com.alex.model.User;

public interface UserService {

    User selectUserById(Integer id);

    User selectUserByName(String name);

    User selectUserByNameAndPassword(String username, String password);
}
