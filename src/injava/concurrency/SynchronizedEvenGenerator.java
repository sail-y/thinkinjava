/*
 * Copyright (c) 2016 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package injava.concurrency;

/**
 * Created by YangFan on 2016/10/12 上午11:33.
 * <p/>
 */
public class SynchronizedEvenGenerator extends IntGenerator {
    private int currentEvenValue = 0;

    public synchronized int next() {

        ++currentEvenValue;
        Thread.yield();
        ++currentEvenValue;
        return currentEvenValue;
    }

    public static void main(String[] args) throws InterruptedException {
        EvenChecker.test(new SynchronizedEvenGenerator());
    }
}
