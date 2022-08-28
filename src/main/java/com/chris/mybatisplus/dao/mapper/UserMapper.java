package com.chris.mybatisplus.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chris.mybatisplus.dto.Encrypt;
import com.chris.mybatisplus.entities.User;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

// 使用mybatis-plus增强接口
public interface UserMapper extends BaseMapper<User> {
}
