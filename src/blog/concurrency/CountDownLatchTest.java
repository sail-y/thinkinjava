/*
 * Copyright (c) 2016 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package blog.concurrency;

import java.time.LocalDateTime;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by YangFan on 2016/10/26 下午5:10.
 * <p/>
 * CountDownLatch主要提供的机制是当多个（具体数量等于初始化CountDownLatch时count参数的值）线程都达到了预期状态或完成预期工作时触发事件，
 * 其他线程可以等待这个事件来触发自己的后续工作。值得注意的是，CountDownLatch是可以唤醒多个等待的线程的。
 */
public class CountDownLatchTest {
    private static class WorkThread extends Thread {
        private CountDownLatch countDownLatch;
        private int sleepSecond;

        public WorkThread(String name, CountDownLatch countDownLatch, int sleepSecond) {
            super(name);
            this.countDownLatch = countDownLatch;
            this.sleepSecond = sleepSecond;
        }

        @Override
        public void run() {
            try {
                System.out.println(this.getName() + " start: " + LocalDateTime.now());
                TimeUnit.SECONDS.sleep(sleepSecond);
                countDownLatch.countDown();
                System.out.println(this.getName() + " end: " + LocalDateTime.now());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static class DoneThread extends Thread {
        private CountDownLatch countDownLatch;

        public DoneThread(String name, CountDownLatch countDownLatch) {
            super(name);
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            try {
                System.out.println(this.getName() + "await start:" + LocalDateTime.now());
                countDownLatch.await();
                System.out.println(this.getName() + "await end:" + LocalDateTime.now());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    // CountDownLatch指定3次调用，无论前面有多少线程await，都需要等待CountDownLatch调用3次countDown()统一唤醒
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        DoneThread d0 = new DoneThread("DoneThread1", countDownLatch);
        DoneThread d1 = new DoneThread("DoneThread2", countDownLatch);
        d0.start();
        d1.start();

        WorkThread w0 = new WorkThread("WorkThread0", countDownLatch, 2);
        WorkThread w1 = new WorkThread("WorkThread1", countDownLatch, 3);
        WorkThread w2 = new WorkThread("WorkThread2", countDownLatch, 4);
        w0.start();
        w1.start();
        w2.start();
    }
}
