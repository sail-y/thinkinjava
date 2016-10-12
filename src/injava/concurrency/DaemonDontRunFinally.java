/*
 * Copyright (c) 2016 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package injava.concurrency;

import java.util.concurrent.TimeUnit;

/**
 * Created by YangFan on 2016/10/11 下午5:48.
 * <p/>
 */
public class DaemonDontRunFinally {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new ADeamon());
        t.setDaemon(true);
        t.start();
        TimeUnit.SECONDS.sleep(10);
    }
}

class ADeamon implements Runnable {
    @Override
    public void run() {
        System.out.println("starting ADaemon");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            System.out.println("This should always run?");
        }

    }
}
