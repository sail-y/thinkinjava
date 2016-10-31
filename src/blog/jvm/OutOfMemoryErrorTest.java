/*
 * Copyright (c) 2016 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package blog.jvm;

import java.util.concurrent.TimeUnit;

/**
 * Created by YangFan on 2016/10/18 下午3:34.
 * <p/>
 * 通过不断创建线程的方式可以产生OutOfMemoryError，因为每个线程都有自己的栈空间。
 */
public class OutOfMemoryErrorTest {
    private static volatile int counter = 0;
    public static void main(String[] args) {
        try {

            while (true)
                new Thread(){
                    @Override
                    public void run() {
                        try {
                            counter++;
                            TimeUnit.MINUTES.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }.start();
        } catch (Throwable e) {
            System.out.println(counter);
            throw e;
        }
    }
    // 上面无限产生线程的场景，从另外一个角度说，就是为每个线程的栈分配的内存空间越大，反而越容易产生内存溢出。
    // 其实这也很好理解，操作系统分配给进程的内存是有限制的，
    // 比如32位的Windows限制为2GB。虚拟机提供了了参数来控制Java堆和方法区这两部分内存的最大值，剩余内存为2GB-最大堆容量-最大方法区容量，
    // 程序计数器很小就忽略了，虚拟机进程本身的耗费也不算，剩下的内存就是栈的了。
    // 每个线程分配到的栈容量越大，可建立的线程数自然就越少，建立线程时就越容易把剩下的内存耗尽。
}
