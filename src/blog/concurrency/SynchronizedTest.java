/*
 * Copyright (c) 2016 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package blog.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by YangFan on 2016/10/24 下午3:35.
 * <p/>
 * 1、A线程持有Object对象的Lock锁，B线程可以以异步方式调用Object对象中的非synchronized类型的方法
 * 2、A线程持有Object对象的Lock锁，B线程如果在这时调用Object对象中的synchronized类型的方法则需要等待，也就是同步
 */
class Apple {
    public int a;

    //关键字synchronized拥有锁重入的功能。所谓锁重入的意思就是：当一个线程得到一个对象锁后，再次请求此对象锁时时可以再次得到该对象的锁的
    public synchronized void add(int i) throws InterruptedException {
        a = a + i;
        TimeUnit.MILLISECONDS.sleep(500);
        // 当一个线程执行的代码出现异常时，其所持有的锁会自动释放

        if (i == 100) {


            TimeUnit.SECONDS.sleep(2);
            throw new RuntimeException("e");
        }

        print();
    }

    public synchronized void print() {
        System.out.println(a);
    }


}


class Syn1 implements Runnable {

    private final Apple apple;

    public Syn1(Apple apple) {
        this.apple = apple;
    }

    @Override
    public void run() {
        try {
            apple.add(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

class Syn2 implements Runnable {
    private final Apple apple;

    public Syn2(Apple apple) {
        this.apple = apple;
    }

    @Override
    public void run() {
        try {
            apple.add(101);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

public class SynchronizedTest {
    public static void main(String[] args) {
        Apple apple = new Apple();
        Syn1 syn1 = new Syn1(apple);
        Syn2 syn2 = new Syn2(apple);
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(syn1);
        executorService.execute(syn2);
        executorService.shutdown();
    }
}
