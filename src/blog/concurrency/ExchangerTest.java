/*
 * Copyright (c) 2016 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package blog.concurrency;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by YangFan on 2016/10/26 下午5:32.
 * <p/>
 */
class ExchangerThread implements Runnable {
    private String str;
    private Exchanger<String> exchanger;
    Random random = new Random(47);

    public ExchangerThread(String str, Exchanger<String> exchanger) {
        this.str = str;
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        try {

            System.out.println(Thread.currentThread().getName() + " start: str=" + str + " " + LocalDateTime.now());
            int timeout = random.nextInt(1000);
            System.out.println("sleeping " + timeout);
            TimeUnit.MILLISECONDS.sleep(timeout);
            str = exchanger.exchange(str);
            System.out.println(Thread.currentThread().getName() + " end: str=" + str + " " + LocalDateTime.now());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class ExchangerTest {
    // sleep 时间不同，时间少的线程等多的
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        ExchangerThread t1 = new ExchangerThread("ExchangerThread1", exchanger);
        ExchangerThread t2 = new ExchangerThread("ExchangerThread2", exchanger);
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(t1);
        executorService.execute(t2);
        executorService.shutdown();
    }
}
