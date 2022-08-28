package com.chris.mybatisplus;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.chris.mybatisplus.dao.mapper.UserMapper;
import com.chris.mybatisplus.dto.Encrypt;
import com.chris.mybatisplus.entities.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.security.SecureRandom;
import java.util.*;

@SpringBootTest(classes = MybatisPlusMain.class)
public class TestMybaisPlus {

    @Autowired
    public UserMapper userMapper;


    //查询所有
    @Test
    public void testFindAll() {
        List<User> users = userMapper.selectList(null);
        users.forEach(user -> System.out.println("user:" + user));
    }

    //根据ID查询
    @Test
    public void testFindById() {
        User user = userMapper.selectById("1");
        System.out.println(user);
    }

    //根据条件查询
    @Test
    public void testFindByConditions() {
        QueryWrapper<User> querWrapper = new QueryWrapper<>();
        //querWrapper.eq("age", 22);
        querWrapper.lt("age", 35);
        //querWrapper.le("age", 33);
        List<User> users = userMapper.selectList(querWrapper);
        users.forEach(user -> System.out.println("user:" + user));
    }

    //模糊查询
    @Test
    public void testFindByLike() {
        QueryWrapper<User> querWrapper = new QueryWrapper<>();
        // like %?%
        //querWrapper.like("last_name", "n");

        // like %?
        // querWrapper.likeLeft("last_name", "s");

        // like ?%
        querWrapper.likeRight("last_name", "s");
        List<User> users = userMapper.selectList(querWrapper);
        users.forEach(user -> System.out.println("user:" + user));
    }

    //写入一条记录
    @Test
    public void testInsert() {
        User user = new User();
        user.setAge(21);
        user.setBir(new Date());
        user.setName("Smith");
        user.setPhone("1234454556");
        int i = userMapper.insert(user);
        System.out.println("insert user account:" + i);
    }

    //写入一批记录
    @Test
    public void testInsert2() {
        SecureRandom secureRandom = RandomUtil.getSecureRandom();
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            User user = new User("c" + i, secureRandom.nextInt(100), new Date());
            users.add(user);
        }

        int total = CommonUtil.insertInBatch(users, userMapper);
        System.out.println("insert user account:" + total);
    }


    //修改数据
    @Test
    public void testUpdate() {
        User user = userMapper.selectById("4");
        user.setAge(22);
        int i = userMapper.updateById(user);
        System.out.println("update user account:" + i);
    }

    /**
     * 基于条件的修改数据
     * 将年龄为22的名称统一改为Rose
     */

    @Test
    public void testUpdateWithConditions() {
        User user = new User();
        user.setName("Rose");
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("age", "22");
        int i = userMapper.update(user, updateWrapper);
        System.out.println("update user account:" + i);
    }


    /**
     * 删除数据
     */

    @Test
    public void testDeleteById() {
        int i = userMapper.deleteById("4");
        System.out.println("delete user account:" + i);
    }


    /**
     * 根据条件删除数据
     * 删除大于等于33的记录
     */

    @Test
    public void testDeleteWithConditions() {
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.ge("age", "33");
        int i = userMapper.delete(updateWrapper);
        System.out.println("delete user account:" + i);
    }

}
