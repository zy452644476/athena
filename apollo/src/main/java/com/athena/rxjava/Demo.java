package com.athena.rxjava;

import com.google.common.collect.Lists;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Action;

import java.util.List;
import java.util.concurrent.Callable;

/**
 * Created by yaser.zhang on 2019/8/17.
 */
public class Demo {
    public static void main(String[] args) throws InterruptedException {
        Observable<String> novel = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                emitter.onNext("连载1");
                emitter.onNext("连载2");
                emitter.onNext("连载3");
                emitter.onError(new Exception("exception"));
                emitter.onComplete();
            }
        });
        novel.subscribe(s -> System.out.println(s), error -> System.out.println(error), new Action() {
            @Override
            public void run() throws Exception {
                System.out.println("complete");
            }
        });

        iterSource();
    }

    private static void justAndDefer() throws InterruptedException {
        Observable.range(10,5).subscribe(integer -> {
            System.out.println(integer);
        });
        Observable<Long> defer = getDefer();
        Observable<Long> just = getJust();
        defer.subscribe(time -> {
            System.out.println("defer:" +time);
        });
        just.subscribe(time->{
            System.out.println("just:"+time);
        });
        Thread.sleep(1000);
        defer.subscribe(time -> {
            System.out.println("defer:" +time);
        });
        just.subscribe(time->{
            System.out.println("just:"+time);
        });
        Thread.sleep(1000);
        defer.subscribe(time -> {
            System.out.println("defer:" +time);
        });
        just.subscribe(time->{
            System.out.println("just:"+time);
        });
    }

    private static Observable<Long> getJust(){
        return Observable.just(System.currentTimeMillis());
    }
    private static Observable<Long> getDefer(){
        return Observable.defer((Callable<Observable<Long>>) () -> getJust());
    }

    private static void iterSource(){
        List<Integer> list = Lists.newArrayList(0,1,2,3,4,5);
        Observable.fromArray(list).subscribe(next -> {
            System.out.println("FromArray:" + next);
        }, error -> {
            System.out.println("OnError");
        }, new Action() {
            @Override
            public void run() throws Exception {
                System.out.println("OnComplete");
            }
        });

    }
}
