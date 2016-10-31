/*
 * Copyright (c) 2016 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package blog.concurrency;

import java.time.Instant;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by YangFan on 2016/10/26 上午9:00.
 * <p/>
 */
class RLCDomain {
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void method1() {
        lock.lock();
        try {
            System.out.println("await begin " + Instant.now());
            condition.await();

            System.out.println("await end " + Instant.now());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    public void method2() {
        lock.lock();
        try {
            System.out.println("signal " + Instant.now());
            condition.signal();
        } finally {
            lock.unlock();
        }
    }
}
class RTCThread_0 implements Runnable {
    private RLCDomain rlcDomain;

    public RTCThread_0(RLCDomain rlcDomain) {
        this.rlcDomain = rlcDomain;
    }

    @Override
    public void run() {
        rlcDomain.method1();
    }
}


class RTCThread_1 implements Runnable {
    private RLCDomain rlcDomain;

    public RTCThread_1(RLCDomain rlcDomain) {
        this.rlcDomain = rlcDomain;
    }

    @Override
    public void run() {
        rlcDomain.method2();
    }
}

public class ReentrantLockConditionTest {
    public static void main(String[] args) {
        RLCDomain rlcDomain = new RLCDomain();
        RTCThread_0 rtcThread_0 = new RTCThread_0(rlcDomain);
        RTCThread_1 rtcThread_1 = new RTCThread_1(rlcDomain);
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(rtcThread_0);
        executorService.execute(rtcThread_1);
        executorService.shutdown();
    }
}
