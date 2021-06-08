package com.chris.mybatisplus.service.impl;

import com.chris.mybatisplus.service.IAsyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @Author Lilun
 * @Date 2021-06-07 22:10
 * @Description
 **/
@Service
@Slf4j
public class AsyncServiceImpl implements IAsyncService {

    /**
     * 将Service层的服务异步化
     * '@Async' 表明executeAsync方法进入的线程池是asyncServiceExecutor方法创建的
     */
    @Override
    @Async("asyncServiceExecutor")
    public void executeAsync() {
        log.info("start executeAsync");

        log.info("异步线程要做的事情");
        log.info("可以在这里执行批量插入等耗时的事情");

        log.info("end executeAsync");
    }
}
