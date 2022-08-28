package com.chris.mybatisplus;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class CommonUtil {

    static <T> int insertInBatch(List<T> list, BaseMapper<T> baseMapper) {
        AtomicInteger i = new AtomicInteger();
        list.parallelStream().forEach(t -> {
            baseMapper.insert(t);
            i.getAndIncrement();
        });
        return i.get();
    }
}


