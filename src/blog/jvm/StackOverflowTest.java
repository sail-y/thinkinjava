/*
 * Copyright (c) 2016 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package blog.jvm;

/**
 * Created by YangFan on 2016/10/18 下午3:28.
 * <p/>
 *
 * Java虚拟机规范中描述了如果线程请求的栈深度太深（换句话说方法调用的深度太深），就会产生栈溢出了。
 * 那么，我们只要写一个无限调用自己的方法，自然就会出现方法调用的深度太深的场景了。测试代码如下
 *
 *
 * 测试内容：栈溢出测试（递归调用导致栈深度不断增加）
 * 虚拟机参数：-Xss128k
 */
public class StackOverflowTest {

    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        StackOverflowTest stackOverflowTest = new StackOverflowTest();
        try {
            stackOverflowTest.stackLeak();

        } catch (Throwable e) {
            System.out.println("stack length:" + stackOverflowTest.stackLength);
            throw e;
        }
    }
    //StackOverFlowError这个异常，有错误堆栈可以阅读，比较好定位。而且如果使用虚拟机默认参数，栈深度在大多数情况下，达到1000~2000完全没有问题，正常方法的调用这个深度应该是完全够了。

}


