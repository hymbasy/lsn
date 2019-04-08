package com.alex.dao;

import com.alex.model.User;

import java.util.Map;

public interface UserDao {

    User selectUserById(Integer id);

    User selectUserByName(String userName);

    User selectUserByNameAndPassword(Map<String,Object> map);
}
