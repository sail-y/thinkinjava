/*
 * Copyright (c) 2016 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package injava.concurrency;

import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by YangFan on 2016/10/14 下午3:30.
 * <p/>
 */
public class ActiveObjectDemo {
    private ExecutorService ex = Executors.newSingleThreadExecutor();
    private Random rand = new Random(47);

    private void pause(int factor) {
        try {
            TimeUnit.MILLISECONDS.sleep(100 + rand.nextInt(factor));
        } catch (InterruptedException e) {
            System.out.println("sleep() interrupted");
        }
    }

    public Future<Integer> calculateInt(final int x, final int y) {
        return ex.submit(() -> {
            System.out.println("starting " + x + " + " + y);
            pause(500);
            return x + y;
        });

    }

    public Future<Float> calculateFloat(final float x, final float y) {
        return ex.submit(() -> {
            System.out.println("starting " + x + " + " + y);
            pause(2000);
            return x + y;
        });

    }

    public void shutdown() {
        ex.shutdown();
    }

    public static void main(String[] args) {
        ActiveObjectDemo d1 = new ActiveObjectDemo();
        List<Future<?>> results = new CopyOnWriteArrayList<>();
        for (float f = 0; f < 1; f += 0.2) {
            results.add(d1.calculateFloat(f, f));
        }
        for (int i = 0; i < 5; i++) {
            results.add(d1.calculateInt(i, i));
        }

        System.out.println("All asynch calls made");

        while (results.size() > 0) {
            for (Future<?> result : results) {
                if(result.isDone()) {
                    try {
                        System.out.println(result.get());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }

                    results.remove(result);
                }
            }

            d1.shutdown();
        }

    }

}
