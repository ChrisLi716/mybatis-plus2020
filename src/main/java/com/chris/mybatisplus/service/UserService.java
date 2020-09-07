package com.chris.mybatisplus.service;

import com.chris.mybatisplus.entities.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    int save(User user);

}
