/*
 * Copyright (c) 2016 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package injava.concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by YangFan on 2016/10/12 下午3:28.
 * <p/>
 */

class ExplicitPairManager1 extends PairManager {
    private Lock lock = new ReentrantLock();

    @Override
    public synchronized void increment() {
        lock.lock();
        try {
            p.incrementY();
            p.incrementX();
            store(getPair());
        } finally {
            lock.unlock();
        }

    }
}


class ExplicitPairManager2 extends PairManager {
    private Lock lock = new ReentrantLock();

    @Override
    public void increment() {
        Pair temp;
        lock.lock();
        try {
            p.incrementY();
            p.incrementX();
            temp = getPair();
        } finally {
            lock.unlock();
        }

        store(temp);

    }
}


public class ExplictCriticalSection {
    public static void main(String[] args) {
        PairManager pman1 = new ExplicitPairManager1();
        PairManager pman2 = new ExplicitPairManager2();
        CriticalSection.testApproaches(pman1, pman2);
    }
}
