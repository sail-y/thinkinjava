/*
 * Copyright (c) 2016 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package blog.concurrency;

import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by YangFan on 2016/10/26 下午4:40.
 * <p/>
 * Task是以队列的方式一个一个被顺序执行的，所以执行的时间有可能和预期的时间不一致，因为前面的任务可能消耗过长，后面任务的运行时间也有可能被延迟
 */
public class TimerTest {
    public static void main(String[] args) throws InterruptedException {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread() + " task1 : " + LocalDateTime.now());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, 1000);

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread() + " task2: " + LocalDateTime.now());
            }
        };
        timer.schedule(task, 1000, 1000);
        Thread.sleep(5000);
        task.cancel();

        Thread.sleep(5000);
        System.out.println("timer cancel");
        timer.cancel();

    }
}
