package com.athena.designpatterns.instance;

/**
 * Created by yaser.zhang on 2019/8/15.
 */
public enum SingleInstance {
    INSTANCE;

    public void fun1() {
        // do something
    }
}

// 使用 SingleInstance.INSTANCE.fun1();