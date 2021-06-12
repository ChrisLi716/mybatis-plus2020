package com.chris.mybatisplus;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(exclude = DruidDataSourceAutoConfigure.class)
@MapperScan("com.chris.mybatisplus.dao.mapper")
@ConfigurationPropertiesScan("com.chris.mybatisplus.config")
@EnableAsync
public class MybatisPlusMain {

    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusMain.class, args);
    }
}
