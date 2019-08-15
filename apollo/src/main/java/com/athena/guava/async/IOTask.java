package com.athena.guava.async;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.concurrent.Callable;

/**
 * Created by yaser.zhang on 2019/8/13.
 */
@Data
@RequiredArgsConstructor
public class IOTask implements Callable<String> {
    @NonNull
    private String id;

    @Override
    public String call() throws Exception {
        // 模拟IO操作，耗时任务
        Thread.sleep((int)(Math.random()*3000));
        return id;
    }
}
