package com.chris.mybatisplus.service;

import java.util.concurrent.Future;

/**
 * @Author Lilun
 * @Date 2021-06-07 22:09
 * @Description
 **/
public interface IAsyncService {
    /**
     * 执行异步任务
     * 可以根据需求，自己加参数拟定，我这里就做个测试演示
     */
    void executeAsync();


    /**
     * 异步调用返回Future
     *
     * @param i input param
     * @return Future
     */
    Future<String> asyncInvokeReturnFuture(int i);
}
