package com.athena.guava.async;

import com.google.common.base.Stopwatch;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by yaser.zhang on 2019/8/13.
 */
public class IOLoop {
    // 异步回调线程池
    private static ListeningExecutorService guavaExecutor = MoreExecutors.listeningDecorator(Executors.newCachedThreadPool());

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<ListenableFuture<String>> futures = Lists.newArrayList();
        // 秒表
        Stopwatch stopwatch = Stopwatch.createStarted();
        for (int i = 0; i < 10; i++) {
            IOTask task = new IOTask(String.valueOf(i));
            // IO请求的ProductPrice，采用异步方式处理
            ListenableFuture<String> future = guavaExecutor.submit(task);
            // 添加回调处理
            Futures.addCallback(future,new IOTaskCallBack(),guavaExecutor);
            futures.add(future);
        }
        // 异步任务已submit，但是不一定运行完成
        for (int i =0;i<futures.size();i++){
            ListenableFuture<String> future = futures.get(i);
            if (!future.isDone()){
                future.get();
            }
        }
        System.out.println(stopwatch.elapsed(TimeUnit.MILLISECONDS));
    }
}
