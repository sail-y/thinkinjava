/*
 * Copyright (c) 2016 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package blog.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by YangFan on 2016/10/25 上午10:09.
 * <p/>
 * synchronized块获得的是一个对象锁，换句话说，synchronized块锁定的是整个对象
 */
class ThreadDomain3 {
    public void methodA() {
        synchronized (this) {
            System.out.println(Thread.currentThread() +  " : begin time = " + System.nanoTime());
            try {
                TimeUnit.MILLISECONDS.sleep(2000);
                System.out.println(Thread.currentThread() +  " : end time = " + System.nanoTime());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void methodB() {
        synchronized (this) {

            System.out.println(Thread.currentThread() +  " : begin time = " + System.nanoTime());
            System.out.println(Thread.currentThread() +  " : end time = " + System.nanoTime());
        }
    }
}

class SynThread3 implements Runnable {
    private ThreadDomain3 threadDomain3;

    public SynThread3(ThreadDomain3 threadDomain3) {
        this.threadDomain3 = threadDomain3;
    }

    @Override
    public void run() {
        threadDomain3.methodA();
    }
}


class SynThread3_2 implements Runnable {
    private ThreadDomain3 threadDomain3;

    public SynThread3_2(ThreadDomain3 threadDomain3) {
        this.threadDomain3 = threadDomain3;
    }

    @Override
    public void run() {
        threadDomain3.methodB();
    }
}

public class SynchronizedTest3 {
    public static void main(String[] args) {
        ThreadDomain3 threadDomain3 = new ThreadDomain3();
        SynThread3 s = new SynThread3(threadDomain3);
        SynThread3_2 s2 = new SynThread3_2(threadDomain3);
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(s);

        executorService.execute(s2);
        executorService.shutdown();
    }
}
