/*
 * Copyright (c) 2016 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package blog.concurrency;

import java.util.concurrent.*;

/**
 * Created by YangFan on 2016/10/26 下午5:54.
 * <p/>
 */
class CallableThread implements Callable {

    @Override
    public Object call() throws Exception {
        System.out.println("call()");
        TimeUnit.MILLISECONDS.sleep(1500);
        return "123";
    }
}
public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future future = executorService.submit(new CallableThread());
        executorService.shutdown();

        System.out.println(future.get());
//        while (!future.isDone()) {
//            System.out.println(future.get());
//        }
    }
}
