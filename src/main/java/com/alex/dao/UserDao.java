package com.alex.dao;

import com.alex.model.User;

public interface UserDao {

    User selectUserById(Integer id);

    User selectUserByName(String userName);
}
