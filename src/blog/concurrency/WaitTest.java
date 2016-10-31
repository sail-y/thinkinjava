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
 * Created by YangFan on 2016/10/25 下午2:40.
 * <p/>
 */
class WThread_0 implements Runnable {

    private Object lock;

    public WThread_0(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            synchronized (lock) {
                System.out.println("wait: " + System.currentTimeMillis());
                lock.wait();
                System.out.println("wait end: " + System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
    }
}

class WThread_1 implements Runnable {

    private Object lock;

    public WThread_1(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            System.out.println("notify: " + System.currentTimeMillis());
            lock.notify();
            System.out.println("notify end: " + System.currentTimeMillis());

        }
    }
}

public class WaitTest {
    public static void main(String[] args) {
        Object lock = new Object();
        WThread_0 wThread_0 = new WThread_0(lock);
        WThread_1 wThread_1 = new WThread_1(lock);
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(wThread_0);
//        executorService.execute(wThread_1);
        executorService.shutdownNow();
    }
}
