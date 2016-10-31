/*
 * Copyright (c) 2016 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package blog.concurrency;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by YangFan on 2016/10/25 下午5:47.
 * <p/>
 */
class ReenDomain {
    private Lock lock = new ReentrantLock();

    public void method1() {
        lock.lock();
        try {
            for (int i = 0; i < 10; i++) {

                System.out.println(Thread.currentThread() + " " + i);
            }
        } finally {
            lock.unlock();
        }

    }

}

class RThread implements Runnable {


    private ReenDomain reenDomain;

    public RThread(ReenDomain reenDomain) {
        this.reenDomain = reenDomain;
    }

    @Override
    public void run() {
        reenDomain.method1();
    }
}

public class ReentrantLockTest {
    public static void main(String[] args) {
        ReenDomain reenDomain = new ReenDomain();

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new RThread(reenDomain));
        executorService.execute(new RThread(reenDomain));
        executorService.shutdown();
    }
}
