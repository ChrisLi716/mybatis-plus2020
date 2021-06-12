package com.chris.mybatisplus.service.impl;

import ch.qos.logback.core.util.TimeUtil;
import com.chris.mybatisplus.service.IAsyncService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

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

    @SneakyThrows
    @Async("asyncServiceExecutor")
    public Future<String> asyncInvokeReturnFuture(int i) {
        log.info("asyncInvokeReturnFuture, param:{}", i);
        Future<String> future = null;
        try {
            TimeUnit.SECONDS.sleep(5);
            future = new AsyncResult<>("invoke success:" + i);
        } catch (InterruptedException e) {
            e.printStackTrace();
            future = new AsyncResult<>("invoke error:" + e.getMessage());
        }
        return future;
    }
}
