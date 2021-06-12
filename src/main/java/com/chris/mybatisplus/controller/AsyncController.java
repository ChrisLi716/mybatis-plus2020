package com.chris.mybatisplus.controller;

import com.chris.mybatisplus.service.IAsyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @Author Lilun
 * @Date 2021-06-07 22:12
 * @Description
 **/
@RestController
@Slf4j
public class AsyncController {

    @Resource
    private IAsyncService asyncService;

    @GetMapping("async")
    public void async() {
        asyncService.executeAsync();
    }

    @GetMapping("asyncInvokeReturnFuture")
    public String asyncInvokeReturnFuture(@RequestParam("key") int key) {
        String result = "";
        try {
            result = asyncService.asyncInvokeReturnFuture(key).get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return result;
    }
}
