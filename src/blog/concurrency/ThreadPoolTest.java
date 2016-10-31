/*
 * Copyright (c) 2016 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package blog.concurrency;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by YangFan on 2016/10/26 下午4:20.
 * <p/>
 * 线程池
 * 线程池的作用就2个：
 1、减少了创建和销毁线程的次数，每个工作线程都可以被重复利用，可执行多个任务
 2、可以根据系统的承受能力，调整线程池中工作线程的数据，防止因为消耗过多的内存导致服务器崩溃
 */
public class ThreadPoolTest {
    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        final List<Integer> list = new LinkedList<>();
        ThreadPoolExecutor tp = new ThreadPoolExecutor(100, 100, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
        final Random random = new Random();
        for (int i = 0; i < 20000; i++) {
            tp.execute(() -> {
                list.add(random.nextInt());
            });
        }

        tp.shutdown();

        tp.awaitTermination(1, TimeUnit.DAYS);
        System.out.println(System.currentTimeMillis() - startTime);
        System.out.println(list.size());
    }
}
