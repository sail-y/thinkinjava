/*
 * Copyright (c) 2016 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package injava.concurrency;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

/**
 * Created by YangFan on 2016/10/12 下午5:50.
 * <p/>
 */
class NonThread {
    public void sleep() {
        new Timer().schedule(new TimerTask() {
                                 @Override
                                 public void run() {
                                     try {
                                         TimeUnit.MILLISECONDS.sleep(100);
                                     } catch (InterruptedException e) {
                                         e.printStackTrace();
                                     }
                                 }
                             },
                5000);
    }
}

public class Ex18 {
    public static void main(String[] args) {
        NonThread nonThread = new NonThread();
        Thread thread = new Thread() {
            @Override
            public void run() {
                nonThread.sleep();
            }
        };


        thread.interrupt();


    }
}
