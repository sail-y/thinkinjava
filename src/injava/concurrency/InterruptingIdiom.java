package injava.concurrency;

import java.util.concurrent.TimeUnit;

/**
 * Created by sail on 2016/10/12.
 */
class NeedsCleanup {
    private final int id;

    public NeedsCleanup(int id) {
        this.id = id;
        System.out.println("NeedsCleanup " + id);
    }

    public void cleanup() {
        System.out.println("cleaning up" + id);
    }
}

class Blocked3 implements Runnable {
    private volatile double d = 0.0;

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            NeedsCleanup n1 = new NeedsCleanup(1);

            try {
                System.out.println("Sleeping");
                TimeUnit.SECONDS.sleep(1);
                NeedsCleanup n2 = new NeedsCleanup(2);
                try {
                    System.out.println("Calculating");
                    for (int i = 0; i < 2500000; i++) {
                        d = d + (Math.PI + Math.E) / d;
                    }
                    System.out.println("Finished time-consuming operation");
                }finally {
                    n2.cleanup();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                n1.cleanup();
            }
        }
    }
}

public class InterruptingIdiom {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Blocked3());
        t.start();
        TimeUnit.MILLISECONDS.sleep(5000);
        t.interrupt();
    }
}
