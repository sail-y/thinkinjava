/*
 * Copyright (c) 2016 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package injava.concurrency;

import java.util.concurrent.TimeUnit;

/**
 * Created by YangFan on 2016/10/11 下午5:21.
 * <p/>
 */
public class SimpleDaemons implements Runnable {
    @Override
    public void run() {
        while (true) {
            try {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread() + " " + this);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread daemon = new Thread(new SimpleDaemons());
            daemon.setDaemon(true);
            daemon.start();
        }

        System.out.println("All daemons started");
        TimeUnit.MILLISECONDS.sleep(175);
    }
}
