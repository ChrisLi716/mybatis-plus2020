package com.chris.mybatisplus.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import javax.annotation.Resource;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author Lilun
 * @Date 2021-06-07 20:19
 * @Description
 **/
@Configuration
@Slf4j
@EnableAsync
//@EnableConfigurationProperties(ThreadPoolConfigBean.class)
public class ExecutorConfig {
    @Resource
    private ThreadPoolConfigBean configBean;

    @Bean(name = "asyncServiceExecutor")
    public Executor asyncServiceExecutor() {
        log.info("start asyncServiceExecutor");
        // ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();

        ThreadPoolTaskExecutor executor = new VisiableThreadPoolTaskExecutor();
        //配置核心线程数
        executor.setCorePoolSize(configBean.getCorePoolSize());
        //配置最大线程数
        executor.setMaxPoolSize(configBean.getMaxPoolSize());
        //配置队列大小
        executor.setQueueCapacity(configBean.getQueueCapacity());
        //配置线程池中的线程的名称前缀
        executor.setThreadNamePrefix(configBean.getNamePrefix());

        // rejection-policy：当pool已经达到max size的时候，如何处理新任务
        // CALLER_RUNS：不在新线程中执行任务，而是有调用者所在的线程来执行
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        //执行初始化
        executor.initialize();
        return executor;
    }


}
