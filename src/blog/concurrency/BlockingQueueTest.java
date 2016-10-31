/*
 * Copyright (c) 2016 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package blog.concurrency;

import java.util.concurrent.*;

/**
 * Created by YangFan on 2016/10/26 下午3:20.
 * <p/>
 */
public class BlockingQueueTest {
    public static void main(String[] args) {
        final BlockingQueue<String> bq = new ArrayBlockingQueue<String>(10);
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            int i = 0;
            while (true) {
                System.out.println("produce " + i++);
                try {
                    bq.put(i + "");
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

        executorService.execute(() -> {
            while (true) {

                try {
                    String take = bq.take();
                    System.out.println("take " + take);
                    TimeUnit.SECONDS.sleep(3);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

        executorService.shutdown();

    }
}
