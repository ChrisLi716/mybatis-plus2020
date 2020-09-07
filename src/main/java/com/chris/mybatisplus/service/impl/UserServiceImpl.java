package com.chris.mybatisplus.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.chris.mybatisplus.dao.mapper.UserMapper;
import com.chris.mybatisplus.entities.User;
import com.chris.mybatisplus.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@DS("master")
public class UserServiceImpl implements UserService {


    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return userMapper.selectList(null);
    }

    @Override
    @DS("cluster")
    public int save(User user) {
        return userMapper.insert(user);
    }
}
