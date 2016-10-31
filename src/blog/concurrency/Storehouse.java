/*
 * Copyright (c) 2016 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package blog.concurrency;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by YangFan on 2016/10/26 下午2:26.
 * <p/>
 */
public class Storehouse {
    public static String value = "";

    public static void main(String[] args) {
        Object o = new Object();
        Producer producer = new Producer(o);
        Customer customer = new Customer(o);
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            while (true)
                customer.getValue();
        });

        executorService.execute(() -> {
            while (true){
                producer.setValue();
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


        });

        executorService.execute(() -> {
            while (true){
                producer.setValue();
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


        });
        executorService.shutdown();
    }
}

class Producer {
    // 货
    private Object o;

    public Producer(Object o) {
        this.o = o;
    }

    public void setValue() {
        try {
            synchronized (o) {
                if (!"".equals(Storehouse.value)) {
                    o.wait();
                }

                String value = System.currentTimeMillis() + "_" + System.nanoTime();
                System.out.println("Set的值是：" + value);
                Storehouse.value = value;
                o.notify();

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}



class Customer {
    // 货
    private Object o;

    public Customer(Object o) {
        this.o = o;
    }

    public void getValue() {
        try {
            synchronized (o) {
                if ("".equals(Storehouse.value)) {
                    o.wait();
                }

                System.out.println("get的值是：" + Storehouse.value);
                Storehouse.value = "";
                o.notify();

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}