package com.chris.mybatis;

import com.chris.mybatisplus.MybatisPlusMain;
import com.chris.mybatisplus.entities.User;
import com.chris.mybatisplus.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Date;

@SpringBootTest(classes = MybatisPlusMain.class)
public class MultiDataSource {

    @Resource
    private UserService userService;


    @Test
    public void testFindAll() {
        userService.findAll().parallelStream().forEach(user -> System.out.println("user:" + user));
    }

    @Test
    public void testSave() {
        User user = new User();
        user.setBir(new Date()).setAge(22).setName("Sopher");
        userService.save(user);
    }

}