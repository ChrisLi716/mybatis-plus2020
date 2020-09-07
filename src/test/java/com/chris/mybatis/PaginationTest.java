package com.chris.mybatis;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chris.mybatisplus.MybatisPlusMain;
import com.chris.mybatisplus.dao.mapper.UserMapper;
import com.chris.mybatisplus.entities.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = MybatisPlusMain.class)
public class PaginationTest {


    @Autowired
    private UserMapper userMapper;

    @Test
    public void paginationSelect() {
        //参数1：当前页数，参数2：每页记录数
        IPage<User> page = new Page<>(2, 2);

        // queryWrapper没有设置条件则查询所有记录
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.le("age", 25);
        IPage<User> ipage = userMapper.selectPage(page, queryWrapper);
        long total = ipage.getTotal();
        System.out.println("total:" + total);
        ipage.getRecords().forEach(user -> System.out.println("user:" + user));
    }
}
