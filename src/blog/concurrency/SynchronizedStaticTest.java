/*
 * Copyright (c) 2016 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package blog.concurrency;

import java.util.concurrent.TimeUnit;

/**
 * Created by YangFan on 2016/10/6 上午10:26.
 * <p/>
 * synchronized还可以应用在静态方法上，如果这么写，则代表的是对当前.java文件对应的Class类加锁
 */
class ThreadDomain6 {
    public synchronized static void printA()
    {
        try
        {
            System.out.println("线程名称为：" + Thread.currentThread().getName() +
                    "在" + System.currentTimeMillis() + "进入printA()方法");
            Thread.sleep(3000);
            System.out.println("线程名称为：" + Thread.currentThread().getName() +
                    "在" + System.currentTimeMillis() + "离开printA()方法");
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    public synchronized static void printB()
    {
        System.out.println("线程名称为：" + Thread.currentThread().getName() +
                "在" + System.currentTimeMillis() + "进入printB()方法");
        System.out.println("线程名称为：" + Thread.currentThread().getName() +
                "在" + System.currentTimeMillis() + "离开printB()方法");

    }

    public synchronized void printC()
    {
        System.out.println("线程名称为：" + Thread.currentThread().getName() +
                "在" + System.currentTimeMillis() + "进入printC()方法");
        System.out.println("线程名称为：" + Thread.currentThread().getName() +
                "在" + System.currentTimeMillis() + "离开printC()方法");
    }
}
class MyThread6_0 extends Thread
{
    public void run()
    {
        ThreadDomain6.printA();
    }
}


class MyThread6_1 extends Thread
{
    public void run()
    {
        ThreadDomain6.printB();
    }
}


class MyThread6_2 extends Thread
{
    private ThreadDomain6 threadDomain6;

    public MyThread6_2(ThreadDomain6 ThreadDomain6) {
        this.threadDomain6 = ThreadDomain6;
    }

    public void run()
    {
        threadDomain6.printC();
    }
}

public class SynchronizedStaticTest {
    // 从运行结果来，对printC()方法的调用和对printA()方法、printB()方法的调用时异步的，这说明了静态同步方法和非静态同步方法持有的是不同的锁，前者是类锁，后者是对象锁。
    public static void main(String[] args) {
        ThreadDomain6 td = new ThreadDomain6();
        MyThread6_0 mt0 = new MyThread6_0();
        MyThread6_1 mt1 = new MyThread6_1();
        MyThread6_2 mt2 = new MyThread6_2(td);
        mt0.start();
        mt1.start();
        mt2.start();
    }
}
