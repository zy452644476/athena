package com.athena.rxjava;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Util;

import java.util.Observable;

/**
 * Created by yaser.zhang on 2019/8/15.
 */
public class ReactiveDemo {
    public static void main(String[] args){
        //可观察对象
        MyObservable observable = new MyObservable();
        //添加观察者
        observable.addObserver((o, arg) -> {
            Util.println("观察者1处理事件:" + arg.toString());
        });

        observable.addObserver((o, arg) -> {
            Util.println("观察者2处理事件:" + arg.toString());
        });

        observable.addObserver((o, arg) -> {
            Util.println("观察者3处理事件:" + arg.toString());
        });
        //发布事件通知观察者
        observable.setChanged();
        // 从尾到头遍历
        observable.notifyObservers("事件@@");
    }


    static class MyObservable extends Observable {
        @Override
        public void setChanged(){
            super.setChanged();
        }
    }
}
