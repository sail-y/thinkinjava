/*
 * Copyright (c) 2016 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package injava.concurrency;

import java.util.concurrent.TimeUnit;

/**
 * Created by YangFan on 2016/10/12 上午11:11.
 * <p/>
 */
public class EvenGenerator extends IntGenerator {
    private int currentEvenValue  = 0;
    public int next() {

        ++currentEvenValue;
        ++currentEvenValue;
        return currentEvenValue;
    }

    public static void main(String[] args) throws InterruptedException {
        EvenChecker.test(new EvenGenerator());
    }
}
