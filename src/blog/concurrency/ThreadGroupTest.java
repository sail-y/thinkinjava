/*
 * Copyright (c) 2016 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package blog.concurrency;

import java.util.concurrent.TimeUnit;

/**
 * Created by YangFan on 2016/10/26 下午3:35.
 * <p/>
 */
class TGThread implements Runnable {
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            System.out.println(Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ThreadGroupTest {
    public static void main(String[] args) {
        ThreadGroup threadGroup = new ThreadGroup("ThreadGroup1");
        Thread thread = new Thread(threadGroup, new TGThread());
        Thread thread2 = new Thread(threadGroup, new TGThread());
        thread.start();
        thread2.start();
        System.out.println("active thread count :" + threadGroup.activeCount());
        System.out.println("thread group name :" + threadGroup.getName());
    }
}
