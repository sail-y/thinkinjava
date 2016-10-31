/*
 * Copyright (c) 2016 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package blog.concurrency;

import java.time.LocalDateTime;
import java.util.concurrent.*;

/**
 * Created by YangFan on 2016/10/26 下午5:43.
 * <p/>
 * CyclicBarrier从字面理解是指循环屏障，它可以协同多个线程，让多个线程在这个屏障前等待，直到所有线程都达到了这个屏障时，再一起继续执行后面的动作。
 *
 */
class CyclicBarrierThread implements Runnable {
    private CyclicBarrier cyclicBarrier;
    private int sleepSecond;

    public CyclicBarrierThread(CyclicBarrier cyclicBarrier, int sleepSecond) {
        this.cyclicBarrier = cyclicBarrier;
        this.sleepSecond = sleepSecond;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " running");
            TimeUnit.SECONDS.sleep(sleepSecond);
            System.out.println(Thread.currentThread().getName() + " waiting " + LocalDateTime.now());
            cyclicBarrier.await();
            System.out.println(Thread.currentThread().getName() + " end wait " + LocalDateTime.now());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}

/*
CountDownLatch和CyclicBarrier都是用于多个线程间的协调的，它们二者的几个差别是：

1、CountDownLatch是在多个线程都进行了latch.countDown()后才会触发事件，唤醒await()在latch上的线程，而执行countDown()的线程，
执行完countDown()后会继续自己线程的工作；CyclicBarrier是一个栅栏，用于同步所有调用await()方法的线程，并且等所有线程都到了await()方法时，这些线程才一起返回继续各自的工作

2、另外CountDownLatch和CyclicBarrier的一个差别是，CountDownLatch不能循环使用，计数器减为0就减为0了，不能被重置，CyclicBarrier可以循环使用

3、CountDownLatch可以唤起多条线程的任务，CyclicBarrier只能唤起一条线程的任务

注意，因为使用CyclicBarrier的线程都会阻塞在await方法上，所以在线程池中使用CyclicBarrier时要特别小心，如果线程池的线程过少，那么就会发生死锁了
 */
public class CyclicBarrierTest {


    public static void main(String[] args) {

        Runnable command = () -> System.out.println("I'm coming");
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, command);
        CyclicBarrierThread t1 = new CyclicBarrierThread(cyclicBarrier, 2);
        CyclicBarrierThread t0 = new CyclicBarrierThread(cyclicBarrier, 2);
        CyclicBarrierThread t2 = new CyclicBarrierThread(cyclicBarrier, 1);
        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(t1);
        executorService.execute(t0);
        executorService.execute(t2);
        executorService.shutdown();

    }
}
