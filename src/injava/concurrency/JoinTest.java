/*
 * Copyright (c) 2016 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package injava.concurrency;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by YangFan on 2016/10/24 下午3:00.
 * <p/>
 */
class Test1 extends Thread {

    @Override
    public void run() {
        try {
            System.out.println("begin");
            Thread.sleep(2000);
            System.out.println("end");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
public class JoinTest {
    public static void main(String[] args) throws InterruptedException {
        Test1 test1 = new Test1();
        test1.start();
        test1.join();


        System.out.println(123);
    }
}
