/*
 * Copyright (c) 2016 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package blog.concurrency;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by YangFan on 2016/10/26 上午10:36.
 * <p/>
 */
class RLTDomain2 {
    private Lock lock = new ReentrantLock(true);

    public void testMethod() {
        lock.lock();
        try {
            System.out.println("ThreadName: " + Thread.currentThread().getName() + " locked ");

        }finally {
            lock.unlock();
        }
    }
}
public class ReentrantLockTest2 {
    public static void main(String[] args) {
        final RLTDomain2 td = new RLTDomain2();
        Runnable runnable = () -> {
            System.out.println("Thread " + Thread.currentThread().getName() + " running");
            td.testMethod();
        };

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(runnable);
        executorService.execute(runnable);
        executorService.execute(runnable);
        executorService.execute(runnable);
        executorService.execute(runnable);
        executorService.shutdown();
    }
}
