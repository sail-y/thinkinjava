/*
 * Copyright (c) 2016 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package blog.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by YangFan on 2016/10/25 上午11:08.
 * <p/>
 * 原子类也无法保证线程安全
 */
class AtomicDomain {
    public static AtomicInteger aiRef = new AtomicInteger();

    public void addNum() {
        System.out.println(Thread.currentThread().getName() + "加了100之后的结果：" +
                aiRef.addAndGet(100));
        aiRef.getAndAdd(1);
    }
}

class AThread implements Runnable {
    private AtomicDomain atomicDomain;

    public AThread(AtomicDomain atomicDomain) {
        this.atomicDomain = atomicDomain;
    }

    @Override
    public void run() {
        atomicDomain.addNum();
    }
}

public class AtomicTest {
    public static void main(String[] args) {
        AtomicDomain atomicDomain = new AtomicDomain();
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            AThread aThread = new AThread(atomicDomain);
            executorService.execute(aThread);
        }

        executorService.shutdown();
    }
}
