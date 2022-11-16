package playground.problem.effectivejava.synchronize;

import java.util.concurrent.TimeUnit;

public class Example2 {
    private static boolean stopRequested;

    public static void main(String[] args) throws InterruptedException {
        Thread backgroundThread = new Thread(() -> {
            int i = 0;
            while (!stopRequested()) {
                i++;
            }
        });

        backgroundThread.start();
        TimeUnit.SECONDS.sleep(1);
        requestStop();
    }


    private static synchronized boolean stopRequested() {
        return stopRequested;
    }

    private static synchronized void requestStop() {
        stopRequested = true;
    }
}
