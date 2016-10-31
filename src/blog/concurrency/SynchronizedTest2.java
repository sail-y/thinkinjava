/*
 * Copyright (c) 2016 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package blog.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by YangFan on 2016/10/25 上午9:51.
 * <p/>
 * 同步代码块测试
 * 1、当A线程访问对象的synchronized代码块的时候，B线程依然可以访问对象方法中其余非synchronized块的部分，第一部分的执行结果证明了这一点
 * 2、当A线程进入对象的synchronized代码块的时候，B线程如果要访问这段synchronized块，那么访问将会被阻塞，第二部分的执行结果证明了这一点
 */
class ThreadDomain {
    public void doLongTimeTask() throws Exception {
        for (int i = 0; i < 100; i++) {
            System.out.println("nosynchronized threadName = " +
                    Thread.currentThread().getName() + ", i = " + (i + 1));
        }
        System.out.println();

        synchronized (this) {
            for (int i = 0; i < 100; i++) {
                System.out.println("synchronized threadName = " +
                        Thread.currentThread().getName() + ", i = " + (i + 1));
            }
        }
    }
}

class SynThread implements Runnable {

    private ThreadDomain threadDomain;

    public SynThread(ThreadDomain domain) {
        threadDomain = domain;
    }

    @Override
    public void run() {

        try {
            threadDomain.doLongTimeTask();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

public class SynchronizedTest2 {


    public static void main(String[] args) {
        ThreadDomain threadDomain = new ThreadDomain();
        SynThread s1 = new SynThread(threadDomain);
        SynThread s2 = new SynThread(threadDomain);

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(s1);
        executorService.execute(s2);
        executorService.shutdown();

    }
}
