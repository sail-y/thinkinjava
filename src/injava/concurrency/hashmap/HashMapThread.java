/*
 * Copyright (c) 2016 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package injava.concurrency.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by YangFan on 2016/10/17 下午4:53.
 * <p/>
 * 并发环境下hashMap的死循环
 */
public class HashMapThread extends Thread {
    private static AtomicInteger ai = new AtomicInteger(0);
    private static Map<Integer, Integer> map = new HashMap<>(1);

    @Override
    public void run() {
        while (ai.get() < 100000) {
            map.put(ai.get(), ai.get());
            ai.incrementAndGet();
        }
    }

    public static void main(String[] args) {

        HashMapThread h1 = new HashMapThread();
        HashMapThread h2 = new HashMapThread();
        HashMapThread h3 = new HashMapThread();
        HashMapThread h4 = new HashMapThread();
        HashMapThread h5 = new HashMapThread();

        h1.start();
        h2.start();
        h3.start();
        h4.start();
        h5.start();


    }
}
