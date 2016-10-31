/*
 * Copyright (c) 2016 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package blog.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by YangFan on 2016/10/25 上午10:37.
 * <p/>
 */
class VThread_0 implements Runnable {


    @Override
    public void run() {
        while (VolatileTest.isRunning) {
        }
    }
}


class VThread_1 implements Runnable {


    @Override
    public void run() {
        VolatileTest.isRunning = false;
        System.out.println("stop running");
    }
}

public class VolatileTest {
    public static boolean isRunning = true;

    /*
       这个不是必现，得多试几次
       stop running 后死循环
       在第二个线程更改后，第一个线程并没有马上停止，原因从Java内存模型（JMM）说起。
       根据JMM，Java中有一块主内存，不同的线程有自己的工作内存，同一个变量值在主内存中有一份，如果线程用到了这个变量的话，自己的工作内存中有一份一模一样的拷贝。
       每次进入线程从主内存中拿到变量值，每次执行完线程将变量从工作内存同步回主内存中。
       出现打印结果现象的原因就是主内存和工作内存中数据的不同步造成的。
     */

    // 线程安全围绕的是可见性和原子性这两个特性展开的，volatile解决的是变量在多个线程之间的可见性，但是无法保证原子性。
    public static void main(String[] args) throws InterruptedException {
        VThread_0 vThread_0 = new VThread_0();
        VThread_1 vThread_1 = new VThread_1();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(vThread_0);
        executorService.execute(vThread_1);

        executorService.shutdown();
    }
}
