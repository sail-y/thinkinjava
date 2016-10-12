/*
 * Copyright (c) 2016 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package injava.concurrency;

/**
 * Created by YangFan on 2016/10/11 上午10:57.
 * <p/>
 */
public class Ex1 implements Runnable {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(new Ex1()).start();
        }
    }


    public Ex1() {
        System.out.println("Ex1 init");
    }

    @Override
    public void run() {
        System.out.println("Ex1");
        Thread.yield();


        System.out.println("Ex1 ended");
    }
}
