/*
 * Copyright (c) 2016 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package blog.concurrency;

/**
 * Created by YangFan on 2016/10/24 下午3:18.
 * <p/>
 *   1、currentThread()方法返回的是对当前正在执行线程对象的引用
 *   2、sleep(long millis)方法的作用是在指定的毫秒内让当前"正在执行的线程"休眠（暂停执行）
 *   3、yield() 暂停当前执行的线程对象，并执行其他线程。这个暂停是会放弃CPU资源的，并且放弃CPU的时间不确定，有可能刚放弃，就获得CPU资源了，也有可能放弃好一会儿，才会被CPU执行。
 *   4、interrupted() 测试当前线程是否已经中断，执行后具有将状态标识清除为false的功能。换句话说，如果连续两次调用该方法，那么返回的必定是false
 */
public class ThreadStaticMethod extends Thread {
    static
    {
        System.out.println("静态块的打印：" +
                Thread.currentThread().getName());

    }

    public ThreadStaticMethod()
    {
        System.out.println("构造方法的打印：" +
                Thread.currentThread().getName());

        System.out.println("this.getName(): " + this.getName());
    }

    public void run()
    {
        System.out.println("run()方法的打印：" +
                Thread.currentThread().getName());

        System.out.println("this.getName(): " + this.getName());
    }

    public static void main(String[] args) {
        ThreadStaticMethod t = new ThreadStaticMethod();
        t.start();
    }
}
// 线程类的构造方法、静态块是被main线程调用的，而线程类的run()方法才是应用线程自己调用的
// 当前执行的Thread未必就是Thread本身,在执行构造方法的时候currentThread返回的是main线程
