package com.athena.designpatterns.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by yaser.zhang on 2019/8/15.
 */
public class Worker implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        String call = (String)arg;
        System.out.println("收到小孩的求救");
        System.out.println("工人停掉工厂的机床，去救助放羊娃。");
    }
}
