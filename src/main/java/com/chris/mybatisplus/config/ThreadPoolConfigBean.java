package com.chris.mybatisplus.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author Lilun
 * @Date 2021-06-08 10:45
 * @Description
 **/
@ConfigurationProperties(prefix = "async.executor.thread")
@Data
public class ThreadPoolConfigBean {
    private int corePoolSize;
    private int maxPoolSize;
    private int queueCapacity;
    private String namePrefix;
}
