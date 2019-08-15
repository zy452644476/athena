package com.athena.guava.async;

import com.google.common.util.concurrent.FutureCallback;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by yaser.zhang on 2019/8/13.
 */
public class IOTaskCallBack implements FutureCallback<String> {
    @Override
    public void onSuccess(String s) {
        // 后置回调处理
        System.out.println(Thread.currentThread().getName() + "后置处理:" + s);
    }

    @Override
    public void onFailure(Throwable throwable) {
        // 回调异常

    }
}
