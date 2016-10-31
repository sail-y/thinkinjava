/*
 * Copyright (c) 2016 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package blog.concurrency;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by YangFan on 2016/10/25 上午11:36.
 * <p/>
 * 一个类可能发生死锁，并不意味着每次都会发生死锁，这只是表示有可能。当死锁出现时，往往是在最糟糕的情况----高负载的情况下
 */
class DeadLock {
    private final Object left = new Object();
    private final Object right = new Object();

    public void leftRight() throws InterruptedException {
        synchronized (left) {
            TimeUnit.SECONDS.sleep(2);
            synchronized (right) {
                System.out.println("left -> right");
            }
        }
    }

    public void rightLeft() throws InterruptedException {
        synchronized (right) {
            TimeUnit.SECONDS.sleep(2);
            synchronized (left) {
                System.out.println("left -> right");
            }
        }
    }
}

class DThread1 implements Runnable {
    private DeadLock deadLock;

    public DThread1(DeadLock deadLock) {
        this.deadLock = deadLock;
    }

    @Override
    public void run() {
        try {
            deadLock.leftRight();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


class DThread2 implements Runnable {
    private DeadLock deadLock;

    public DThread2(DeadLock deadLock) {
        this.deadLock = deadLock;
    }

    @Override
    public void run() {
        try {
            deadLock.rightLeft();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class DeadLockTest {
    public static void main(String[] args) {
        DeadLock deadLock = new DeadLock();
        ExecutorService executorService = Executors.newCachedThreadPool();
        DThread1 thread1 = new DThread1(deadLock);
        DThread2 thread2 = new DThread2(deadLock);
        executorService.execute(thread1);
        executorService.execute(thread2);
        executorService.shutdown();
    }
}
