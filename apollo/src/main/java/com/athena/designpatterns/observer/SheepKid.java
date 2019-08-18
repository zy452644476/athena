package com.athena.designpatterns.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by yaser.zhang on 2019/8/15.
 */
public class SheepKid extends Observable {

    public static void main(String[] args) {
        SheepKid sheepKid = new SheepKid();
        Observer farmer = new Farmer();
        sheepKid.addObserver(farmer);
        Worker worker = new Worker();
        sheepKid.addObserver(worker);
        sheepKid.callWolfIsComming();
        System.out.println("小孩说谎了，狼没有来");
        System.out.println("工人不相信小孩，退订了");
        sheepKid.deleteObserver(worker);
        sheepKid.callWolfIsComming();
        System.out.println("小孩说谎了，狼没有来");
        System.out.println("农民不相信小孩，退订了");
        sheepKid.deleteObserver(farmer);
        sheepKid.callWolfIsComming();
        System.out.println("狼真的来了，但是没人来帮他了");
    }

    public void callWolfIsComming(){
        String call = "Help ,Help ,Wolf isComming!!!";
        System.out.println(call);
        setChanged();
        notifyObservers(call);
    }
}
