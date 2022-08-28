package com.chris.mybatisplus;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.chris.mybatisplus.dao.mapper.UserCryptoMapper;
import com.chris.mybatisplus.dao.mapper.UserMapper;
import com.chris.mybatisplus.dto.Encrypt;
import com.chris.mybatisplus.entities.User;
import com.chris.mybatisplus.entities.UserCrypto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest(classes = MybatisPlusMain.class)
public class EncryptTest {

    @Resource
    private UserCryptoMapper cryptoMapper;

    //写入一条记录，并对phone字段加密
    @Test
    public void testInsertEncrypt() {
        int encrypt = cryptoMapper.addUser("cl", 23, new Date(), new Encrypt("1234454556"), "US");
        System.out.println("insert user account:" + encrypt);
    }

    //查询phone对应的用户信息
    @Test
    public void findUserByPhone() {
        List<User> usersByPhone = cryptoMapper.findUsersByPhone(new Encrypt("1234454556"));
        System.out.println("usersByPhone:" + JSONUtil.toJsonStr(usersByPhone));
    }


    @Test
    public void testEncrypt() {
        UserCrypto user = new UserCrypto();
        user.setAge(21);
        user.setBir(new Date());
        user.setName("Hency");
        user.setPhone(new Encrypt("1263324456677"));
        int i = cryptoMapper.insert(user);
        System.out.println("insert user account:" + i);
    }

}
