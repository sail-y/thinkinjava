/*
 * Copyright (c) 2016 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package blog.concurrency;

import java.time.LocalDateTime;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by YangFan on 2016/10/26 下午1:51.
 * <p/>
 * 多个Thread可以同时进行读取操作，但是同一时刻只允许一个Thread进行写入操作。
 */
class RRWLDomain extends ReentrantReadWriteLock {
    public void read() {
        try {
            readLock().lock();
            System.out.println(Thread.currentThread().getName() + " get read lock() " + LocalDateTime.now());
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readLock().unlock();
        }
    }

    public void write() {
        try {
            writeLock().lock();

            System.out.println(Thread.currentThread().getName() + " get write lock() " + LocalDateTime.now());
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            writeLock().unlock();
        }
    }
}

public class ReentrantReadWriteLockTest {
    public static void main(String[] args) {
        final RRWLDomain rrwlDomain = new RRWLDomain();

        ExecutorService executorService = Executors.newCachedThreadPool();
//        executorService.execute(rrwlDomain::read);
//        executorService.execute(rrwlDomain::read);
//        executorService.execute(rrwlDomain::write);
//        executorService.execute(rrwlDomain::write);
        executorService.execute(rrwlDomain::read);
        executorService.execute(rrwlDomain::write);
        executorService.shutdown();
    }
}
